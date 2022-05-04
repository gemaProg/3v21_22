/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author GEMA
 */
public class EjemploArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        ArrayList<String> lista = new ArrayList();
        lista.add("Madrid");
        lista.add("Málaga");
        lista.add("Madrid");
        lista.add("Albacete");
        lista.add("Sevilla");
        lista.add("Murcia");
        lista.add("Ciudad Real");
        lista.add("Vigo");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        System.out.println(lista.size());
        lista.add("Asturias");
        lista.add("Asturias");
        lista.add("Asturias");
        System.out.println("----------sin ordenar");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        System.out.println("-------------");
        Collections.sort(lista);
        System.out.println("----------ordenado");
        System.out.println(lista.toString());
        TreeSet <String> ts = new TreeSet(lista);
        System.out.println(ts.toString());
    }
    
}
