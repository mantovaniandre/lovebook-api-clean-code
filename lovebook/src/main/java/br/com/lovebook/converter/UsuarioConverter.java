package br.com.lovebook.converter;

import br.com.lovebook.form.usuario.FormularioAtualizacaoUsuario;
import br.com.lovebook.form.usuario.FormularioCriacaoUsuario;
import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioConverter {

    @Autowired
    private PerfilRepository perfilRepository;


    public Usuario converterFormParaEntidade(FormularioCriacaoUsuario formulario) {
        Perfil perfilComBaseNoNome = this.recuperarPerfilSeExistir(formulario.getPerfil());

        return new Usuario(formulario.getNome(), formulario.getSobrenome(), formulario.getEmailUsuario(), formulario.getSenhaUsuario(), formulario.getSexoUsuario(), formulario.getCepUsuario(),
                formulario.getCidadeUsuario(), formulario.getEstadoUsuario(), formulario.getEnderecoUsuario(),
                formulario.getNumeroEnderecoUsuario(), formulario.getComplementoEnderecoUsuario(),
                formulario.getNumeroCartaoCredito(), formulario.getNomeCartaoCredito(),
                formulario.getMesExpiracaoCartaoCredito(), formulario.getAnoExpiracaoCartaoCredito(),
                formulario.getCodigoSegurancaCartaoCredito(), perfilComBaseNoNome);

    }

    public Usuario converterFormParaEntidade(FormularioAtualizacaoUsuario formulario) {

        return new Usuario(formulario.getNome(), formulario.getSobrenome(), null, formulario.getSenhaUsuario(), formulario.getSexoUsuario(), formulario.getCepUsuario(),
                formulario.getCidadeUsuario(), formulario.getEstadoUsuario(), formulario.getEnderecoUsuario(),
                formulario.getNumeroEnderecoUsuario(), formulario.getComplementoEnderecoUsuario(),
                formulario.getNumeroCartaoCredito(), formulario.getNomeCartaoCredito(),
                formulario.getMesExpiracaoCartaoCredito(), formulario.getAnoExpiracaoCartaoCredito(),
                formulario.getCodigoSegurancaCartaoCredito(), null);

    }

    private Perfil recuperarPerfilSeExistir(String nomePerfil) {
        Optional<Perfil> resultadoQuery = perfilRepository.findByNome(nomePerfil);
        if (resultadoQuery.isPresent()) {
            return resultadoQuery.get();
        }

        return null;
    }

}
