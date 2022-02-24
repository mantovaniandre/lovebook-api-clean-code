package br.com.lovebook.report;

public class StatsReport {

    private Double lucratividade;
    private String categoriaMaisVendida;
    private String livroMaisVendido;
    private String leitorPorRegiao;
    private String leitorPorGenero;
    private Double livrosVendidos;

    public StatsReport(Double lucratividade, String categoriaMaisVendida, String livroMaisVendido,
                       String leitorPorRegião, String leitorPorGenero, Double livrosVendidos) {
        this.lucratividade = lucratividade;
        this.categoriaMaisVendida = categoriaMaisVendida;
        this.livroMaisVendido = livroMaisVendido;
        this.leitorPorRegiao = leitorPorRegião;
        this.leitorPorGenero = leitorPorGenero;
        this.livrosVendidos = livrosVendidos;
    }

    public Double getLucratividade() {
        return lucratividade;
    }

    public void setLucratividade(Double lucratividade) {
        this.lucratividade = lucratividade;
    }

    public String getCategoriaMaisVendida() {
        return categoriaMaisVendida;
    }

    public void setCategoriaMaisVendida(String categoriaMaisVendida) {
        this.categoriaMaisVendida = categoriaMaisVendida;
    }

    public String getLivroMaisVendido() {
        return livroMaisVendido;
    }

    public void setLivroMaisVendido(String livroMaisVendido) {
        this.livroMaisVendido = livroMaisVendido;
    }

    public String getLeitorPorRegiao() {
        return leitorPorRegiao;
    }

    public void setLeitorPorRegiao(String leitorPorRegiao) {
        this.leitorPorRegiao = leitorPorRegiao;
    }

    public String getLeitorPorGenero() {
        return leitorPorGenero;
    }

    public void setLeitorPorGenero(String leitorPorGenero) {
        this.leitorPorGenero = leitorPorGenero;
    }

    public Double getLivrosVendidos() {
        return livrosVendidos;
    }

    public void setLivrosVendidos(Double livrosVendidos) {
        this.livrosVendidos = livrosVendidos;
    }

}
