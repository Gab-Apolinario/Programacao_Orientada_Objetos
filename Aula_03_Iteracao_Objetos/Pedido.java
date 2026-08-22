package Aula_03_Iteracao_Objetos;

public class Pedido {
    private String nomeCliente;
    Produto produto;
    private int quantidadeComprada;

    public Pedido(String nomeCliente, Produto produto, int quantidadeComprada) {
        this.nomeCliente = nomeCliente;
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;

        System.out.printf("Pedido criado: Cliente: %s | Produto Pedido: %s | Quantidade: %d\n", this.nomeCliente,
                this.produto.nome_produto(), this.quantidadeComprada);
    }

    public float fechar_pedido(Pedido pedido) {
        // calcula valor total
        float subtotal = pedido.produto.preco_produto() * pedido.quantidadeComprada;

        // exibe resumo da compra
        System.out.printf("Resumo da Compra: Valor Total = R$%.2f | Verificando Estoque...\n", subtotal);

        // chama o método para reduzir estoque
        try {
            produto.reduzir_estoque(quantidadeComprada);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return subtotal;
    }
}
