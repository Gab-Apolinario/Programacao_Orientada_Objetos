package Aula_04_Exercicios_POO;

import java.util.Random;

class Cachorro{
    private String nomeCachorro;
    private String raca;
    private int nivelSujeira; //0 a 10

    public Cachorro(String nomeCachorro, String raca){
        this.nomeCachorro = nomeCachorro;
        this.raca = raca;
        this.nivelSujeira = 0;

        this.exibir_status();
    }

    public String nome_cachorro(){
        return this.nomeCachorro;
    }

    public String raca_cachorro(){
        return this.raca;
    }

    public int nivel_sujeira(){
        return this.nivelSujeira;
    }

    public void brincarNaLama(){
        Random rand = new Random();
        this.nivelSujeira = rand.nextInt(0, 11);
        this.exibir_status();
    }

    public void zerar_sujeira(){
        this.nivelSujeira = 0;
    }

    public void exibir_status(){
        System.out.printf("Cachorro: %s | Raça: %s | Nível de Sujeira: %d/10\n", this.nome_cachorro(), this.raca_cachorro(), this.nivel_sujeira());
    }
}

class PetShop{
    private String nomePetShop;
    private double caixa;
    private double precoBanho;

    public PetShop(String nomePetShop){
        this.nomePetShop = nomePetShop;
        this.caixa = 0;
        this.precoBanho = 0;

        System.out.printf("PetShop %s criado!\n", this.nomePetShop);
    }

    public double valor_caixa(){
        return this.caixa;
    }

    public void dar_banho(Cachorro cachorro){
        if (cachorro.nivel_sujeira() > 0){
            if(cachorro.nivel_sujeira() > 0 && cachorro.nivel_sujeira() <= 5){
                this.precoBanho = 50;
                this.caixa += this.precoBanho;
            }else{
                this.precoBanho = 80;
                this.caixa += this.precoBanho;
            }
            
            cachorro.zerar_sujeira();
            System.out.printf("Cachorro %s tomou banho e agora o nível de sujeira é: %d/10\n", cachorro.nome_cachorro(), cachorro.nivel_sujeira());
        }else{
            throw new IllegalArgumentException("Cachorro está limpo, não precisa de banho!");
        }
    }

    public void exibir_caixa(){
        System.out.printf("Preço do banho = R$%.2f\n", this.valor_caixa());
    }
}

public class SistemaPetshop{

    public static void main(String[] args){
        Cachorro cachorro1 = new Cachorro( "Kiara", "Pitbull");
        PetShop petShop1 = new PetShop("LavaDog");
        cachorro1.brincarNaLama();

        try{
            petShop1.dar_banho(cachorro1);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        petShop1.exibir_caixa();
    }
}
