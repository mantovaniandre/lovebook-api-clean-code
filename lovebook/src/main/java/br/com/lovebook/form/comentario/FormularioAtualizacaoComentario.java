package br.com.lovebook.form.comentario;

import br.com.lovebook.model.Comentario;
import br.com.lovebook.repository.ComentarioRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

public class FormularioAtualizacaoComentario {

    @NotNull
    @NotEmpty
    private String tituloDoComentario;
    @NotNull
    @NotEmpty
    private String comentarioConteudo;
    @NotNull
    @NotEmpty
    private Date dataComentario;

    private Long idDoLivro;

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

    public Date getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(Date dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Optional<Comentario> atualizar(ComentarioRepository comentarioRepository) {
        Optional<Comentario> comentarios = comentarioRepository.findById(this.idDoLivro);
        comentarios.get().setTitulo(tituloDoComentario);
        comentarios.get().setComentario(comentarioConteudo);
        comentarios.get().setData(dataComentario);
        return comentarios;
    }


}
