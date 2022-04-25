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
public class ImparException extends Exception { //excepción verificada->tiempo de compilación obligue a su tratamiento
    
    public ImparException (){
        super("El número es impar");
    }
    public ImparException (int num){
        super("El número "+num+" es impar");
    }
    public ImparException (String mensaje){
        super(mensaje);
    }
    
    
}
