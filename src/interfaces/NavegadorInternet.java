package interfaces;

public interface NavegadorInternet {
    Boolean navegadorEstaAberto();
    void abrirNavegador();
    void fecharNavegador();
    void exibirPagina();
    void adicionarNovaAba();
    void atualizarPagina();
}