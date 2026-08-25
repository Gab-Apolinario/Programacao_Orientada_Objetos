package Aula_04_Exercicios_POO;

class Semente{
    private String tipo;
    private int diasCrescimento;
    private boolean regada;

    public Semente(String tipo, int diasCrescimento){
        this.tipo = tipo;
        this.diasCrescimento = diasCrescimento;
        this.regada = false;

        this.info_semente();
    }

    //GET - SET
    public String getTipo(){
        return this.tipo;
    }

    public int getDiasCrescimento(){
        return this.diasCrescimento;
    }

    public boolean getRegada(){
        return this.regada;
    }

    public void receberAgua(){
        this.regada = true;
        System.out.printf("Planta %s Regada!\n", this.getTipo());
    }

    public boolean prontaParaColher(){
        if(!this.getRegada()){
            throw new IllegalArgumentException("Planta não está pronta para colheita, ainda não foi regada.");
        }else{
            System.out.println("Planta Pronta para Colheita");
            return true;
        }
    }

    public void info_semente(){
        System.out.printf("Semente %s Criada | %s Regada | Dias para Colher: %d\n",
        this.getTipo(), this.getRegada() ? "Já foi" : "Ainda não foi", this.getDiasCrescimento());
    }
}

class Agricultor{
    private String nome;
    private int moedas;
    private int nivelXP;
    Semente sementePlantada;

    public Agricultor(String nome){
        this.nome = nome;
        this.moedas = 0;
        this.nivelXP = 0;
        this.sementePlantada = null;

        this.info_agricultor();
    }

    public String getNomeAgricultor(){
        return this.nome;
    }

    public int getMoedas(){
        return this.moedas;
    }

    public void setMoedas(int incremento){
        this.moedas += incremento;
    }

    public int getXP(){
        return this.nivelXP;
    }

    public void setXP(int incremento){
        this.nivelXP += incremento;
        System.out.printf("XP Ganha: %d | XP Atual: %d\n", incremento, this.getXP());
    }

    public String getSemente(){
        return this.sementePlantada.getTipo();
    }

    public void setSemente(Semente s){
        this.sementePlantada = s;
    }
    
    public void plantar(Semente s){
        this.setSemente(s);
        System.out.println("Semente Plantada");
    }

    public void cuidar_plantacao(){
        //aciona receberAgua() na semente
        this.sementePlantada.receberAgua();
        //aumenta Xp agricultor
        this.setXP(15);
    }

    public void colher(){
        if(this.sementePlantada.prontaParaColher()){
            setMoedas(50);
            setXP(30);
            System.out.printf("Planta %s Colhida! | %d Moedas Adicionadas | Pronto para plantar outra semente!\n",
            this.sementePlantada.getTipo(), this.getMoedas());
            setSemente(null);
        }
    }

    public void info_agricultor(){
        System.out.printf("Agricultor %s Criado! | Moedas: %d | Xp: %d\n",
                            this.getNomeAgricultor(), this.getMoedas(), this.getXP());
    }
}

public class SimulaçãoAgricolaSimples {
    public static void main(String[] args){
        Semente semente = new Semente("Cannabis Sativa", 90);
        Agricultor agricultor = new Agricultor("Guizin");

        agricultor.plantar(semente);

        try{
            agricultor.colher();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        agricultor.cuidar_plantacao();
        
        try{
            agricultor.colher();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
