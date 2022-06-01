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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author prog
 */
public class GestionFicheros {
    public static void escribirFichero(ArrayList<Pista>pistas){
        try{
            PrintWriter pw=new PrintWriter(new File("ficheroPistas.txt"));
            for (int i = 0; i < pistas.size(); i++) {
                pw.println(pistas.get(i).toStringFichero());
                
            }
            pw.close();
        }catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado.");
        }
    }
    
   /* public static ArrayList<Pista>leerFichero(){
        ArrayList<Pista> auxiliar=new ArrayList<Pista>();
        Scanner sc;
        try{
            sc=new Scanner(new File("ficheroPistas.txt"));
            String cad;
            while(sc.hasNextLine()){
                cad=sc.nextLine();
                String partes[]=cad.split("/");
                if(partes[0].equalsIgnoreCase("SkiFondo")){
                    auxiliar.add(new SkiFondo(Integer.parseInt(partes[1]),partes[2],partes[3],Double.parseDouble(partes[4]),StringBuilder(partes[5])));
                    
                }else{
                    auxiliar.add(new SkiAlphino(Integer.parseInt(partes[1]),partes[2],partes[3],Double.parseDouble(partes[4]),partes[5]));
                
                    
            }
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado.");
        }
        return auxiliar;
    }
    

    */
    public static void escribirFicheroBinario(ArrayList<Pista>pistas){
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream ("ficheroBinario.txt"));
            os.writeObject(pistas);
            os.close();
        }catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado.");
        }catch(IOException e){
            System.out.println("Error.");
        }
    }
    public static ArrayList<Pista> leerFicheroBinario(){
        ArrayList<Pista>auxiliar=new ArrayList<Pista>(); 
        try{
        ObjectInputStream is=new ObjectInputStream(new FileInputStream("ficheroBinario.txt"));
        auxiliar=(ArrayList<Pista>)is.readObject();
        is.close();
        }catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado.");
        }catch(IOException e){
            System.out.println("Error.");
        }catch(ClassNotFoundException e){
            System.out.println("Clase no encontrada.");
        }
        return auxiliar;
    }

    private static StringBuilder StringBuilder(String parte) {
        StringBuilder pueblos=new StringBuilder("Huesca/Zaragoza");
        return pueblos;
    }
}
