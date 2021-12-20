package br.com.lovebook.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.lovebook.model.Comentarios;
import br.com.lovebook.repository.ComentariosRepository;

public class AtualizacaoComentariosForm {
	
	@NotNull
	@NotEmpty
	private String tituloDoComentario;
	@NotNull
	@NotEmpty
	private String comentarioConteudo;
	private Long idDoLivro;
	
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
	
	public Optional<Comentarios> atualizar(ComentariosRepository comentariosRepository){
		Optional<Comentarios> comentarios = comentariosRepository.findById(this.idDoLivro);
		comentarios.get().setTitulo(tituloDoComentario);
		comentarios.get().setComentario(comentarioConteudo);
		return comentarios;
	}
	
	
	
}
