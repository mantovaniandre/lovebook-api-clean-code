package br.com.lovebook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Usuario;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	Optional<List<Compra>> findByUsuario(Usuario usuario);
	
	@Query(value = "select sum(preco) from compra where month(data) = %:mes% and year(data) = %:ano%", nativeQuery = true)
	Double getSomaPreco(@Param("mes") Integer mes, @Param("ano") Integer ano);
	
	@Query(value = "select sum(custo) from compra c inner join livro l on c.livro_id = l.id where month(data) = %:mes% and year(data) = %:ano%", nativeQuery = true)
	Double getSomaCusto(@Param("mes") Integer mes, @Param("ano") Integer ano);
}
