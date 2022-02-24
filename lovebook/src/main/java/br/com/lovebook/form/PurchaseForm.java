package br.com.lovebook.form;

import br.com.lovebook.model.Compra;
import br.com.lovebook.model.Livro;
import br.com.lovebook.model.Usuario;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PurchaseForm {

    private List<Long> listaIds = new ArrayList<>();


    public Compra converter(Usuario usuario, Livro livro) {
        return new Compra(usuario, livro, LocalDate.now(), livro.getPrecoDeVenda(), livro.getCategoria());
    }

}
