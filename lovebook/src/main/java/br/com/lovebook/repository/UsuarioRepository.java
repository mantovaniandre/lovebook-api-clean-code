package br.com.lovebook.repository;

import br.com.lovebook.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String nome);

    Optional<Usuario> findByEmailUsuario(String email);

    @Query(value = "select count(*) from usuario u where u.perfil_id = 2", nativeQuery = true)
    Integer getReaderQuantity();
}
