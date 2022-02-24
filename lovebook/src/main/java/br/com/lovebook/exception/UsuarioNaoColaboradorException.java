package br.com.lovebook.exception;

public class UsuarioNaoColaboradorException extends RuntimeException {

    private static final String MSG_USUARIO_NAO_COLABORADOR = "O usuário não é um colaborador";

    public UsuarioNaoColaboradorException() {
        super(MSG_USUARIO_NAO_COLABORADOR);
    }

}
