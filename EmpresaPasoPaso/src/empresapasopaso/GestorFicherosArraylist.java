/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresapasopaso;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class GestorFicherosArraylist {

    public static final String FICHERO_TRABAJADORES = "Trabajadores";

    public static final String FICHERO_BINARIO_TRABAJADORES = "TrabajadoresBinario";

    public static void crearFicheros() {
        File f = new File(FICHERO_TRABAJADORES);
        File f2 = new File(FICHERO_BINARIO_TRABAJADORES);
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

    public static void escribirFicheroPW(String fichero, ArrayList<Trabajador> lista) {
        Scanner lector = new Scanner(System.in);
        try {
            PrintWriter pw = new PrintWriter(fichero);
            for (int i = 0; i < lista.size(); i++) {
               
                    pw.println(lista.get(i).toStringFichero());
                
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("fichero no encontrado");
        }
    }

   

    public static ArrayList<Trabajador> leerFicheroEscaner(String fichero) {
        System.out.println("leyedo fichero....");
        ArrayList<Trabajador> lista = new ArrayList();
        int i = 0;
        try {
            Scanner lf = new Scanner(new File(fichero)/*,"ISO-8859-1"*/);
            String cadena;

            while (lf.hasNextLine()) {
                cadena = lf.nextLine();
                String trozos[] = cadena.split(";");
                if (trozos[0].equalsIgnoreCase("PROGRAMADOR")) {
                    lista.add(new Programador(Boolean.parseBoolean(trozos[6]), trozos[2], new StringBuilder(trozos[7]), trozos[1], trozos[3], new Fecha(trozos[4]), Double.parseDouble(trozos[5])));
                } else {//ojo danger, tienes que hacerlo!!!
                   lista.add(new JefeProyecto());
                }
                System.out.println(lista.get(i));
//boolean experienciaPOO, String NIF, StringBuilder lenguajes, String nombre, String departamento, Fecha fecha, double sueldoBase) 
//lista.get(i)=new 
                
            }

            lf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado" + ex.getMessage());
        }
        return lista;
    }
//Escribir y Leer Ficheros Binario, el array completo de una vez

    public static void escribirFicheroBinario(String fichero, ArrayList<Trabajador> lista) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fichero));
            os.writeObject(lista);
            /*DataOutputStream ds = new DataOutputStream(new FileOutputStream(fichero));
        ds.writeUTF(lista[0].nombre);
        ds.writeUTF(lista[0].departamento);
        ds.writeDouble(lista[0].sueldoBase);
             */
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Trabajador> leerFicheroBinario(String fichero) {
        ArrayList<Trabajador> lista = null;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Trabajador>) os.readObject();
            os.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + "Clase Trabajador [] no encontrada");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
//Escribir y Leer Ficheros Binario, elemento por elemento

    public static void escribirFicheroBinarioUnoPorUno(String fichero, ArrayList<Trabajador> lista) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fichero));
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) != null) {
                    os.writeObject(lista.get(i));
                }
            }

            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Trabajador> leerFicheroBinarioUnoPorUno(String fichero) {
        ArrayList<Trabajador> lista = new ArrayList();
        boolean EOF = false;
        int i = 0;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(fichero));
            while (!EOF) {
                try {
                    lista.add((Trabajador) os.readObject());
                    i++;
                } catch (EOFException e) {
                    EOF = true;
                    System.out.println("Ha alcanzado el final del fichero");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + "Clase Trabajador [] no encontrada");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
