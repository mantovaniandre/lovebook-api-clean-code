package br.com.lovebook.controller;

import br.com.lovebook.controller.comum.ControllerPadrao;
import br.com.lovebook.dto.UsuarioDto;
import br.com.lovebook.form.usuario.FormularioAtualizacaoUsuario;
import br.com.lovebook.form.usuario.FormularioCriacaoUsuario;
import br.com.lovebook.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/user")
@Transactional
public class UsuarioController extends ControllerPadrao {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<UsuarioDto> exibirUsuario(HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        UsuarioDto usuarioEncontrado = this.usuarioService.recuperarUsuarioSeExistir(idUsuarioLogado);
        return ResponseEntity.ok(usuarioEncontrado);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid FormularioCriacaoUsuario form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.salvar(form));
    }

    @DeleteMapping
    public ResponseEntity<?> remover(HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        usuarioService.deletarUsuario(idUsuarioLogado);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDto> atualizar(@RequestBody @Valid FormularioAtualizacaoUsuario atualizacaoUsuarioForm,
                                                HttpServletRequest request) {
        Long idUsuarioLogado = this.recuperarIdDoUsuario(request);
        UsuarioDto usuarioAtualizado = this.usuarioService.atualizarUsuario(atualizacaoUsuarioForm, idUsuarioLogado);
        return ResponseEntity.ok(usuarioAtualizado);
    }

}
