package br.com.lovebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lovebook.converter.UsuarioConverter;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.form.UsuarioForm;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioConverter usuarioConverter;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public UsuarioDto salvar(UsuarioForm usuarioForm) {
		this.encriptarSenhaDoUsuario(usuarioForm);
		Usuario usuario = this.usuarioConverter.converterFormParEntidade(usuarioForm);
		usuarioRepository.save(usuario);
		return new UsuarioDto(usuario);
	}
	
	private void encriptarSenhaDoUsuario(UsuarioForm usuarioForm) {
		String senhaOriginal = usuarioForm.getSenhaUsuario();
		usuarioForm.setSenhaUsuario(new BCryptPasswordEncoder().encode(senhaOriginal));
	}
	
}
