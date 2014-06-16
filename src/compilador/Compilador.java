/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Sergio
 */
public class Compilador {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        AnalisadorSintatico sintatico = new AnalisadorSintatico();
        sintatico.setVisible(true);
    }
    
}
