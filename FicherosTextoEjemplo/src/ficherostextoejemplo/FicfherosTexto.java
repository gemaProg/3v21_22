/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherostextoejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gema
 */
public class FicfherosTexto {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File fichero = new File("Carlota.txt");
        if (fichero.exists() == false) {
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                System.out.println("No se ha podido crear el fichero");
            }
        }
        
        Ficheros.listarLineas(Ficheros.leerFichero());
    }

}
