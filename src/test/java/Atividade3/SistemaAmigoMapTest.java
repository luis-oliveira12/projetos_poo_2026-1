package ufpb.dcx.atividade3;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class SistemaAmigoMapTest {
    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMapTest() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        this.amigos.put(emailAmigo.toLowerCase(), new Amigo(nomeAmigo, emailAmigo));
    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        return this.amigos.get(emailAmigo.toLowerCase());
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        this.mensagens.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        this.mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        if (pessoa == null) {
            throw new AmigoInexistenteException("A pessoa com e-mail " + emailDaPessoa + " não está cadastrada.");
        }
        pessoa.setAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        if (pessoa == null) {
            throw new AmigoInexistenteException("A pessoa com e-mail " + emailDaPessoa + " não está cadastrada.");
        }
        String sorteado = pessoa.getEmailAmigoSorteado();
        if (sorteado == null) {
            throw new AmigoNaoSorteadoException("O amigo secreto de " + emailDaPessoa + " ainda não foi configurado.");
        }
        return sorteado;
    }
}