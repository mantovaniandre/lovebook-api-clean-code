package br.com.lovebook.form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.lovebook.model.Comentarios;
import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Livro;

import br.com.lovebook.model.Usuario;


public class ComentariosForm {

	private List<Long> listaIds = new ArrayList<>();

	public List<Long> getListaIds() {
		return listaIds;
	}

	public void setListaIds(List<Long> listaIds) {
		this.listaIds = listaIds;
	}
	
	public Comentarios converter(Comentarios comentarios) {
		return new Comentarios(comentarios.getData(), comentarios.getTitulo(), comentarios.getComentario(), comentarios.getUsuario(), comentarios.getLivro());
	}
	
	
}
