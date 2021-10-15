package br.com.lovebook.form;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForm {

	private List<Long> listaIds = new ArrayList<>();

	public List<Long> getListaIds() {
		return listaIds;
	}

	public void setListaIds(List<Long> listaIds) {
		this.listaIds = listaIds;
	}

}
