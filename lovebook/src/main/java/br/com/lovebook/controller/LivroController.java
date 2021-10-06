package br.com.lovebook.controller;

import java.util.List;

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

import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.form.LivroForm;
import br.com.lovebook.model.Livro;
import br.com.lovebook.repository.LivroRepository;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/book")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
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
	
}
