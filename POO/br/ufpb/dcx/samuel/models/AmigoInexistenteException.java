package br.ufpb.dcx.samuel.models;
/**
 * @author Samuel
 */
public class AmigoInexistenteException extends Exception {
    private static final long serialVersionUID = 1L;

    public AmigoInexistenteException(String msg) {
        super(msg);
    }
}
