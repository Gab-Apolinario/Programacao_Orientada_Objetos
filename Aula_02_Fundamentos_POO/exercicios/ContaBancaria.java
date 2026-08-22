package exercicios;
import Aula_03_Iteracao_Objetos.Pedido;

public class ContaBancaria{
    private double saldo;

    //Método CONSTRUTOR
    public ContaBancaria(double saldoInicial){

        if (saldoInicial < 0){
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo...");
        }
        this.saldo = saldoInicial;
    }

    public void depositar(double valor){
        if (valor < 0){
            throw new IllegalArgumentException("Valor inválido...");
        }
        this.saldo += valor;
    }
    
    public void sacar(double valor){
        if (valor < 0){
            throw new IllegalArgumentException("Valor inválido...");
        }
        if (valor > this.saldo){
            throw new IllegalArgumentException("Saldo insuficiente...");
        }

        this.saldo -= valor;
        System.out.printf("Compra Efetuada! | Saldo Atual: R$%.2f", this.mostrarSaldo());
    }
    
    public void comprar(ItemPedido pedido) {
        this.sacar(pedido.Subtotal());
    }
    
    public void comprar(Pedido pedido) {
        System.out.printf("Saldo Atual: R$%.2f\n", this.mostrarSaldo());
        this.sacar(pedido.fechar_pedido(pedido));
    }
    
    public double mostrarSaldo(){
        return this.saldo;
    }
}