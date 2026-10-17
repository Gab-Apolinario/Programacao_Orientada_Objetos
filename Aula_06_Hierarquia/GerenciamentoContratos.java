package Aula_06_Hierarquia;

//EXERCICIO 9

//SUPERCLASSE
class Documento {
    protected String titulo;

    public Documento(String titulo) {
        this.titulo = titulo;
    } 

    public void imprimir() {
        System.out.println("Documento " + this.titulo);
    }
}

//SUBCLASSE
class Contrato extends Documento {
    private String partesEnvolvidas;

    public Contrato(String tituloContrato, String partesEnvolvidas) {
        super(tituloContrato);
        this.partesEnvolvidas = partesEnvolvidas;
    }

    @Override
    public void imprimir() {
        System.out.println("=====================================");
        System.out.println(super.titulo.toUpperCase());
        System.out.println("=====================================");
        System.out.printf("Partes envolvidas: %s\n", this.partesEnvolvidas);
    }
}

public class GerenciamentoContratos {
    public static void main(String[] args) {
        Documento doc1 = new Documento("Um");
        Contrato cont1 = new Contrato("Contratação", "Trabalhador");
        doc1.imprimir();
        cont1.imprimir();
    }
}
