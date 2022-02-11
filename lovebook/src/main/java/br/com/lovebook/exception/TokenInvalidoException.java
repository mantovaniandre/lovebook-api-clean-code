package br.com.lovebook.exception;

public class TokenInvalidoException extends RuntimeException {

	private static final String MSG_ERRO_TOKEN_INVALIDO = "O token não está válido";
	
	public TokenInvalidoException(){
		super(MSG_ERRO_TOKEN_INVALIDO);
	}
	
	
}
