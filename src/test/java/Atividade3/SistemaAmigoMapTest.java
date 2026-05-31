package Atividade3;

import ufpb.dcx.atividade3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SistemaAmigoMapTest {

    private SistemaAmigoMap sistema;


    @BeforeEach
    void setUp() {
        sistema = new SistemaAmigoMap();
        sistema.cadastraAmigo("José", "jose@email.com");
        sistema.cadastraAmigo("Maria", "maria@email.com");
    }


    @Test
    void testaCadastroEBuscaDeAmigo() {
        Amigo jose = sistema.pesquisaAmigo("jose@email.com");


        assertNotNull(jose);

        assertEquals("José", jose.getNome());
    }

    @Test
    void testaConfigurarEPesquisarAmigoSecretoComSucesso() {
        try {
            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            String amigoSorteado = sistema.pesquisaAmigoSecretoDe("jose@email.com");


            assertEquals("maria@email.com", amigoSorteado);
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção ao configurar corretamente.");
        }
    }

    @Test
    void testaExcecaoAmigoInexistente() {

        assertThrows(AmigoInexistenteException.class, () -> {
            sistema.configuraAmigoSecretoDe("fantasma@email.com", "maria@email.com");
        });
    }

    @Test
    void testaExcecaoAmigoNaoSorteado() {

        assertThrows(AmigoNaoSorteadoException.class, () -> {
            sistema.pesquisaAmigoSecretoDe("jose@email.com");
        });
    }

    @Test
    void testaEnvioDeMensagemAnonima() {
        sistema.enviarMensagemParaTodos("Feliz Natal", "maria@email.com", true);
        List<Mensagem> anonimas = sistema.pesquisaMensagensAnonimas();

        // Afirma que a lista de mensagens anônimas tem tamanho 1
        assertEquals(1, anonimas.size());
        // Afirma que o texto salvo é exatamente este
        assertTrue(anonimas.get(0).getTextoCompletoAExibir().contains("Mensagem para todos"));
    }
}