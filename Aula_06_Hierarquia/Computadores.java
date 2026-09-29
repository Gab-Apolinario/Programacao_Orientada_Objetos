package Aula_06_Hierarquia;

//EXERCICIO 7

class Processador {
    private String modelo;

    public Processador(String modelo) {
        this.modelo = modelo;
    }

    public void trabalhar() {
        System.out.println("Atividade da CPU: Trabalhando...\n");
    }
}

class Computador {
    private Processador cpu;

    public Computador(String modeloCPU) {
        this.cpu = new Processador(modeloCPU);
    }

    public void ligar() {
        System.out.println("Ligando computador...");
        this.cpu.trabalhar();
    }
}

public class Computadores {
    public static void main(String[] args) {
        Computador pc = new Computador("Intel i9");
        pc.ligar();
    }
}
