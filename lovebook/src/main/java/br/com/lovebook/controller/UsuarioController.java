package br.com.lovebook.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.form.UsuarioForm;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.PerfilRepository;
import br.com.lovebook.repository.UsuarioRepository;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PerfilRepository perfilRepository;

	@GetMapping
	public ResponseEntity<UsuarioDto> exibirUsuario(String nome, HttpServletRequest request) {
		Optional<Usuario> user = usuarioRepository.findByNome(nome);
		if (user.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(user));
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form) {
		Usuario usuario = form.converter(perfilRepository);
		usuarioRepository.save(usuario);
		return ResponseEntity.ok(new UsuarioDto(usuario));
	}

	@DeleteMapping
	@Transactional
	public ResponseEntity<?> remover(HttpServletRequest request) {
		usuarioRepository.deleteById((long) 1);
		return ResponseEntity.ok().build();
	}

}
