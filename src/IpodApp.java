import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.ReprodutorMusical;
import models.Album;
import models.Musica;

public class IpodApp implements ReprodutorMusical{
    private Boolean hasBeenActived;
    private List<Album> albuns;

    public IpodApp(List<Album> albuns){
        this.albuns = albuns;
        this.hasBeenActived=false;
    }

    @Override
    public void ativarReprodutor(){
        this.hasBeenActived=true;
    }

    @Override
    public void desativarReprodutor(){
        this.hasBeenActived=false;
    }

    @Override
    public Boolean estaAtivado(){
        return this.hasBeenActived;
    }

    @Override
    public void tocar(String musica){
        if (!musica.isEmpty()) {
            System.out.println("Musica " + musica + " esta tocando");
        }else{
            System.out.println("Nenhuma musica foi selecionada!");
        }
        
    }
    
    @Override
    public void pausar(String musica){
        if (!musica.isEmpty()){
            System.out.println("Musica" + musica + " esta pausada");
        }else{
            System.out.println("Nenhuma musica foi selecionada!");
        }
    }

    @Override
    public String selecionarMusica(){
        Scanner input = new Scanner(System.in);
        List<String> nomesAlbum =  new ArrayList<>();
        List<String> nomesMusica = new ArrayList<>();
        System.out.println("Selecao de Musica\n\n");
        System.out.println("Albuns: ");
        for (Album album : albuns) {
            nomesAlbum.add(album.getNomeAlbum());
            System.out.println("    Nome album: " + album.getNomeAlbum());
        }
        System.out.println("Digite o nome do album que deseja selecionar:");
        String nomeAlbum = input.nextLine();

        if(nomesAlbum.contains(nomeAlbum)){
            System.out.println("\n\nMusicas:");
            for (Album album: albuns) {
                if (album.getNomeAlbum() == nomeAlbum) {
                    for (Musica musica : album.getMusicas()) {
                        nomesMusica.add(musica.getNomeMusica());
                        System.out.println("    Musica: " + musica.getNomeMusica());
                    }
                }
            }
            System.out.println("Selecione uma musica: ");
            String nomeMusica = input.nextLine();

            if(nomesMusica.contains(nomeMusica)){
                input.close();
                return nomeMusica;
            }else{
                System.out.println("Nome de musica nao existe no repertorio");
                input.close();
                return null;
            }
        }else{
            System.out.println("Nome de album nao existe no repertorio");
            input.close();
            return null;
        }

    }
}