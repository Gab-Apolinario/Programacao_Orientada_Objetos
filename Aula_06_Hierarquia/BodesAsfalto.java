package Aula_06_Hierarquia;

//EXERCICIO 5

class Motociclista {
    private String apelido;

    public Motociclista(String apelido) {
        this.apelido = apelido;
    }

    public String getApelido() {
        return this.apelido;
    }
}

class MotoClube {
    private String nome;
    private Motociclista[] membros;
    private int totalInscritos;

    public MotoClube(String nome) {
        this.nome = nome;
        this.membros = new Motociclista[15]; // cria o vetor com 15 membros;
        this.totalInscritos = 0;
    }

    public void adicionarMembro(Motociclista m) {
        if (this.totalInscritos < this.membros.length) {
            this.membros[this.totalInscritos] = m; // add motociclista
            totalInscritos++;
            System.out.printf("Motociclista %s agora faz parte do %s.\n", m.getApelido(), this.nome);
        } else {
            System.out.printf("Não é possível entrar no %s, ele já está cheio.\n", this.nome);
        }
    }

    public void listarBodes() {
        System.out.printf("Membros do MotoClube %s:\n", this.nome);
        for (int i = 0; i < this.totalInscritos; i++) {
            System.out.printf("- Motociclista: %s!\n", this.membros[i].getApelido());
        }
    }
}

public class BodesAsfalto {
    public static void main(String[] args) {
        Motociclista motociclista1 = new Motociclista("Apolinário");
        Motociclista motociclista2 = new Motociclista("Guizin");
        MotoClube bodesAsfalto = new MotoClube("Bodes do Asfalto");
        bodesAsfalto.adicionarMembro(motociclista1);
        bodesAsfalto.adicionarMembro(motociclista2);
        bodesAsfalto.listarBodes();
    }
}