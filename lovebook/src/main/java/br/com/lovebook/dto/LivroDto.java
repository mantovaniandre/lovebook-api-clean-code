package br.com.lovebook.dto;

import br.com.lovebook.model.Livro;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class LivroDto implements Serializable {
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

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.editora = livro.getEditora();
        this.idioma = livro.getIdioma();
        this.nomeDoAutor = livro.getNomeDoAutor();
        this.precoDeVenda = livro.getPrecoDeVenda();
        this.urlDaImagem = livro.getUrlDaImagem();
        this.quantidade = livro.getQuantidade();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.categoria = livro.getCategoria();
        this.custo = livro.getCusto();
    }


}
