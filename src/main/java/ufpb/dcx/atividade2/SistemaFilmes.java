package ufpb.dcx.atividade2;

/**
 *
 */
public interface SistemaFilmes {

    public void adicionarFilme(String titulo, int anoDeLancamento, String diretor, String genero, int classificacaoIndicativa);
    public void listarFilmes(Filme);
}
