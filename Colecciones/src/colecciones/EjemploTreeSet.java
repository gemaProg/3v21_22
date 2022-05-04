/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author GEMA
 */
public class EjemploTreeSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        TreeSet<String> lista = new TreeSet();
        lista.add("Madrid");
        lista.add("Málaga");
        lista.add("Madrid");
        lista.add("Albacete");
        lista.add("Sevilla");
        lista.add("Murcia");
        lista.add("Ciudad Real");
        lista.add("Vigo");
        System.out.println(lista.toString());
        Iterator<String> it = lista.iterator();
        //imprimir un elemento en concreto
        while (it.hasNext()){
            String provincia = it.next();
            if (provincia.equalsIgnoreCase("Murcia"))
                 System.out.println(provincia); //todo System.out.println(it.next());
        }
        System.out.println(lista.size());
        lista.add("Asturias");
        lista.add("Asturias");
        lista.add("Asturias");
        System.out.println("-------------");
        
        System.out.println(lista.toString());
    }
    
}
