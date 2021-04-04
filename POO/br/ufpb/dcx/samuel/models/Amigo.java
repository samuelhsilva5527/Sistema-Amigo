package br.ufpb.dcx.samuel.models;
/**
 * @author Samuel
 */
public class Amigo {

     private String nome;
     private String email;
     private String emailAmigoSorteado;
    /**
     * Contrutor padrão
     * @param nome
     * @param email
     */
    public Amigo(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
     
}
