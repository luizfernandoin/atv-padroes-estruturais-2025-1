package br.edu.ifpb.padroes.atv3.cardapio;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {
    private String nome;
    private String descricao;
    private List<ItemCardapio> itens;
    private double desconto;

    public Combo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.itens = new ArrayList<>();
        this.desconto = 0.0;
    }

    public Combo(String nome, String descricao, double desconto) {
        this(nome, descricao);
        this.desconto = desconto;
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public void removerItem(ItemCardapio item) {
        itens.remove(item);
    }

    @Override
    public String getDescricao() {
        return nome + ": " + descricao + " (Combo com " + itens.size() + " itens)";
    }

    @Override
    public double getPreco() {
        double precoTotal = itens.stream()
                .mapToDouble(ItemCardapio::getPreco)
                .sum();
        return precoTotal * (1 - desconto);
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "COMBO: " + nome + " - R$ " + String.format("%.2f", getPreco()));
        System.out.println(indentacao + "   " + descricao);
        if (desconto > 0) {
            System.out.println(indentacao + "   Desconto: " + (desconto * 100) + "%");
        }

        for (ItemCardapio item : itens) {
            item.exibir(indentacao + "   │ ");
        }
        System.out.println(indentacao + "   └─ Preço Total: R$ " + String.format("%.2f", getPreco()));
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}