/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3ev;

import java.io.Serializable;

/**
 *
 * @author prog
 */
public class Pista implements Serializable, Comparable<Pista>{
    protected int id;
    protected String nombre;
    protected String provincia;
    protected double km;

    public Pista(int id, String nombre, String provincia, double km) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.km = km;
    }
    public Pista(String id, String nombre, String provincia, String km) {
        this(Integer.parseInt(id), nombre,provincia,Double.parseDouble(km));
        /*this.id = Integer.parseInt(id);
        this.nombre = nombre;
        this.provincia = provincia;
        this.km = Double.parseDouble(km);*/
    }

    public Pista(){
        this.id = 0;
        this.nombre = "Pista";
        this.provincia = "Andorra";
        this.km = 200;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ "id=" + id + ", nombre=" + nombre + ", provincia=" + provincia + ", km=" + km + '}';
    }
    public String toStringFichero(){//PON EL SEPARADOR QUE QUIERAS, OJO EVITAR . Y , (DECIMALES)
        return getClass().getSimpleName()+"/"+id+"/"+nombre+"/"+provincia+"/"+km;
    }

    @Override
    public int compareTo(Pista arg0) {
        return this.id-arg0.id;
        //return Integer.compare(this.id,arg0.id);
        
    }
    
    
    
}
