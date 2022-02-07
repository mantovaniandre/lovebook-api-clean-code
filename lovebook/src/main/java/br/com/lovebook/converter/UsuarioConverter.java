package br.com.lovebook.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lovebook.form.UsuarioForm;
import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.PerfilRepository;

@Component
public class UsuarioConverter {

	@Autowired
	private PerfilRepository perfilRepository;
	
	
	public Usuario converterFormParEntidade(UsuarioForm usuarioForm) {
		Perfil perfilComBaseNoNome = this.recuperarPerfilSeExistir(usuarioForm.getPerfil());
		
		return new Usuario(usuarioForm.getNome(), usuarioForm.getSobrenome(), usuarioForm.getEmailUsuario(), usuarioForm.getSenhaUsuario(), usuarioForm.getSexoUsuario(), usuarioForm.getCepUsuario(), 
				usuarioForm.getCidadeUsuario(), usuarioForm.getEstadoUsuario(), usuarioForm.getEnderecoUsuario(), 
				usuarioForm.getNumeroEnderecoUsuario(), usuarioForm.getComplementoEnderecoUsuario(), 
				usuarioForm.getNumeroCartaoCredito(), usuarioForm.getNomeCartaoCredito(), 
				usuarioForm.getMesExpiracaoCartaoCredito(), usuarioForm.getAnoExpiracaoCartaoCredito(), 
				usuarioForm.getCodigoSegurancaCartaoCredito(), perfilComBaseNoNome);
		
	}
	
	private Perfil recuperarPerfilSeExistir(String nomePerfil) {
		Optional<Perfil> resultadoQuery = perfilRepository.findByNome(nomePerfil);
		if(resultadoQuery.isPresent()) {
			return resultadoQuery.get();
		} 
		
		return null;
	}
	
}
