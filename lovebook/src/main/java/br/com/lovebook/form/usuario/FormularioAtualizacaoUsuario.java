package br.com.lovebook.form.usuario;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.UsuarioRepository;

public class FormularioAtualizacaoUsuario {

	private String nome;
	private String sobrenome;
	private String senhaUsuario;
	private String sexoUsuario;
	private String cepUsuario;
	private String cidadeUsuario;
	private String estadoUsuario;
	private String enderecoUsuario;
	private String numeroEnderecoUsuario;
	private String complementoEnderecoUsuario;
	private String numeroCartaoCredito;
	private String nomeCartaoCredito;
	private String mesExpiracaoCartaoCredito;
	private String anoExpiracaoCartaoCredito;
	private String codigoSegurancaCartaoCredito;
	
	
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
	
	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public String getNumeroEnderecoUsuario() {
		return numeroEnderecoUsuario;
	}

	public void setNumeroEnderecoUsuario(String numeroEnderecoUsuario) {
		this.numeroEnderecoUsuario = numeroEnderecoUsuario;
	}

	public String getComplementoEnderecoUsuario() {
		return complementoEnderecoUsuario;
	}

	public void setComplementoEnderecoUsuario(String complementoEnderecoUsuario) {
		this.complementoEnderecoUsuario = complementoEnderecoUsuario;
	}

	public String getNumeroCartaoCredito() {
		return numeroCartaoCredito;
	}

	public void setNumeroCartaoCredito(String numeroCartaoCredito) {
		this.numeroCartaoCredito = numeroCartaoCredito;
	}

	public String getNomeCartaoCredito() {
		return nomeCartaoCredito;
	}

	public void setNomeCartaoCredito(String nomeCartaoCredito) {
		this.nomeCartaoCredito = nomeCartaoCredito;
	}

	public String getMesExpiracaoCartaoCredito() {
		return mesExpiracaoCartaoCredito;
	}

	public void setMesExpiracaoCartaoCredito(String mesExpiracaoCartaoCredito) {
		this.mesExpiracaoCartaoCredito = mesExpiracaoCartaoCredito;
	}

	public String getAnoExpiracaoCartaoCredito() {
		return anoExpiracaoCartaoCredito;
	}

	public void setAnoExpiracaoCartaoCredito(String anoExpiracaoCartaoCredito) {
		this.anoExpiracaoCartaoCredito = anoExpiracaoCartaoCredito;
	}

	public String getCodigoSegurancaCartaoCredito() {
		return codigoSegurancaCartaoCredito;
	}

	public void setCodigoSegurancaCartaoCredito(String codigoSegurancaCartaoCredito) {
		this.codigoSegurancaCartaoCredito = codigoSegurancaCartaoCredito;
	}


	public Optional<Usuario> atualizar(Long Id, UsuarioRepository usuarioRepository) {
		Optional<Usuario> user = usuarioRepository.findById(Id);
		user.get().setCepUsuario(cepUsuario);
		user.get().setCidadeUsuario(cidadeUsuario);
		user.get().setEstadoUsuario(estadoUsuario);
		user.get().setNome(nome);
		user.get().setSenhaUsuario(senhaUsuario);
		user.get().setSobrenome(sobrenome);
		user.get().setSexoUsuario(sexoUsuario);
		user.get().setEnderecoUsuario(enderecoUsuario);
		user.get().setNumeroEnderecoUsuario(numeroEnderecoUsuario);
		user.get().setComplementoEnderecoUsuario(complementoEnderecoUsuario);
		user.get().setNumeroCartaoCredito(numeroCartaoCredito);
		user.get().setNomeCartaoCredito(nomeCartaoCredito);
		user.get().setMesExpiracaoCartaoCredito(mesExpiracaoCartaoCredito);
		user.get().setAnoExpiracaoCartaoCredito(anoExpiracaoCartaoCredito);
		user.get().setCodigoSegurancaCartaoCredito(codigoSegurancaCartaoCredito);
		return user;
	}

}
