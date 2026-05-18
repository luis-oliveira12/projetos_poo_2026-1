package ufpb.dcx.projetosPoo;

import java.util.Objects;

public class Filme {

    private String titulo;
    private int anoDeLancamento;
    private String diretor;
    private String genero;
    private int classificacaoIndicativa;

    public Filme (){

    }

    public Filme(String titulo, int anoDeLancamento, String diretor, String genero, int classificacaoIndicativa){
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.diretor = diretor;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDeLancamento(){
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento){
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getDiretor(){
        return diretor;
    }

    public void setDiretor(String diretor){
        this.diretor = diretor;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public int getClassificacaoIndicativa(){
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa){
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String toString(){
        return "Filme: " + titulo + " (" + anoDeLancamento + ") | Diretor: " + diretor + " | Gênero: " + genero + " | Classificação Indicativa: +" + classificacaoIndicativa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filme filmes = (Filme) o;
        return anoDeLancamento == filmes.anoDeLancamento && Objects.equals(titulo, filmes.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, anoDeLancamento);
    }
}


