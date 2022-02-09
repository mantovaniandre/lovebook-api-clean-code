package br.com.lovebook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lovebook.model.Perfil;
import br.com.lovebook.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	public Perfil buscarPerfilPorNome(String nomeDoPerfil) {
		Optional<Perfil> resultadoQuery = perfilRepository.findByNome(nomeDoPerfil);
		if (resultadoQuery.isPresent()) {
			return resultadoQuery.get();
		} else {
			return null;
		}
	}
}
