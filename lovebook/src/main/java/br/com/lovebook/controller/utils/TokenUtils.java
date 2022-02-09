package br.com.lovebook.controller.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class TokenUtils {

	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final String HEADER_AUTHORIZATION_TYPE = "Bearer ";
	private static final String HEADER_AUTHORIZATION_SEPARADOR = " ";
	private static final int HEADER_AUTHORIZATION_CONTEUDO_SEGUNDO_VALOR = 1;

	public String recuperarToken(HttpServletRequest request) {
		String tokenCompleto = this.recuperarTokenCompleto(request);
		if(this.verificarSeTokenNaoEstaValido(tokenCompleto)) {
			return null;
		}

		return this.recuperarConteudoDoToken(tokenCompleto);
	}

	private String recuperarTokenCompleto(HttpServletRequest request) {
		return request.getHeader(HEADER_AUTHORIZATION);
	}

	private boolean verificarSeTokenNaoEstaValido(String token) {
		return Strings.isEmpty(token) || !token.startsWith(HEADER_AUTHORIZATION_TYPE); 
	}

	private String recuperarConteudoDoToken(String tokenCompleto) {
		return tokenCompleto.split(HEADER_AUTHORIZATION_SEPARADOR)[HEADER_AUTHORIZATION_CONTEUDO_SEGUNDO_VALOR];
	}
}
