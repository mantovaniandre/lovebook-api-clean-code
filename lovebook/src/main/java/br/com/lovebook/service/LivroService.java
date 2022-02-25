package br.com.lovebook.service;

import br.com.lovebook.converter.LivroConverter;
import br.com.lovebook.dto.ComentarioDto;
import br.com.lovebook.dto.LivroDto;
import br.com.lovebook.exception.LivroNaoEncontradoException;
import br.com.lovebook.exception.LivrosNaoEncontradosException;
import br.com.lovebook.form.livro.FormularioAtualizacaoLivro;
import br.com.lovebook.form.livro.FormularioCriacaoLivro;
import br.com.lovebook.model.Comentario;
import br.com.lovebook.model.Livro;
import br.com.lovebook.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroConverter livroConverter;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private ComentarioService comentarioService;

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

    protected Livro recuperarLivroPorId(Long idDoLivro) {
        Optional<Livro> resultadoQuery = livroRepository.findById(idDoLivro);
        if (resultadoQuery.isPresent()) {
            return resultadoQuery.get();
        }

        throw new LivroNaoEncontradoException();
    }

    public void invalidar(Long idDoLivro){
        Livro livroRecuperado = this.recuperarLivroPorId(idDoLivro);
        livroRecuperado.setAtivo(false);
        this.livroRepository.save(livroRecuperado);
    }

    public List<LivroDto> buscar(String nome, String categoria, String auto, String editora, Boolean ativo){
        List<Livro> livrosEncontrados = null;

        if(ativo != null){
            livrosEncontrados = livroRepository.findByNomeLikeIgnoreCaseAndCategoriaLikeIgnoreCaseAndNomeDoAutorLikeIgnoreCaseAndEditoraLikeIgnoreCaseAndAtivo(
                    nome+"%", categoria+"%", auto+"%", editora+"%", ativo);
        } else {
            livrosEncontrados = livroRepository.findByNomeLikeIgnoreCaseAndCategoriaLikeIgnoreCaseAndNomeDoAutorLikeIgnoreCaseAndEditoraLikeIgnoreCase(
                    nome+"%", categoria+"%", auto+"%", editora+"%");
        }

        if(livrosEncontrados.isEmpty()){
            throw new LivrosNaoEncontradosException();
        }

        return livrosEncontrados.stream().map(LivroDto::new).collect(Collectors.toList());
    }

    public Double atualizarNota(Long idDoLivro){
        Livro livro = this.recuperarLivroPorId(idDoLivro);

        List<ComentarioDto> listaComentarios = comentarioService.buscarComentariosPorLivro(idDoLivro);

        Integer quantidadeComentarios = listaComentarios.size();

        Double notaAtualizada = listaComentarios.stream().map(ComentarioDto::getNota).reduce(0.0, Double::sum) / quantidadeComentarios;

        livro.setNota(notaAtualizada);
        this.livroRepository.save(livro);

        return notaAtualizada;
    }

}
