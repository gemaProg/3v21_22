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
public class ImparException extends Exception { //excepci�n verificada->tiempo de compilaci�n obligue a su tratamiento
    
    public ImparException (){
        super("El n�mero es impar");
    }
    public ImparException (int num){
        super("El n�mero "+num+" es impar");
    }
    public ImparException (String mensaje){
        super(mensaje);
    }
    
    
}
