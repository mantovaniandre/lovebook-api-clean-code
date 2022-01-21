package br.com.lovebook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.lovebook.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {


	List<Livro> findByNomeLikeAndCategoriaLikeAndNomeDoAutorLikeAndEditoraLike(String nome, String categoria, String auto, String editora);
	Optional<Livro> findById(Long id);
	
	@Query(value = "select sum(quantidade) from livro", nativeQuery = true)
	Integer getBookQuantity();
	
//	@Query(value = "select * from livro l where l.nome like %:nome%", nativeQuery = true)
//	List<Livro> procurarPeloNome(@Param("nome") String nome);
	


}
