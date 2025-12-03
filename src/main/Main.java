package main;
import models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Item[] estoque = new Item[5];

        estoque[0] = new Acessorio("Bolsa de Mão", 10, 2, 20);
        estoque[1] = new RoupaTamanhoUnico("Camiseta Oversized", 5, 1, 10);
        estoque[2] = new RoupaPMG("Calça Jeans", 3, 4, 2, 1, 10);
        estoque[3] = new RoupaTamanhoUnico("Roupão", 8, 2, 15);
        estoque[4] = new Acessorio("Tiaras", 12, 3, 25);

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Controle de Estoque ---");
            for (int i = 0; i < estoque.length; i++) {
                System.out.println(i + " - " + estoque[i].getDescricao());
            }
            System.out.println("5 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            if (opcao >= 0 && opcao < 5) {
                estoque[opcao].venda();
                estoque[opcao].reposicaoEstoque();
            } else if (opcao != 5) {
                System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        System.out.println("\n--- Estoque Final ---");
        for (int i = 0; i < estoque.length; i++) {
            System.out.print(estoque[i].getDescricao() + ": ");
            if (estoque[i] instanceof RoupaPMG) {
                RoupaPMG r = (RoupaPMG) estoque[i];
                System.out.println("P=" + r.getQuantidadeP() + 
                                   " M=" + r.getQuantidadeM() + 
                                   " G=" + r.getQuantidadeG());
            } else {
                System.out.println(estoque[i].getQuantidade());
            }
        }
        sc.close();
    }
}
