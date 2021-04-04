package br.ufpb.dcx.samuel.models;

import java.util.List;

/**
 * 
 * @author Samuel
 *
 */
public class TesteSistemaAmigo {

    
    public static void main(String[] args) throws AmigoJaExisteException {

        SistemaAmigo sistema = new SistemaAmigo();
        //Amigo userJose = new Amigo("Jose", "jose@email.com" );
        //Amigo userMaria = new Amigo("Maria", "maria@email.com");
       
        try {
            sistema.cadastraAmigo("Jose", "jose@email.com");
            sistema.cadastraAmigo("Maria", "maria@email.com");

            

            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");

            sistema.enviarMensagemParaAlguem("Oi amigo", "maria@email.com", "jose@email.com", true);
            sistema.enviarMensagemParaTodos("Adorando a brincadeira", "maria@email.com", true);

            //sistema.teste();

            List<Mensagem> mensagensAnonimas = sistema.pesquisaMensagensAnonimas();
            for (Mensagem mensagem : mensagensAnonimas) {
                System.out.println(mensagem.getTextoCompletoAexibir());
            }

            System.out.println(sistema.pesquisaAmigoSecretoDe("jose@email.com"));
            
            List<Mensagem> todasMsg = sistema.pesquisaTodasAsMensagens();
            for (Mensagem mensagem : todasMsg) {
				System.out.println(mensagem.getTexto());
			}

        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());     
        }
    }
}
