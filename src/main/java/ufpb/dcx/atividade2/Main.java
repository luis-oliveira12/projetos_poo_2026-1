package ufpb.dcx.atividade2;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner leitor = new Scanner(System.in);
        CatalogoDeFilmes catalogo = new CatalogoDeFilmes();
        boolean continuar = true;
        System.out.println("=== CADASTRO DE FILMES ===");

        while (continuar) {
            try {
                System.out.println("Digite o título do filme: ");
                String titulo = leitor.nextLine();

                System.out.println("Digite o nome do(a) Diretor(a): ");
                String diretor = leitor.nextLine();

                System.out.println("Digite o gênero do filme: ");
                String genero = leitor.nextLine();

                System.out.println("Digite o ano de lançamento do filme: ");
                int anoDeLancamento = leitor.nextInt();
                leitor.nextLine();

                System.out.println("Digite a classificação indicativa do filme: ");
                int classificacaoIndicativa = leitor.nextInt();
                leitor.nextLine();

                Filme novoFilme = new Filme(titulo, anoDeLancamento, diretor, genero, classificacaoIndicativa);
                catalogo.adicionarFilme(novoFilme);
            } catch (InputMismatchException erroDeDigitacao) {
                System.out.println("Erro crítico! Você inseriu letras onde deveria ser número");

            } catch (Exception erroDeRegraDeNegocio) {
                System.out.println(erroDeRegraDeNegocio.getMessage());
            }

            System.out.println("\n Deseja cadastrar outro filme? (S/N)");
            String resposta = leitor.nextLine();
            if(resposta.equalsIgnoreCase("n")){
                continuar = false;
            }
        }
        leitor.close();
        System.out.println("\n");
        catalogo.listarFilmes();
    }
}

