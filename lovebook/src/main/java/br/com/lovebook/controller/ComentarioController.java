package br.com.lovebook.controller;

import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.controller.comum.ControllerPadrao;
import br.com.lovebook.dto.ComentarioDto;
import br.com.lovebook.form.comentario.FormularioAtualizacaoComentario;
import br.com.lovebook.form.comentario.FormularioCriacaoComentario;
import br.com.lovebook.model.Comentario;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.ComentarioRepository;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.UsuarioRepository;
import br.com.lovebook.service.ComentarioService;
import br.com.lovebook.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
@Transactional
public class ComentarioController extends ControllerPadrao {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<ComentarioDto>> listarComentarios(@RequestParam Long idDoLivro) {
        List<ComentarioDto> comentarioDoLivro = comentarioService.buscarComentariosPorLivro(idDoLivro);
        return ResponseEntity.ok(comentarioDoLivro);
    }

    @GetMapping("/user")
    public ResponseEntity<List<ComentarioDto>> listarComentariosUsuario(HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        List<ComentarioDto> comentariosDoUsuario = comentarioService.buscarComentariosDoUsuario(idUsuarioLogado);

        return ResponseEntity.ok(comentariosDoUsuario);

    }

    @PostMapping
    public ResponseEntity<ComentarioDto> cadastrarComentario(@RequestBody @Valid FormularioCriacaoComentario formularioCriacaoComentario, HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);

        ComentarioDto comentarioDto = comentarioService.salvarComentario(idUsuarioLogado, formularioCriacaoComentario);

        livroService.atualizarNota(formularioCriacaoComentario.getIdDoLivro());

        return ResponseEntity.ok(comentarioDto);
    }

    @DeleteMapping("/{idComentario}")
    public ResponseEntity<?> deletarComentarios(HttpServletRequest request, @PathVariable Long idComentario) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);

        Optional<Comentario> comentarios = comentarioRepository.findById(idComentario);

        if (comentarios.get().getUsuario().getId() == idUsuarioLogado) {
            comentarioRepository.deleteById(idComentario);
            Optional<Livro> livro = livroRepository.findById(comentarios.get().getLivro().getId());

            List<Comentario> listaComentarios = comentarioRepository.findByLivroId(comentarios.get().getLivro().getId());
            if (listaComentarios.isEmpty()) {
                livro.get().setNota(0.0);
            } else {
                livro.get().setNota((listaComentarios.stream().map(comment -> comment.getNota()).reduce(0.0, Double::sum)) / (listaComentarios.size()));
            }

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }

    @PutMapping
    public ResponseEntity<ComentarioDto> atualizarComentarios(@RequestBody @Valid FormularioAtualizacaoComentario formularioAtualizacaoComentario,
                                                              HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);

        Optional<Comentario> idUsuarioComentarios = comentarioRepository.findById(idUsuarioLogado);

        if (idUsuarioComentarios.get().getUsuario().getId() == user.get().getId()) {
            Optional<Comentario> comentarios = formularioAtualizacaoComentario.atualizar(comentarioRepository);
            return ResponseEntity.ok(new ComentarioDto(comentarios));
        }

        return ResponseEntity.badRequest().build();
    }


}
