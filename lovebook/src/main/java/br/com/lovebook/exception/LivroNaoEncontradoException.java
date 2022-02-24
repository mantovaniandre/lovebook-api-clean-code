package br.com.lovebook.exception;

public class LivroNaoEncontradoException extends RuntimeException {

    private static final String MSG_ERRO_LIVRO_NAO_ENCONTRADO = "O livro não foi encontrado";

    public LivroNaoEncontradoException() {
        super(MSG_ERRO_LIVRO_NAO_ENCONTRADO);
    }

}
