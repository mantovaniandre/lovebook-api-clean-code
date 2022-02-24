package br.com.lovebook.model;

import br.com.lovebook.form.ComentariosForm;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
public class Comentarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private String titulo;
    private String comentario;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Livro livro;
    private Double nota;

    public Comentarios() {

    }

    public Comentarios(ComentariosForm comentariosForm, Usuario usuario, Livro livro) {
        super();
        this.data = new Date();
        this.titulo = comentariosForm.getTituloDoComentario();
        this.comentario = comentariosForm.getComentarioConteudo();
        this.usuario = usuario;
        this.livro = livro;
        this.nota = comentariosForm.getNota();
    }

}
