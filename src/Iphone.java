import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.AparelhoTelefone;
import interfaces.NavegadorInternet;
import interfaces.ReprodutorMusical;
import models.Album;
import models.Contato;
import models.Musica;

public class Iphone {
    public static void main(String[] args) throws Exception {
        Boolean sysOn=true;
        System.out.println("Ola, seja bem vindo ao Iphone!");
        System.out.println("Para desligar, digite 0");
        Scanner input = new Scanner(System.in);
        List<Album> albuns = new ArrayList<>();
        List<Contato> contatos = new ArrayList<>();
        List<Musica> musicas1 = new ArrayList<>();
        List<Musica> musicas2 = new ArrayList<>();

        musicas1.add(new Musica("melodia1"));
        musicas1.add(new Musica("melodia2"));
        musicas1.add(new Musica("melodia3"));
        musicas1.add(new Musica("melodia4"));

        musicas2.add(new Musica("melodia5"));
        musicas2.add(new Musica("melodia6"));
        musicas2.add(new Musica("melodia7"));

        contatos.add(new Contato("Alex","123456"));
        contatos.add(new Contato("Amanda","3333333"));
        contatos.add(new Contato("Antonio","5555555"));
        

        Album album1 = new Album(musicas1,"album1");
        Album album2 = new Album(musicas2,"album2");

        albuns.add(album1);
        albuns.add(album2);

        AparelhoTelefone phoneApp = new PhoneApp(contatos);
        NavegadorInternet safariWebBrowserApp = new SafariWebBrowserApp();
        ReprodutorMusical ipodApp = new IpodApp(albuns);
        do{
            System.out.println("Apps do iphone: ");
            System.out.println("1 - Ipod");
            System.out.println("2 - PhoneApp");
            System.out.println("3 - Safari Browser");

            System.out.println("\nEscolha um app para usar suas funcionalidades:");
            int entrada = input.nextInt();
            input.nextLine();
            switch (entrada) {
                case 1:
                    ipodApp.ativarReprodutor();
                    String musicaSelecionada = "";
                    while (ipodApp.estaAtivado()) {
                        System.out.println("Selecione uma opcao");
                        System.out.println("1 - Selecionar uma musica");
                        System.out.println("2 - tocar a musica");
                        System.out.println("3 - pausar a musica");
                        System.out.println("0 - sair do Ipod");
                        int entradaIpod = input.nextInt();
                        input.nextLine();
                        switch (entradaIpod) {
                            case 1:
                                musicaSelecionada=ipodApp.selecionarMusica();
                                break;
                            case 2:
                                ipodApp.tocar(musicaSelecionada);
                                break;
                            case 3:
                                ipodApp.pausar(musicaSelecionada);
                                break;
                            case 0:
                                ipodApp.desativarReprodutor();
                            default:
                                System.out.println("Entrada invalida!");
                                break;
                        }
                    }
                    break;
                case 2:
                    int entradaPhoneApp;
                    do{
                        entradaPhoneApp=input.nextInt();
                        input.nextLine();
                        System.out.println("1 - Ligar para algum contato");
                        System.out.println("2 - Atender o telefone");
                        System.out.println("3 - Iniciar o correio de voz");
                        System.out.println("0 - Sair do phone app");
                        switch (entradaPhoneApp) {
                            case 1:
                                phoneApp.ligar();
                                break;
                            case 2:
                                phoneApp.atender();
                                break;
                            case 3:
                                phoneApp.iniciarCorreioVoz();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Entrada invalida");
                                break;
                        }
                    }while(entradaPhoneApp != 0);
                    break;
                case 3:
                    safariWebBrowserApp.abrirNavegador();
                    while(safariWebBrowserApp.navegadorEstaAberto()){
                        int entradaSafari=input.nextInt();
                        input.nextLine();
                        System.out.println("1 - Exibr pagina");
                        System.out.println("2 - Adicionar nova aba");
                        System.out.println("3 - atualizar pagina");
                        System.out.println("0 - Sair do navegador");
                        switch (entradaSafari) {
                            case 1:
                                safariWebBrowserApp.exibirPagina();
                                break;
                            case 2:
                                safariWebBrowserApp.adicionarNovaAba();
                                break;
                            case 3:
                                safariWebBrowserApp.atualizarPagina();
                                break;
                            case 0:
                                safariWebBrowserApp.fecharNavegador();
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 0:
                    sysOn=false;
                    break;
                default:
                    System.out.println("Entrada invalida!");
                    break;
            }
        }while(sysOn==true);
        System.out.println("Desligando o Iphone...");
        input.close();
    }
}
