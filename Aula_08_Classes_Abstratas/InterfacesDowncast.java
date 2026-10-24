package Aula_08_Classes_Abstratas;

// EXERCICIO 6

interface Armazenamento {
    void salvar(String dados);
}

class DiscoRigido implements Armazenamento {
    @Override
    public void salvar(String dados) {
        System.out.printf("%s sendo salvo no Disco Rígido...\n", dados);
    }
}

class SSD implements Armazenamento {
    @Override
    public void salvar(String dados) {
        System.out.printf("%s sendo salvo no SSD...\n", dados);
    }

    public void otimizar() {
        System.out.println("Otimizando armazenamento do SSD...");
    }
}

public class InterfacesDowncast {
    public static void main(String[] args) {
        Armazenamento[] armazenamentos = new Armazenamento[2];
        armazenamentos[0] = new DiscoRigido();
        armazenamentos[1] = new SSD();
    
        for (int i = 0; i < armazenamentos.length; i++) {
            armazenamentos[i].salvar("Fotos Câmera");
            if (armazenamentos[i] instanceof SSD) {
                SSD s = (SSD) armazenamentos[i];
                s.otimizar();
            }
        }
    }
}
