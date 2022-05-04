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
public class EjemploTreeSet1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        /*TreeSet<Integer> lista = new TreeSet();
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(4);
        lista.add(1);
        lista.add(0);
        lista.add(2);
        lista.add(2);
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        
        System.out.println("size"+lista.size());*/
        ArrayList<Integer> lista = new ArrayList();
        lista.add(2);
        lista.add(3);
        lista.add(2);
        lista.add(4);
        lista.add(1);
        lista.add(0);
        lista.add(2);
        lista.add(2);
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        
        System.out.println("size"+lista.size());
        
    }
}
