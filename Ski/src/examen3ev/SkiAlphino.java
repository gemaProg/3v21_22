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
public class SkiAlphino extends Pista {
    protected static final String []dificultades={"Verde","Azul","Roja"};
    protected String dificultad;

    public SkiAlphino(int id, String nombre, String provincia, double km, String dificultad) {
        super(id, nombre, provincia, km);
        this.dificultad = dificultad;
    }

    public SkiAlphino(){
        super();
        this.dificultad="Verde";
    }    
    
    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public static String[] getDificultades() {
        return dificultades;
    }

    
    @Override
    public String toString() {
        return super.toString()+ "dificultad=" + dificultad + '}';
    }
    
    @Override
    public String toStringFichero(){
        return super.toStringFichero()+"/"+dificultad;
    }
    
    public static void compruebaDificultad(String dificultad) throws ExcepcionDificultad{
        //if (!(dificultad.equalsIgnoreCase("Verde")||dificultad.equalsIgnoreCase("Azul")||dificultad.equalsIgnoreCase("Roja")))
        if(!dificultad.equalsIgnoreCase("Verde")&&!dificultad.equalsIgnoreCase("Azul")&&!dificultad.equalsIgnoreCase("Roja"))
            throw new ExcepcionDificultad();
    
    }
    
    
}
