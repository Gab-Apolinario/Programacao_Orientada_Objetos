package exercicios;
public class Motocicleta {
    private String modelo;
    private boolean motorLigado;
    private boolean atingiuLimite;
    private float velocidadeAtual;
    private final float velocidadeMaxima = 90f;

    public Motocicleta(String modelo){
        this.modelo = modelo;
        this.motorLigado = false;
        this.atingiuLimite = false;
        this.velocidadeAtual = 0f;
    }

    public void ligarMotor() {
        this.motorLigado = true;
        System.out.printf("Motor da %s ligado.\n", this.modelo);
    }

    public void desligarMotor() {
        this.motorLigado = false;
        System.out.printf("Motor da %s desligado.\n", this.modelo);
    }

    public void acelerar(float valor){
        if (!this.motorLigado){
            throw new IllegalArgumentException("Ligue a motocicleta para poder acelerar.\n");
        }
        else {
            velocidadeAtual += valor;
            if ( velocidadeAtual >= velocidadeMaxima){
                velocidadeAtual = velocidadeMaxima;
                this.atingiuLimite = true;
            }
            System.out.printf("Acelerando moto em %.2f km/h. | Velocidade Atual: %.2f km/h\n", valor, this.velocidadeAtual);
            
            if (this.atingiuLimite) {
                System.out.println("Limite de velocidade atingido!");
            }
        }
    }

    public static void main(String[] args) {
        Motocicleta motocicleta1 = new Motocicleta("CG");

        System.out.println("--------------------------------------------------------\n");
        System.out.printf("Moto modelo %s | Motor Ligado %b | Velocidade Atual: %.2f\n", motocicleta1.modelo, motocicleta1.motorLigado, motocicleta1.velocidadeAtual);
        System.out.println("--------------------------------------------------------\n");
        motocicleta1.ligarMotor();
        System.out.println("--------------------------------------------------------\n");

        try {
            motocicleta1.acelerar(30);
        } catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            motocicleta1.acelerar(40);
        } catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            motocicleta1.acelerar(15);
        } catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            motocicleta1.acelerar(30);
        } catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
