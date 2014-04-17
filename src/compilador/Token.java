/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

/**
 *
 * @author Sergio
 */
public class Token {

    private String lexema;
    private String simbolo;

    public Token() {
    }
    
    public Token(String lexema, String simbolo) {
        this.lexema = lexema;
        this.simbolo = simbolo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Token{" + "lexema=" + lexema + ", simbolo=" + simbolo + '}';
    }

}
