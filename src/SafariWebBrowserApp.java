import interfaces.NavegadorInternet;

public class SafariWebBrowserApp implements NavegadorInternet {

    private Boolean isOpen;

    public SafariWebBrowserApp() {
        this.isOpen = false;
    }

    @Override
    public Boolean navegadorEstaAberto(){
        return isOpen;
    }

    @Override
    public void abrirNavegador(){
        this.isOpen=true;
    }

    @Override
    public void fecharNavegador(){
        this.isOpen=false;
    }

    @Override
    public void exibirPagina() {
        System.out.println("Voce esta exibindo uma pagina");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Voce adicionou uma nova aba");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Voce atualizou a pagina");
    }
    
}
