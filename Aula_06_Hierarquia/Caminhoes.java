package Aula_06_Hierarquia;

//EXERCICIO 4

//SUPERCLASSE
class VeiculoCarga {
    protected double toneladas;

    public VeiculoCarga(double toneladas) {
        this.toneladas = toneladas;
    }

    public double calcularFrete() {
        return toneladas * 50;
    }
}

class Caminhao extends VeiculoCarga {
    private int eixos;

    public Caminhao(double toneladasCaminhao, int eixos) {
        super(toneladasCaminhao);
        this.eixos = eixos;
    }

    @Override
    public double calcularFrete() {
        double valorComTaxa = eixos * 150;
        valorComTaxa += super.calcularFrete();
        return valorComTaxa;
    }
}

public class Caminhoes {
    public static void main(String[] args) {
        VeiculoCarga veiculo = new VeiculoCarga(10);
        Caminhao caminhao1 = new Caminhao(10, 2);
        System.out.println("Frete comum: " + veiculo.calcularFrete());
        System.out.println("Taxa Adicional por Eixo do Veículo: " + (caminhao1.calcularFrete() - veiculo.calcularFrete()));
        System.out.println("Frete com Taxa: " + caminhao1.calcularFrete());
    }
}