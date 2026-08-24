package Aula_03_Iteracao_Objetos;

class Arma{
    private String nomeArma;
    private int bonusDano;

    public Arma(String nomeArma, int bonusDano){
        this.nomeArma = nomeArma;
        this.bonusDano = bonusDano;

        System.out.printf("Arma %s criada! Bonus de Dano: %d\n", this.nomeArma, this.bonusDano);
    }
    
    public String nome_arma(){
        return this.nomeArma;
    }
    
    public int bonus_arma(){
        return this.bonusDano;
    }
}

class Personagem{
    private String nomePersonagem;
    private int pontosVida;
    private final int DANO_BASE = 5;
    Arma armaEquipada;
    
    public Personagem(String nome, int pontosVida){
        this.nomePersonagem = nome;
        this.pontosVida = pontosVida;
        
        System.out.printf("Personagem %s criado! Vida Total: %d\n", this.nomePersonagem, this.pontosVida);
    }

    public String nome_personagem(){
        return this.nomePersonagem;
    }
    
    public void equipar_armar(Arma arma){
        this.armaEquipada = arma;
        System.out.printf("%s equipou %s!\n", this.nomePersonagem, arma.nome_arma());
    }

    public void atacar(Personagem alvo){
        int danoTotal = this.DANO_BASE + armaEquipada.bonus_arma();
        alvo.pontosVida -= danoTotal;

        if (alvo.pontosVida <= 0){
            System.out.printf("%s atacou %s! | Dano Causado: %d | Vida do %s restante: %d\n",
            this.nomePersonagem, alvo.nome_personagem(), danoTotal, alvo.nome_personagem(), alvo.pontosVida);
            System.out.printf("%s morreu!\n", alvo.nome_personagem());
        }else{
            System.out.printf("%s atacou %s! | Dano Causado: %d | Vida do %s restante: %d\n",
            this.nomePersonagem, alvo.nome_personagem(), danoTotal, alvo.nome_personagem(), alvo.pontosVida);
        }
    }
}

public class CombateRPG{
    public static void main(String[] args){
        Personagem arqueiro = new Personagem("Legolas", 100);
        Personagem goblin = new Personagem("Goblin Guerreiro", 40);
        Arma arco = new Arma("Arco Lendário", 25);
        Arma porrete = new Arma("Porrete", 10);

        arqueiro.equipar_armar(arco);
        goblin.equipar_armar(porrete);
        arqueiro.atacar(goblin);
        arqueiro.atacar(goblin);
}
}