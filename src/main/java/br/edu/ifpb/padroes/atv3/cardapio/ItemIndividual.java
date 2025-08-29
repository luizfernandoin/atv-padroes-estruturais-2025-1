package br.edu.ifpb.padroes.atv3.cardapio;

public class ItemIndividual implements ItemCardapio {
    private String nome;
    private String descricao;
    private double preco;

    public ItemIndividual(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return nome + ": " + descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + nome + " - R$ " + preco);
    }

    public String getNome() {
        return nome;
    }
}