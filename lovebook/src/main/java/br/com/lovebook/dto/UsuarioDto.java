package br.com.lovebook.dto;

import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioDto implements Serializable {

    private String nome;
    private String sobrenome;
    private String emailUsuario;
    private String sexoUsuario;
    private String cepUsuario;
    private String cidadeUsuario;
    private String estadoUsuario;
    private String senhaUsuario;
    private String enderecoUsuario;
    private String numeroEnderecoUsuario;
    private String complementoEnderecoUsuario;
    private String numeroCartaoCredito;
    private String nomeCartaoCredito;
    private String mesExpiracaoCartaoCredito;
    private String anoExpiracaoCartaoCredito;
    private String codigoSegurancaCartaoCredito;
    private Perfil tipoUsuario;

    public UsuarioDto(Usuario user) {
        this.nome = user.getNome();
        this.sobrenome = user.getSobrenome();
        this.emailUsuario = user.getEmailUsuario();
        this.sexoUsuario = user.getSexoUsuario();
        this.cepUsuario = user.getCepUsuario();
        this.cidadeUsuario = user.getCidadeUsuario();
        this.estadoUsuario = user.getEstadoUsuario();
        this.senhaUsuario = user.getPassword();
        this.enderecoUsuario = user.getEnderecoUsuario();
        this.numeroEnderecoUsuario = user.getNumeroEnderecoUsuario();
        this.complementoEnderecoUsuario = user.getComplementoEnderecoUsuario();
        this.numeroCartaoCredito = user.getNumeroCartaoCredito();
        this.nomeCartaoCredito = user.getNomeCartaoCredito();
        this.mesExpiracaoCartaoCredito = user.getMesExpiracaoCartaoCredito();
        this.anoExpiracaoCartaoCredito = user.getAnoExpiracaoCartaoCredito();
        this.codigoSegurancaCartaoCredito = user.getCodigoSegurancaCartaoCredito();
        this.tipoUsuario = user.getPerfil();
    }


}
