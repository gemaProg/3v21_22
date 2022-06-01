/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3ev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prog
 */
public class GestionFicheros {

    public static final String ficherotxt = "ficheroPistas";
    public static final String ficheroB = "ficheroPistasBinario";

    //Texto
    public static void crearFicheros() {
        File f = new File(ficherotxt);
        File f2 = new File(ficheroB);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            if (!f2.exists()) {
                f2.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escribirFichero(ArrayList<Pista> pistas) {

        try {
            //PrintWriter pw = new PrintWriter(new FileWriter(ficherotxt)); //crea fichero
            PrintWriter pw = new PrintWriter(ficherotxt);
            for (int i = 0; i < pistas.size(); i++) {
                pw.println(pistas.get(i).toStringFichero());
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*catch (IOException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static ArrayList<Pista> leerFichero() {
        //Se pone esta línea para ir creando una pista por cada línea leida en el fichero
        ArrayList<Pista> auxiliar = new ArrayList();
        Scanner sc;
        try {
            sc = new Scanner(new File(ficherotxt));
            while (sc.hasNextLine()) {
                String cad = sc.nextLine();
                String partes[] = cad.split("/");
                if (partes[0].equalsIgnoreCase("SkiFondo")) {
                    //auxiliar.add(new SkiFondo(partes[1], partes[2], partes[3], partes[4], partes[5]));
                    ArrayList<String> pueblos = new ArrayList<>();
                    String trozos[] = partes[5].split(";");
                    for (int i = 0; i < partes.length; i++) {
                        pueblos.add(trozos[i]);
                    }
                    auxiliar.add(new SkiFondo(Integer.parseInt(partes[1]), partes[2], partes[3], Double.parseDouble(partes[4]), pueblos));

                } else {
                    auxiliar.add(new SkiAlpino(Integer.parseInt(partes[1]), partes[2], partes[3], Double.parseDouble(partes[4]), partes[5]));

                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
        }
        return auxiliar;
    }

    
    public static void escribirFicheroBinario(ArrayList<Pista> pistas) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroB));
            os.writeObject(pistas);
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }

    public static ArrayList<Pista> leerFicheroBinario() {
        ArrayList<Pista> auxiliar = new ArrayList<Pista>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(ficheroB));
            auxiliar = (ArrayList<Pista>) is.readObject();
             is.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("Error.");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
        }
        return auxiliar;
    }

}    