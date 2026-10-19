package Aula_06_Hierarquia;

class MotorDobra {
    public void ativar() {
        //ativar motor
        System.out.println("Motor de Dobra ATIVADO!");
    }
}

class Astronauta {
    private String nome;

    public Astronauta(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}

//Criar MotorDobra no Construtor (COMPOSIÇÃO)
class NaveEspacial {
    private Astronauta[] astronautas = new Astronauta[5];
    private int contadorAstronautas = 0;
    private MotorDobra motorDobra; //cria fora para todos os métodos enxergar

    public NaveEspacial() {
        System.out.println("Nave Criada!");
        motorDobra = new MotorDobra(); //somente preenche a variável no construtor
    }

    public void embarcar(Astronauta a) {
        if (contadorAstronautas < astronautas.length) {
            astronautas[contadorAstronautas] = a;
            System.out.printf("Astronauta %s embarcado!\n", a.getNome());
            contadorAstronautas++;
        } else {
            System.out.printf("Astronauta %s não pode embarcar, nave cheia!\n", a.getNome());
        }
    }

    public void saltar() {
        if (contadorAstronautas > 0) {
            System.out.printf("Astronauta %s ativando o motor!\n", astronautas[0].getNome());
            motorDobra.ativar();
        } else {
            System.out.println("Nave sem tripulantes, motor não pode ser ativado sozinho!");
        }
    }
}

public class Espaconaves {
    public static void main(String[] args) {
        NaveEspacial nave = new NaveEspacial();
        Astronauta astro1 = new Astronauta("Gabriel");
        Astronauta astro2 = new Astronauta("José");
        Astronauta astro3 = new Astronauta("Paula");
        Astronauta astro4 = new Astronauta("Ana Paula");
        Astronauta astro5 = new Astronauta("Joana");
        Astronauta astro6 = new Astronauta("Henrique");

        nave.embarcar(astro1);
        nave.embarcar(astro2);
        nave.embarcar(astro3);
        nave.embarcar(astro4);
        nave.embarcar(astro5);
        nave.embarcar(astro6);

        nave.saltar();
    }
}