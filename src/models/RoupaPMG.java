package models;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RoupaPMG implements Item {
    Scanner sc = new Scanner(System.in);
    String descricao;
    int quantidadeP;
    int quantidadeM;
    int quantidadeG;
    int estoqueMinimo;
    int estoqueMaximo;

    public RoupaPMG(String descricao, int quantidadeP, int quantidadeM, int quantidadeG, 
                    int estoqueMinimo, int estoqueMaximo) { 
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }
        if (quantidadeP < 0 || quantidadeM < 0 || quantidadeG < 0) {
            throw new IllegalArgumentException("Quantidades não podem ser negativas");
        }
        if (estoqueMinimo < 0) {
            throw new IllegalArgumentException("Estoque mínimo não pode ser negativo");
        }
        if (estoqueMaximo <= 0) {
            throw new IllegalArgumentException("Estoque máximo deve ser positivo");
        }
        
        this.descricao = descricao;
        this.quantidadeP = quantidadeP;
        this.quantidadeM = quantidadeM;
        this.quantidadeG = quantidadeG;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
    }

    @Override
    public void venda() {
        try {
            System.out.println("Tamanho do Item: ");
            String tamanho = sc.next();
            tamanho = tamanho.toUpperCase(); 
            
            switch (tamanho) {
                case "P":
                    if (quantidadeP > 0) {
                        this.quantidadeP -= 1;
                    } else {
                        System.out.println("Estoque P esgotado.");
                    }
                    break;
                case "M": 
                    if (quantidadeM > 0) {
                        this.quantidadeM -= 1;
                    } else {
                        System.out.println("Estoque M esgotado.");
                    }
                    break;
                case "G":
                    if (quantidadeG > 0) {
                        this.quantidadeG -= 1;
                    } else {
                        System.out.println("Estoque G esgotado.");
                    }
                    break;
                default:
                    System.out.println("Tamanho inválido. Use P, M ou G.");
            }
            
        } catch (Exception e) {
            System.out.println("Erro durante a venda: " + e.getMessage());
        }
    }

    @Override
    public void reposicaoEstoque() {
        if (quantidadeP < estoqueMinimo) {
            quantidadeP = estoqueMaximo;
        } 
        if (quantidadeM < estoqueMinimo) {
            quantidadeM = estoqueMaximo;
        }
        if (quantidadeG < estoqueMinimo) {
            quantidadeG = estoqueMaximo;
        }
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    public int getQuantidadeP() {
        return this.quantidadeP;
    }

    public int getQuantidadeM() {
        return this.quantidadeM;
    }

    public int getQuantidadeG() {
        return this.quantidadeG;
    }

    @Override
    public int getQuantidade() {
        return this.quantidadeG + this.quantidadeM + this.quantidadeP;
    }
}
