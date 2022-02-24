package br.com.lovebook.form.usuario;

import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.PerfilRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class FormularioCriacaoUsuario {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String emailUsuario;
    @NotBlank
    private String senhaUsuario;
    @NotBlank
    private String sexoUsuario;
    @NotBlank
    private String cepUsuario;
    @NotBlank
    private String cidadeUsuario;
    @NotBlank
    private String estadoUsuario;
    @NotBlank
    private String enderecoUsuario;
    @NotBlank
    private String numeroEnderecoUsuario;
    @NotBlank
    private String complementoEnderecoUsuario;
    @NotBlank
    private String numeroCartaoCredito;
    @NotBlank
    private String nomeCartaoCredito;
    @NotBlank
    private String mesExpiracaoCartaoCredito;
    @NotBlank
    private String anoExpiracaoCartaoCredito;
    @NotBlank
    private String codigoSegurancaCartaoCredito;
    @NotBlank(message = "Perfil não pode ficar em branco")
    private String perfil;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getCepUsuario() {
        return cepUsuario;
    }

    public void setCepUsuario(String cepUsuario) {
        this.cepUsuario = cepUsuario;
    }

    public String getCidadeUsuario() {
        return cidadeUsuario;
    }

    public void setCidadeUsuario(String cidadeUsuario) {
        this.cidadeUsuario = cidadeUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public String getNumeroEnderecoUsuario() {
        return numeroEnderecoUsuario;
    }

    public void setNumeroEnderecoUsuario(String numeroEnderecoUsuario) {
        this.numeroEnderecoUsuario = numeroEnderecoUsuario;
    }

    public String getComplementoEnderecoUsuario() {
        return complementoEnderecoUsuario;
    }

    public void setComplementoEnderecoUsuario(String complementoEnderecoUsuario) {
        this.complementoEnderecoUsuario = complementoEnderecoUsuario;
    }

    public String getNumeroCartaoCredito() {
        return numeroCartaoCredito;
    }

    public void setNumeroCartaoCredito(String numeroCartaoCredito) {
        this.numeroCartaoCredito = numeroCartaoCredito;
    }

    public String getNomeCartaoCredito() {
        return nomeCartaoCredito;
    }

    public void setNomeCartaoCredito(String nomeCartaoCredito) {
        this.nomeCartaoCredito = nomeCartaoCredito;
    }

    public String getMesExpiracaoCartaoCredito() {
        return mesExpiracaoCartaoCredito;
    }

    public void setMesExpiracaoCartaoCredito(String mesExpiracaoCartaoCredito) {
        this.mesExpiracaoCartaoCredito = mesExpiracaoCartaoCredito;
    }

    public String getAnoExpiracaoCartaoCredito() {
        return anoExpiracaoCartaoCredito;
    }

    public void setAnoExpiracaoCartaoCredito(String anoExpiracaoCartaoCredito) {
        this.anoExpiracaoCartaoCredito = anoExpiracaoCartaoCredito;
    }

    public String getCodigoSegurancaCartaoCredito() {
        return codigoSegurancaCartaoCredito;
    }

    public void setCodigoSegurancaCartaoCredito(String codigoSegurancaCartaoCredito) {
        this.codigoSegurancaCartaoCredito = codigoSegurancaCartaoCredito;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Usuario converter(PerfilRepository perfilRepository) {
        Optional<Perfil> perfil = perfilRepository.findByNome(this.perfil);
        return new Usuario(this.nome, this.sobrenome, this.emailUsuario, this.senhaUsuario, this.sexoUsuario, this.cepUsuario, this.cidadeUsuario, this.estadoUsuario, this.enderecoUsuario, this.numeroEnderecoUsuario, this.complementoEnderecoUsuario, this.numeroCartaoCredito, this.nomeCartaoCredito, this.mesExpiracaoCartaoCredito, this.anoExpiracaoCartaoCredito, this.codigoSegurancaCartaoCredito, perfil.get());

    }

}
