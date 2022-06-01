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
        //GestionFicheros.escribirFichero(pista.pistas);
        //GestionFicheros.escribirFicheroBinario(pista.pistas);
        /*pista.pistas=GestionFicheros.leerFichero();
        pista.pistas=GestionFicheros.leerFicheroBinario();*/
        pistas.listarPistas();
        try {
            pistas.consultarKm();
            //pistas.añadirPueblo();
            pistas.sinDuplicadas();
            /*
            int opcion;
            System.out.println("Bienvenido a nuestra empresa de pistas de ski.");
            
            
            do{
            System.out.println("Elija la opciÃ³n que desea realizar."
            + "\n 1. Añadir una pista."
            + "\n 2. Consultar km de extensiÃ³n de pistas que tiene una provincia."
            + "\n 3. Añadir pueblo a la ruta de una pista de SkiFondo."
            + "\n 4. Eliminar una pista de SkiAlphino."
            + "\n 5. Listar pistas sin duplicar."
            + "\n 6. Listar pistas."
            + "\n 7. Salir del menÃº.");
            opcion=sc.nextInt();
            
            switch(opcion){
            case 1:
            pista.añadirPista();
            break;
            case 2:
            pista.consultarKm();
            break;
            case 3:
            pista.añadirPueblo();
            break;
            case 4:
            pista.eliminarPista();
            break;
            case 5:
            pista.sinDuplicadas();
            break;
            case 6:
            pista.listarPistas();
            break;
            }
            }while(opcion<7);*/
        } catch (IOException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    

