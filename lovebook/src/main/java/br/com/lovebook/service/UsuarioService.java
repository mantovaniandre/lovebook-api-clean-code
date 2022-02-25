package br.com.lovebook.service;

import br.com.lovebook.converter.UsuarioConverter;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.exception.PerfilNaoEncontradoException;
import br.com.lovebook.exception.PerfilNaoInformadoException;
import br.com.lovebook.exception.UsuarioNaoEncontradoException;
import br.com.lovebook.form.usuario.FormularioAtualizacaoUsuario;
import br.com.lovebook.form.usuario.FormularioCriacaoUsuario;
import br.com.lovebook.model.Perfil;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.UsuarioRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioConverter usuarioConverter;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilService perfilService;

    public UsuarioDto salvar(FormularioCriacaoUsuario usuarioForm) {
        this.validarUsuarioForm(usuarioForm);

        this.encriptarSenhaDoUsuario(usuarioForm);
        Usuario usuarioParaSalvar = this.usuarioConverter.converterFormParaEntidade(usuarioForm);
        Usuario usuarioSalvo = usuarioRepository.save(usuarioParaSalvar);
        return new UsuarioDto(usuarioSalvo);
    }

    private void encriptarSenhaDoUsuario(FormularioCriacaoUsuario usuarioForm) {
        String senhaOriginal = usuarioForm.getSenhaUsuario();
        usuarioForm.setSenhaUsuario(encriptarSenha(senhaOriginal));
    }

    private void validarUsuarioForm(FormularioCriacaoUsuario usuarioForm) {
        this.validarPerfil(usuarioForm);
    }

    private void validarPerfil(FormularioCriacaoUsuario formularioDoUsuario) {
        String perfilInformado = formularioDoUsuario.getPerfil();
        if (Strings.isNotEmpty(perfilInformado)) {
            Perfil perfilEncontrado = perfilService.buscarPerfilPorNome(perfilInformado);
            if (perfilEncontrado == null) {
                throw new PerfilNaoEncontradoException(perfilInformado);
            }
        } else {
            throw new PerfilNaoInformadoException();
        }
    }

    public UsuarioDto recuperarUsuarioSeExistir(Long idDoUsuario) {
        Usuario usuarioRecuperado = this.recuperarUsuarioPorId(idDoUsuario);
        return new UsuarioDto(usuarioRecuperado);
    }

    protected Usuario recuperarUsuarioPorId(Long idDoUsuario) {
        Optional<Usuario> resultadoQuery = usuarioRepository.findById(idDoUsuario);
        if (resultadoQuery.isPresent()) {
            return resultadoQuery.get();
        }

        throw new UsuarioNaoEncontradoException();
    }

    public void deletarUsuario(Long idDoUsuario) {
        this.recuperarUsuarioSeExistir(idDoUsuario);
        usuarioRepository.deleteById(idDoUsuario);
    }

    public UsuarioDto atualizarUsuario(FormularioAtualizacaoUsuario atualizacaoUsuarioForm, Long idDoUsuario) {
        Usuario usuarioDoBanco = this.recuperarUsuarioPorId(idDoUsuario);

        this.prepararSenhaDoUsuarioComBaseNoCadastroDoBanco(atualizacaoUsuarioForm, usuarioDoBanco);

        Usuario usuarioParaSalvar = this.usuarioConverter.converterFormParaEntidade(atualizacaoUsuarioForm);
        this.preencherCamposObrigatoriosComBaseNaEntidadeSalva(usuarioParaSalvar, usuarioDoBanco);

        Usuario usuarioSalvo = usuarioRepository.save(usuarioParaSalvar);
        return new UsuarioDto(usuarioSalvo);

    }

    private void preencherCamposObrigatoriosComBaseNaEntidadeSalva(Usuario usuarioParaSalvar,
                                                                   Usuario usuarioBancoDeDados) {
        usuarioParaSalvar.setPerfil(usuarioBancoDeDados.getPerfil());
        usuarioParaSalvar.setEmailUsuario(usuarioBancoDeDados.getEmailUsuario());
        usuarioParaSalvar.setId(usuarioBancoDeDados.getId());
    }

    private void prepararSenhaDoUsuarioComBaseNoCadastroDoBanco(FormularioAtualizacaoUsuario formularioAtualizacao,
                                                                Usuario usuarioBancoDeDados) {
        String senhaDoFormulario = formularioAtualizacao.getSenhaUsuario();

        if (this.verificarSeSenhaEstaPreenchida(senhaDoFormulario)) {
            String senhaEncriptada = encriptarSenha(senhaDoFormulario);
            formularioAtualizacao.setSenhaUsuario(senhaEncriptada);
        } else {
            String senhaSalvoNoBanco = usuarioBancoDeDados.getSenhaUsuario();
            formularioAtualizacao.setSenhaUsuario(senhaSalvoNoBanco);
        }

    }

    private boolean verificarSeSenhaEstaPreenchida(String senhaDoFormulario) {
        return Strings.isNotEmpty(senhaDoFormulario);
    }

    private String encriptarSenha(String senhaOriginal) {
        return new BCryptPasswordEncoder().encode(senhaOriginal);
    }
}
