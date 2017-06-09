package com.david.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by David on 24/05/2017.
 */
public class ListaEquipo implements Serializable {
    private static final long serialVersionUID = -6095978850473269070L;

    //Declaracion de variables

    private ArrayList<Equipo> listaEquipos;


    //Constructores


    public ListaEquipo() {
        listaEquipos=new ArrayList<>(); //instanciamos el arraylist
    }

    //Metodos

    /**
     * Recorreos nuestro arraylist con un foreach
     */
    public void mostrarEquipos(String nombreEquipo) {

        for (Equipo equipo : listaEquipos) {

            if (equipo.getNombreEquipo() == nombreEquipo) {

                System.out.println(equipo);
            }
        }
    }

    /**
     * metemos delante de los equipos los números del indice que ocupan en el mismo
     */
    public  void mostrarEquipos(){

        for (int i=0; i < listaEquipos.size();i++){
            System.out.println(i+" - "+listaEquipos.get(i));
        }
    }

    /**
     * Metemos los nombres de los equipos con sus atributos
     */
//    public void cargarEquipos(){
//
//        listaEquipos.add(new Equipo("Betis" ,"Sevilla"));
//        listaEquipos.add(new Equipo("Sevilla" ,"Sevilla"));
//        listaEquipos.add(new Equipo("Real madrid" ,"Madrid"));
//        listaEquipos.add(new Equipo("Atletico de madrid" ,"Madrid"));
//        listaEquipos.add(new Equipo("Leganes" ,"Madrid"));
//        listaEquipos.add(new Equipo("Barcelona" ,"Barcelona"));
//        listaEquipos.add(new Equipo("Espanyol" ,"Barcelona"));
//        listaEquipos.add(new Equipo("Malaga" ,"Malaga"));
//        listaEquipos.add(new Equipo("Osasuna" ,"Navarra"));
//        listaEquipos.add(new Equipo("Granada" ,"Granada"));
//        listaEquipos.add(new Equipo("Alaves" ,"Alava"));
//        listaEquipos.add(new Equipo("Athletic" ,"Bilbao"));
//        listaEquipos.add(new Equipo("Sporting de gijon" ,"Gijon"));
//        listaEquipos.add(new Equipo("Deportivo de la coruña" ,"La coruña"));
//        listaEquipos.add(new Equipo("Celta de vigo" ,"Vigo"));
//        listaEquipos.add(new Equipo("Las palmas" ,"Gran Canarias"));
//        listaEquipos.add(new Equipo("Eibar" ,"Alava"));
//        listaEquipos.add(new Equipo("Real sociedad" ,"San Sebastian"));
//        listaEquipos.add(new Equipo("Villarreal" ,"Castellon"));
//        listaEquipos.add(new Equipo("Valencia" ,"Valencia"));
//    }

    /**
     * 1.Realizamos un filtro para cuando se inserte un dato no numérico, generar la excepción
     * 2.También realizaremos que si el tamaño de la listaEquipos es mayor al indice a la hora de insertar el valor, ponga que no es correcto, obligando al usuario insertar el valor adecuado.
     * 3.Por último borraremos el equipo a elegir, si es correcto el valor del indice que le demos.
     * @param index indice del array de nuestro equipo
     */
    public void borrarEquipos(int index){
            if (index==-1){
                    System.out.println("El índice no es correcto, debe ser numérico. ");
                }else {

                    if (listaEquipos.size() > index) {
                    listaEquipos.remove(index);
                } else {
                    System.out.println("El indice no es correcto, maximo: " + listaEquipos.size());
                }
            }
    }

    /**
     * Ordenamos los equipos por nombre desde la A -Z
     *Utilizamos para ello un método compare
     */
    public void ordenarEquipoPorNombre(){
        Collections.sort(listaEquipos);
    }

    /**
     * Ordenamos los equipos por las ciudades de la A-Z
     * Utilizamos para ello el comparator estatico
     */
    public void ordenarEquipoPorCiudad(){
        Collections.sort(listaEquipos, Equipo.CompararPorCiudad);
    }
}
