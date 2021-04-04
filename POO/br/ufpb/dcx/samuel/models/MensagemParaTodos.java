package br.ufpb.dcx.samuel.models;
/**
 * Envia uma mensagem anonima ou não para todos.
 * @author Samuel
 */
public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAexibir() {
        if(ehAnonima()) {
            return "Mensagem para todos. Texto: " + getTexto();
        }else{
            return "Mensagem de " + getEmailRemetente() + " para todos. Texto: " + getTexto();
        }
    }  
}
