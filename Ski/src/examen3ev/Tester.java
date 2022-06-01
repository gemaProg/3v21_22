/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3ev;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prog
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        GestorPistas pistas=new GestorPistas();
        GestionFicheros.crearFicheros();
        GestionFicheros.escribirFichero(pistas.pistas);
        //GestionFicheros.escribirFicheroBinario(pista.pistas);
        /*pista.pistas=GestionFicheros.leerFichero();
        pista.pistas=GestionFicheros.leerFicheroBinario();*/
        pistas.listarPistas();
        pistas.pistas=GestionFicheros.leerFichero(); //Este es el método para sustituir las pistas de la RAM por el contenido del fichero de texto
        /*try {
            pistas.consultarKm();
            pistas.añadirPueblo();
            pistas.añadirPista();
        
            System.out.println("..................");
            pistas.ordenarProvinciaKm();
            System.out.println("..................");
            pistas.ordenarDificultadKm();
            System.out.println("..................");
            
            pistas.sinDuplicadas();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       }
    }
    
    

