package br.com.lovebook.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lovebook.converter.UsuarioConverter;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.exception.PerfilNaoEncontradoException;
import br.com.lovebook.exception.PerfilNaoInformadoException;
import br.com.lovebook.form.UsuarioForm;
import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.PerfilRepository;
import br.com.lovebook.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioConverter usuarioConverter;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PerfilService perfilService;

	public UsuarioDto salvar(UsuarioForm usuarioForm) {
		this.validarUsuarioForm(usuarioForm);
		
		this.encriptarSenhaDoUsuario(usuarioForm);
		Usuario usuario = this.usuarioConverter.converterFormParEntidade(usuarioForm);
		usuarioRepository.save(usuario);
		return new UsuarioDto(usuario);
	}

	private void encriptarSenhaDoUsuario(UsuarioForm usuarioForm) {
		String senhaOriginal = usuarioForm.getSenhaUsuario();
		usuarioForm.setSenhaUsuario(new BCryptPasswordEncoder().encode(senhaOriginal));
	}

	private void validarUsuarioForm(UsuarioForm usuarioForm) {
		this.validarPerfil(usuarioForm);
	}

	private void validarPerfil(UsuarioForm formularioDoUsuario) {
		String perfilInformado = formularioDoUsuario.getPerfil();
		if (Strings.isNotEmpty(perfilInformado)) {
			Perfil perfilEncontrado = perfilService.buscarPerfilPorNome(perfilInformado);
			if (perfilEncontrado == null) {
				throw new PerfilNaoEncontradoException(perfilInformado);
			}
		} else {
			throw new PerfilNaoInformadoException();
		}
	}

}
