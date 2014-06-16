/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Sergio
 */

public class AnalisadorLexical {
    
    JFileChooser choice;
    int option, linha = 0;
    char caracter;
    File file;
    FileReader read;
    BufferedReader reader;
    Token token;
    private int count = 0;
    
    public AnalisadorLexical(File file2) throws FileNotFoundException, IOException{
        
        file = file2;
        read = new FileReader(file);
        reader = new BufferedReader(read);
        caracter = ' ';
    }
    
    public Token getToken() throws IOException{
        
        //caracter = (char)reader.read();
        while(reader.ready()){
            while(caracter == ' ' || caracter == '{' || caracter == '\n' && reader.ready() || caracter == '\r' || caracter == '\t'){
                if(caracter == '\n')
                    linha++;
                if(caracter == '{')
                    while(caracter != '}')
                        caracter = (char)reader.read();
                caracter = (char)reader.read();
            }
            token = pegaToken();
            System.out.println(token);
            return token;          
        }
        //System.out.println(count);
        //System.out.println("Lexico Sucesso");
        token = pegaToken();
        System.out.println(token);
        return token;
    }

    private Token pegaToken() throws IOException {
        
        if(Character.isDigit(caracter))
            return trataDigito();
        else if(Character.isAlphabetic(caracter))
            return trataIdentificador();
        else if(caracter == ':')
            return trataAtribuicao();
        else if(caracter == '+' || caracter == '-' || caracter == '*')
            return trataOpAritmetico();
        else if(caracter == '>' || caracter == '<' || caracter == '=' || caracter == '!' )
            return trataOpRelacional();
        else if(caracter == ';' || caracter == ',' || caracter == '(' || caracter == ')' || caracter == '.')
            return trataPontuacao();
        else
            System.err.println("Erro lexico na linha:" +linha);
        
        return null;
    }

    private Token trataDigito() throws IOException {
        String num;
        num = String.valueOf(caracter);
        caracter = (char)reader.read();
        
        while(Character.isDigit(caracter)){
            num = num + caracter;
            caracter = (char)reader.read();
        }
        return new Token(num,"Snumero");
    }

    private Token trataIdentificador() throws IOException {
        String id;
        id = String.valueOf(caracter);
        caracter = (char)reader.read();
        
        while(Character.isDigit(caracter) || Character.isAlphabetic(caracter) || caracter == '_'){
            
            id = id + caracter;
            caracter = (char)reader.read();
        }
        switch(id){
            
        case "programa": 
            return new Token(id,"Sprograma");
            
        case "se": 
            return new Token(id,"Sse");
            
        case "entao": 
            return new Token(id,"Sentao");
            
        case "senao": 
            return new Token(id,"Ssenao");
            
        case "enquanto": 
            return new Token(id,"Senquanto");
            
        case "faca": 
            return new Token(id,"Sfaca");
            
        case "inicio": 
            return new Token(id,"Sinicio");
            
        case "fim": 
            return new Token(id,"Sfim");
            
        case "escreva": 
            return new Token(id,"Sescreva");
            
        case "leia": 
            return new Token(id,"Sleia");
            
        case "var": 
            return new Token(id,"Svar");
            
        case "inteiro": 
            return new Token(id,"Sinteiro");
            
        case "booleano": 
            return new Token(id,"Sbooleano");
            
        case "verdadeiro": 
            return new Token(id,"Sverdadeiro");
            
        case "falso": 
            return new Token(id,"Sfalso");
            
        case "procedimento": 
            return new Token(id,"Sprocedimento");
            
        case "funcao": 
            return new Token(id,"Sfuncao");
            
        case "div": 
            return new Token(id,"Sdiv");
            
        case "e": 
            return new Token(id,"Se");
            
        case "ou": 
            return new Token(id,"Sou");
            
        case "nao": 
            return new Token(id,"Snao");
        
        default:
        return new Token(id,"Sidentificador");
        }
    }
    private Token trataOpAritmetico() throws IOException {
        
        String id;
        id = String.valueOf(caracter);
        caracter = (char) reader.read();
        
        switch(id){
            
            case "+":
                return new Token(id,"Smais");
                
            case "-":
                return new Token(id,"Smenos");
                
            case "*":
                return new Token(id,"Smult");
        } 
        return null;
    }

    private Token trataOpRelacional() throws IOException {
        
        String id;
        id = String.valueOf(caracter);
        caracter = (char) reader.read();
        if(caracter == '='){
            
            switch(id){
                
                case ">":
                    id = id + caracter;
                    caracter = (char) reader.read();
                    return new Token(id,"Smaiorig");
                    
                case "<":
                    id = id + caracter;
                    caracter = (char) reader.read();
                    return new Token(id,"Smenorig");
                    
                case "!":
                    id = id + caracter;
                    caracter = (char) reader.read();
                    return new Token(id,"Sdif");

            }

        }else{
            switch(id){
                case ">":
                    return new Token(id,"Smaior");
                    
                case "<":
                    return new Token(id,"Smenor");
                    
                case "=":
                    return new Token(id,"Sig");
            }
        }
        return null;
        
    }

    private Token trataPontuacao() throws IOException {
        
        String id;
        id = String.valueOf(caracter);
        caracter = (char) reader.read();
        
        if(caracter != '='){
        
            switch(id){

                case ".":
                    return new Token(id,"Sponto");

                case ",":
                    return new Token(id,"Svirgula");

                case ";":
                    return new Token(id,"Sponto_virgula");

                case ")":
                    return new Token(id,"Sfecha_parenteses");

                case "(":
                    return new Token(id,"Sabre_parenteses");
            }
            
        }
        return null;
    }

    private Token trataAtribuicao() throws IOException {
        
        String id;
        id = String.valueOf(caracter);
        caracter = (char) reader.read();
        
        if(caracter == '='){
            id = id + caracter;
            caracter = (char) reader.read();
            return new Token(id,"Satribuicao");
        }else
            return new Token(id,"Sdoispontos");
            
    }

   public int getLinha() {
        return linha;
    }
}

