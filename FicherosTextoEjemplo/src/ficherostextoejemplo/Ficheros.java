/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherostextoejemplo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gema
 */
public class Ficheros {
    public static final String nombreFichero = "Carlota.txt";
    //Ficheros de Texto
    public static int contadorLineas() {
        int contadorLineas = 0;
        try {
            Scanner lector = new Scanner(new File(nombreFichero));
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

    public static String[] leerFichero() {
        String[] lineasFichero = new String[contadorLineas()];
        try {
            Scanner lector = new Scanner(new File(nombreFichero));
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

    public static ArrayList<String> leerFicheroArrayList() {
        ArrayList<String> lineasFichero = new ArrayList();
        try {
            Scanner lector = new Scanner(new File(nombreFichero));
            while (lector.hasNextLine()) {
                lineasFichero.add(lector.nextLine());
            }

            lector.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicfherosTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineasFichero;
    }

    public static ArrayList<String> leerFicheroArrayListBR() {
        ArrayList<String> lineasFichero = new ArrayList();
       
        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File(nombreFichero)));
            String cadena = null;
            /*do{
                cadena = bf.readLine();
                if (cadena!=null)
                    lineasFichero.add(cadena);
            }while(cadena!=null);*/
            
            while((cadena=bf.readLine())!=null){
                lineasFichero.add(cadena);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static void escribirFichero(String [] lineasFichero){
    //Escritura
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(new File(nombreFichero),true));
            for (int i = 0; i < lineasFichero.length; i++) {
                pw.println(lineasFichero[i]);
            }
            pw.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de entrada-salida"+ex.getMessage());
        }
    
    }
    //Ficheros Binarios
    
}
