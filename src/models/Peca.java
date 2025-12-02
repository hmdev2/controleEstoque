package models;

public abstract class Peca {
    private String descricao;
    private int quantidade;
    private int estoqueMinimo;
    private int estoqueMaximo;
    
    public Peca(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
    }
    
    public abstract void venda();
    
    public void reposicaoEstoque() {
        if (quantidade < estoqueMinimo) {
            quantidade = estoqueMaximo;
        }
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    
    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }
}