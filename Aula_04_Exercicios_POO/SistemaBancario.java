package Aula_04_Exercicios_POO;

class Cliente{
    private String nomeCliente;
    private int cpfCliente;
    private String emailCliente;

    public Cliente(String nomeCliente, int cpfCliente, String emailCliente){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;

        System.out.printf("Cliente Criado! | Nome: %s | CPF: %d | Email: %s\n", this.get_nome(), this.get_cpf(), this.get_email());
    }

    public String get_nome(){
        return this.nomeCliente;
    }

    public int get_cpf(){
        return this.cpfCliente;
    }

    public String get_email(){
        return this.emailCliente;
    }
}

class ContaBancaria{
    private int numero;
    private Cliente titular;
    private double saldo;

    public ContaBancaria(int numero, Cliente titular, double saldoInicial){
        this.numero = numero;
        this.titular = titular;
        if(saldoInicial < 0){
            this.saldo = 0;
            throw new IllegalArgumentException("Saldo inicial inválido");
        }else{
            this.saldo = saldoInicial;
            System.out.printf("Conta Bancária Criada! | Titular: %s | Saldo: %.2f\n", titular.get_nome(), this.get_saldo());
        }
    }

    public double get_saldo(){
        return this.saldo;
    }

    public int get_numero(){
        return this.numero;
    }

    public Cliente get_titular(){
        return this.titular;
    }

    //TRY/CATCH
    public void depositar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Valor inválido para depósito.");
        }else{
            this.saldo += valor;
            System.out.printf("Valor Depositado: RS%.2f\n", valor);
        }
    }
    
    //TRY/CATCH
    public void sacar(double valor){
        if(valor > this.saldo){
            throw new IllegalArgumentException("Saldo insuficiente para o valor do saque.");
        }else{
            this.saldo -= valor;
            System.out.printf("Valor Sacado: RS%.2f\n", valor);
        }
    }

    public void exibir_saldo(){
        System.out.printf("Saldo Atual: RS%.2f\n", this.get_saldo());
    }
}

public class SistemaBancario {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Gabriel Apolinario", 1091914643, "gabriel.apolinario@gmail.com");
        ContaBancaria cc_cliente1 = null;

        //CRIAÇÃO DA CONTA
        try{
            cc_cliente1 = new ContaBancaria(01, cliente1, 10);
        }catch(IllegalArgumentException e){
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
        
        //VERIFiCAÇÃO SE A CONTA NÃO ESTÁ VAZIA
        if(cc_cliente1 != null){
            System.out.println("Conta criada com sucesso!");
        }else{
            System.out.println("Falha ao criar conta. Encerrando o programa.");
            return;
        }

        //TENTATIVA DEPÓSITO
        try{
            cc_cliente1.depositar(150);
            cc_cliente1.exibir_saldo();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        //TENTATIVA SACAR
        try{
            cc_cliente1.sacar(100);
            cc_cliente1.exibir_saldo();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
