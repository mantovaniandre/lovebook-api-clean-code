package br.com.lovebook.testfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lovebook.model.Perfil;
import br.com.lovebook.repository.PerfilRepository;

@Component
public class FabricaDeCadastro {

	@Autowired
	private PerfilRepository perfilRepository;
	
	public Perfil criarPerfil(String nomeDoPerfil) {
		Perfil perfil = new Perfil();
		perfil.setNome(nomeDoPerfil);
		return perfilRepository.save(perfil);
	}
}
