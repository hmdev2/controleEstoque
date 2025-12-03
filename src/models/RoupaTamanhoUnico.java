package models;

public class RoupaTamanhoUnico extends Peca implements Item {
    
    public RoupaTamanhoUnico(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
        super(descricao, quantidade, estoqueMinimo, estoqueMaximo);
    }

    @Override
    public void venda() {
        if (quantidade > 0) {
            quantidade--;
        } else {
            System.out.println("Estoque esgotado.");
        }
    }
}
