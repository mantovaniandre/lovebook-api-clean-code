package br.com.lovebook.exception;

public class LivrosNaoEncontradosException extends RuntimeException {

    private static final String MSG_LIVRO_NAO_ENCONTRADO = "Não foram encontrados livros com filtros utilizados";

    public LivrosNaoEncontradosException() {
        super(MSG_LIVRO_NAO_ENCONTRADO);
    }

}
