import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import interfaces.AparelhoTelefone;
import models.Contato;

public class PhoneApp implements AparelhoTelefone {

    private List<Contato> listaDeContatos;

    public PhoneApp(List<Contato> listaDeContatos) {
        this.listaDeContatos = listaDeContatos;
    }

    @Override
    public void ligar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Lista de contatos:  ");
        Map<String, String>mapTelefoneContato = new HashMap<String, String>();
        for (Contato contato : listaDeContatos) {
            System.out.println("Nome: " + contato.getNome() + " | Telefone: " + contato.getTelefone());
            mapTelefoneContato.put(contato.getNome(), new String(contato.getTelefone()));
        }
        System.out.println("Digite o nome de um contato para efetuar uma ligacao:");
        String nome = input.nextLine();
        if(mapTelefoneContato.containsKey(nome)){
            System.out.println("Voce efetuou uma ligacao para " + nome);
        }else{
            System.out.println("Esse nome nao esta na sua lista de contatos");
        }
        input.close();
    }

    @Override
    public void atender() {
       System.out.println("Voce atendeu o telefone");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Voce inicou o correio de voz");
    }
    
}
