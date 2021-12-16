package br.com.lovebook.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lovebook.config.security.AutenticacaoViaTokenFilter;
import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.dto.ComentariosDto;
import br.com.lovebook.dto.CompraDto;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.form.ComentariosForm;
import br.com.lovebook.form.LivroForm;
import br.com.lovebook.model.Comentarios;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.ComentariosRepository;
import br.com.lovebook.repository.CompraRepository;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.UsuarioRepository;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
public class ComentariosController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<ComentariosDto>> listarComentarios(@RequestParam Long idDoLivro){
		List<Comentarios> listaComentarios = comentariosRepository.findByLivro_id(idDoLivro);
		List<ComentariosDto> listaComentariosDto = new ArrayList<>();
		
		if(!listaComentarios.isEmpty()) {
			for (Comentarios comentarios : listaComentarios) {
					listaComentariosDto.add(new ComentariosDto(comentarios));
			}
		}

		return ResponseEntity.ok(listaComentariosDto);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ComentariosDto> cadastrarComentario(@RequestBody @Valid ComentariosForm comentariosForm, HttpServletRequest request){
		Long idUsuarioLogado = idUsuarioLogado(request);
		Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);
	
		Optional<Livro> livro = livroRepository.findById(comentariosForm.getIdDoLivro());
		
		Comentarios comentario = new Comentarios(comentariosForm, user.get(), livro.get()); 
		
		comentariosRepository.save(comentario);
		
		return ResponseEntity.ok(new ComentariosDto(comentario));
	}
	
	
	private Long idUsuarioLogado(HttpServletRequest request) {
		AutenticacaoViaTokenFilter autenticacaoViaTokenFilter = new AutenticacaoViaTokenFilter(tokenService,
				usuarioRepository);
		String token = autenticacaoViaTokenFilter.recuperarToken(request);
		Long idUsuarioLogado = tokenService.getIdUsuario(token);
		return idUsuarioLogado;
	}
}
