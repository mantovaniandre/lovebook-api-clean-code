package br.com.lovebook.testfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.PerfilRepository;
import br.com.lovebook.repository.UsuarioRepository;

@Component
public class FabricaDeCadastro {

	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Perfil criarPerfil(String nomeDoPerfil) {
		Perfil perfil = new Perfil();
		perfil.setNome(nomeDoPerfil);
		return perfilRepository.save(perfil);
	}
	
	public Usuario criarUsuario(String nomeDoUsuario) {
		Usuario usuario = new Usuario();
		usuario.setNome(nomeDoUsuario);
		return usuarioRepository.save(usuario);
		
	}
}
