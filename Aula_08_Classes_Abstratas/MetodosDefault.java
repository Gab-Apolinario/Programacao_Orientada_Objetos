package Aula_08_Classes_Abstratas;

// EXERCICIO 5

interface Drone {
    default void calibrar() {
        System.out.println("Calibrando Drone...");
    }
}

interface CameraAerea {
    default void calibrar() {
        System.out.println("Calibrando Câmera Aérea...");
    }
}

class EquipamentoFilmagens implements Drone, CameraAerea {
    @Override
    public void calibrar() {
        Drone.super.calibrar();
        CameraAerea.super.calibrar();
    }
}

public class MetodosDefault {
    public static void main(String[] args) {
        EquipamentoFilmagens equipamento = new EquipamentoFilmagens();
        equipamento.calibrar();
    }
}
