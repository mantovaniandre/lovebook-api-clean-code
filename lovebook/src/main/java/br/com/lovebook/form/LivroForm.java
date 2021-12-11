package br.com.lovebook.form;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.lovebook.model.Livro;

public class LivroForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String editora;
	@NotNull
	@NotEmpty
	private String idioma;
	@NotNull
	@NotEmpty
	private String nomeDoAutor;
	@NotNull
	private BigDecimal precoDeVenda;
	@NotNull
	@NotEmpty
	private String urlDaImagem;
	@NotNull
	private Integer quantidade;
	@NotNull
	private Integer numeroDePaginas;
	@NotNull
	@NotEmpty
	private String categoria;
	@NotNull
	private BigDecimal custo;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNomeDoAutor() {
		return nomeDoAutor;
	}

	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}

	public BigDecimal getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(BigDecimal precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public String getUrlDaImagem() {
		return urlDaImagem;
	}

	public void setUrlDaImagem(String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public Livro converter() {

		return new Livro(this.nome, this.editora, this.idioma, this.nomeDoAutor, this.precoDeVenda, this.urlDaImagem,
				this.quantidade, this.numeroDePaginas, this.categoria, this.custo);
	}
	
	

}
