package br.com.lovebook.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.lovebook.model.Compra;

public class CompraDto {

	private String nomeDoLivro;
	private String nomeDoAutor;
	private BigDecimal preco;
	private LocalDate data;
	private String urlImagemLivro;
	private String categoria;

	public CompraDto(Compra compra) {
		this.nomeDoLivro = compra.getLivro().getNomeDoLivro();
		this.nomeDoAutor = compra.getLivro().getNomeDoAutor();
		this.preco = compra.getPreco();
		this.data = compra.getData();
		this.urlImagemLivro = compra.getLivro().getUrlDaImagemDoLivro();
		this.categoria = compra.getLivro().getCategoriaDoLivro();
	}

	public String getNomeDoLivro() {
		return nomeDoLivro;
	}

	public void setNomeDoLivro(String nomeDoLivro) {
		this.nomeDoLivro = nomeDoLivro;
	}

	public String getNomeDoAutor() {
		return nomeDoAutor;
	}

	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getUrlImagemLivro() {
		return urlImagemLivro;
	}

	public void setUrlImagemLivro(String urlImagemLivro) {
		this.urlImagemLivro = urlImagemLivro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
