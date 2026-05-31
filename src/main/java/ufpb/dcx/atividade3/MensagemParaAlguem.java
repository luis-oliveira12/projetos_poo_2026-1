package ufpb.dcx.atividade3;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() { return emailDestinatario; }
    public void setEmailDestinatario(String emailDestinatario) { this.emailDestinatario = emailDestinatario; }

    @Override
    public String getTextoCompletoAExibir() {
        if (ehAnonima()) {
            return "Mensagem para " + this.emailDestinatario + ". Texto: " + getTexto();
        } else {
            return "Mensagem de: " + getEmailRemetente() + " para " + this.emailDestinatario + ". Texto: " + getTexto();
        }
    }
}