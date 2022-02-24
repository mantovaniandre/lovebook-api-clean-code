package br.com.lovebook.service;

import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.exception.UsuarioNaoColaboradorException;
import br.com.lovebook.model.Perfil;
import br.com.lovebook.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilService {

    private static final String NOME_PERFIL_COLABORADOR = "Colaborador";

    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private UsuarioService usuarioService;

    public Perfil buscarPerfilPorNome(String nomeDoPerfil) {
        Optional<Perfil> resultadoQuery = perfilRepository.findByNome(nomeDoPerfil);
        if (resultadoQuery.isPresent()) {
            return resultadoQuery.get();
        } else {
            return null;
        }
    }

    public void validarSeUsuarioLogadoEColaborador(Long idDoUsuario) {
        UsuarioDto usuarioLogado = usuarioService.recuperarUsuarioSeExistir(idDoUsuario);
        Perfil perfilDoUsuario = usuarioLogado.getTipoUsuario();

        String nomeDoPerfil = perfilDoUsuario.getNome();

        if (this.verificarSeNomeDoPerfilDiferenteDeColaborador(nomeDoPerfil)) {
            throw new UsuarioNaoColaboradorException();
        }

    }

    private boolean verificarSeNomeDoPerfilIgualColaborador(String nomeDoPerfil) {
        return nomeDoPerfil.equals(NOME_PERFIL_COLABORADOR);
    }

    private boolean verificarSeNomeDoPerfilDiferenteDeColaborador(String nomeDoPerfil) {
        return !this.verificarSeNomeDoPerfilIgualColaborador(nomeDoPerfil);
    }
}
