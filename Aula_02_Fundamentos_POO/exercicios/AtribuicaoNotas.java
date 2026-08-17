package exercicios;

class Estudante {
    private String nome;
    private float nota;

    public Estudante(String nome, float nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public void situacaoAluno(){
        if (this.nota >= 7f){
            System.out.printf("Aluno %s aprovado. Nota: %.1f.", this.nome, this.nota);
        }else if (this.nota >= 4f && this.nota < 7f){
            System.out.printf("Aluno %s em recuperação. Nota: %.1f.", this.nome, this.nota);
        }else{
            System.out.printf("Aluno %s reprovado. Nota: %.1f.", this.nome, this.nota);
        }
    }

    public float getNota(){
        return this.nota;
    }

    public String getNome(){
        return this.nome;
    }

    public void atualizarNota(float novaNota) {
        if (novaNota < 0) {
            throw new IllegalArgumentException("Nota negativa, valor inválido.");
        }else if (novaNota > 10){
            throw new IllegalArgumentException("Nota maior que o 10, valor inválido.");
        }else {
            this.nota = novaNota;
        }
    }
}

class Professor {
    private String nome;

    public Professor(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void atribuirNota(Estudante estudante, float nota) {
        estudante.atualizarNota(nota);
    }
}
public class AtribuicaoNotas{
    public static void main(String[] args) {
        Estudante estudante1 = new Estudante("Gabriel", 0f);
        Professor professor = new Professor("Dani");

        try {
            professor.atribuirNota(estudante1, 7f);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        estudante1.situacaoAluno();
    }
}