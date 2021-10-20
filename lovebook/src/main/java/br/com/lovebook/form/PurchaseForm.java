package br.com.lovebook.form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;

public class PurchaseForm {

	private List<Long> listaIds = new ArrayList<>();

	public List<Long> getListaIds() {
		return listaIds;
	}

	public void setListaIds(List<Long> listaIds) {
		this.listaIds = listaIds;
	}
	
	public Compra converter(Usuario usuario, Livro livro) {
		return new Compra(usuario, livro, LocalDate.now(), livro.getPrecoDeVendaDoLivro(), livro.getCategoriaDoLivro());
	}

}
