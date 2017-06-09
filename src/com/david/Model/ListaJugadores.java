package com.david.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by David on 24/05/2017.
 */
public class ListaJugadores implements Serializable {
    private static final long serialVersionUID = 2865230302879664105L;

    //Declaracion de variables

    private  ArrayList<Jugador> listaJugadores;

    //Constructores

    public ListaJugadores() {
        listaJugadores=new ArrayList<>(); //instanciamos el arraylist
    }


    //Metodos

    /**
     * Imprimimos la lista de jugadores de nuestra lista de array
     */
    public void mostrarJugadores(){

        //for (Jugador jugador:listaJugadores) {
        for (int i=0; i < listaJugadores.size();i++){
            System.out.println(i+" - "+listaJugadores.get(i));
        }
    }

    /**
     *
     * @param nombreEquipo le pasamos el nombre equipo para cuando buscamos un jugador, metemos el nombre del equipo para encontrar el equipo
     */
    public void mostrarJugadores(String nombreEquipo) {

            for (Jugador jugador : listaJugadores) {
        if (jugador.getEquipo().equalsIgnoreCase(nombreEquipo))
                System.out.println(jugador);

        }
    }

//    public void cargarJugadores(){
//
//        listaJugadores.add(new Jugador("Cristiano Ronaldo","Real madrid",35,"Portugal"));
//        listaJugadores.add(new Jugador("Vitolo","Sevilla",27,"España"));
//        listaJugadores.add(new Jugador("Ruben Castrao","Betis",60,"España"));
//        listaJugadores.add(new Jugador("Antoine Griezmann","Atletico de madrid",25,"Francia"));
//        listaJugadores.add(new Jugador("Araujo","Las palmas",25,"Argentina"));
//        listaJugadores.add(new Jugador("Manu Garcia","Alaves",35,"España"));
//        listaJugadores.add(new Jugador("Sandro","Malaga",21,"España"));
//        listaJugadores.add(new Jugador("Memo Ochoa","Granada",27,"Mexico"));
//        listaJugadores.add(new Jugador("Jose Antonio Reyes","Espanyol",33,"España"));
//        listaJugadores.add(new Jugador("Aduriz","Athletic",36,"España"));
//        listaJugadores.add(new Jugador("Fernando Navarro","Deportivo de la coruña",36,"España"));
//        listaJugadores.add(new Jugador("Bakambu","Villarreal",25,"El congo belga"));
//        listaJugadores.add(new Jugador("Iago Aspas","Celta de vigo",29,"España"));
//        listaJugadores.add(new Jugador("Ivan Cuellar","Sporting de gijon",49,"España"));
//        listaJugadores.add(new Jugador("Rodrigo","Valencia",24,"España"));
//        listaJugadores.add(new Jugador("Ander Capa","Eibar",28,"España"));
//        listaJugadores.add(new Jugador("Carlos Vela","Real sociedad",28,"Mexico"));
//        listaJugadores.add(new Jugador("Sergio Leon","Osasuna",24,"España"));
//        listaJugadores.add(new Jugador("Peter Languila","Leganes",4,"España"));
//        listaJugadores.add(new Jugador("Andres Iniesta","Barcelona",34,"España"));
//    }

    /**
     * 1.Realizamos un filtro para cuando se inserte un dato no numérico, generar la excepción
     * 2.También realizaremos que si el tamaño de la listaJugadores es mayor al indice a la hora de insertar el valor, ponga que no es correcto, obligando al usuario insertar el valor adecuado.
     * 3.Por último borraremos el jugador a elegir, si es correcto el valor del indice que le demos.
     * @param index indice del array de nuestro jugador
     */
    public void borrarJugadores(int index){
        if (index==-1){
            System.out.println("El índice no es correcto, debe ser numérico. ");
        }else {

            if (listaJugadores.size() > index) {
                listaJugadores.remove(index);
            } else {
                System.out.println("El indice no es correcto, maximo: " + listaJugadores.size());
            }
        }
    }

    /**
     *
     * @param jugador añadimos jugadores a nuestro arraylist de jugadores
     */
    public void añadirJugadores(Jugador jugador){

        listaJugadores.add(jugador);

    }

    /**
     * Preguntamos los datos de los atributos que tendran nuestros jugadores en los equipos
     * @return devuelve los atributos que tendran los jugadores
     */
    public Jugador preguntarInformacion() {
        boolean datoCorrecto = false;
        int opcion2 = -1;

        Scanner s = new Scanner(System.in);

        System.out.println("Nombre del jugador: ");
        String opcion = s.nextLine();
        System.out.println("Equipo del jugador: ");
        String opcion1 = s.nextLine();

        while (!datoCorrecto) {
            System.out.println("Edad del jugador: ");
            try {
                opcion2 =s.nextInt();
                datoCorrecto = true;

            } catch (InputMismatchException e) {
                datoCorrecto = false;
                System.out.println("Dato incorrecto");
                s.nextLine();
            }
        }
        System.out.println("Nacionalidad del jugador: ");
        String opcion3 = s.next();

        return new Jugador(opcion, opcion1, opcion2, opcion3);

    }

    /**
     * ordenamos los jugadores por la edad mediante un comparator
     */
    public void ordenarJugadorPorEdad(){
        Collections.sort(listaJugadores,new Jugador());
    }

}
