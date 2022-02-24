package br.com.lovebook.dto;

import br.com.lovebook.model.Compra;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CompraDto implements Serializable {

    private String nomeDoLivro;
    private String nomeDoAutor;
    private BigDecimal preco;
    private LocalDate data;
    private String urlImagemLivro;
    private String categoria;

    public CompraDto(Compra compra) {
        this.nomeDoLivro = compra.getLivro().getNome();
        this.nomeDoAutor = compra.getLivro().getNomeDoAutor();
        this.preco = compra.getPreco();
        this.data = compra.getData();
        this.urlImagemLivro = compra.getLivro().getUrlDaImagem();
        this.categoria = compra.getLivro().getCategoria();
    }


}
