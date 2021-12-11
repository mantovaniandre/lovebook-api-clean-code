package br.com.lovebook.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	public Livro () {
		
	}

	public Livro(String nome, String editora, String idioma, String nomeDoAutor, BigDecimal precoDeVenda,
			String urlDaImagem, Integer quantidade, Integer numeroDePaginas, String categoria, BigDecimal custo) {
		super();
		this.nome = nome;
		this.editora = editora;
		this.idioma = idioma;
		this.nomeDoAutor = nomeDoAutor;
		this.precoDeVenda = precoDeVenda;
		this.urlDaImagem = urlDaImagem;
		this.quantidade = quantidade;
		this.numeroDePaginas = numeroDePaginas;
		this.categoria = categoria;
		this.custo = custo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoLivro() {
		return nome;
	}

	public void setNomeDoLivro(String nomeDoLivro) {
		this.nome = nomeDoLivro;
	}

	public String getEditoraDoLivro() {
		return editora;
	}

	public void setEditoraDoLivro(String editoraDoLivro) {
		this.editora = editoraDoLivro;
	}

	public String getIdiomaDoLivro() {
		return idioma;
	}

	public void setIdiomaDoLivro(String idiomaDoLivro) {
		this.idioma = idiomaDoLivro;
	}

	public String getNomeDoAutor() {
		return nomeDoAutor;
	}

	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}

	public BigDecimal getPrecoDeVendaDoLivro() {
		return precoDeVenda;
	}

	public void setPrecoDeVendaDoLivro(BigDecimal precoDeVendaDoLivro) {
		precoDeVenda = precoDeVendaDoLivro;
	}

	public String getUrlDaImagemDoLivro() {
		return urlDaImagem;
	}

	public void setUrlDaImagemDoLivro(String urlDaImagemDoLivro) {
		this.urlDaImagem = urlDaImagemDoLivro;
	}

	public Integer getQuantidadeDeLivros() {
		return quantidade;
	}

	public void setQuantidadeDeLivros(Integer quantidadeDeLivros) {
		this.quantidade = quantidadeDeLivros;
	}

	public Integer getNumeroDaPaginaDoLivro() {
		return numeroDePaginas;
	}

	public void setNumeroDaPaginaDoLivro(Integer numeroDaPaginaDoLivro) {
		this.numeroDePaginas = numeroDaPaginaDoLivro;
	}

	public String getCategoriaDoLivro() {
		return categoria;
	}

	public void setCategoriaDoLivro(String categoriaDoLivro) {
		this.categoria = categoriaDoLivro;
	}

	public BigDecimal getCustoDoLivro() {
		return custo;
	}

	public void setCustoDoLivro(BigDecimal custoDoLivro) {
		this.custo = custoDoLivro;
	}

}
