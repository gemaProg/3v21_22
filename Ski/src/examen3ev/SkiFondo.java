/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3ev;

import java.util.ArrayList;





/**
 *
 * @author prog
 */
public class SkiFondo extends Pista {
   
    protected ArrayList<String> pueblos;

   
    public SkiFondo(int id, String nombre, String provincia, double km,ArrayList<String> pueblos) {
        super(id, nombre, provincia, km);
        this.pueblos=pueblos;
    }

    public SkiFondo() {
        super();
        pueblos=new ArrayList();
        pueblos.add("Huesca");
        pueblos.add("Zaragoza");
    }
    
    public SkiFondo(String id, String nombre, String provincia, String km, String pueblos){
        super(id,nombre,provincia,km);
        String trozos [] = pueblos.split(";");
        for (int i = 0; i < trozos.length; i++) {
           this.pueblos.add(trozos[i]);
        }
    
    }
    public SkiFondo(ArrayList<String> pueblos) {
        this.pueblos = pueblos;
    }

    public ArrayList<String> getPueblos() {
        return pueblos;
    }

    public void setPueblos(ArrayList<String> pueblos) {
        this.pueblos = pueblos;
    }

    @Override
    public String toString() {
        return super.toString()+ "pueblos=" + pueblos + '}';
    }
    
    public String formateaPueblos(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pueblos.size()-1; i++) {
            sb.append(pueblos.get(i)).append(";");
        }
        sb.append(pueblos.get(pueblos.size()-1));
        return sb.toString();
    }
    
    public String toStringFichero(){
        return super.toStringFichero()+"/"+formateaPueblos();
    }

    

    
    
    
    
    
}
