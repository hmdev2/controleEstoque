package models;

import java.util.Scanner;

public class Acessorio extends Peca implements Item {
    private static Scanner scanner = new Scanner(System.in);

    public Acessorio(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
        super(descricao, quantidade, estoqueMinimo, estoqueMaximo);
    }

    @Override
    public void venda() {
        System.out.print("Quantidade vendida do acessório: ");
        int qtd = scanner.nextInt();
        if (qtd <= quantidade) {
            quantidade -= qtd;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }
    
}
