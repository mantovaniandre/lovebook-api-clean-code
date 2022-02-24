package br.com.lovebook.repository;

import br.com.lovebook.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByNomeLikeAndCategoriaLikeAndNomeDoAutorLikeAndEditoraLikeAndValido(String nome, String categoria, String auto, String editora, Boolean valido);

    Optional<Livro> findById(Long id);

    @Query(value = "select sum(quantidade) from livro", nativeQuery = true)
    Integer getBookQuantity();


}
