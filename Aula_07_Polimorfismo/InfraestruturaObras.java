package Aula_07_Polimorfismo;

// EXERCICIO 8

class ProjetoObra {
    protected float areaM2;
    protected float orcamentoBase;

    public ProjetoObra(float areaM2) {
        this.areaM2 = areaM2;
    }

    public float calcularOrcamentoBase() {
        orcamentoBase = areaM2 * 100;
        return orcamentoBase;
    }
}

class RenovacaoPrecial extends ProjetoObra {
    public RenovacaoPrecial(float areaM2) {
        super(areaM2);
    }
    
    @Override
    public float calcularOrcamentoBase() {
        super.calcularOrcamentoBase();
        orcamentoBase += areaM2 * 250;
        return orcamentoBase;
    }
}

class ManutencaoEletrica extends ProjetoObra {
    public ManutencaoEletrica(float areaM2) {
        super(areaM2);
    }
    
    @Override
    public float calcularOrcamentoBase() {
        super.calcularOrcamentoBase();
        orcamentoBase += 1500;
        return orcamentoBase;
    }
}

public class InfraestruturaObras {
    public static void main(String[] args) {
        ProjetoObra[] projetos = new ProjetoObra[3];
        projetos[0] = new ProjetoObra(100);
        projetos[1] = new RenovacaoPrecial(100);
        projetos[2] = new ManutencaoEletrica(100);
        
        for (int i = 0; i < projetos.length; i++) {
            projetos[i].calcularOrcamentoBase();
            System.out.println(projetos[i].orcamentoBase);
        }
    }
}
