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
    public static int contadorLineas() {
        int contadorLineas = 0;
        try {
            Scanner lector = new Scanner(new File("Carlota.txt"));
            while (lector.hasNextLine()) {
                contadorLineas++;
                lector.nextLine();
            }

            lector.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicfherosTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contadorLineas;
    }

    public static String[] leerFichero(int lineas) {
        String[] lineasFichero = new String[lineas];
        try {
            Scanner lector = new Scanner(new File("Carlota.txt"));
            /*int i=0;
            while (lector.hasNextLine()) {
                lineasFichero[i]=lector.nextLine();
                i++;
            }*/

            for (int i = 0; lector.hasNextLine(); i++) {
                lineasFichero[i] = lector.nextLine();
            }
            lector.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicfherosTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineasFichero;
    }

    public static ArrayList<String> leerFichero() {
        ArrayList<String> lineasFichero = new ArrayList();
        try {
            Scanner lector = new Scanner(new File("Carlota.txt"));
            while (lector.hasNextLine()) {
                lineasFichero.add(lector.nextLine());
            }

            lector.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicfherosTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineasFichero;
    }

    public static void listarLineas(ArrayList<String> lineasFichero) {
        for (int i = 0; i < lineasFichero.size(); i++) {
            System.out.println(lineasFichero.get(i));
        }
    }

    public static void listarLineas(String[] lineasFichero) {
        for (int i = 0; i < lineasFichero.length; i++) {
            System.out.println(lineasFichero[i]);
        }
    }

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
        //Escritura
        try {
            PrintWriter pw2 = new PrintWriter(new FileWriter(new File("Carlota.txt"),true));
            pw2.println("Tienes agujetas?");
            pw2.println("Que no curres mucho el finde");
            pw2.println("Vamos de fiesta");
            pw2.println("Cómo llevas el examen de bbdd?");
            pw2.println("Ey, no te olvides del ahorcado");
            pw2.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        }
        listarLineas(leerFichero(contadorLineas()));
    }

}
