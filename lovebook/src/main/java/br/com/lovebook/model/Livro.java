package br.com.lovebook.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome = "";
    private String editora = "";
    private String idioma = "";
    private String nomeDoAutor = "";
    private BigDecimal precoDeVenda;
    private String urlDaImagem = "";
    private Integer quantidade;
    private Integer numeroDePaginas;
    private String categoria = "";
    private BigDecimal custo;
    private Double nota = 0.0;
    private Boolean ativo = true;

    public Livro() {

    }

    public Livro(String nome, String editora, String idioma, String nomeDoAutor, BigDecimal precoDeVenda,
                 String urlDaImagem, Integer quantidade, Integer numeroDePaginas, String categoria, BigDecimal custo,
                 Boolean ativo) {
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
        this.ativo = ativo;
    }

    public Livro(Long id, String nome, String editora, String idioma, String nomeDoAutor, BigDecimal precoDeVenda,
                 String urlDaImagem, Integer quantidade, Integer numeroDePaginas, String categoria, BigDecimal custo,
                 Boolean ativo) {
        this(nome, editora, idioma, nomeDoAutor, precoDeVenda, urlDaImagem, quantidade, numeroDePaginas, categoria,
                custo, ativo);
        this.id = id;
    }

}
