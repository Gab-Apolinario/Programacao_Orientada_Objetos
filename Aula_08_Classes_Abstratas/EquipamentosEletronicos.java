package Aula_08_Classes_Abstratas;

// EXERCICIO 1

abstract class EquipamentoEletronico {
    protected int voltagem;    
    abstract void ligar();
}

class AspiradorDePo extends EquipamentoEletronico {
    @Override
    public void ligar() {
        System.out.println("Ligando Aspirador de Pó...");
    }
}

public class EquipamentosEletronicos {
    public static void main(String[] args) {
        EquipamentoEletronico aspirador = new AspiradorDePo();
        aspirador.ligar();
    }
}