package Aula_06_Hierarquia;

//EXERCICIO 3

class DispositivoMovel {
    protected String marca;

    public DispositivoMovel(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void ligar() {
        System.out.printf("Dispositivo %s está ligado!\n", getMarca());
    }
}

class Tablet extends DispositivoMovel {
    private boolean suportaCaneta;

    public Tablet(String marca, boolean suporta) {
        super(marca);
        this.suportaCaneta = suporta;
    }

    public void desenhar() {
        if (this.suportaCaneta) {
            System.out.printf("Desenhando na tela do %s!\n", this.getMarca());
        } else {
            System.out.printf("Esse equipamento não suporta caneta...\n");
        }
    }
}

public class TabletMobile {
    public static void main(String[] args) {
        Tablet meuTablet = new Tablet("Samsung S7", true);
        meuTablet.ligar();
        meuTablet.desenhar();
    }
}