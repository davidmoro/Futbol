package com.david.Model;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by David on 27/04/2017.
 */
public class Equipo implements Comparable<Equipo>,Serializable {

    //Declaración de variables

    private String nombreEquipo;
    private String ciudadEquipo;

    //Constructores

    public Equipo() {
    }

    public Equipo(String nombreEquipo, String ciudadEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.ciudadEquipo = ciudadEquipo;
    }


    //Accesores

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getCiudadEquipo() {
        return ciudadEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void setCiudadEquipo(String ciudadEquipo) {
        this.ciudadEquipo = ciudadEquipo;
    }

    //METODOS

    /**
     * Mostraremos los datos de nuestros jugadores con el metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", ciudadEquipo='" + ciudadEquipo + '\'' +
                '}';
    }

    /**
     * implementamos el metodo compare
     * @param o
     * @return
     */
    @Override
    public int compareTo(Equipo o) {
        return this.getNombreEquipo().compareToIgnoreCase(o.getNombreEquipo());
    }

    /**
     * implementamos el metodo comparator estatico
     */
    public static Comparator<Equipo> CompararPorCiudad = new Comparator<Equipo>() {
        @Override
        public int compare(Equipo o1, Equipo o2) {
            if (o1.getCiudadEquipo().equalsIgnoreCase(o2.getCiudadEquipo())) {
                return 1;
            } else if (!o1.getCiudadEquipo().equalsIgnoreCase(o2.getCiudadEquipo())){
                return 0;
            }else {
                return -1;
            }
        }
    };
}
