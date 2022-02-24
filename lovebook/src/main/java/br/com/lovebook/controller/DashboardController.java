package br.com.lovebook.controller;

import br.com.lovebook.config.security.AutenticacaoViaTokenFilter;
import br.com.lovebook.config.security.TokenService;
import br.com.lovebook.model.Usuario;
import br.com.lovebook.report.GlobalReport;
import br.com.lovebook.report.StatsReport;
import br.com.lovebook.repository.CompraRepository;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CompraRepository compraRepository;

    @GetMapping("/global")
    @Transactional
    public ResponseEntity<?> gerarRelatorioFixo(HttpServletRequest request) {
        Long idUsuarioLogado = idUsuarioLogado(request);
        Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);

        if (user.isPresent()) {
            if (user.get().getPerfil().getId() == 1) {
                GlobalReport globalReport = new GlobalReport(usuarioRepository.getReaderQuantity(), livroRepository.getBookQuantity());
                return ResponseEntity.ok(globalReport);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/stats")
    @Transactional
    public ResponseEntity<?> gerarRelatorioVariavel(Integer mes, Integer ano, HttpServletRequest request) {
        Long idUsuarioLogado = idUsuarioLogado(request);
        Optional<Usuario> user = usuarioRepository.findById(idUsuarioLogado);

        if (user.isPresent()) {
            if (user.get().getPerfil().getId() == 1) {
                if (compraRepository.getSomaPreco(mes, ano) != null && compraRepository.getSomaCusto(mes, ano) != null) {
                    Double lucratividade = compraRepository.getSomaPreco(mes, ano) - compraRepository.getSomaCusto(mes, ano);
                    Optional<List<String>> listaCategoriaVendas = compraRepository.getVendasCategoria(mes, ano);
                    Optional<List<String>> vendasLivros = compraRepository.getVendasLivros(mes, ano);
                    Optional<List<String>> vendasEstado = compraRepository.getVendasEstado(mes, ano);
                    Optional<List<String>> vendasSexo = compraRepository.getVendasSexo(mes, ano);
                    Double totalVendasLivro = compraRepository.getTotalVendasLivros(mes, ano);

                    StatsReport statsReport = new StatsReport(lucratividade, listaCategoriaVendas.get().get(0), vendasLivros.get().get(0), vendasEstado.get().get(0), vendasSexo.get().get(0), totalVendasLivro);
                    return ResponseEntity.ok(statsReport);
                } else {
                    StatsReport statsReport = new StatsReport(0.0, "N/A", "N/A", "N/A", "N/A", 0.0);
                    return ResponseEntity.ok(statsReport);
                }

            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }

        return ResponseEntity.notFound().build();
    }


    private Long idUsuarioLogado(HttpServletRequest request) {
        AutenticacaoViaTokenFilter autenticacaoViaTokenFilter = new AutenticacaoViaTokenFilter(tokenService,
                usuarioRepository);
        String token = autenticacaoViaTokenFilter.recuperarToken(request);
        Long idUsuarioLogado = tokenService.getIdUsuario(token);
        return idUsuarioLogado;
    }

}
