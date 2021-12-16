package br.com.lovebook.dto;

import java.util.Date;
import java.util.Optional;

import javax.persistence.ManyToOne;

import br.com.lovebook.model.Comentarios;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;

public class ComentariosDto {

	
	private Date data;
	private String titulo;
	private String comentario;
	private String usuario;
	private Livro livro;
	
	
	public ComentariosDto(Optional<Comentarios> comentarios) {
		this.data = comentarios.get().getData();
		this.titulo = comentarios.get().getTitulo();
		this.comentario = comentarios.get().getComentario();
		this.usuario = comentarios.get().getUsuario().getNome();
		this.livro = comentarios.get().getLivro();
	}
	
	
	public ComentariosDto(Comentarios comentarios) {
		this.data = comentarios.getData();
		this.titulo = comentarios.getTitulo();
		this.comentario = comentarios.getComentario();
		this.usuario = comentarios.getUsuario().getNome();
		this.livro = comentarios.getLivro();
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
}
