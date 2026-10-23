package Aula_08_Classes_Abstratas;

// EXERCICIO 2

interface Conectavel {
    void conectarInternet();
}

class SmartTV implements  Conectavel {
    @Override
    public void conectarInternet() {
        System.out.println("Conectando SmartTV no WIFi...");
    }
}

public class InterfaceConectavel {
    public static void main(String[] args) {
        Conectavel tv = new SmartTV();
        tv.conectarInternet();
    }
}