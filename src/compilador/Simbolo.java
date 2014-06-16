/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

/**
 *
 * @author Sergio
 */
public class Simbolo {
    
    String lexema, tipo, escopo;
    int id, endereco, nivel, posProcFunc;
    
    public void setPosProcFunc(int pos){
        posProcFunc = pos;
    }
    
    public void setLexema(String lex){
        lexema = lex;
    }
    
    public void setTipo(String t){
        tipo = t;
    }
    
    public void setId(int ID){
        id = ID;
    }
    
    public void setEndereco(int end){
        endereco = end;
    }
    
    public void setEscopo(String esc){
        escopo = esc;
    }
    
    public void setNivel(int n){
        nivel = n;
    }
    
    public int getPosProcFunc(){
        return posProcFunc;
    }
    
    public String getLexema(){
        return lexema;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public int getId(){
        return id;
    }
    
    public int getEndereco(){
        return endereco;
    }
    
    public String getEscopo(){
        return escopo;
    }
    
    public int getNivel(){
        return nivel;
    }
}
