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
public class Comprobaciones {
    public static void isPar(int a) throws ParException, ImparException {
        if (a%2==0)
            throw new ParException(a);
        else
            throw new ImparException();
    }
}
