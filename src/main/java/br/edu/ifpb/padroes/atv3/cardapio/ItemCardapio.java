package br.edu.ifpb.padroes.atv3.cardapio;

public interface ItemCardapio {
    String getDescricao();
    double getPreco();
    void exibir(String indentacao);
}