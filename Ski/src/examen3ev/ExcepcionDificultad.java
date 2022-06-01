/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3ev;

/**
 *
 * @author prog
 */
public class ExcepcionDificultad extends Exception {
    public ExcepcionDificultad(){
        super("La dificultad debe ser: verde, azul o roja");
    }
    public ExcepcionDificultad(String dificultad){
        super("La dificultad "+ dificultad + " no existe.");
    }
    
    
}
