package br.com.bandtec.projetoindividual1;

public class Violao extends Produto {

    private Integer qtdCorda;

    public Violao(Integer codigo, String nome, Double preco, Integer qtdCorda) {
        super(codigo, nome, preco);
        this.qtdCorda = qtdCorda;
    }

    @Override
    public Double getValorLucro() {
        return this.getPreco() * 1.30;
    }

    @Override
    public String toString() {
        return "Violao{" +
                "qtdCorda=" + qtdCorda +
                ", getValorLucro()=" + String.format("R$%.2f", getValorLucro()) +
                "} " + super.toString();
    }

    public Integer getQtdCorda() {
        return qtdCorda;
    }

    public void setQtdCorda(Integer qtdCorda) {
        this.qtdCorda = qtdCorda;
    }

}