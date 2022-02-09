package br.com.lovebook.exception;

public class PerfilNaoInformadoException extends RuntimeException {

	private static final String MSG_ERRO_PERFIL_NAO_ENCONTRADO = "Não foi informado um perfil.";
	
	public PerfilNaoInformadoException(){
		super(MSG_ERRO_PERFIL_NAO_ENCONTRADO);
	}
	
	
}
