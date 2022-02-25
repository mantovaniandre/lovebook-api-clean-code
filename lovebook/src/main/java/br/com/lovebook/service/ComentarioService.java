package br.com.lovebook.service;

import br.com.lovebook.dto.ComentarioDto;
import br.com.lovebook.form.comentario.FormularioCriacaoComentario;
import br.com.lovebook.model.Comentario;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private LivroService livroService;
    @Autowired
    private UsuarioService usuarioService;

    public List<ComentarioDto> buscarComentariosPorLivro(Long idDoLivro) {
        List<Comentario> comentariosDoBanoDeDados = comentarioRepository.findByLivroId(idDoLivro);

        return comentariosDoBanoDeDados.stream().map(ComentarioDto::new).collect(Collectors.toList());

    }

    public List<ComentarioDto> buscarComentariosDoUsuario(Long idDoUsuario) {
        List<Comentario> comentariosDoBanoDeDados = comentarioRepository.findByUsuarioId(idDoUsuario);

        return comentariosDoBanoDeDados.stream().map(ComentarioDto::new).collect(Collectors.toList());
    }

    public ComentarioDto salvarComentario(Long idDoUsuario, FormularioCriacaoComentario formularioCriacaoComentario) {
        Livro livroDoComentario = livroService.recuperarLivroPorId(formularioCriacaoComentario.getIdDoLivro());
        Usuario usuarioAutorDoComentario = usuarioService.recuperarUsuarioPorId(idDoUsuario);

        Comentario comentarioSalvo = salvarComentario(formularioCriacaoComentario, usuarioAutorDoComentario, livroDoComentario);
        return new ComentarioDto(comentarioSalvo);

    }

    private Comentario salvarComentario(FormularioCriacaoComentario formularioCriacaoComentario, Usuario usuario, Livro livro) {
        Comentario comentario = new Comentario(formularioCriacaoComentario, usuario, livro);
        return comentarioRepository.save(comentario);

    }


}
