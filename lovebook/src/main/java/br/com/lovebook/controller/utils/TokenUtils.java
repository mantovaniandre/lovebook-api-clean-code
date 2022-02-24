package br.com.lovebook.controller.utils;

import br.com.lovebook.exception.TokenInvalidoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenUtils {

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_AUTHORIZATION_TYPE = "Bearer ";
    private static final String HEADER_AUTHORIZATION_SEPARADOR = " ";
    private static final int HEADER_AUTHORIZATION_CONTEUDO_SEGUNDO_VALOR = 1;

    @Value("${api.jwt.secret}")
    private String chaveSecretaJwt;

    public String recuperarToken(HttpServletRequest request) {
        String tokenCompleto = this.recuperarTokenCompleto(request);
        if (this.verificarSeTokenNaoEstaValido(tokenCompleto)) {
            throw new TokenInvalidoException();
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

    public Long extrairIdDoUsuarioDoToken(String token) {
        Claims claims = this.decriptografarToken(token);
        return this.converterParaId(claims);
    }

    private Claims decriptografarToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.chaveSecretaJwt).parseClaimsJws(token).getBody();
        return claims;
    }

    private Long converterParaId(Claims claims) {
        return Long.parseLong(claims.getSubject());
    }

    public Long recuperarIdDoUsuario(HttpServletRequest request) {
        String token = this.recuperarToken(request);
        return this.extrairIdDoUsuarioDoToken(token);
    }
}
