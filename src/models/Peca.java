package models;

public abstract class Peca {
    protected String descricao;
    protected int quantidade;
    protected int estoqueMinimo;
    protected int estoqueMaximo;
    
    public Peca(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        if (estoqueMinimo < 0) {
            throw new IllegalArgumentException("Estoque mínimo não pode ser negativo");
        }
        if (estoqueMaximo <= estoqueMinimo) {
            throw new IllegalArgumentException("Estoque máximo deve ser maior que o mínimo");
        }
        
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
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }
    
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    
    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }
}
