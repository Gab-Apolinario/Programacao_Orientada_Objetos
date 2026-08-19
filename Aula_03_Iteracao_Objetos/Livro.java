package Aula_03_Iteracao_Objetos;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true; //cria o livro já disponível
    }

    public void exibir_info() {
        System.out.printf("Livro: %s | Autor: %s | Disponível: %s\n", this.titulo, this.autor, (this.disponivel? "Sim":"Não"));
    }

    public String get_Titulo() {
        return this.titulo;
    }

    public void set_disponivel() {
        this.disponivel = true;
    }

    public boolean livro_disponivel() {
        return this.disponivel;
    }

    public void set_indisponivel() {
        this.disponivel = false;
    }
}

class Leitor {
    private String nome;
    private Livro livroEmprestado;

    public Leitor(String nome) {
        this.nome = nome;
        this.livroEmprestado = null; //cria vazio pois ainda não tem nada emprestado
    }

    public void pegar_emprestado(Livro livro) {
        if (livro.livro_disponivel()) {
            livroEmprestado = livro;
            livro.set_indisponivel();
            System.out.printf("O leitor %s pegou o livro %s emprestado.\n", this.nome, this.livroEmprestado.get_Titulo());
        }else{
            throw new IllegalArgumentException("Livro Indisponível, não pode ser emprestado."); // try/catch
        }
    }

    public void devolver_livro() {
        if (livroEmprestado != null) {
            System.out.printf("O leitor %s devolveu o livro %s.\n", this.nome, this.livroEmprestado.get_Titulo());
            this.livroEmprestado.set_disponivel(); //torna false
            this.livroEmprestado = null; //deixa vazio
        }
    }

    public static void main(String[] args) {
        Livro livro_0 = new Livro("Senhor dos Anéis", "Tolkien");
        Leitor leitor_0 = new Leitor("Gabriel");
        Leitor leitor_1 = new Leitor("Abelardo Barbosa");

        livro_0.exibir_info();
        leitor_0.pegar_emprestado(livro_0);
        livro_0.exibir_info();
        
        try {
            leitor_1.pegar_emprestado(livro_0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}