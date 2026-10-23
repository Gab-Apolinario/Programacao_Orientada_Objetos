package Aula_07_Polimorfismo;

// EXERCICIO 7

class ModeloCognitivo {
    public void processarDados() { }
}

class ModuloEmocao extends ModeloCognitivo {
    @Override
    public void processarDados() {
        System.out.println("Módulo com detecção de varições emocionais.");
    }
}

class ModuloLinguagem extends ModeloCognitivo {
    @Override
    public void processarDados() {
        System.out.println("Módulo com tradução semântica usando Google IA Pro.");
    }
}

public class ProjetosIA {
    public static void main(String[] args) {
        ModeloCognitivo[] modeloCognitivos = new ModeloCognitivo[2];
        modeloCognitivos[0] = new ModuloEmocao();
        modeloCognitivos[1] = new ModuloLinguagem();
        
        for (int i = 0; i < modeloCognitivos.length; i++) {
            modeloCognitivos[i].processarDados();
        }
    }
}
