package exercicios;
//CLASSE
public class Produto {
    //Atributos da Classe
    private String codigo;
    private double preco;

    //CONTRUTOR -> mesmo nome da Classe
    public Produto(String codigo, double preco){
        this.codigo = codigo;
        this.preco = preco;
    }

    //Métodos da Classe
    public String getCodigo(){
        return this.codigo;
    }

    public double getPreco(){
        return this.preco;
    }
}

//CLASSE
class ItemPedido {
    //Atributos da Classe
    Produto produto;
    private int quantidade;
    
    //CONTRUTOR -> mesmo nome da Classe
    public ItemPedido(Produto produto, int quantidade) {
        if (quantidade <= 0){
            throw new IllegalArgumentException("Quantidade inválida...");
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double Subtotal() {
        double subTotal;
        subTotal = produto.getPreco() * this.getQuantidade();
        return subTotal;
    }
}
