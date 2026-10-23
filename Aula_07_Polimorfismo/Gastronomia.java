package Aula_07_Polimorfismo;

// EXERCICIO 6

class ReservaRestaurante {
    public void confirmar() {
        System.out.println("Confirmação da Reserva");
    }
}

class ReservaCasal extends ReservaRestaurante {
    @Override
    public void confirmar() {
        System.out.println("Reserva Confirmada para Ibperico Gastronomia, intimista para dois.");
    }
}

class ReservaEvento extends ReservaRestaurante {
    @Override
    public void confirmar() {
        System.out.println("Confirmação reserva corporativa para 50 pessoas.");
    }
}

public class Gastronomia {
    public static void main(String[] args) {
        ReservaRestaurante[] reservas = new ReservaRestaurante[3];
        reservas[0] = new ReservaRestaurante();
        reservas[1] = new ReservaCasal();
        reservas[2] = new ReservaEvento();
        
        for (int i = 0; i < reservas.length; i++) {
            reservas[i].confirmar();
        }
    }
}
