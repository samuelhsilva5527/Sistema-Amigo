package br.ufpb.dcx.samuel.models;

/**
 * Envia uma mensagem anonima ou não para alguem.
 * @author Samuel
 */
public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;
    
    /**
     * Construtor padrão.
     * @param texto
     * @param emailRemetente
     * @param emailDestinatario
     * @param anonima
     */
    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAexibir() {
        if (ehAnonima()) {
           return "Mensagem para " + getEmailDestinatario() + " Texto: " + getTexto();
        }else{
            return "Mensagem de: " + getEmailRemetente() + " para " + getEmailDestinatario() + " Texto: " + getTexto();
        }
        
    }

}
