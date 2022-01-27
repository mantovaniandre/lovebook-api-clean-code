package br.com.lovebook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lovebook.config.security.AutenticacaoViaTokenFilter;
import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.dto.ComentariosDto;
import br.com.lovebook.dto.CompraDto;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.form.AtualizacaoComentariosForm;
import br.com.lovebook.form.AtualizacaoLivroForm;
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
	
	@GetMapping("/user")
	@Transactional
	public ResponseEntity<List<ComentariosDto>> listarComentariosUsuario(HttpServletRequest request){
		Long idUsuarioLogado = idUsuarioLogado(request);
		List<Comentarios> listaComentarios = comentariosRepository.findByUsuario_id(idUsuarioLogado);
		List<ComentariosDto> listaComentariosDto = new ArrayList<>();
		
		for (Comentarios comentarios : listaComentarios) {
			listaComentariosDto.add(new ComentariosDto(comentarios));
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
		
		List<Comentarios> listaComentarios = comentariosRepository.findByLivro_id(comentariosForm.getIdDoLivro());
		livro.get().setNota((listaComentarios.stream().map(comment -> comment.getNota()).reduce(0.0, Double::sum))/(listaComentarios.size()));
		
		
		return ResponseEntity.ok(new ComentariosDto(comentario));
	}
	
	@DeleteMapping("/{idComentario}")
	@Transactional 
	public ResponseEntity<?> deletarComentarios(HttpServletRequest request, @PathVariable Long idComentario){
		Long idUsuarioLogado = idUsuarioLogado(request);
		
		Optional<Comentarios> comentarios = comentariosRepository.findById(idComentario);
		
		if(comentarios.get().getUsuario().getId() == idUsuarioLogado) {
			comentariosRepository.deleteById(idComentario);
			Optional<Livro> livro = livroRepository.findById(comentarios.get().getLivro().getId());
			
			List<Comentarios> listaComentarios = comentariosRepository.findByLivro_id(comentarios.get().getLivro().getId());
			if(listaComentarios.isEmpty()) {
				livro.get().setNota(0.0);
			} else {
				livro.get().setNota((listaComentarios.stream().map(comment -> comment.getNota()).reduce(0.0, Double::sum))/(listaComentarios.size()));
			}
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<ComentariosDto> atualizarComentarios(@RequestBody @Valid AtualizacaoComentariosForm atualizacaoComentariosForm,
			HttpServletRequest request) {
		Long idUsuarioLogado = idUsuarioLogado(request);
		Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);
		
		Optional<Comentarios> idUsuarioComentarios = comentariosRepository.findById(idUsuarioLogado);
		
		if(idUsuarioComentarios.get().getUsuario().getId() == user.get().getId()) {
			Optional<Comentarios> comentarios = atualizacaoComentariosForm.atualizar(comentariosRepository);
			return ResponseEntity.ok(new ComentariosDto(comentarios));
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	
	private Long idUsuarioLogado(HttpServletRequest request) {
		AutenticacaoViaTokenFilter autenticacaoViaTokenFilter = new AutenticacaoViaTokenFilter(tokenService,
				usuarioRepository);
		String token = autenticacaoViaTokenFilter.recuperarToken(request);
		Long idUsuarioLogado = tokenService.getIdUsuario(token);
		return idUsuarioLogado;
	}
}
