package ufpb.dcx.projetosPoo;

import java.util.List;
import java.util.ArrayList;

public class CatalogoDeFilmes {

    private List<Filme> listaDeFilmes;

    public CatalogoDeFilmes(){
        this.listaDeFilmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme novoFilme) throws Exception{
        if(listaDeFilmes.contains(novoFilme)){
            throw new Exception("Erro: O filme '" + novoFilme.getTitulo() + "' já está cadastrado no catálogo!");
        }

        listaDeFilmes.add(novoFilme);
        System.out.println("Filme '" + novoFilme.getTitulo() + " 'adicionado com sucesso ao catálogo");
    }

    public void listarFilmes(){
        if (listaDeFilmes.isEmpty()) {
            System.out.println("O catálogo está vazio no momento.");
        }else{
            System.out.println("--- Catálogo de Filmes ---");
            for (Filme filme : listaDeFilmes){
                System.out.println(filme);
            }
            System.out.println("------------------------");
        }
    }

}

