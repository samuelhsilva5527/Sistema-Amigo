package br.ufpb.dcx.samuel.models;

import java.util.ArrayList;
import java.util.List;

 /**
  * Classe para gerenciar um sistema de amigo secreto.
  * @author samuel
  */
 
public class SistemaAmigo {
    
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    /**
     * Contrutor padr„o da classe.
     */
    public SistemaAmigo(){
        this.amigos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }
/**
 * Cadastra um novo participante do amigo secreto.
 * @param nomeAmigo
 * @param emailAmigo
 * @throws AmigoJaExisteException
 */
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        
        Amigo user = new Amigo(nomeAmigo, emailAmigo);
        if (amigos.size() == 0) {
            amigos.add(user);
        }else{
            if (amigos.contains(user)) {
                throw new AmigoJaExisteException("Amigo " + nomeAmigo + " j· existe");
            }else{
                amigos.add(user);
            }
        }
    }

    /**
     * Pesquisa um amigo participante.
     * @param amigo
     * @return
     */
    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
    	for (Amigo amg : amigos) {
			if(amg.getEmail().equals(emailAmigo)) {
				return amg;
			}
		}
		throw new AmigoInexistenteException(emailAmigo + " inexistente");
    }

    /**
     * Envia a mensagem para todos.
     * @param texto
     * @param emailRemetente
     * @param ehAnonima
     */
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        MensagemParaTodos msg = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(msg);
        System.out.println(msg.getTextoCompletoAexibir());
    }

    /**
     * Envia a mensagem para alguem.
     * @param texto
     * @param emailRemetente
     * @param emailDestinatario
     * @param ehAnonima
     */
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        MensagemParaAlguem msg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(msg);
        System.out.println(msg.getTextoCompletoAexibir());

    }

    /**
     * Pesquisar as mensagens anominas.
     * @return uma lista com as mensagens anonimas.
     */
    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimos = new ArrayList<>();
        for (Mensagem msg : mensagens) {
            if (msg.ehAnonima()) {
                anonimos.add(msg);
            }  
        }
        return anonimos;
    }

    /**
     *  Pesquisar todas as mensagens enviadas
     * @return uma lista de mensagens
     */
    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    /**
     * Configura o amigo secreto de emailDaPessoa para emailAmigoSorteado
     * @param emailDaPessoa
     * @param emailAmigoSorteado
     * @throws AmigoInexistenteException
     */
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        boolean naoExiste = true;
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailDaPessoa)) {
                amigo.setEmailAmigoSorteado(emailAmigoSorteado);
                naoExiste = false;
            }
        }
        if (naoExiste) {
            throw new AmigoInexistenteException(emailDaPessoa + " inexistente");
        }
        
    }

    /*public void teste(){
       
        for (Amigo amigo : amigos) {
            System.out.println(amigo.getNome());
            System.out.println(amigo.getEmail());
        }
    }*/

    /**
     * Pesquisa o amigo secreto de emailDaPessoa
     * @param emailDaPessoa
     * @return
     * @throws AmigoInexistenteException
     * @throws AmigoNaoSorteadoException
     */
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        boolean naoExiste = true;
        
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailDaPessoa)) {
                naoExiste = false;
                if (amigo.getEmailAmigoSorteado()!= null) {
                    
                    return amigo.getEmailAmigoSorteado();
                    
                }
            }
        }
        if (naoExiste) {
            throw new AmigoInexistenteException(emailDaPessoa + " inexistente");
        }
        
        throw new AmigoNaoSorteadoException("Amigo secreto de: " + emailDaPessoa + " n√£o sorteado");
        
        
    }

}
