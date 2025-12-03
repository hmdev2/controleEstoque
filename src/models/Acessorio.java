package models;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Acessorio extends Peca implements Item {
    private static Scanner scanner = new Scanner(System.in);

    public Acessorio(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
        super(descricao, quantidade, estoqueMinimo, estoqueMaximo);
    }

    @Override
    public void venda() {
        try {
            System.out.print("Quantidade vendida do acessório: ");
            int qtd = scanner.nextInt();
            
            if (qtd <= 0) {
                System.out.println("Erro: Quantidade deve ser maior que zero.");
                return;
            }
            
            if (qtd <= quantidade) {
                quantidade -= qtd;
            } else {
                System.out.println("Quantidade insuficiente em estoque.");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números inteiros.");
            scanner.nextLine();
        }
    }
}
