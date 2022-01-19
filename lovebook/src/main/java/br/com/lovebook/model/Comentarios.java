package br.com.lovebook.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.lovebook.form.ComentariosForm;

@Entity
public class Comentarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data;
	private String titulo;
	private String comentario;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Livro livro;
	private Double nota;

	public Comentarios() {

	}

	public Comentarios(ComentariosForm comentariosForm, Usuario usuario, Livro livro) {
		super();
		this.data = new Date();
		this.titulo = comentariosForm.getTituloDoComentario();
		this.comentario = comentariosForm.getComentarioConteudo();
		this.usuario = usuario;
		this.livro = livro;
		this.nota = comentariosForm.getNota();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", data=" + data + ", titulo=" + titulo + ", comentario=" + comentario
				+ ", usuario=" + usuario + ", livro=" + livro + "]";
	}

}
