package Aula_04_Exercicios_POO;

class Lampada{
    private String marcaLampada;
    private int potenciaLampada;
    private boolean ligada;

    public Lampada(String marcaLampada, int potenciaLampada){
        this.marcaLampada = marcaLampada;
        this.potenciaLampada = potenciaLampada;
        this.ligada = false;

        System.out.printf("Lâmpada Criada! | Marca: %s | Potência: %d W\n", this.marcaLampada, this.potenciaLampada);
    }

    public boolean status_lampada(){
        return this.ligada;
    }

    public void ligar_lampada(){
        if(this.ligada){
            System.out.println("Lâmpada já está ligada!");
        }else{
            this.ligada = true;
            System.out.println("Lâmpada ligada!");
        }
    }
    
    public void desligar(){
        if(!this.ligada){
            System.out.println("Lâmpada já está desligada!");
        }else{
            this.ligada = false;
            System.out.println("Lâmpada desligada!");
        }
    }

    public void exibir_estado(){
        System.out.printf("Lâmpada da marca %s com potência %d W está %s!\n", this.marcaLampada, this.potenciaLampada, this.ligada ? "ligada" : "desligada");
    }
}

class Interruptor{
    private String comodo;
    private String cor;
    private Lampada lampadaConectada;

    public Interruptor(String comodo, String cor){
        this.comodo = comodo;
        this.cor = cor;
        this.lampadaConectada = null;

        System.out.printf("Interruptor Criado! | Local: %s | Car: %s\n", this.comodo, this.cor);
    }

    public void conectar_lampada(Lampada lampada){
        this.lampadaConectada = lampada;
        System.out.println("Lâmpada conectada ao interruptor!");
    }

    public void acionar_interruptor(){
        if(this.lampadaConectada != null){
            if(this.lampadaConectada.status_lampada() == false){
                this.lampadaConectada.ligar_lampada();
            }else{
                this.lampadaConectada.desligar();
            }
        }else{
            throw new IllegalArgumentException("Nenhuma lâmpada conectada ao interruptor.");
        }
    }
}

public class AutomacaoResidencial {
    public static void main(String[] args){
        Lampada lampada1 = new Lampada("Positivo", 10);
        Interruptor interruptor1 = new Interruptor("Sala de Estar", "Branca");

        lampada1.exibir_estado();
        interruptor1.conectar_lampada(lampada1);

        try{
            interruptor1.acionar_interruptor();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        lampada1.exibir_estado();
        
        try{
            interruptor1.acionar_interruptor();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        lampada1.exibir_estado();
    }
}
