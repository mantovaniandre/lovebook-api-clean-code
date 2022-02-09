package br.com.lovebook.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lovebook.config.security.AutenticacaoViaTokenFilter;
import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.form.AtualizacaoUsuarioForm;
import br.com.lovebook.form.UsuarioForm;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.PerfilRepository;
import br.com.lovebook.repository.UsuarioRepository;
import br.com.lovebook.service.UsuarioService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<UsuarioDto> exibirUsuario(HttpServletRequest request) {
		Long idUsuarioLogado = recuperarIdDoUsuarioLogado(request);
		Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);
		if (user.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(user));
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form) {
		return ResponseEntity.ok(this.usuarioService.salvar(form));
	}

	@DeleteMapping
	@Transactional
	public ResponseEntity<?> remover(HttpServletRequest request) {
		Long idUsuarioLogado = recuperarIdDoUsuarioLogado(request);
		Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);

		if (user.isPresent()) {
			System.out.println(user);
			usuarioRepository.deleteById(idUsuarioLogado);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}

	@PutMapping
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@RequestBody @Valid AtualizacaoUsuarioForm atualizacaoUsuarioForm,
			HttpServletRequest request) {
		Long idUsuarioLogado = recuperarIdDoUsuarioLogado(request);
		Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);

		if (!atualizacaoUsuarioForm.getSenhaUsuario().isBlank()) {
			atualizacaoUsuarioForm
					.setSenhaUsuario(new BCryptPasswordEncoder().encode(atualizacaoUsuarioForm.getSenhaUsuario()));
		} else {
			atualizacaoUsuarioForm.setSenhaUsuario(user.get().getSenhaUsuario());
		}

		if (user.isPresent()) {
			Optional<Usuario> usuario = atualizacaoUsuarioForm.atualizar(idUsuarioLogado, usuarioRepository);
			System.out.println(usuario);
			return ResponseEntity.ok(new UsuarioDto(usuario));
			
		}

		return ResponseEntity.notFound().build();
	}

	private Long recuperarIdDoUsuarioLogado(HttpServletRequest request) {
		AutenticacaoViaTokenFilter autenticacaoViaTokenFilter = new AutenticacaoViaTokenFilter(tokenService,
				usuarioRepository);
		String token = autenticacaoViaTokenFilter.recuperarToken(request);
		Long idUsuarioLogado = tokenService.getIdUsuario(token);
		return idUsuarioLogado;
	}

}
