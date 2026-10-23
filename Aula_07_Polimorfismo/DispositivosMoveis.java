package Aula_07_Polimorfismo;

// EXERCICIO 1

//Classe Pai
class DispositivoMovel {
    public void exibirTela() {}
}

//Classe Filha 1
class Celular extends DispositivoMovel {
    private String modelo;

    public Celular(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void exibirTela() {
        System.out.printf("Tela do Celular %s ativada!\n", modelo);
    }
}

//Classe Filha 2
class Tablet extends DispositivoMovel {
    private String modelo;

    public Tablet(String modelo) {
        this.modelo = modelo;
    }

    @Override public void exibirTela() {
        System.out.printf("Tela do Tablet %s ativada!\n", modelo);
    }
}

public class DispositivosMoveis {
    public static void main(String[] args) {
        DispositivoMovel celular = new Celular("Motorola Edge 60 Neo");
        DispositivoMovel tablet = new Tablet("Samsung Galaxy S10 FE 5G");

        celular.exibirTela();
        tablet.exibirTela();
    }
}