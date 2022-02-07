package br.com.lojagames.lovegames.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import br.com.lovebook.LovebookApplication;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.form.UsuarioForm;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.UsuarioRepository;
import br.com.lovebook.service.UsuarioService;

@SpringBootTest
@ContextConfiguration(classes = LovebookApplication.class)
@Transactional
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeEach
	public void limparCenario() {
		this.usuarioRepository.deleteAll();
	}

	@Test
	void deveSalvarUsuarioSemPerfilCorretamente() {

		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setSenhaUsuario("123");

		UsuarioDto usuarioSalvo = this.usuarioService.salvar(usuarioForm);

		List<Usuario> usuariosCadastrados = this.usuarioRepository.findAll();

		assertEquals(1, usuariosCadastrados.size());
		assertEquals(1, usuariosCadastrados.get(0).getId());
		assertNotEquals("123", usuariosCadastrados.get(0).getSenhaUsuario());
		assertNull(usuariosCadastrados.get(0).getPerfil());

	}
	
	@Test
	void deveSalvarUsuarioComPerfilCorretamente() {

		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setSenhaUsuario("123");
		usuarioForm.setPerfil("Cliente");

		UsuarioDto usuarioSalvo = this.usuarioService.salvar(usuarioForm);

		List<Usuario> usuariosCadastrados = this.usuarioRepository.findAll();

		assertEquals(1, usuariosCadastrados.size());
		assertEquals(1, usuariosCadastrados.get(0).getId());
		assertNotEquals("123", usuariosCadastrados.get(0).getSenhaUsuario());
		assertNotNull(usuariosCadastrados.get(0).getPerfil());

	}

}
