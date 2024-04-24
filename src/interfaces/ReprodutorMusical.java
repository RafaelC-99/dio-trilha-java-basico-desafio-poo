package interfaces;

public interface ReprodutorMusical {
    void ativarReprodutor();
    void desativarReprodutor();
    Boolean estaAtivado();
    void tocar(String musica);
    void pausar(String musica);
    String selecionarMusica();
}
