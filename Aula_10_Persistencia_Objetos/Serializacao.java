package Aula_10_Persistencia_Objetos;

import java.io.*;

class Usuario implements Serializable {
    private static final long serialVersionUID = 1L; // 'versionamento' -> Hash **OBRIGATÓRIA** para trabalhar com
                                                     // serializable

    private String nome;
    private transient String senha; // Não é salva no arquivo

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    @Override   //senha, por ser transient, não guarda valor na var, então será null. 
                // Mas precisa mostrar na tela e transformar em string antes
    public String toString() {
        return "Usuário[Nome = " + nome + ", Senha = " + senha + "]";

    }
    
    public void salvarDados(String nomeArquivo) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))){
            oos.writeObject(this);
            System.out.println(this.nome + " salvo no disco");
        } catch (IOException e) {
            System.err.println("Erro!" + e.getMessage());
        }
    }
    
    public static Usuario lerDados(String nomeArquivo) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (Usuario) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler objeto!" + e.getMessage());
            return null;
        }
    }

    public class Serializacao {
        public static void main(String[] args) {
            System.out.println("Serialização em Disco!");

            String arquivo = "dados.dat";

            Usuario meuUsuario = new Usuario("Gabriel", "Apolinario579");

            System.out.println("Criado: " + meuUsuario);
            
            meuUsuario.salvarDados(arquivo);
            
            System.out.println("Recuperando Dados!");
            Usuario usuarioRecuperado = new Usuario("",""); // Cria um objeto vazio para receber os dados do arquivo
            usuarioRecuperado = Usuario.lerDados(arquivo);
            System.out.println("Recuperado: " + usuarioRecuperado);
        }
    }
}