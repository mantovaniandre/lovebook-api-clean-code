package br.com.lovebook.form.livro;

import br.com.lovebook.model.Livro;
import br.com.lovebook.repository.LivroRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@Data
public class FormularioAtualizacaoLivro implements Serializable {

    private Long id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String editora;
    @NotNull
    @NotEmpty
    private String idioma;
    @NotNull
    @NotEmpty
    private String nomeDoAutor;
    @NotNull
    private BigDecimal precoDeVenda;
    @NotNull
    @NotEmpty
    private String urlDaImagem;
    @NotNull
    private Integer quantidade;
    @NotNull
    private Integer numeroDePaginas;
    @NotNull
    @NotEmpty
    private String categoria;
    @NotNull
    private BigDecimal custo;

    public Optional<Livro> atualizar(LivroRepository livroRepository) {
        Optional<Livro> livro = livroRepository.findById(this.id);
        livro.get().setCategoria(this.categoria);
        livro.get().setCusto(custo);
        livro.get().setEditora(editora);
        livro.get().setIdioma(idioma);
        livro.get().setNomeDoAutor(nomeDoAutor);
        livro.get().setNome(nome);
        livro.get().setNumeroDePaginas(numeroDePaginas);
        livro.get().setPrecoDeVenda(precoDeVenda);
        livro.get().setQuantidade(quantidade);
        livro.get().setUrlDaImagem(urlDaImagem);
        return livro;
    }
}
