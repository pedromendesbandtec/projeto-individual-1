package br.com.bandtec.projetoindividual1;

public class Saxofone extends Produto{

    private String tipoExtensao;

    public Saxofone(Integer codigo, String nome, Double preco, String tipoExtensao) {
        super(codigo, nome, preco);
        this.tipoExtensao = tipoExtensao;
    }

    @Override
    public Double getValorLucro(){
        return getPreco() * 1.50;
    }

    @Override
    public String toString() {
        return "Saxofone{" +
                "tipoExtensao='" + tipoExtensao + '\'' +
                ", getValorLucro()=" + String.format("R$%.2f", getValorLucro()) +
                "} " + super.toString();
    }

    public String getTipoExtensao() {
        return tipoExtensao;
    }

    public void setTipoExtensao(String tipoExtensao) {
        this.tipoExtensao = tipoExtensao;
    }

}