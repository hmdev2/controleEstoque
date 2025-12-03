package main;

import models.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Item[] estoque = new Item[5];

        try {
            estoque[0] = new Acessorio("Bolsa de Mão", 10, 2, 20);
            estoque[1] = new RoupaTamanhoUnico("Camiseta Oversized", 5, 1, 10);
            estoque[2] = new RoupaPMG("Calça Jeans", 3, 4, 2, 1, 10);
            estoque[3] = new RoupaTamanhoUnico("Roupão", 8, 2, 15);
            estoque[4] = new Acessorio("Tiaras", 12, 3, 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao inicializar estoque: " + e.getMessage());
            return;
        }

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            try {
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
                
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números.");
                sc.nextLine();
                opcao = -1;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erro: Opção inválida. Escolha entre 0 e 5.");
                opcao = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                opcao = -1;
            }
        } while (opcao != 5);

        try {
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
        } catch (Exception e) {
            System.out.println("Erro ao exibir estoque final: " + e.getMessage());
        }
        
        sc.close();
    }
}
