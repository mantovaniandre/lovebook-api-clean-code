package br.com.lovebook.repository;


import br.com.lovebook.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {


    List<Comentario> findByLivroId(Long id);

    Optional<Comentario> deleteByUsuario_id(Long id);

    List<Comentario> findByUsuarioId(Long id);


}
