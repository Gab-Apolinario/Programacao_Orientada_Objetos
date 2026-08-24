package Aula_04_Exercicios_POO;

class Motorista{
    private String nomeMotorista;
    private int cnh;
    private int anosExperiencia;

    public Motorista(String nomeMotorista, int cnh, int anosExperiencia){
        this.nomeMotorista = nomeMotorista;
        this.cnh = cnh;
        this.anosExperiencia = anosExperiencia;

        System.out.printf("Motorista Criado! | Nome: %s | CNH: %d | Anos de Experiência: %d\n", this.getNome(), this.getCnh(), this.getAnosXP());
    }

    public String getNome(){
        return this.nomeMotorista;
    }

    public int getCnh(){
        return this.cnh;
    }

    public int getAnosXP(){
        return this.anosExperiencia;
    }

    public void avaliar_motorista(){
        if(this.getAnosXP() >= 2){
            System.out.printf("Motorista com mais de dois anos de experiência. APTO!");
        }else{
            throw new IllegalArgumentException("Motorista com pouca experiência. NÃO APTO!");
        }
    }
}

class Carro{
    private String modelo;
    private final float VEL_MAX = 110f;
    private float velocidadeAtual;
    private Motorista motorista;

    public Carro(String modelo){
        this.modelo = modelo;
        this.velocidadeAtual = 0f;
        this.motorista = null;

        System.out.printf("Carro Criado! | Modelo: %s\n", this.getModelo());
    }

    public String getModelo(){
        return this.modelo;
    }

    public float getVelMax(){
        return this.VEL_MAX;
    }

    public float getVelAtual(){
        return this.velocidadeAtual;
    }

    public Motorista getMotorista(){
        return this.motorista;
    }

    public void atribuir_motorista(Motorista m){
        this.motorista = m;
        System.out.printf("Motorista %s agora está dirigindo o Carro %s.\n", m.getNome(), this.getModelo());
    }

    public void acelerar(int incremento){
        if(this.getMotorista() == null){
            throw new IllegalArgumentException("Carro sem Motorista!");
        }else{
            this.velocidadeAtual += incremento;

            if(this.getVelAtual() >= VEL_MAX){
                this.velocidadeAtual = VEL_MAX;
                System.out.printf("Velocidade limite atingida! %.2f\n", VEL_MAX);
            }else{
                System.out.printf("Velocidade atual aumentada! %.2f Km/h.\n", this.getVelAtual());
            }
        }
    }

    public void exibir_status(){
        System.out.printf("Carro %s está sendo dirigido por %s. | Velocidade Atual: %.2f Km/h", this.getModelo(), motorista.getNome(), this.getVelAtual());
    }
}

public class SimuladorCorrida {
    public static void main(String[] args){
        Motorista motorista1 = new Motorista("Gabriel", 111222358, 6);
        Carro carro1 = new Carro( "Ford Ka");
   
        try{
            carro1.acelerar(120);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
                
        carro1.atribuir_motorista(motorista1);
        
        try{
            carro1.acelerar(120);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        carro1.exibir_status();
    }
}