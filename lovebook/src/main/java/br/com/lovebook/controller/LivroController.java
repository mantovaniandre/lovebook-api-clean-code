package br.com.lovebook.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lovebook.config.security.AutenticacaoViaTokenFilter;
import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.form.AtualizacaoLivroForm;
import br.com.lovebook.form.LivroForm;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.UsuarioRepository;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/book")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Livro>> consultar(String nome, HttpServletRequest request){
		List<Livro> livros = livroRepository.findByNomeLike(nome+"%");
		if(livros.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
//		List<LivroDto> livrosDto = new ArrayList<>();
//		for (Livro livro : livros) {
//			livrosDto.add(new LivroDto(livro));
//		}
		return ResponseEntity.ok(livros);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm livroForm){
		Livro livro = livroForm.converter();
		livroRepository.save(livro);
		return ResponseEntity.ok(new LivroDto(livro));
		
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<?> remover(HttpServletRequest request){
		livroRepository.deleteById((long) 1);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<LivroDto> atualizar(@RequestBody @Valid AtualizacaoLivroForm atualizacaoLivroForm, HttpServletRequest request){
		Long idUsuarioLogado = idUsuarioLogado(request);
		Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);
		
		if(user.get().getTipoUsuario().getId() == 2) {
			Optional<Livro> livro = atualizacaoLivroForm.atualizar(livroRepository);
			return ResponseEntity.ok(new LivroDto(livro));
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	private Long idUsuarioLogado(HttpServletRequest request) {
		AutenticacaoViaTokenFilter autenticacaoViaTokenFilter = new AutenticacaoViaTokenFilter(tokenService, usuarioRepository);
		String token = autenticacaoViaTokenFilter.recuperarToken(request);
		Long idUsuarioLogado = tokenService.getIdUsuario(token);
		return idUsuarioLogado;
	}
	
}
