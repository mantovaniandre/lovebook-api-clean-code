package br.com.lovebook.service;

import br.com.lovebook.converter.LivroConverter;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.exception.LivroNaoEncontradoException;
import br.com.lovebook.exception.LivrosNaoEncontradosException;
import br.com.lovebook.form.FormularioAtualizacaoLivro;
import br.com.lovebook.form.FormularioCriacaoLivro;
import br.com.lovebook.model.Livro;
import br.com.lovebook.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroConverter livroConverter;
    @Autowired
    private LivroRepository livroRepository;

    public LivroDto salvar(FormularioCriacaoLivro formularioCriacaoLivro) {
        Livro livroParaSalvar = livroConverter.converterParaEntidade(formularioCriacaoLivro);
        Livro livroSalvo = livroRepository.save(livroParaSalvar);
        return new LivroDto(livroSalvo);
    }

    public LivroDto atualizar(FormularioAtualizacaoLivro formularioAtualizacaoLivro) {
        this.recuperarLivroSeExistir(formularioAtualizacaoLivro.getId());

        Livro livroParaSalvar = livroConverter.converterParaEntidade(formularioAtualizacaoLivro);
        Livro livroSalvo = livroRepository.save(livroParaSalvar);

        return new LivroDto(livroSalvo);

    }

    public LivroDto recuperarLivroSeExistir(Long idDoLivro) {
        Livro livroRecuperado = this.recuperarLivroPorId(idDoLivro);
        return new LivroDto(livroRecuperado);
    }

    private Livro recuperarLivroPorId(Long idDoLivro) {
        Optional<Livro> resultadoQuery = livroRepository.findById(idDoLivro);
        if (resultadoQuery.isPresent()) {
            return resultadoQuery.get();
        }

        throw new LivroNaoEncontradoException();
    }

    public void invalidar(Long idDoLivro){
        Livro livroRecuperado = this.recuperarLivroPorId(idDoLivro);
        livroRecuperado.setValido(false);
        this.livroRepository.save(livroRecuperado);
    }

    public List<LivroDto> buscar(String nome, String categoria, String auto, String editora, Boolean valido){
        List<Livro> livrosEncontrados = livroRepository.findByNomeLikeAndCategoriaLikeAndNomeDoAutorLikeAndEditoraLikeAndValido(
                nome+"%", categoria+"%", auto+"%", editora+"%", valido);

        if(livrosEncontrados.isEmpty()){
            throw new LivrosNaoEncontradosException();
        }

        return livrosEncontrados.stream().map(LivroDto::new).collect(Collectors.toList());
    }

}
