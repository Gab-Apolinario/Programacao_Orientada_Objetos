package exercicios;
public class FundamentosPOO
{
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------\n");
        System.out.println("Bem vindo ao Sistema Bancário PUCPR!\n");
        System.out.println("--------------------------------------------------------\n");
        
        //CRIAÇÃO DO OBJETO
        ContaBancaria cc_Gabriel = null; //Vazio para poder tratar a exceção caso ocorra algum erro na criação da conta

        try {
            cc_Gabriel = new ContaBancaria(80.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
            System.out.println("--------------------------------------------------------\n");
        }

        //Verificação se a conta foi criada com sucesso antes de prosseguir
        if (cc_Gabriel != null) {
            System.out.println("Conta criada com sucesso!");
        } else {
            System.out.println("Falha ao criar conta. Encerrando o programa.");
            return;
        }

        System.out.printf("O saldo inicial da conta de Gabriel é de R$ %.2f\n", cc_Gabriel.mostrarSaldo());
        System.out.println("--------------------------------------------------------\n");
        System.out.println("Depositando R$ 30...");
        cc_Gabriel.depositar(30.0);
        System.out.printf("Novo saldo: R$ %.2f\n", cc_Gabriel.mostrarSaldo());
        System.out.println("--------------------------------------------------------\n");
        System.out.println("Sacando R$ 20...");
        cc_Gabriel.sacar(20.0);
        System.out.printf("Novo saldo: R$ %.2f\n", cc_Gabriel.mostrarSaldo());
        System.out.println("--------------------------------------------------------\n");
        
        //SISTEMA DE VENDAS
        System.out.println("Bem vindo ao sistema de vendas!\n");
        System.out.println("--------------------------------------------------------\n");

        //PRODUTO 1
        Produto produto1 = new Produto("Lápis", 2.0);
        
        //PEDIDO 1
        ItemPedido pedido1 = new ItemPedido(produto1, 5);

        //EXIBINDO INFORMAÇÕES DO PEDIDO 1
        System.out.printf("PEDIDO 1: \nProduto selecionado: %s | Valor: %.2f | Quantidade: %d\n\n",
        produto1.getCodigo(), produto1.getPreco(), pedido1.getQuantidade());
        
        System.out.printf("Subtotal Pedido 1: %.2f\n\n", pedido1.Subtotal());
        
        //PRODUTO 2
        Produto produto2 = new Produto("Caderno", 10.0);
        
        //PEDIDO 2
        ItemPedido pedido2 = new ItemPedido(produto2, 10);
        
        //EXIBINDO INFORMAÇÕES DO PEDIDO 2
        System.out.printf("PEDIDO 2: \nProduto selecionado: %s | Valor: %.2f | Quantidade: %d\n\n",
        produto2.getCodigo(), produto2.getPreco(), pedido2.getQuantidade());

        System.out.printf("Subtotal Pedido 2: %.2f\n\n", pedido2.Subtotal());

        System.out.println("--------------------------------------------------------\n");
        
        System.out.printf("Saldo atual: R$ %.2f\n", cc_Gabriel.mostrarSaldo());
        
        try {
            System.out.printf("Efetuando a compra do pedido 1 no valor de R$ %.2f\n", pedido1.Subtotal());
            cc_Gabriel.comprar(pedido1);
            System.out.printf("Saldo após compra: R$ %.2f\n", cc_Gabriel.mostrarSaldo());
            System.out.println("--------------------------------------------------------\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao efetuar compra: " + e.getMessage());
            System.out.println("--------------------------------------------------------\n");
        }
        
        try {
            System.out.printf("Efetuando a compra do pedido 2 no valor de R$ %.2f\n", pedido2.Subtotal());
            cc_Gabriel.comprar(pedido2);
            System.out.printf("Saldo após compra: R$ %.2f\n", cc_Gabriel.mostrarSaldo());
            System.out.println("--------------------------------------------------------\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao efetuar compra: " + e.getMessage());
            System.out.println("--------------------------------------------------------\n");
        }

    }
}