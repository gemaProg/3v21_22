/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcionpropiaejemplo;



/**
 *
 * @author gema
 */
public class ParException extends Exception { //excepci�n verificada->tiempo de compilaci�n obligue a su tratamiento
    
    public ParException (){
        super("El n�mero es par");
    }
    public ParException (int num){
        super("El n�mero "+num+" es par");
    }
    public ParException (String mensaje){
        super(mensaje);
    }
    
    
}
