package Aula_06_Hierarquia;

//EXERCICIO 6

class Musica {
    private String titulo;

    public Musica(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }
}

class Playlist {
    private String nome;
    private Musica[] musicas = new Musica[20];
    private int contadorMusicas = 0;

    public Playlist(String nome) {
        this.nome = nome;
    }
    
    public void addMusica(Musica m) {
        if (contadorMusicas < musicas.length) {
            musicas[contadorMusicas] = m;
            System.out.printf("Musica %s adicionada na posição %d\n", m.getTitulo(), contadorMusicas);
            contadorMusicas++;
        } else {
            System.out.println("Playlist Cheia!");
        }
    }

    public void tocar() {
        System.out.printf("Tocando Playlist %s:\n", this.nome);
        System.out.println("Fila:");
        for (int i = 0; i < contadorMusicas; i++) {
            System.out.printf("%d - %s\n", i, musicas[i].getTitulo());
        }
    }
}

public class Playlists {
    public static void main(String[] args) {
        //Criar variáveis com for
        Musica avulsas[] = new Musica[5];
        for (int i = 0; i < avulsas.length; i++) {
            avulsas[i] = new Musica("Musica " + i);
        }

        //For adiconar na playlist
        Playlist playlist = new Playlist("Favoritas");
        for (int i = 0; i < avulsas.length; i++) {
            playlist.addMusica(avulsas[i]);
        }

        playlist.tocar();
    }
}