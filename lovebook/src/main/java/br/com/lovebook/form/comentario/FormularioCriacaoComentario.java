package br.com.lovebook.form.comentario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FormularioCriacaoComentario {

    @NotNull
    @NotEmpty
    private String tituloDoComentario;
    @NotNull
    @NotEmpty
    private String comentarioConteudo;
    private Long idDoLivro;
    private Double nota;

    public FormularioCriacaoComentario() {

    }

    public String getTituloDoComentario() {
        return tituloDoComentario;
    }

    public void setTituloDoComentario(String tituloDoComentario) {
        this.tituloDoComentario = tituloDoComentario;
    }

    public String getComentarioConteudo() {
        return comentarioConteudo;
    }

    public void setComentarioConteudo(String comentarioConteudo) {
        this.comentarioConteudo = comentarioConteudo;
    }

    public Long getIdDoLivro() {
        return idDoLivro;
    }

    public void setIdDoLivro(Long idDoLivro) {
        this.idDoLivro = idDoLivro;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

}
