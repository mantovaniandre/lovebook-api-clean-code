package br.com.lovebook.controller;

import br.com.lovebook.config.security.AutenticacaoViaTokenFilter;
import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.dto.CompraDto;
import br.com.lovebook.form.PurchaseForm;
import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.repository.CompraRepository;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private CompraRepository compraRepository;

    @GetMapping
    @Transactional
    public ResponseEntity<List<CompraDto>> listarCompras(HttpServletRequest request) {
        Long idUsuarioLogado = idUsuarioLogado(request);
        Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);

        if (user.isPresent()) {
            Optional<List<Compra>> listaCompra = compraRepository.findByUsuario(user.get());
            if (listaCompra.isPresent()) {
                List<CompraDto> listaCompraDto = new ArrayList<>();
                for (Compra compra : listaCompra.get()) {
                    listaCompraDto.add(new CompraDto(compra));
                }
                return ResponseEntity.ok(listaCompraDto);
            }
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> purchase(@RequestBody @Valid PurchaseForm purchaseForm, HttpServletRequest request) {
        Long idUsuarioLogado = idUsuarioLogado(request);
        Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);

        if (user.isPresent()) {
            if (user.get().getPerfil().getId() == 2) {
                for (Long id : purchaseForm.getListaIds()) {
                    Optional<Livro> livro = livroRepository.findById(id);
                    if (livro.isPresent()) {
                        livro.get().setQuantidade(livro.get().getQuantidade() - 1);
                        Compra compra = purchaseForm.converter(user.get(), livro.get());
                        compraRepository.save(compra);
                    }
                }
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }

        } else {
            return ResponseEntity.notFound().build();
        }

    }

    private Long idUsuarioLogado(HttpServletRequest request) {
        AutenticacaoViaTokenFilter autenticacaoViaTokenFilter = new AutenticacaoViaTokenFilter(tokenService,
                usuarioRepository);
        String token = autenticacaoViaTokenFilter.recuperarToken(request);
        Long idUsuarioLogado = tokenService.getIdUsuario(token);
        return idUsuarioLogado;
    }

}
