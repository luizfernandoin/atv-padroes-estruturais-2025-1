package br.edu.ifpb.padroes.atv3.cardapio;

public class RestauranteClient {
    public static void main(String[] args) {
        ItemCardapio pizza = new ItemIndividual(
                "Pizza Margherita",
                "Pizza com molho de tomate, mussarela e manjericão",
                45.90
        );
        ItemCardapio refrigerante = new ItemIndividual(
                "Refrigerante",
                "Lata 350ml",
                8.50
        );
        ItemCardapio sobremesa = new ItemIndividual(
                "Pudim",
                "Pudim de leite condensado",
                12.90
        );
        ItemCardapio batataFrita = new ItemIndividual(
                "Batata Frita",
                "Porção média com ketchup",
                15.90
        );

        Combo comboJantar = new Combo(
                "Combo Jantar",
                "Prato principal + bebida + sobremesa",
                0.10
        );
        comboJantar.adicionarItem(pizza);
        comboJantar.adicionarItem(refrigerante);
        comboJantar.adicionarItem(sobremesa);

        Combo comboSuper = new Combo(
                "Combo Super",
                "Pizza + batata + refrigerante + pudim", 0.15);
        comboSuper.adicionarItem(comboJantar);
        comboSuper.adicionarItem(batataFrita);

        System.out.println("========== CARDÁPIO DO RESTAURANTE ==========");
        System.out.println("\n--- Itens Individuais ---");
        pizza.exibir("");
        refrigerante.exibir("");
        sobremesa.exibir("");
        batataFrita.exibir("");

        System.out.println("\n--- Combos ---");
        comboJantar.exibir("");
        comboSuper.exibir("");

        System.out.println("\n========== RESUMO DE PREÇOS ==========");
        System.out.println("Pizza Individual: R$ " + pizza.getPreco());
        System.out.println("Combo Jantar: R$ " + String.format("%.2f", comboJantar.getPreco()));
        System.out.println("Combo Super: R$ " + String.format("%.2f", comboSuper.getPreco()));
    }
}