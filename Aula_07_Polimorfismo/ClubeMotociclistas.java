package Aula_07_Polimorfismo;

// EXERCICIO 2

class Motociclista {
    public void prepararViagem() {
        System.out.println("Verificando pneus e combustível!");
    }
}

class MembroOficial extends Motociclista {
    @Override
    public void prepararViagem() {
        super.prepararViagem();
        System.out.println("Vestindo o colete oficial do moto Clube Bodes do Asfalto!");
    }
}

public class ClubeMotociclistas {
    public static void main(String[] args) {
        Motociclista membroOficial = new MembroOficial();
        membroOficial.prepararViagem();
    }
}