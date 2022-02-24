package br.com.lovebook.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Livro livro;
    private LocalDate data;
    private BigDecimal preco;
    private String categoria;

    public Compra() {

    }

    public Compra(Usuario usuario, Livro livro, LocalDate data, BigDecimal preco, String categoria) {
        this.usuario = usuario;
        this.livro = livro;
        this.data = data;
        this.preco = preco;
        this.categoria = categoria;

    }


}
