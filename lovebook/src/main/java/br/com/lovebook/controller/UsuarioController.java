package br.com.lovebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lovebook.controller.utils.TokenUtils;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.form.usuario.FormularioAtualizacaoUsuario;
import br.com.lovebook.form.usuario.FormularioCriacaoUsuario;
import br.com.lovebook.service.UsuarioService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/user")
@Transactional
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TokenUtils tokenUtils;

	@GetMapping
	public ResponseEntity<UsuarioDto> exibirUsuario(HttpServletRequest request) {
		Long idUsuarioLogado = tokenUtils.recuperarIdDoUsuario(request);
		UsuarioDto usuarioEncontrado = this.usuarioService.recuperarUsuarioSeExistir(idUsuarioLogado);
		return ResponseEntity.ok(usuarioEncontrado);
	}

	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid FormularioCriacaoUsuario form) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.salvar(form));
	}

	@DeleteMapping
	public ResponseEntity<?> remover(HttpServletRequest request) {
		Long idUsuarioLogado = tokenUtils.recuperarIdDoUsuario(request);
		usuarioService.deletarUsuario(idUsuarioLogado);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<UsuarioDto> atualizar(@RequestBody @Valid FormularioAtualizacaoUsuario atualizacaoUsuarioForm,
			HttpServletRequest request) {
		Long idUsuarioLogado = tokenUtils.recuperarIdDoUsuario(request);
		UsuarioDto usuarioAtualizado = this.usuarioService.atualizarUsuario(atualizacaoUsuarioForm, idUsuarioLogado);
		return ResponseEntity.ok(usuarioAtualizado);
	}

}
