package br.com.lovebook.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.lovebook.model.Comentarios;

public class ComentariosForm {

	@NotNull
	@NotEmpty
	private String tituloDoComentario;
	@NotNull
	@NotEmpty
	private String comentarioConteudo;
	private Long idDoLivro;
	private Double nota;

	public ComentariosForm() {

	}

	public String getTituloDoComentario() {
		return tituloDoComentario;
	}

	public void setTituloDoComentario(String tituloDoComentario) {
		this.tituloDoComentario = tituloDoComentario;
	}

	public String getComentarioConteudo() {
		return comentarioConteudo;
	}

	public void setComentarioConteudo(String comentarioConteudo) {
		this.comentarioConteudo = comentarioConteudo;
	}

	public Long getIdDoLivro() {
		return idDoLivro;
	}

	public void setIdDoLivro(Long idDoLivro) {
		this.idDoLivro = idDoLivro;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

}
