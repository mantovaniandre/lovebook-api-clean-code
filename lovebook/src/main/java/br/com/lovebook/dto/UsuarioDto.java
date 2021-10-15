package br.com.lovebook.dto;

import java.util.Optional;

import br.com.lovebook.model.Usuario;

public class UsuarioDto {

	private String nome;
	private String sobrenome;
	private String emailUsuario;
	private String sexoUsuario;
	private String cepUsuario;
	private String cidadeUsuario;
	private String estadoUsuario;

	public UsuarioDto(Optional<Usuario> user) {
		this.nome = user.get().getNomeUsuario();
		this.sobrenome = user.get().getSobrenomeUsuario();
		this.emailUsuario = user.get().getEmailUsuario();
		this.sexoUsuario = user.get().getSexoUsuario();
		this.cepUsuario = user.get().getCepUsuario();
		this.cidadeUsuario = user.get().getCidadeUsuario();
		this.estadoUsuario = user.get().getEstadoUsuario();
	}

	public UsuarioDto(Usuario user) {
		this.nome = user.getNomeUsuario();
		this.sobrenome = user.getSobrenomeUsuario();
		this.emailUsuario = user.getEmailUsuario();
		this.sexoUsuario = user.getSexoUsuario();
		this.cepUsuario = user.getCepUsuario();
		this.cidadeUsuario = user.getCidadeUsuario();
		this.estadoUsuario = user.getEstadoUsuario();
	}

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

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
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

}
