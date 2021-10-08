package br.com.lovebook.dto;

import java.util.Optional;

import br.com.lovebook.model.Usuario;

public class UsuarioDto {

	private String nome;
	private String sobrenome;

	public UsuarioDto(Optional<Usuario> user) {
		this.nome = user.get().getNomeUsuario();
		this.sobrenome = user.get().getSobrenomeUsuario();
	}

	public UsuarioDto(Usuario user) {
		this.nome = user.getNomeUsuario();
		this.sobrenome = user.getSobrenomeUsuario();
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

}
