package ufpb.dcx.atividade2;

import java.io.*;
import java.util.Collection;

public class GravadorDeDados {

    public static final String NOME_ARQUIVO_FILMES = "filmes.txt";

    public void salvarFilmes(Collection<Filme> filmes) throws IOException {
        //TODO

        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO_FILMES));
            gravador.writeObject(filmes);
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }

    public Collection recuperarFilmes() throws IOException{
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO_FILMES));
            Collection<Filme> filmesRecuperados;
            return produtosRecuperados;
        } catch (ClassNotFoundException e){
            throw new IOException("Classe desconhecida:" + e.getMessage());
        }finally {
            if (leitor!=null){
            leitor.close();
            }
        }
    }
}


