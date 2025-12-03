package models;

import java.util.Scanner;

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
        this.descricao = descricao;
        this.quantidadeP = quantidadeP;
        this.quantidadeM = quantidadeM;
        this.quantidadeG = quantidadeG;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
    }

    @Override
    public void venda() {
        System.out.println("Tamanho do Item: ");
        String tamanho = sc.next();
        tamanho = tamanho.toUpperCase(); 
        switch (tamanho) {
            case "P":
                this.quantidadeP -= 1;
                break;
            case "M": 
                this.quantidadeM -= 1;
                break;
            case "G":
                this.quantidadeG -= 1;
                break;
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
