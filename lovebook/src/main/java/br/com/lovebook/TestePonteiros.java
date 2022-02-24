package br.com.lovebook;

import br.com.lovebook.model.Usuario;

public class TestePonteiros {

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario();
        usuario1.setNome("André");
        Usuario usuario2 = new Usuario();
        usuario2.setNome("Carlos");

        System.out.println(usuario1);


    }

}
