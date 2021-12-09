package br.com.lovebook.dto;

import java.util.Optional;

import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;

public class UsuarioDto {

	private String nome;
	private String sobrenome;
	private String emailUsuario;
	private String sexoUsuario;
	private String cepUsuario;
	private String cidadeUsuario;
	private String estadoUsuario;
	private String senhaUsuario;
	private String enderecoUsuario;
	private String numeroEnderecoUsuario;
	private String complementoEnderecoUsuario;
	private String numeroCartaoCredito;
	private String nomeCartaoCredito;
	private String mesExpiracaoCartaoCredito;
	private String anoExpiracaoCartaoCredito;
	private String codigoSegurancaCartaoCredito;
	private Perfil tipoUsuario;

	public UsuarioDto(Optional<Usuario> user) {
		this.nome = user.get().getNome();
		this.sobrenome = user.get().getSobrenome();
		this.emailUsuario = user.get().getEmailUsuario();
		this.sexoUsuario = user.get().getSexoUsuario();
		this.cepUsuario = user.get().getCepUsuario();
		this.cidadeUsuario = user.get().getCidadeUsuario();
		this.estadoUsuario = user.get().getEstadoUsuario();
		this.senhaUsuario = user.get().getPassword();
		this.enderecoUsuario = user.get().getEnderecoUsuario();
		this.numeroEnderecoUsuario = user.get().getNumeroEnderecoUsuario();
		this.complementoEnderecoUsuario = user.get().getComplementoEnderecoUsuario();
		this.numeroCartaoCredito = user.get().getNumeroCartaoCredito();
		this.nomeCartaoCredito = user.get().getNomeCartaoCredito();
		this.mesExpiracaoCartaoCredito = user.get().getMesExpiracaoCartaoCredito();
		this.anoExpiracaoCartaoCredito = user.get().getAnoExpiracaoCartaoCredito();
		this.codigoSegurancaCartaoCredito = user.get().getCodigoSegurancaCartaoCredito();
		this.tipoUsuario = user.get().getPerfil();
		
	}

	public UsuarioDto(Usuario user) {
		this.nome = user.getNome();
		this.sobrenome = user.getSobrenome();
		this.emailUsuario = user.getEmailUsuario();
		this.sexoUsuario = user.getSexoUsuario();
		this.cepUsuario = user.getCepUsuario();
		this.cidadeUsuario = user.getCidadeUsuario();
		this.estadoUsuario = user.getEstadoUsuario();
		this.senhaUsuario = user.getPassword();
		this.enderecoUsuario = user.getEnderecoUsuario();
		this.numeroEnderecoUsuario = user.getNumeroEnderecoUsuario();
		this.complementoEnderecoUsuario = user.getComplementoEnderecoUsuario();
		this.numeroCartaoCredito = user.getNumeroCartaoCredito();
		this.nomeCartaoCredito = user.getNomeCartaoCredito();
		this.mesExpiracaoCartaoCredito = user.getMesExpiracaoCartaoCredito();
		this.anoExpiracaoCartaoCredito = user.getAnoExpiracaoCartaoCredito();
		this.codigoSegurancaCartaoCredito = user.getCodigoSegurancaCartaoCredito();
		this.tipoUsuario = user.getPerfil();
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
	
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
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


	public Perfil getTipoUsuario() {
		return tipoUsuario;
	}
	

	public void setTipoUsuario(Perfil tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
