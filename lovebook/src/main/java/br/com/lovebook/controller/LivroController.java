package br.com.lovebook.controller;

import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.controller.comum.ControllerPadrao;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.form.FormularioAtualizacaoLivro;
import br.com.lovebook.form.FormularioCriacaoLivro;
import br.com.lovebook.model.Livro;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.UsuarioRepository;
import br.com.lovebook.service.LivroService;
import br.com.lovebook.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/book")
@Transactional
public class LivroController extends ControllerPadrao {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilService perfilService;
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDto>> consultar(@RequestParam(defaultValue = "") String nome,
                                                 @RequestParam(defaultValue = "") String categoria, @RequestParam(defaultValue = "") String autor,
                                                 @RequestParam(defaultValue = "") String editora, @RequestParam(defaultValue = "true") Boolean valido, HttpServletRequest request) {
        List<LivroDto> livros = this.livroService.buscar(nome, categoria, autor, editora, valido);
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid FormularioCriacaoLivro formularioCriacaoLivro,
                                              HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        perfilService.validarSeUsuarioLogadoEColaborador(idUsuarioLogado);

        LivroDto livroSalvo = livroService.salvar(formularioCriacaoLivro);
        return ResponseEntity.ok(livroSalvo);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id, HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        perfilService.validarSeUsuarioLogadoEColaborador(idUsuarioLogado);

        livroService.invalidar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping
    public ResponseEntity<LivroDto> atualizar(@RequestBody @Valid FormularioAtualizacaoLivro formularioAtualizacaoLivro,
                                              HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        perfilService.validarSeUsuarioLogadoEColaborador(idUsuarioLogado);

        LivroDto livroSalvo = livroService.atualizar(formularioAtualizacaoLivro);

        return ResponseEntity.ok(livroSalvo);

    }

}
