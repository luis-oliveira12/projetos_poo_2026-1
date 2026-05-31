import ufpb.dcx.atividade3.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class SistemaAmigoMap {
    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos; // Chave: Email -> Valor: Objeto Amigo

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        // No Map, usamos put(chave, valor)
        this.amigos.put(emailAmigo.toLowerCase(), novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        // Sem laços 'for'! Busca direta e performática
        return this.amigos.get(emailAmigo.toLowerCase());
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem msg = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(msg);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem msg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(msg);
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