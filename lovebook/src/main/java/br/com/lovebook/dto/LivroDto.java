package br.com.lovebook.dto;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.lovebook.model.Livro;

public class LivroDto {

	private String nome;
	private String editora;
	private String idioma;
	private String nomeDoAutor;
	private BigDecimal precoDeVenda;
	private String urlDaImagem;
	private Integer quantidade;
	private Integer numeroDePaginas;
	private String categoria;
	private BigDecimal custo;

	public LivroDto(Optional<Livro> livro) {
		this.nome = livro.get().getNomeDoLivro();
		this.editora = livro.get().getEditoraDoLivro();
		this.idioma = livro.get().getIdiomaDoLivro();
		this.nomeDoAutor = livro.get().getNomeDoAutor();
		this.precoDeVenda = livro.get().getPrecoDeVendaDoLivro();
		this.urlDaImagem = livro.get().getUrlDaImagemDoLivro();
		this.quantidade = livro.get().getQuantidadeDeLivros();
		this.numeroDePaginas = livro.get().getNumeroDaPaginaDoLivro();
		this.categoria = livro.get().getCategoriaDoLivro();
		this.custo = livro.get().getCustoDoLivro();
	}

	public LivroDto(Livro livro) {
		this.nome = livro.getNomeDoLivro();
		this.editora = livro.getEditoraDoLivro();
		this.idioma = livro.getIdiomaDoLivro();
		this.nomeDoAutor = livro.getNomeDoAutor();
		this.precoDeVenda = livro.getPrecoDeVendaDoLivro();
		this.urlDaImagem = livro.getUrlDaImagemDoLivro();
		this.quantidade = livro.getQuantidadeDeLivros();
		this.numeroDePaginas = livro.getNumeroDaPaginaDoLivro();
		this.categoria = livro.getCategoriaDoLivro();
		this.custo = livro.getCustoDoLivro();
	}

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
		precoDeVenda = precoDeVenda;
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

}
