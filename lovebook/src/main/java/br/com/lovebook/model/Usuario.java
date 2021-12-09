package br.com.lovebook.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	private String emailUsuario;
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
	@ManyToOne
	private Perfil perfil;

	public Usuario() {

	}

	public Usuario(String nome, String sobrenome, String emailUsuario, String senhaUsuario, String sexoUsuario,
			String cepUsuario, String cidadeUsuario, String estadoUsuario, String enderecoUsuario,
			String numeroEnderecoUsuario, String complementoEnderecoUsuario, String numeroCartaoCredito,
			String nomeCartaoCredito, String mesExpiracaoCartaoCredito, String anoExpiracaoCartaoCredito,
			String codigoSegurancaCartaoCredito, Perfil perfil) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.sexoUsuario = sexoUsuario;
		this.cepUsuario = cepUsuario;
		this.cidadeUsuario = cidadeUsuario;
		this.estadoUsuario = estadoUsuario;
		this.enderecoUsuario = enderecoUsuario;
		this.numeroEnderecoUsuario = numeroEnderecoUsuario;
		this.complementoEnderecoUsuario = complementoEnderecoUsuario;
		this.numeroCartaoCredito = numeroCartaoCredito;
		this.nomeCartaoCredito = nomeCartaoCredito;
		this.mesExpiracaoCartaoCredito = mesExpiracaoCartaoCredito;
		this.anoExpiracaoCartaoCredito = anoExpiracaoCartaoCredito;
		this.codigoSegurancaCartaoCredito = codigoSegurancaCartaoCredito;
		this.perfil = perfil;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	@Override
	public String toString() {
		return "CadastrarUsuarioModel [id=" + id + ", nomeUsuario=" + nome + ", sobrenomeUsuario=" + sobrenome
				+ ", emailUsuario=" + emailUsuario + ", senhaUsuario=" + senhaUsuario + ", sexoUsuario=" + sexoUsuario
				+ ", cepUsuario=" + cepUsuario + ", cidadeUsuario=" + cidadeUsuario + ", estadoUsuario=" + estadoUsuario
				+ ", enderecoUsuario=" + enderecoUsuario
				+ ", numeroEnderecoUsuario=" + numeroEnderecoUsuario
				+ ", complementoEnderecoUsuario=" + complementoEnderecoUsuario
				+ ", numeroCartaoCredito=" + numeroCartaoCredito
				+ ", nomeCartaoCredito=" + nomeCartaoCredito
				+ ", mesExpiracaoCartaoCredito=" + mesExpiracaoCartaoCredito
				+ ", anoExpiracaoCartaoCredito=" + anoExpiracaoCartaoCredito
				+ ", codigoSegurancaCartaoCredito=" + codigoSegurancaCartaoCredito
				+ ", tipoUsuario=" + perfil + "]";
	}	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senhaUsuario;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.emailUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
