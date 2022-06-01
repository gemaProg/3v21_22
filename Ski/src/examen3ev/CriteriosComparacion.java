/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3ev;

import java.util.Comparator;

/**
 *
 * @author gema
 */
public class CriteriosComparacion {
    
}
class porProvinciaKm implements Comparator<Pista>{

    @Override
    public int compare(Pista arg0, Pista arg1) {
      int aux = arg0.provincia.compareTo(arg1.provincia);
      if (aux == 0)
          aux = Double.compare(arg0.km,arg1.km);
      return aux;
    }
}


class porDificultadKm implements Comparator<SkiAlpino>{

    @Override
    public int compare(SkiAlpino arg0,SkiAlpino arg1) {
        int aux = arg0.dificultad.compareTo(arg1.dificultad);
        if (aux == 0) //departamentos iguales
            //aux = Double.compare(arg0.km, arg1.km);
            aux = (int)(arg0.km-arg1.km);
        return aux;
    }

   
}


  