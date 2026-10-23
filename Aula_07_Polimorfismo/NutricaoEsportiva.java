package Aula_07_Polimorfismo;

// EXERCICIO 3

class Suplementos {
    public double calcularDose(double peso) {
        return peso * 0.5;
    }
}

class ProteinaIsolada extends Suplementos {
    @Override
    public  double calcularDose(double peso) {
        return peso * 2.2;
    }
}

class Isotonico extends Suplementos {
    @Override
    public double calcularDose(double peso) {
        return 30.0;
    }
}

public class NutricaoEsportiva {
    public static void main(String[] args) {
        // Suplementos suplementoBase = new Suplementos();
        // Suplementos proteinaIsolada = new ProteinaIsolada();
        // Suplementos isotonico = new Isotonico();

        // System.out.println(suplementoBase.calcularDose(10));
        // System.out.println(proteinaIsolada.calcularDose(10));
        // System.out.println(isotonico.calcularDose(10));
        
        //Resolvendo com vetor e for
        Suplementos[] suplementos = new Suplementos[3];
        suplementos[0] = new Suplementos(); 
        suplementos[1] = new ProteinaIsolada(); 
        suplementos[2] = new Isotonico(); 

        for (int i = 0; i < suplementos.length; i++) {
            System.out.println(suplementos[i].calcularDose(10));
        }
    }
}
