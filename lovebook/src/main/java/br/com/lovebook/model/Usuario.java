package br.com.lovebook.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {

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
	@ManyToOne
	private Perfil perfil;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Livro> listaLivro = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(String nome, String sobrenome, String emailUsuario, String senhaUsuario, String sexoUsuario,
			String cepUsuario, String cidadeUsuario, String estadoUsuario, Perfil perfil) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.sexoUsuario = sexoUsuario;
		this.cepUsuario = cepUsuario;
		this.cidadeUsuario = cidadeUsuario;
		this.estadoUsuario = estadoUsuario;
		this.perfil = perfil;
	}

	public String getNomeUsuario() {
		return nome;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nome = nomeUsuario;
	}

	public String getSobrenomeUsuario() {
		return sobrenome;
	}

	public void setSobrenomeUsuario(String sobrenomeUsuario) {
		this.sobrenome = sobrenomeUsuario;
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

	public Perfil getTipoUsuario() {
		return perfil;
	}

	public void setTipoUsuario(Perfil tipoUsuario) {
		this.perfil = tipoUsuario;
	}

	@Override
	public String toString() {
		return "CadastrarUsuarioModel [id=" + id + ", nomeUsuario=" + nome + ", sobrenomeUsuario=" + sobrenome
				+ ", emailUsuario=" + emailUsuario + ", senhaUsuario=" + senhaUsuario + ", sexoUsuario=" + sexoUsuario
				+ ", cepUsuario=" + cepUsuario + ", cidadeUsuario=" + cidadeUsuario + ", estadoUsuario=" + estadoUsuario
				+ ", tipoUsuario=" + perfil + "]";
	}
}
