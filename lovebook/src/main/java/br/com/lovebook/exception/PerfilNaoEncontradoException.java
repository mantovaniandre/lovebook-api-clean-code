package br.com.lovebook.exception;

public class PerfilNaoEncontradoException extends RuntimeException {

	private static final String MSG_ERRO_PERFIL_NAO_ENCONTRADO = "O perfil '%s' não está cadastrado.";
	
	public PerfilNaoEncontradoException(String nomeDoPerfil){
		super(String.format(MSG_ERRO_PERFIL_NAO_ENCONTRADO, nomeDoPerfil));
	}
	
	
}
