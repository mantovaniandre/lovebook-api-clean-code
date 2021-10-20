package br.com.lovebook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Usuario;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	Optional<List<Compra>> findByUsuario(Usuario usuario);
}
