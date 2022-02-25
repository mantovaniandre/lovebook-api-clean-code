package br.com.lovebook.testfactory;

import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.PerfilRepository;
import br.com.lovebook.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaDeCadastro {

    public static final String SENHA_PADRAO = "123";

    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LivroRepository livroRepository;


    public Perfil criarPerfil(String nomeDoPerfil) {
        Perfil perfil = new Perfil();
        perfil.setNome(nomeDoPerfil);
        return perfilRepository.save(perfil);
    }

    public Usuario criarUsuario(String nomeDoUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNome(nomeDoUsuario);
        usuario.setSenhaUsuario(SENHA_PADRAO);
        return usuarioRepository.save(usuario);
    }

    public Livro criarLivro(String nomeDoLivro) {
        return criarLivro(nomeDoLivro, true);
    }

    public Livro criarLivro(String nomeDoLivro, Boolean valido) {
        Livro livro = new Livro();
        livro.setNome(nomeDoLivro);
        livro.setAtivo(valido);
        return livroRepository.save(livro);
    }
}
