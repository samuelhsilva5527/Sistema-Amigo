package br.ufpb.dcx.samuel.models;

import java.util.Scanner;

/**
 * 
 * @author Samuel
 *
 */
public class TestaSistemaAmigoGUI {
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        System.out.println("Digite a quantidade máxima de mensagem que o sistema suporta");
        int quantMsgs = leitor.nextInt();

        System.out.println("Digite a quantidade de pessoas que participarão");
        int quantPessoas = leitor.nextInt();

        try {
            for (int i = 0; i < quantPessoas; i++) {

                System.out.println("Digite o nome da pessoa:");
                String nome = leitor.next();
    
                System.out.println("Digite o email da pessoa:");
                String email = leitor.next();
                
                sistema.cadastraAmigo(nome, email);
    
            }

            sistema.configuraAmigoSecretoDe("samuel@email", "adrian@email");
            sistema.configuraAmigoSecretoDe("adrian@email", "nathan@email");
            sistema.configuraAmigoSecretoDe("nathan@email", "chico@email");
            sistema.configuraAmigoSecretoDe("chico@email", "samuel@email");
            
            System.out.println("samuel@email: " + sistema.pesquisaAmigoSecretoDe("samuel@email"));
            System.out.println("adrian@email: " + sistema.pesquisaAmigoSecretoDe("adrian@email"));
            System.out.println("nathan@email: " + sistema.pesquisaAmigoSecretoDe("nathan@email"));
            System.out.println("chico@email: " + sistema.pesquisaAmigoSecretoDe("chico@email"));

        } catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Digite o email da pessoa que ir� enviar a mensagem: ");
        String emailRemetente = leitor.next();
        System.out.println("Digite o texto a ser enviado: ");
        String texto = leitor.next();
        System.out.println("Para enviar de forma anonima digite 1 /n"
        		+ "Caso contrario digite 2");
        
        
        int anonimaInt = leitor.nextInt();
        while (anonimaInt != 1 && anonimaInt != 2) {
            System.out.println("valor invalido, digite novamente");
            anonimaInt = leitor.nextInt();
        }
        boolean anonima = anonimaInt == 1 ? true : false;
        
        sistema.enviarMensagemParaTodos(texto, emailRemetente, anonima);
		
        
        leitor.close();
    }
}