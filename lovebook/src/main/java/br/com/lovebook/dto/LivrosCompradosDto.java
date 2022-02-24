package br.com.lovebook.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LivrosCompradosDto implements Serializable {

    private String nome;
    private String editora;
    private String idioma;
    private String nomeDoAutor;
    private String urlDaImagem;
    private Integer quantidadeComprada;
    private Integer numeroDePaginas;
    private String categoria;


}
