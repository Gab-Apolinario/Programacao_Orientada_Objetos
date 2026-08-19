package exercicios;
import java.util.Random;

public class Carro {
    private final int numeroID;
    private float velocidade = 0;
    private char direcao; // ideal: L ou N, com 50% de chance para cada um -> ESTATÍSTICA
    private Random rand = new Random();
    private float coordenada_x = 0;
    private float coordenada_y = 0;
    private int tempo_estimado = 0;

    //Só cria as variáveis, o valor vai ser calculado no método coordenada_aleatoria()
    private float valor_aleatorio_x;
    private float valor_aleatorio_y;

    //Constante estática para o tempo de atualização da posição do carro
    private static final float TEMPO_ATUALIZACAO = 1200;

    //CLASSE CONSTRUTORA
    public Carro(int numeroID){
        this.numeroID = numeroID;
        definir_dir();
    }

    //private pois só é usado dentro da classe e não pode ser alterado de fora
    private void definir_dir(){
        boolean moeda = rand.nextBoolean();
        if (moeda){
            this.direcao = 'N';
        }else{
            this.direcao = 'L';
        }
    }
    
    //private pois só é usado dentro da classe e não pode ser alterado de fora
    private void atualizar_velocidade(float x, float y) {
        float delta_x = Math.abs(x - this.coordenada_x);
        float delta_y = Math.abs(y - this.coordenada_y);
        float distancia_percorrida = delta_x + delta_y; // distancia percorrida
        velocidade = (distancia_percorrida / TEMPO_ATUALIZACAO) * 3600; // velocidade em km/h -> 3600 segundos = 1 hora
    }
    
    //private pois só é usado dentro da classe e não pode ser alterado de fora
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
            
    //Gera coordenadas aleatórias
    public void coordenada_aleatoria(){
        valor_aleatorio_x = rand.nextFloat() * 15; // Gera um valor aleatório entre 0 e 10
        valor_aleatorio_y = rand.nextFloat() * 20;
        float x = this.coordenada_x + valor_aleatorio_x;
        float y = this.coordenada_y + valor_aleatorio_y;
        estimar_tempo(x, y);
        atualizar_velocidade(x, y); //Aqui atualiza a velocidade do carro com base na distância percorrida e no tempo de atualização
        atualizar_coordenadas(x, y); //Aqui atualiza as coordenadas do carro e a direção -> Novo destino
    }
    
    //private pois só é usado dentro da classe e não pode ser alterado de fora
    private void atualizar_coordenadas(float x, float y) {
        atualizar_direcao(x, y);
        this.coordenada_x = x;
        this.coordenada_y = y;
    }

    //ESTIMATIVA!! Sempre vai dar variação, pois a velocidade do carro muda a cada atualização de coordenadas
    public int estimar_tempo(float x, float y) {
        float delta_x = Math.abs(x - this.coordenada_x);
        float delta_y = Math.abs(y - this.coordenada_y);
        float distancia_a_percorrer = delta_x + delta_y; // distancia a percorrer
        if (velocidade == 0) {
            tempo_estimado = 0;
            return 0;
        }

        tempo_estimado = (int) ((distancia_a_percorrer / velocidade) * 60); // tempo estimado em minutos
        System.out.printf("Tempo estimado para o percurso %.2f, na velocidade %.2f Km: %d minutos\n", distancia_a_percorrer, velocidade, tempo_estimado);
        return tempo_estimado;
    }
    
    public void exibir_dados() {
        System.out.printf("Carro %d | Velocidade: %.2f Km/h | Direção: %c | Coordenadas: (%.2f, %.2f) | Tempo estimado: %d minutos\n",
                this.numeroID, this.velocidade, this.direcao, this.coordenada_x, this.coordenada_y, this.tempo_estimado);
    }
    
    public static void main(String[] args) {
        Carro[] carros = new Carro[3];

        System.out.println("--------------------------------------------------------\n");
        System.out.println("Criando os objetos carros...\n");
        System.out.println("--------------------------------------------------------\n");

        for (int i = 0; i < carros.length; i++){
            carros[i] = new Carro(i);
            carros[i].exibir_dados();
        }

        System.out.println("--------------------------------------------------------\n");
        System.out.println("Carros criados!\n");
        System.out.println("--------------------------------------------------------\n");
        
        System.out.println("--------------------------------------------------------\n");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Atualizando as coordenadas dos carros - Iteração %d...\n", i + 1);
            System.out.println("--------------------------------------------------------\n");
            
            for (int j = 0; j < carros.length; j++){
                System.out.printf("Atualizando as coordenadas do carro %d...\n", j);
                carros[j].coordenada_aleatoria();
                carros[j].exibir_dados();
                System.out.println("--------------------------------------------------------\n");
            }
        }
    }
}