package br.com.lovebook.dto;

import br.com.lovebook.model.Comentario;
import br.com.lovebook.model.Livro;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Data
public class ComentarioDto implements Serializable {

    private Long id;
    private Date data;
    private String titulo;
    private String comentario;
    private String usuario;
    private Livro livro;
    private Double nota;

    public ComentarioDto(Optional<Comentario> comentarios) {
        this.id = comentarios.get().getId();
        this.data = comentarios.get().getData();
        this.titulo = comentarios.get().getTitulo();
        this.comentario = comentarios.get().getComentario();
        this.usuario = comentarios.get().getUsuario().getNome();
        this.livro = comentarios.get().getLivro();
        this.nota = comentarios.get().getNota();
    }

    public ComentarioDto(Comentario comentario) {
        this.id = comentario.getId();
        this.data = comentario.getData();
        this.titulo = comentario.getTitulo();
        this.comentario = comentario.getComentario();
        this.usuario = comentario.getUsuario().getNome();
        this.livro = comentario.getLivro();
        this.nota = comentario.getNota();
    }


}
