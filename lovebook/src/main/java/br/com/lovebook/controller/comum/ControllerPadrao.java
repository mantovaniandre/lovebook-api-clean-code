package br.com.lovebook.controller.comum;

import br.com.lovebook.controller.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public abstract class ControllerPadrao {


    @Autowired
    private TokenUtils tokenUtils;

    protected Long recuperarIdDoUsuario(HttpServletRequest request) {
        return tokenUtils.recuperarIdDoUsuario(request);
    }
}
