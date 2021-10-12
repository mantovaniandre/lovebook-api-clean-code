package br.com.lovebook.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String sobrenome;
	@NotNull
	private String senhaUsuario;
	@NotNull
	@NotEmpty
	private String sexoUsuario;
	@NotNull
	@NotEmpty
	private String cepUsuario;
	@NotNull
	@NotEmpty
	private String cidadeUsuario;
	@NotNull
	@NotEmpty
	private String estadoUsuario;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getSexoUsuario() {
		return sexoUsuario;
	}

	public void setSexoUsuario(String sexoUsuario) {
		this.sexoUsuario = sexoUsuario;
	}

	public String getCepUsuario() {
		return cepUsuario;
	}

	public void setCepUsuario(String cepUsuario) {
		this.cepUsuario = cepUsuario;
	}

	public String getCidadeUsuario() {
		return cidadeUsuario;
	}

	public void setCidadeUsuario(String cidadeUsuario) {
		this.cidadeUsuario = cidadeUsuario;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	
	public Optional<Usuario> atualizar(Long Id, UsuarioRepository usuarioRepository) {
		Optional<Usuario> user = usuarioRepository.findById(Id);
		user.get().setCepUsuario(cepUsuario);
		user.get().setCidadeUsuario(cidadeUsuario);
		user.get().setEstadoUsuario(estadoUsuario);
		user.get().setNomeUsuario(nome);
		user.get().setSenhaUsuario(senhaUsuario);
		user.get().setSobrenomeUsuario(sobrenome);
		user.get().setSexoUsuario(sexoUsuario);
		return user;
	}

}
