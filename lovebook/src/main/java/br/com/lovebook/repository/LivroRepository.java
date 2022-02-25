package br.com.lovebook.repository;

import br.com.lovebook.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByNomeLikeIgnoreCaseAndCategoriaLikeIgnoreCaseAndNomeDoAutorLikeIgnoreCaseAndEditoraLikeIgnoreCaseAndAtivo(
            String nome, String categoria, String auto, String editora, Boolean ativo);

    @Query(value = "select sum(quantidade) from livro", nativeQuery = true)
    Integer getBookQuantity();

    List<Livro> findByNomeLikeIgnoreCaseAndCategoriaLikeIgnoreCaseAndNomeDoAutorLikeIgnoreCaseAndEditoraLikeIgnoreCase(
            String nome, String categoria, String auto, String editora);


}
