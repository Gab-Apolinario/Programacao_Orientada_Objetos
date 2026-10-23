package Aula_07_Polimorfismo;

// EXERCICIO 5

class OperadorRadio { 
    public void identificarEstacao() {
        System.out.println("Iniciando Transmissão Local...");
    }
}

class RadioAmador extends OperadorRadio {
    private String indicativoChamada;

    public RadioAmador(String indicativoChamada) {
        this.indicativoChamada = indicativoChamada;
    }

    @Override
    public void identificarEstacao() {
        super.identificarEstacao();
        System.out.printf("Indicativo atribuído pela Anatel: %s", indicativoChamada);
    }
}

public class TrasmissaoRadio {
    public static void main(String[] args) {
        OperadorRadio operador = new RadioAmador("PU5MSG");
        operador.identificarEstacao();
    }
}
