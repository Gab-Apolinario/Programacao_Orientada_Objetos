package Aula_04_Exercicios_POO;

class Passageiro{
    private String nomePassageiro;
    private String passaporte;
    private String assentoReservado;

    public Passageiro(String nomePassageiro, String passaporte){
        this.nomePassageiro = nomePassageiro;
        this.passaporte = passaporte;
        this.assentoReservado = "Nenhum";

        this.exibir_info();
    }

    public String getNome(){
        return this.nomePassageiro;
    }

    public String getPassaporte(){
        return this.passaporte;
    }

    public String getAssento(){
        return this.assentoReservado;
    }

    public void setAssento(String assento){
        this.assentoReservado = assento;
    }

    public void exibir_info(){
        System.out.printf("INFO: Passageiro %s | Passaporte: %s | Assento: %s\n",
                                this.getNome(), this.getPassaporte(), this.getAssento());
    }
}

class Voo{
    private int codigo;
    private String destino;
    private int vagasDisponiveis;
    private float precoPassagem;

    public Voo(int codigo, String destino, int vagasDisponiveis, float precoPassagem){
        this.codigo = codigo;
        this.destino = destino;
        this.vagasDisponiveis = vagasDisponiveis;
        this.precoPassagem = precoPassagem;

        this.status_voo();
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getDestino(){
        return this.destino;
    }

    public int getVagas(){
        return this.vagasDisponiveis;
    }

    public float getPreco(){
        return this.precoPassagem;
    }

    //TRY - CATCH
    public void vender_passagem(Passageiro p, String assento){
        if(this.getVagas() > 0){
            p.setAssento(assento);
            this.vagasDisponiveis--;
            System.out.printf("Passagem vendida para %s | Vagas Disponíveis no Voo: %d\n", p.getNome(), this.getVagas());
        }else{
            throw new IllegalArgumentException("Passagem não pode ser comprada. Voo lotado!".toUpperCase());
        }
    }

    public void status_voo(){
        System.out.printf("VOO %d | DESTINO: %s | VAGAS: %d | VALOR PASSAGEM: R$%.2f\n",
                                this.getCodigo(), this.getDestino(), this.getVagas(), this.getPreco());        
    }
}

public class ReservaVoos {
    public static void main(String[] args){
        Voo voo1 = new Voo(579, "Chile", 1, 650);
        Passageiro passageiro1 = new Passageiro("Watermelon Gabe", "579160FG");
        Passageiro passageiro2 = new Passageiro("Watermelon Nico", "160579GF");

        try{
            voo1.vender_passagem(passageiro2, "35G");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            voo1.vender_passagem(passageiro1, "35F");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
