package br.com.lovebook.service;

import br.com.lovebook.LovebookApplication;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.exception.LivroNaoEncontradoException;
import br.com.lovebook.form.FormularioAtualizacaoLivro;
import br.com.lovebook.form.FormularioCriacaoLivro;
import br.com.lovebook.model.Livro;
import br.com.lovebook.repository.LivroRepository;
import br.com.lovebook.testfactory.FabricaDeCadastro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ContextConfiguration(classes = LovebookApplication.class)
@Transactional
public class LivroServiceTest {

    @Autowired
    private LivroService livroService;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private FabricaDeCadastro fabricaDeCadastro;

    @Test
    void deveSalvaLivroCorretamente() {

        FormularioCriacaoLivro formularioLivro = new FormularioCriacaoLivro();
        formularioLivro.setNome("Dom Casmurro");

        livroService.salvar(formularioLivro);

        List<Livro> livrosDoBancoDeDados = livroRepository.findAll();

        assertEquals(1, livrosDoBancoDeDados.size());
        assertEquals(formularioLivro.getNome(), livrosDoBancoDeDados.get(0).getNome());

    }

    @Test
    void deveAtualizarLivroCorretamente() {
        Livro livroCriado = fabricaDeCadastro.criarLivro("Alienista");

        FormularioAtualizacaoLivro formularioAtualizacaoLivro = new FormularioAtualizacaoLivro();
        formularioAtualizacaoLivro.setId(livroCriado.getId());
        formularioAtualizacaoLivro.setNome("Dom Casmurro");

        livroService.atualizar(formularioAtualizacaoLivro);

        List<Livro> livrosDoBancoDeDados = livroRepository.findAll();

        assertEquals(1, livrosDoBancoDeDados.size());
        assertEquals("Dom Casmurro", livrosDoBancoDeDados.get(0).getNome());

    }

    @Test
    void deveLancarErroAoAtualizarLivroComIdInvalido() {

        FormularioAtualizacaoLivro formularioAtualizacaoLivro = new FormularioAtualizacaoLivro();
        formularioAtualizacaoLivro.setId(900l);
        formularioAtualizacaoLivro.setNome("Dom Casmurro");

        assertThrows(LivroNaoEncontradoException.class, () -> this.livroService.atualizar(formularioAtualizacaoLivro));

    }

    @Test
    void deveInvalidarLivroCorretamente() {
        Livro livroCriado = fabricaDeCadastro.criarLivro("Alienista");

        this.livroService.invalidar(livroCriado.getId());

        List<Livro> livrosDoBancoDeDados = livroRepository.findAll();
        assertEquals(1, livrosDoBancoDeDados.size());

        assertEquals(false, livrosDoBancoDeDados.get(0).getValido());

    }

    @Test
    void deveBuscarLivrosPorNome(){
        fabricaDeCadastro.criarLivro("NomeA");
        fabricaDeCadastro.criarLivro("NomeB");

        List<LivroDto> livros = this.livroService.buscar("NomeA", "", "", "", true);

        assertEquals(1, livros.size());

    }
}


