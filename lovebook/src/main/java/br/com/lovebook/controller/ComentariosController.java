package br.com.lovebook.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lovebook.config.security.AutenticacaoViaTokenFilter;
import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.dto.ComentariosDto;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.form.ComentariosForm;
import br.com.lovebook.form.LivroForm;
import br.com.lovebook.form.PurchaseForm;
import br.com.lovebook.model.Comentarios;
import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.ComentariosRepository;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.UsuarioRepository;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
public class ComentariosController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ComentariosRepository comentariosRepository;

	@GetMapping
	public ResponseEntity<Optional<Comentarios>> consultar(Long id) {
		Optional<Comentarios> comentarios = comentariosRepository.findById(id);
		if (comentarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(comentarios);
	}
	
	
	
	

}
