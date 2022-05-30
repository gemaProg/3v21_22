/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresapasopaso;

import java.util.Comparator;

/**
 *
 * @author gema
 */
public class CriteriosComparacion {
    
}
class porDepartamento implements Comparator<Trabajador>{

    @Override
    public int compare(Trabajador arg0, Trabajador arg1) {
        return arg0.departamento.compareTo(arg1.departamento);
    }

   
}

class porDepartamentoporSueldo implements Comparator<Trabajador>{

    @Override
    public int compare(Trabajador arg0, Trabajador arg1) {
        int aux = arg0.departamento.compareTo(arg1.departamento);
        if (aux == 0) //departamentos iguales
            //aux = Double.compare(arg0.sueldoBase, arg1.sueldoBase);
            aux = (int)(arg1.sueldoBase-arg0.sueldoBase);
        return aux;
    }

   
}
class porSueldo implements Comparator<Trabajador>{

    @Override
    public int compare(Trabajador arg0, Trabajador arg1) {
       //return Double.compare(arg0.sueldoBase, arg1.sueldoBase);
       return (int)(arg0.sueldoBase-arg1.sueldoBase);
    }


}
class porGente implements Comparator<JefeProyecto>{

    @Override
    public int compare(JefeProyecto arg0, JefeProyecto arg1) {
    return arg0.personas-arg1.personas;
    }

   

    
}

  