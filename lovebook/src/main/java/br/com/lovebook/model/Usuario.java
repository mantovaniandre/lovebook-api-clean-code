package br.com.lovebook.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String emailUsuario;
    private String senhaUsuario;
    private String sexoUsuario;
    private String cepUsuario;
    private String cidadeUsuario;
    private String estadoUsuario;
    private String enderecoUsuario;
    private String numeroEnderecoUsuario;
    private String complementoEnderecoUsuario;
    private String numeroCartaoCredito;
    private String nomeCartaoCredito;
    private String mesExpiracaoCartaoCredito;
    private String anoExpiracaoCartaoCredito;
    private String codigoSegurancaCartaoCredito;
    @ManyToOne
    private Perfil perfil;

    public Usuario() {

    }

    public Usuario(String nome, String sobrenome, String emailUsuario, String senhaUsuario, String sexoUsuario,
                   String cepUsuario, String cidadeUsuario, String estadoUsuario, String enderecoUsuario,
                   String numeroEnderecoUsuario, String complementoEnderecoUsuario, String numeroCartaoCredito,
                   String nomeCartaoCredito, String mesExpiracaoCartaoCredito, String anoExpiracaoCartaoCredito,
                   String codigoSegurancaCartaoCredito, Perfil perfil) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.sexoUsuario = sexoUsuario;
        this.cepUsuario = cepUsuario;
        this.cidadeUsuario = cidadeUsuario;
        this.estadoUsuario = estadoUsuario;
        this.enderecoUsuario = enderecoUsuario;
        this.numeroEnderecoUsuario = numeroEnderecoUsuario;
        this.complementoEnderecoUsuario = complementoEnderecoUsuario;
        this.numeroCartaoCredito = numeroCartaoCredito;
        this.nomeCartaoCredito = nomeCartaoCredito;
        this.mesExpiracaoCartaoCredito = mesExpiracaoCartaoCredito;
        this.anoExpiracaoCartaoCredito = anoExpiracaoCartaoCredito;
        this.codigoSegurancaCartaoCredito = codigoSegurancaCartaoCredito;
        this.perfil = perfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.senhaUsuario;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.emailUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
