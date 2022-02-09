package br.com.lovebook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.lovebook.LovebookApplication;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.exception.PerfilNaoEncontradoException;
import br.com.lovebook.exception.PerfilNaoInformadoException;
import br.com.lovebook.form.UsuarioForm;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.UsuarioRepository;
import br.com.lovebook.testfactory.FabricaDeCadastro;

@SpringBootTest
@ContextConfiguration(classes = LovebookApplication.class)
@Transactional
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private FabricaDeCadastro fabricaDeCadastro;


	@Test
	void deveLancarErroAoSalvaUsuarioSemPerfil() {

		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setSenhaUsuario("123");

		assertThrows(PerfilNaoInformadoException.class, () -> this.usuarioService.salvar(usuarioForm));

	}
	
	@Test
	void deveLancarErroAoSalvaUsuarioComPerfilNaoEncontrado() {

		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setSenhaUsuario("123");
		usuarioForm.setPerfil("Funcionario");

		assertThrows(PerfilNaoEncontradoException.class, () -> this.usuarioService.salvar(usuarioForm));

	}

	@Test
	void deveSalvarUsuarioComPerfilCorretamente() {
		fabricaDeCadastro.criarPerfil("Cliente");
		
		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setSenhaUsuario("123");
		usuarioForm.setPerfil("Cliente");

		UsuarioDto usuarioSalvo = this.usuarioService.salvar(usuarioForm);

		List<Usuario> usuariosCadastrados = this.usuarioRepository.findAll();

		assertEquals(1, usuariosCadastrados.size());
		assertNotEquals("123", usuariosCadastrados.get(0).getSenhaUsuario());
		assertNotNull(usuariosCadastrados.get(0).getPerfil());

	}

}
