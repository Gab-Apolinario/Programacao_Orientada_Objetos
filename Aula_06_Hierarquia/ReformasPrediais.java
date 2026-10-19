package Aula_06_Hierarquia;

class Engenheiro {
    private String registroCrea;

    public Engenheiro(String registroCrea) {
        this.registroCrea = registroCrea;
    }

    public String getCrea() {
        return this.registroCrea;
    }
}

class Reforma {
    private String local;
    private Engenheiro responsavel;

    public Reforma(String local, Engenheiro responsavel) {
        this.local = local;
        this.responsavel = responsavel;
    }

    public void exibirPlacaDeObra() {
        System.out.printf("Local da obra: %s | CREA do Responsável: %s\n", this.local, responsavel.getCrea());
    }
}

public class ReformasPrediais {
    public static void main(String[] args) {
        Engenheiro eng = new Engenheiro("1122334455");
        Reforma ref = new Reforma("Prédio Administrativo", eng);
        ref.exibirPlacaDeObra();
    }
}