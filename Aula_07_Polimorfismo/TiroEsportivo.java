package Aula_07_Polimorfismo;

// EXERCICIO 4

class ArtigoManutencao {
    public void aplicarProduto() {
        System.out.println("Equipamento em Processo de Limpeza.");
    }
}

class OxidacaoAFrio extends ArtigoManutencao {
    @Override
    public void aplicarProduto() {
        System.out.println("Oxidação a frio com Perma Blue (peça de aço):");
        System.out.println("1. Desengordurar bem a superfície metálica com desengraxante.");
        System.out.println("2. Aplicar o líquido sobre a peça já limpa.");
        System.out.println("3. Aguardar 60 segundos para a reação escurecer o metal.");
        System.out.println("4. Remover o excesso com um pano.");
        System.out.println("5. Repetir até atingir a tonalidade de azulado desejada.");
    }
}

class RestauradorCoronha extends ArtigoManutencao {
    @Override
    public void aplicarProduto() {
        System.out.println("Acabamento de coronha com Tru-Oil (madeira):");
        System.out.println("1. Limpar a madeira e remover o pó.");
        System.out.println("2. Aplicar o Tru-Oil líquido em camada fina para preencher os poros.");
        System.out.println("3. Deixar secar e lixar levemente com lixa 400 entre as camadas.");
        System.out.println("4. Repetir as camadas até o acabamento ficar uniforme.");
        System.out.println("5. Para brilho acetinado, polir com lã de aço fina.");
    }
}

public class TiroEsportivo {
    public static void main(String[] args) {
        ArtigoManutencao[] metodosManutencao = new ArtigoManutencao[3];
        metodosManutencao[0] = new ArtigoManutencao();
        metodosManutencao[1] = new OxidacaoAFrio();
        metodosManutencao[2] = new RestauradorCoronha();

        for (int i = 0; i < metodosManutencao.length; i++) {
            metodosManutencao[i].aplicarProduto();
        }
    }
}
