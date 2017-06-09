package com.david.Model;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by David on 27/04/2017.
 */
public class Jugador implements Comparator<Jugador>,Serializable {

    //Declaración de variables

    private String nombre;
    private String equipo;
    private int edad;
    private String nacionalidad;

    //Constructores


    public Jugador() {
    }

    public Jugador(String nombre, String equipo, int edad, String nacionalidad) {
        this.setNombre(nombre);
        this.setEquipo(equipo);
        this.setEdad(edad);
        this.setNacionalidad(nacionalidad);
    }

    //Accesores


    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    /**
     * Crearemos un filtro si el dato introducido es menor a 0, ponga por defecto la edad del jugador a 18 años.
     * @param edad devuelve la edad del jugador
     */
    public void setEdad(int edad) {
        if (edad<0)
            this.edad=18;
        else {
            this.edad=edad;
        }
    }

    public void setNombre(String nombre) {
        if (nombre ==" ")
            this.nombre="ET";
        else {
            this.nombre = nombre;
        }
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        if (equipo ==" ")
            this.equipo="Sevilla";
        else {
            this.equipo = equipo;
        }
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad ==" ")
            this.nacionalidad="España";
        else {
            this.nacionalidad = nacionalidad;
        }
    }

    //Metodos

    /**
     * metodo toString para imprimir los datos de los jugadores
     * metodo que se hereda de object
     * @return
     */
    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }

    /**
     *
     * @param o1 parametro de object para compararlo con el segundo
     * @param o2 parametro heredado de object para compararlo con el primero
     * @return
     */
    @Override
    public int compare(Jugador o1, Jugador o2) {
        return o1.getEdad()-o2.getEdad();
    }
}
