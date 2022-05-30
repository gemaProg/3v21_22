/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresapasopaso;

import java.io.File;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author GEMA
 */
public class EmpresaArrayList {

    protected ArrayList<Trabajador> trabajadores;

    public EmpresaArrayList() {
        File f = new File(GestorFicherosArraylist.FICHERO_TRABAJADORES);
        if (f.exists()) {
            trabajadores = GestorFicherosArraylist.leerFicheroEscaner(GestorFicherosArraylist.FICHERO_TRABAJADORES);
        } else {
            trabajadores = new ArrayList();
            for (int i = 0; i < 12; i++) {
                if (i < 6) {
                    trabajadores.add(new Programador());
                } else {
                    trabajadores.add(new JefeProyecto());
                }
            }

        }

    }

    public EmpresaArrayList(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void listarTrabajadores() {
        /*for (int i = 0; i < trabajadores.size(); i++) {
            System.out.println(trabajadores.get(i));
        }
         */
        //opcion2 foreach
        /*for (Trabajador trabajador: trabajadores) {
            System.out.println(trabajador);
        }*/
        //opcion3 notación funcional
        //trabajadores.forEach(trabajador -> print(trabajador));
        //opcion4 notación funcional
        trabajadores.forEach(System.out::println);

    }

    public static void print(Trabajador trabajador) {
        System.out.println(trabajador);
        // System.out.println(Arrays.toString(trabajadores));
    }

    public static Trabajador crearTrabajador() {
        Trabajador trabajador = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Â¿PROGRAMADOR O JEFE DE PROYECTO?");
        String op = sc.nextLine().toUpperCase();
        if (op.equals("PROGRAMADOR") || op.equals("JEFE DE PROYECTO")) {
            System.out.print("NOMBRE: ");
            String nombre = sc.nextLine().toUpperCase();
            System.out.print("NIF: ");
            String nif = sc.nextLine().toUpperCase();
            System.out.print("DEPARTAMENTO: ");
            String departamento = sc.nextLine().toUpperCase();
            System.out.println("Introduzca fecha(dia mes aÃ±o)");
            int dia = sc.nextInt();
            int mes = sc.nextInt();
            int anyo = sc.nextInt();
            System.out.println("Introduzca sueldo");
            double sueldo = sc.nextDouble();
            sc.nextLine();
            if (op.equals("PROGRAMADOR")) {
                String choose;
                boolean poo;
                do {
                    System.out.print("Â¿Tiene concomientos de POO?: ");
                    choose = sc.nextLine().toUpperCase();
                    if (!choose.equals("SI") && !choose.equals("NO")) {
                        System.out.println("ERROR | VUELVE A INTRODUCIR");
                    }
                    poo = (choose.equals("SI"));
                } while (!choose.equals("SI") && !choose.equals("NO"));
                StringBuilder lenguajes = new StringBuilder();
                System.out.println("Lenguajes de ProgramaciÃ³n [** para terminar] ");
                String lenguaje;
                do {
                    lenguaje = sc.nextLine();
                    if (!lenguaje.equals("**")) {
                        lenguajes = lenguajes.append(":").append(lenguaje);
                    }
                } while (!lenguaje.equals("**"));

                trabajador = new Programador(poo, nif, lenguajes, nombre, departamento, new Fecha(dia, mes, anyo), sueldo);
            } else {
                System.out.print("Â¿Cuantas personas dirige?: ");
                int numP = sc.nextInt();
                trabajador = new JefeProyecto(numP, nif, nombre, departamento, new Fecha(dia, mes, anyo), sueldo);

            }
        } else {
            System.out.println("ERROR | VUELVE A INTRODUCIR");
        }
        return trabajador;
    }

    public void insertarEmpresa(Trabajador trabajador) {
        boolean introducido = trabajadores.add(trabajador);
        if (introducido) {
            System.out.println("El trabajador ha sido contratado por la empresa");
        } else {
            System.out.println("Esta vez no ha podido ser.");
        }

    }

    public void consultaPorDepartamento(String dpto) {
        /*for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).departamento.equalsIgnoreCase(dpto)) {
                System.out.println(trabajadores.get(i));
            }
        }*/
        //opcion2 foreach
        /* for (Trabajador trabajador: trabajadores) {
            if (trabajador.departamento.equalsIgnoreCase(dpto))
                  System.out.println(trabajador);
        }*/
        //opción3 funcional1 
        /*trabajadores.stream()
                .filter(trabajador -> (trabajador.departamento.equalsIgnoreCase(dpto)))
                .forEachOrdered(trabajador -> { System.out.println(trabajador);});  */
        //opcion3 notación funcional2
        trabajadores.stream()
                .filter(trabajador -> trabajador.departamento.equalsIgnoreCase(dpto))
                .forEach(System.out::println);

    }

    //4 Actualizar salario de un trabajador a partir de su NIF que serÃ¡ introducido como argumento de entrada al mÃ©todo. (0,75p)
    public void actualizarSalario(String NIF) {
        Scanner lector = new Scanner(System.in);

        /* for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).NIF.equalsIgnoreCase(NIF)) {
                System.out.println(trabajadores.get(i));
                System.out.println("Introduce el salario nuevo");
                //trabajadores.get(i).setSueldoBase(lector.nextDouble());
                trabajadores.get(i).sueldoBase = lector.nextDouble();
            }
        }*/
        //opcion2 foreach
        /*for (Trabajador trabajador : trabajadores) {
            if (trabajador.NIF.equalsIgnoreCase(NIF)) {
                System.out.println(trabajador);
                System.out.println("Introduce el salario nuevo");
                //trabajadores.get(i).setSueldoBase(lector.nextDouble());
                trabajador.sueldoBase = lector.nextDouble();
            }
        }
        //opcion3 lambda
        trabajadores.forEach(trabajador -> {
            if (trabajador.NIF.equalsIgnoreCase(NIF)) {
                System.out.println(trabajador);
                System.out.println("Introduce el salario nuevo");
                trabajador.sueldoBase = lector.nextDouble();
            }

        });*/
        //opcion4 streams
        trabajadores.stream()
                .filter(trabajador -> trabajador.NIF.equalsIgnoreCase(NIF))
               .forEach(trabajador->{
                System.out.println("Introduce el salario nuevo");
                trabajador.sueldoBase = lector.nextDouble();
            });

    }

    public boolean actualizarPersonas(String nombre, int personas) {
        boolean flag=false;
        /*for (int i = 0; i < trabajadores.size() && !todoOk; i++) {
            if (trabajadores.get(i) instanceof JefeProyecto && trabajadores.get(i).nombre.equalsIgnoreCase(nombre)) {
                ((JefeProyecto) trabajadores.get(i)).personas = personas;
                todoOk = true;
            }
            
        }*/
        //opcion2 foreach
        for (Trabajador trabajador : trabajadores) {
            if (trabajador instanceof JefeProyecto && trabajador.nombre.equalsIgnoreCase(nombre)) {
               ((JefeProyecto)trabajador).personas = personas; 
               flag = true;
            }
        }
        return flag; //sin sentido utilizando expresiones lambda opción 3 y opción 4, en esos casos no devolveríamos nada o true.
        /*
        //opcion3 lambda
        trabajadores.forEach(trabajador -> {
            if (trabajador instanceof JefeProyecto && trabajador.nombre.equalsIgnoreCase(nombre)) {
               ((JefeProyecto)trabajador).personas = personas; 
            }

        });
        //opcion4 streams
       
       trabajadores.stream()
                .filter(trabajador -> trabajador instanceof JefeProyecto)
                .filter(trabajador -> trabajador.nombre.equalsIgnoreCase(nombre))
                .forEach(trabajador -> { 
                    ((JefeProyecto)trabajador).personas = personas;  
                });
*/
        
        
    }

    public void eliminar() {
        Scanner lector = new Scanner(System.in);
        String nombre, departamento;
        System.out.println("Introduzca el nombre del trabajador y el departamento");
        nombre = lector.nextLine();
        departamento = lector.nextLine();
        /*for (int i = 0; i < trabajadores.size() && !eliminado; i++) {
            if (trabajadores.get(i).nombre.equalsIgnoreCase(nombre) && trabajadores.get(i).departamento.equalsIgnoreCase(departamento)) {
                trabajadores.remove(i);
                eliminado = true;
            }
        }
        if (eliminado) {
            System.out.println("El trabajador ha sido eliminado correctamente");
        }
        */ 
        //opcion2 foreach no se puede porque salta la excepción ConcurrentModificationException, solución utilizar iterator
        
        /*
        //opcion3 lambda
        trabajadores.forEach(trabajador -> {
            if (trabajador instanceof JefeProyecto && trabajador.nombre.equalsIgnoreCase(nombre)) {
               ((JefeProyecto)trabajador).personas = personas; 
            }

        });
        //opcion4 streams
       
       trabajadores.stream()
                .filter(trabajador -> trabajador instanceof JefeProyecto)
                .filter(trabajador -> trabajador.nombre.equalsIgnoreCase(nombre))
                .forEach(trabajador -> { 
                    ((JefeProyecto)trabajador).personas = personas;  
                });
*/
    }
    public void filter(String nombre, String dpto) {
    for (Iterator<Trabajador> it = trabajadores.iterator(); it.hasNext(); )
        if (cond(it.next(),nombre,dpto))
            it.remove();
    }
    public boolean cond(Trabajador t, String nombre, String dpto){
        boolean aux = false;
        if (t.nombre.equalsIgnoreCase(nombre)&& t.departamento.equalsIgnoreCase(dpto))
            aux = true;
        return aux;
    
    }
    public void calcularSalario(String dpto) {
        double salarioDpto = 0;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).departamento.equals(dpto)) {
                System.out.printf("%s gana %.2f \n", trabajadores.get(i).nombre, trabajadores.get(i).calcularSalario());
                // salarioDpto+=trabajadores.get(i).calcularSalario();
                salarioDpto = salarioDpto + trabajadores.get(i).calcularSalario();
            }
        }
        System.out.printf("El salario total del dpto es %.2f â‚¬", salarioDpto);
    }

    public void ordenarOriginal() {
        Trabajador aux = null;
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;
            for (int i = 0; i < trabajadores.size() - 1; i++) {
                if (trabajadores.get(i).sueldoBase < trabajadores.get(i + 1).sueldoBase) {
                    aux = trabajadores.get(i);
                    trabajadores.set(i, trabajadores.get(i + 1));
                    trabajadores.set(i + 1, aux);
                    intercambio = true;
                }
            }

        }

    }

    public void ordenarCopia() {

        ArrayList<Trabajador> copia = new ArrayList(trabajadores);

        /*System.out.println("Orden natural");

        Collections.sort(copia);

        for (int i = 0; i < copia.size(); i++) {
            System.out.println(copia.get(i));

        }

        /*TreeSet<Trabajador> copiaT = new TreeSet(trabajadores);
        Iterator<Trabajador> it = trabajadores.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        
         */
        System.out.println("--------------doble criterio");
        System.out.println("Por Departamentopor Sueldo");
        Collections.sort(copia, new porDepartamentoporSueldo());
        //Collections.sort(copia, new porGente());

        for (int i = 0; i < copia.size(); i++) {
            System.out.println(copia.get(i));
        }
        System.out.println("--------------ordenando  jefes");

        System.out.println("Ordenando los jefes de proyecto");
        ArrayList<JefeProyecto> jps = new ArrayList();
        System.out.println(trabajadores.size());
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i) instanceof JefeProyecto) {
                jps.add((JefeProyecto) trabajadores.get(i));
            }
        }
        Collections.sort(jps, new porGente());
        //Collections.reverse(jps);
        for (int i = jps.size() - 1; i >= 0; i--) {
            System.out.println(jps.get(i));
        }

    }

    @Override
    public String toString() {
        return "Empresa{" + "trabajadores=" + trabajadores + '}';
    }

}
