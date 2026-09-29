package Aula_06_Hierarquia;

//EXERCICIO 1

class Camera {
    private String modelo;

    public Camera(String modelo) {
        this.modelo = modelo;

        System.out.printf("A câmera %s foi criada!\n", getModelo());
    }

    public String getModelo() {
        return this.modelo;
    }
}

class Fotografo {
    private String nome;
    private Camera camera;

    public Fotografo(String nome, Camera camera) {
        this.nome = nome;
        this.camera = camera;

        System.out.printf("O fotógrafo %s foi criado!\n", getNome());
    }

    public String getNome() {
        return this.nome;
    }

    public void tirarFoto(Camera c) {
        System.out.printf("O fotógrafo %s está capturando uma imagem com a câmera %s", getNome(), c.getModelo());
    }
}

public class Fotografia {
    public static void main(String[] args) {
        Camera camera1 = new Camera("Canon 6D Mark II");
        Fotografo fotografo1 = new Fotografo("Sebastião Salgado", camera1);

        fotografo1.tirarFoto(camera1);
    }
}