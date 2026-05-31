package Atividade3;

import ufpb.dcx.atividade3.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();
        boolean sair = false;

        System.out.println(" Bem-vindo ao Sistema de Amigo Secreto Interativo! ");


        while (!sair) {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Cadastrar um Amigo");
            System.out.println("2. Configurar Amigo Secreto (Sorteio)");
            System.out.println("3. Pesquisar Amigo Secreto de alguém");
            System.out.println("4. Enviar Mensagem para Todos");
            System.out.println("5. Enviar Mensagem para Alguém Específico");
            System.out.println("6. Ver Apenas Mensagens Anônimas");
            System.out.println("7. Ver Todas as Mensagens");
            System.out.println("8. Sair do Programa");
            System.out.println("======================================");
            System.out.print(" Escolha uma opção: ");

            String opcaoStr = scanner.nextLine();
            int opcao;


            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                System.out.println(" ERRO: Por favor, digite um número válido!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do amigo: ");
                    String nome = scanner.nextLine();
                    System.out.print("E-mail do amigo: ");
                    String email = scanner.nextLine();
                    sistema.cadastraAmigo(nome, email);
                    System.out.println(" Amigo cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("E-mail da pessoa: ");
                    String emailPessoa = scanner.nextLine();
                    System.out.print("E-mail do amigo que ela tirou no sorteio: ");
                    String emailSorteado = scanner.nextLine();


                    try {
                        sistema.configuraAmigoSecretoDe(emailPessoa, emailSorteado);
                        System.out.println(" Sorteio configurado com sucesso!");
                    } catch (AmigoInexistenteException e) {
                        System.out.println(" ERRO DE CADASTRO: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Deseja saber o amigo secreto de qual e-mail? ");
                    String emailBusca = scanner.nextLine();


                    try {
                        String resultado = sistema.pesquisaAmigoSecretoDe(emailBusca);
                        System.out.println(" O amigo secreto dessa pessoa é: " + resultado);
                    } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
                        System.out.println(" ERRO NA BUSCA: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Seu e-mail (Remetente): ");
                    String remetenteTodos = scanner.nextLine();
                    System.out.print("Texto da mensagem: ");
                    String textoTodos = scanner.nextLine();
                    System.out.print("A mensagem é anônima? (S/N): ");
                    boolean anonimaTodos = scanner.nextLine().equalsIgnoreCase("S");

                    sistema.enviarMensagemParaTodos(textoTodos, remetenteTodos, anonimaTodos);
                    System.out.println(" Mensagem enviada para o mural de todos!");
                    break;

                case 5:
                    System.out.print("Seu e-mail (Remetente): ");
                    String remetenteAlguem = scanner.nextLine();
                    System.out.print("E-mail de quem vai receber (Destinatário): ");
                    String destinatario = scanner.nextLine();
                    System.out.print("Texto da mensagem: ");
                    String textoAlguem = scanner.nextLine();
                    System.out.print("A mensagem é anônima? (S/N): ");
                    boolean anonimaAlguem = scanner.nextLine().equalsIgnoreCase("S");

                    sistema.enviarMensagemParaAlguem(textoAlguem, remetenteAlguem, destinatario, anonimaAlguem);
                    System.out.println(" Mensagem entregue a " + destinatario + "!");
                    break;

                case 6:
                    System.out.println("\n---  Mensagens Anônimas ---");
                    List<Mensagem> anonimas = sistema.pesquisaMensagensAnonimas();
                    if (anonimas.isEmpty()) {
                        System.out.println("Nenhuma mensagem anônima encontrada.");
                    } else {
                        for (Mensagem m : anonimas) {
                            System.out.println(m.getTextoCompletoAExibir());
                        }
                    }
                    break;

                case 7:
                    System.out.println("\n--- Todas as Mensagens ---");
                    List<Mensagem> todas = sistema.pesquisaTodasAsMensagens();
                    if (todas.isEmpty()) {
                        System.out.println("O mural de mensagens está vazio.");
                    } else {
                        for (Mensagem m : todas) {
                            System.out.println(m.getTextoCompletoAExibir());
                        }
                    }
                    break;

                case 8:
                    sair = true;
                    System.out.println(" Encerrando o sistema. Feliz Amigo Secreto!");
                    break;

                default:
                    System.out.println(" Opção inválida. Escolha um número de 1 a 8.");
            }
        }
        scanner.close();
    }
}