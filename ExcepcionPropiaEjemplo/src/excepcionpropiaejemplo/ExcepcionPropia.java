/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcionpropiaejemplo;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gema
 */
public class ExcepcionPropia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce número");
        
        try{
            int num = lector.nextInt();
            Comprobaciones.isPar(num);
        }catch(InputMismatchException e){
            System.out.println("Introduce números");
            //e.printStackTrace();
        }catch (ParException ex) {
            System.out.println(ex.getMessage());
        }catch (ImparException ex) {
            System.out.println(ex.getMessage());
           // ex.printStackTrace();
        }
    }

}
