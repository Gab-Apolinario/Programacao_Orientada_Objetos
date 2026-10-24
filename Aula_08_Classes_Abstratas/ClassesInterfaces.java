package Aula_08_Classes_Abstratas;

// EXERCICIO 4

abstract class Funcionario {
    abstract void trabalhar();
}

interface AcessoAdministrativo {
    void entrarNoServidor();
}

class GerenteRede extends Funcionario implements AcessoAdministrativo {
    @Override
    public void trabalhar() {
        System.out.println("Gerente trabalhando...");
    }

    @Override
    public void entrarNoServidor() {
        System.out.println("Gerente entrando no servidor...");
    }
}

public class ClassesInterfaces {
    public static void main(String[] args) {
        GerenteRede gerente = new GerenteRede();
        gerente.trabalhar();
        gerente.entrarNoServidor();
    }
}