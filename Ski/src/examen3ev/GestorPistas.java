/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3ev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prog
 */
public class GestorPistas {

    protected ArrayList<Pista> pistas;

    public GestorPistas() {
        pistas = new ArrayList();
        //int id, String nombre, String provincia, double km,ArrayList<String> pueblos) {

        pistas.add(new SkiFondo(100, "pista1", "Madrid", 100, new ArrayList()));
        ((SkiFondo) pistas.get(0)).pueblos.add("Navacerrada");
        ((SkiFondo) pistas.get(0)).pueblos.add("Rascafría");
        pistas.add(new SkiFondo(2, "pisasdfta1", "Madrid", 200, new ArrayList()));
        ((SkiFondo) pistas.get(1)).pueblos.add("Guadarrama");
        ((SkiFondo) pistas.get(1)).pueblos.add("Los Molinos");
        pistas.add(new SkiFondo(3, "pista1", "Granada", 300, new ArrayList()));
        ((SkiFondo) pistas.get(2)).pueblos.add("Pueblo1");
        ((SkiFondo) pistas.get(2)).pueblos.add("Los Molinos");
        pistas.add(new SkiFondo(4, "pista1", "Murcia", 10, new ArrayList()));
        ((SkiFondo) pistas.get(3)).pueblos.add("zzzzz");
        ((SkiFondo) pistas.get(3)).pueblos.add("Los Molinos");
        pistas.add(new SkiFondo(4, "pista1", "Madasdrid", 50, new ArrayList()));
        ((SkiFondo) pistas.get(4)).pueblos.add("ppp");
        pistas.add(new SkiAlpino(5, "pista5", "Madrid", 230, "Verde"));
        pistas.add(new SkiAlpino(6, "pista5", "Madrid", 240, "Roja"));
        pistas.add(new SkiAlpino(7, "pista6", "Madrid", 220, "Azul"));
        pistas.add(new SkiAlpino(8, "pista7", "Madrid", 230, "Azul"));
        pistas.add(new SkiAlpino(9, "pista5", "Madrid", 240, "Verde"));
    }

    public void listarPistas() {
        for (int i = 0; i < pistas.size(); i++) {
            System.out.println(pistas.get(i));

        }
    }

    public void añadirPista() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto;
        boolean añadido = false;
        int opcion;
        System.out.println("Introduzca id, nombre de la pista, provincia y km de la pista");
        int id = sc.nextInt();
        String nombre = br.readLine();
        String provincia = br.readLine();
        double km = sc.nextDouble();
        
        System.out.println("¿Que tipo de pista quiere añadir?"
                + "\n 1.SkiFondo"
                + "\n 2.SkiAlphino");
        opcion = sc.nextInt();

        if (opcion == 1) {
            System.out.println("Ha elegido Skifondo.");
            System.out.println("Ahora introduzca los pueblos por donde pasa la pista");
            String pueblo = br.readLine();
            ArrayList<String> pueblos = new ArrayList();
            pueblos.add(pueblo);
            pistas.add(new SkiFondo(id, nombre, provincia, km, pueblos));
            añadido = true;

        } else if (opcion == 2) {
            System.out.println("Ha elegido SkiAlphino");
            String dificultad;
            do {
                correcto = false;
                System.out.println("Ahora introduzca la dificultad de la pista: verde, azul o roja.");
                dificultad = br.readLine();
                try {
                    SkiAlpino.compruebaDificultad(dificultad);
                    correcto = true;
                    pistas.add(new SkiAlpino(id, nombre, provincia, km, dificultad));
                    añadido = true;
                } catch (ExcepcionDificultad e) {
                    System.out.println(e.getMessage());
                }
            } while (!correcto); 
            

        }
        if (añadido)
            System.out.println("Pista añadida correctamente");
    }

    public void consultarKm() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double kms = 0;
        System.out.println("Introduzca la provincia de la que quiere consultar los km");
        String provincia;
        provincia = br.readLine();
        for (int i = 0; i < pistas.size(); i++) {
            if (pistas.get(i).provincia.equalsIgnoreCase(provincia)) {
                kms += pistas.get(i).km;
            }
        }
        System.out.println("El numero total de kms de las pistas de " + provincia + " son" + kms);

    }

    public void añadirPueblo() {
        Scanner sc = new Scanner(System.in);
        boolean añadido = false;
        System.out.println("Introduce el nombre de la pista a la que le quiere añadir un pueblo.");
        String nombre = sc.nextLine();
        for (int i = 0; i < pistas.size() && !añadido; i++) {
            if (pistas.get(i).getClass().getSimpleName().equalsIgnoreCase("SkiFondo") && pistas.get(i).nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Introduce los pueblos que quiere añadir a la ruta separados por /");
                String pueblo = sc.nextLine();
                ((SkiFondo) pistas.get(i)).pueblos.add(pueblo);
                añadido = true;
                System.out.println("Pueblo/s añadido/s");
            }
        }
        if (!añadido) {
            System.out.println("No se ha encontrado la pista. No se puede añadir pueblo");
        }
    }

    
    public void eliminarPista() throws IOException{
        Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce la provincia de la que quiere eliminar la pista");
        String provincia=br.readLine();
        int opcion;
        for (int i = 0; i < pistas.size(); i++) {
            if(pistas.get(i).getClass().getSimpleName().equalsIgnoreCase("SkiAlphino")){
            if(pistas.get(i).provincia.equalsIgnoreCase(provincia)){
                System.out.println(pistas.get(i));
                System.out.println("1. Eliminar esta pista"
                        + "\n 2. Pasar a la siguiente pista");
                        
                opcion=sc.nextInt();
                if(opcion==1){
                    pistas.remove(pistas.get(i));
                    i--;
                }else{
                    System.out.println("La pista no será eliminada.");
                }
                
            
            
        }
     }
    }
    
    
}
    
    public void sinDuplicadas() {
        TreeSet<Pista> ts = new TreeSet(pistas);
        //System.out.println(ts);
        Iterator<Pista> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public void ordenarProvinciaKm(){ //ordenar copia
       //Collections.sort(pistas, new porProvinciaKm());
       ArrayList<Pista> copia = new ArrayList(pistas);
       Collections.sort(copia, new porProvinciaKm());
       for (int i = 0; i < copia.size(); i++) {
           System.out.println(copia.get(i));
        }
    
    }
    public ArrayList<SkiAlpino> getPistasAlpino (){
        ArrayList<SkiAlpino> copia = new ArrayList();
        for (int i = 0; i < pistas.size(); i++) {
            if (pistas.get(i) instanceof SkiAlpino)
                copia.add((SkiAlpino)pistas.get(i));
        }
        return copia;
    }
            
    public void ordenarDificultadKm(){ //ordenar copia
       //Collections.sort(pistas, new porProvinciaKm());
       ArrayList<SkiAlpino> copia = getPistasAlpino();
       Collections.sort(copia, new porDificultadKm());
       for (int i = 0; i < copia.size(); i++) {
           System.out.println(copia.get(i));
        }
    
    }
}
