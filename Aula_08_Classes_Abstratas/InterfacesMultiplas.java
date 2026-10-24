package Aula_08_Classes_Abstratas;

// EXERCICIO 3

interface Camera {
    void tirarFoto();
}

interface GPS {
    void obterLocalizacao();
}

class Smartphone implements Camera, GPS {
    @Override
    public void tirarFoto() {
        System.out.println("Smartphone Tirando Foto...");
    }
    
    @Override
    public void obterLocalizacao() {
        System.out.println("Smartphone Obtendo Localização...");
    }
}

public class InterfacesMultiplas {
    public static void main(String[] args) {
        Smartphone celular = new Smartphone();
        celular.tirarFoto();
        celular.obterLocalizacao();
    }
}