package br.com.lovebook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.lovebook.LovebookApplication;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.exception.PerfilNaoEncontradoException;
import br.com.lovebook.exception.PerfilNaoInformadoException;
import br.com.lovebook.exception.UsuarioNaoEncontradoException;
import br.com.lovebook.form.usuario.FormularioAtualizacaoUsuario;
import br.com.lovebook.form.usuario.FormularioCriacaoUsuario;
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

		FormularioCriacaoUsuario usuarioForm = new FormularioCriacaoUsuario();
		usuarioForm.setSenhaUsuario("123");

		assertThrows(PerfilNaoInformadoException.class, () -> this.usuarioService.salvar(usuarioForm));

	}

	@Test
	void deveLancarErroAoSalvaUsuarioComPerfilNaoEncontrado() {

		FormularioCriacaoUsuario usuarioForm = new FormularioCriacaoUsuario();
		usuarioForm.setSenhaUsuario("123");
		usuarioForm.setPerfil("Funcionario");

		assertThrows(PerfilNaoEncontradoException.class, () -> this.usuarioService.salvar(usuarioForm));

	}

	@Test
	void deveSalvarUsuarioComPerfilCorretamente() {
		fabricaDeCadastro.criarPerfil("Cliente");

		FormularioCriacaoUsuario usuarioForm = new FormularioCriacaoUsuario();
		usuarioForm.setSenhaUsuario("123");
		usuarioForm.setPerfil("Cliente");

		UsuarioDto usuarioSalvo = this.usuarioService.salvar(usuarioForm);

		List<Usuario> usuariosCadastrados = this.usuarioRepository.findAll();

		assertEquals(1, usuariosCadastrados.size());
		assertNotEquals("123", usuariosCadastrados.get(0).getSenhaUsuario());
		assertNotNull(usuariosCadastrados.get(0).getPerfil());

	}

	@Test
	void deveBuscarUsuarioPorIdCorretamente() {
		Usuario usuarioAndre = fabricaDeCadastro.criarUsuario("André");
		Long idDoUsuario = usuarioAndre.getId();

		UsuarioDto usuarioRecuperado = usuarioService.recuperarUsuarioSeExistir(idDoUsuario);

		assertEquals("André", usuarioRecuperado.getNome());

	}

	@Test
	void deveLancarErroAoBuscarUsuarioPorIdInvalido() {

		assertThrows(UsuarioNaoEncontradoException.class, () -> this.usuarioService.recuperarUsuarioSeExistir(100L));

	}

	@Test
	void deveDeletarUsuarioCorretamente() {
		Usuario usuarioAndre = fabricaDeCadastro.criarUsuario("André");
		Usuario usuarioCarlos = fabricaDeCadastro.criarUsuario("Carlos");

		List<Usuario> usuariosCadastrados = this.usuarioRepository.findAll();

		assertEquals(2, usuariosCadastrados.size());

		this.usuarioService.deletarUsuario(usuarioAndre.getId());

		usuariosCadastrados = this.usuarioRepository.findAll();

		assertEquals(1, usuariosCadastrados.size());
		assertEquals("Carlos", usuariosCadastrados.get(0).getNome());

	}

	@Test
	void deveAtualizarUsuarioCorretamente() {
		Usuario usuarioAndre = fabricaDeCadastro.criarUsuario("André");

		FormularioAtualizacaoUsuario atualizacaoUsuarioForm = new FormularioAtualizacaoUsuario();
		atualizacaoUsuarioForm.setNome("Carlos");

		usuarioService.atualizarUsuario(atualizacaoUsuarioForm, usuarioAndre.getId());

		List<Usuario> usuariosAposAtualizacao = usuarioRepository.findAll();

		assertEquals(1, usuariosAposAtualizacao.size());
		assertEquals("Carlos", usuariosAposAtualizacao.get(0).getNome());

	}

	@Test
	void deveAtualizarSenhaCorretamente() {
		Usuario usuarioComDadosOriginais = fabricaDeCadastro.criarUsuario("André");

		FormularioAtualizacaoUsuario atualizacaoUsuarioForm = new FormularioAtualizacaoUsuario();
		atualizacaoUsuarioForm.setSenhaUsuario("321");

		usuarioService.atualizarUsuario(atualizacaoUsuarioForm, usuarioComDadosOriginais.getId());

		List<Usuario> usuariosAposAtualizacao = usuarioRepository.findAll();

		assertEquals(1, usuariosAposAtualizacao.size());
		assertNotEquals(FabricaDeCadastro.SENHA_PADRAO, usuariosAposAtualizacao.get(0).getSenhaUsuario());

	}

}
