package Aula_06_Hierarquia;

//EXERCICIO 2

class ModuloIA {
    private String tarefa;

    public ModuloIA(String tarefa) {
        this.tarefa = tarefa;

        System.out.printf("Tarefa %s criada!", getTarefa());
    }

    public String getTarefa() {
        return this.tarefa;
    }

    public void executar() {
        System.out.printf("Executando a tarefa %s", getTarefa());
    }
}

class ProjetoSentirIA {

}

public class SistemaIA {
    public static void main(String[] args) {
        //ModuloIA moduloIA = new ModuloIA("Analisar PDFs");
    }
}
