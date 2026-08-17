package exercicios;

public class Carro {
    private int numeroID;
    private float velocidade = 0;
    private char direcao = 'N'; // ideal: L ou N, com 50% de chance para cada um -> ESTATÍSTICA
    private float coordenada_x = 0;
    private float coordenada_y = 0;

    // constante estática para o tempo de atualização da posição do carro
    private static final float TEMPO_ATUALIZACAO = 1200;

    public void definir_nr(int n) {
        this.numeroID = n;
    }

    public void exibir_dados() {
        System.out.printf("Carro %d | Velocidade: %.2f Km/h | Direção: %c | Coordenadas: (%.2f, %.2f)\n",
                this.numeroID, this.velocidade, this.direcao, this.coordenada_x, this.coordenada_y);
    }

    private void atualizar_velocidade(float x, float y) {
        float delta_x = Math.abs(x - this.coordenada_x);
        float delta_y = Math.abs(y - this.coordenada_y);
        float distancia_percorrida = delta_x + delta_y; // distancia percorrida
        velocidade = (distancia_percorrida / TEMPO_ATUALIZACAO) * 3600; // velocidade em km/h -> 3600 segundos = 1 hora
    }

    private void atualizar_direcao(float x, float y) {
        switch (direcao) {
            case 'L', 'O':
                if (y < this.coordenada_y) {
                    direcao = 'S';
                } else if (y > this.coordenada_y) {
                    direcao = 'N';
                }
                break;
            case 'N', 'S':
                if (x < this.coordenada_x) {
                    direcao = 'O';
                } else if (x > this.coordenada_x) {
                    direcao = 'L';
                }
                break;
        }
    }

    private void atualizar_coordenadas(float x, float y) {
        atualizar_velocidade(x, y);
        atualizar_direcao(x, y);
        this.coordenada_x = x;
        this.coordenada_y = y;
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------\n");
        System.out.println("Criando os objetos carros...");
        System.out.println("--------------------------------------------------------\n");

        Carro carro_A = new Carro();
        Carro carro_B = new Carro();
        Carro carro_C = new Carro();

        carro_A.definir_nr(1);
        carro_B.definir_nr(2);
        carro_C.definir_nr(3);

        System.out.println("Carros criados!");
        System.out.println("--------------------------------------------------------\n");

        carro_A.exibir_dados();
        carro_B.exibir_dados();
        carro_C.exibir_dados();
        System.out.println("--------------------------------------------------------\n");

        carro_A.atualizar_coordenadas(10, 15);
        carro_A.exibir_dados();
    }
}