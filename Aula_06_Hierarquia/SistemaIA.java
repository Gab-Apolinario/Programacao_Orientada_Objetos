package Aula_06_Hierarquia;

//EXERCICIO 2

class ModuloIA {
    private String tarefa;

    public ModuloIA(String tarefa) {
        this.tarefa = tarefa;

        System.out.printf("Tarefa %s criada!\n", getTarefa());
    }

    public String getTarefa() {
        return this.tarefa;
    }

    public void executar() {
        System.out.printf("Executando a tarefa %s\n", getTarefa());
    }
}

class ProjetoSentirIA {
    //vertor com tamanho 2
    private ModuloIA[] modulos = new ModuloIA[2];
    
    public ProjetoSentirIA() {
        modulos[0] = new ModuloIA("Reconhecimento de Emoções");
        modulos[1] = new ModuloIA("Processamento de Linguagem Natural");
    }

    public void inicializar() {
        System.out.println("Inicializando");
        for (int i = 0; i < modulos.length; i++) {
            modulos[i].executar();
        }
    }
}

public class SistemaIA {
    public static void main(String[] args) {
        //new ProjetoSentirIA
        ProjetoSentirIA projeto = new ProjetoSentirIA();
        //inicializar()
        projeto.inicializar();
    }
}
