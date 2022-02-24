package br.com.lovebook.repository;

import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    Optional<List<Compra>> findByUsuario(Usuario usuario);

    @Query(value = "select sum(preco) from compra where month(data) = :mes and year(data) = :ano", nativeQuery = true)
    Double getSomaPreco(@Param("mes") Integer mes, @Param("ano") Integer ano);

    @Query(value = "select sum(custo) from compra c inner join livro l on c.livro_id = l.id where month(data) = :mes and year(data) = :ano", nativeQuery = true)
    Double getSomaCusto(@Param("mes") Integer mes, @Param("ano") Integer ano);

    @Query(value = "select categoria from compra c  where month(data) = :mes and year(data) = :ano group by categoria order by count(categoria) desc", nativeQuery = true)
    Optional<List<String>> getVendasCategoria(@Param("mes") Integer mes, @Param("ano") Integer ano);

    @Query(value = "select l.nome from compra c inner join livro l on c.livro_id = l.id where month(data) = :mes and year(data) = :ano group by l.nome order by count(l.nome) desc", nativeQuery = true)
    Optional<List<String>> getVendasLivros(@Param("mes") Integer mes, @Param("ano") Integer ano);

    @Query(value = "select u.estado_usuario from compra c inner join usuario u on c.usuario_id = u.id where month(data) = :mes and year(data) = :ano group by u.estado_usuario order by count(u.estado_usuario) desc", nativeQuery = true)
    Optional<List<String>> getVendasEstado(@Param("mes") Integer mes, @Param("ano") Integer ano);

    @Query(value = "select u.sexo_usuario from compra c inner join usuario u on c.usuario_id = u.id where month(data) = :mes and year(data) = :ano group by u.sexo_usuario order by count(u.sexo_usuario) desc", nativeQuery = true)
    Optional<List<String>> getVendasSexo(@Param("mes") Integer mes, @Param("ano") Integer ano);

    @Query(value = "select count(c.id) from compra c where month(data) = :mes and year(data) = :ano", nativeQuery = true)
    Double getTotalVendasLivros(@Param("mes") Integer mes, @Param("ano") Integer ano);
}
