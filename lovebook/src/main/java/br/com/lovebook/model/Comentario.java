package br.com.lovebook.model;

import br.com.lovebook.form.comentario.FormularioCriacaoComentario;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
public class Comentario implements Serializable {

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

    public Comentario() {

    }

    public Comentario(FormularioCriacaoComentario formularioCriacaoComentario, Usuario usuario, Livro livro) {
        super();
        this.data = new Date();
        this.titulo = formularioCriacaoComentario.getTituloDoComentario();
        this.comentario = formularioCriacaoComentario.getComentarioConteudo();
        this.usuario = usuario;
        this.livro = livro;
        this.nota = formularioCriacaoComentario.getNota();
    }

}
