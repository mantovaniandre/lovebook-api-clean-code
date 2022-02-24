package br.com.lovebook.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    private static final String MSG_ERRO_USUARIO_NAO_ENCONTRADO = "O usuário não foi encontrado";

    public UsuarioNaoEncontradoException() {
        super(MSG_ERRO_USUARIO_NAO_ENCONTRADO);
    }

}
