package br.com.lovebook.dto;

import br.com.lovebook.model.Comentarios;
import br.com.lovebook.model.Livro;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Data
public class ComentariosDto implements Serializable {

    private Long id;
    private Date data;
    private String titulo;
    private String comentario;
    private String usuario;
    private Livro livro;
    private Double nota;

    public ComentariosDto(Optional<Comentarios> comentarios) {
        this.id = comentarios.get().getId();
        this.data = comentarios.get().getData();
        this.titulo = comentarios.get().getTitulo();
        this.comentario = comentarios.get().getComentario();
        this.usuario = comentarios.get().getUsuario().getNome();
        this.livro = comentarios.get().getLivro();
        this.nota = comentarios.get().getNota();
    }

    public ComentariosDto(Comentarios comentarios) {
        this.id = comentarios.getId();
        this.data = comentarios.getData();
        this.titulo = comentarios.getTitulo();
        this.comentario = comentarios.getComentario();
        this.usuario = comentarios.getUsuario().getNome();
        this.livro = comentarios.getLivro();
        this.nota = comentarios.getNota();
    }


}
