package br.com.lovebook.converter;

import br.com.lovebook.form.livro.FormularioAtualizacaoLivro;
import br.com.lovebook.form.livro.FormularioCriacaoLivro;
import br.com.lovebook.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroConverter {

    public Livro converterParaEntidade(FormularioCriacaoLivro formularioCriacaoLivro) {

        return new Livro(formularioCriacaoLivro.getNome(), formularioCriacaoLivro.getEditora(), formularioCriacaoLivro.getIdioma(),
                formularioCriacaoLivro.getNomeDoAutor(), formularioCriacaoLivro.getPrecoDeVenda(), formularioCriacaoLivro.getUrlDaImagem(),
                formularioCriacaoLivro.getQuantidade(), formularioCriacaoLivro.getNumeroDePaginas(), formularioCriacaoLivro.getCategoria(),
                formularioCriacaoLivro.getCusto(), true);
    }

    public Livro converterParaEntidade(FormularioAtualizacaoLivro formularioAtualizacaoLivro) {

        return new Livro(formularioAtualizacaoLivro.getId(), formularioAtualizacaoLivro.getNome(), formularioAtualizacaoLivro.getEditora(), formularioAtualizacaoLivro.getIdioma(),
                formularioAtualizacaoLivro.getNomeDoAutor(), formularioAtualizacaoLivro.getPrecoDeVenda(), formularioAtualizacaoLivro.getUrlDaImagem(),
                formularioAtualizacaoLivro.getQuantidade(), formularioAtualizacaoLivro.getNumeroDePaginas(), formularioAtualizacaoLivro.getCategoria(),
                formularioAtualizacaoLivro.getCusto(), true);
    }

}
