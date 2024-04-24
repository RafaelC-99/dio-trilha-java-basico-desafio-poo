package models;
import java.util.List;

public class Album {
    private List<Musica> musicas;
    private String nomeAlbum;

    public Album(List<Musica> musicas, String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
        this.musicas = musicas;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }
}
