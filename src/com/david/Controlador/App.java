package com.david.Controlador;

import com.david.Model.Equipo;
import com.david.Model.Jugador;
import com.david.Model.ListaEquipo;
import com.david.Model.ListaJugadores;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David on 24/05/2017.
 */
public class App {

    //Declaracion de variables

    private ListaEquipo listaEquipo; //llamamos a la clase ListaEquipo

    private ListaJugadores listaJugadores;


    //Constructores

    public App() {                  //creamos el construcotor vacio
        this.listaEquipo = new ListaEquipo();
        this.listaJugadores=new ListaJugadores();

    }

    //Metodos

    /**
     * Switch que inicializa nuestro menú
     */
    public void start() {
        int option;
        leerArchivo(); //accede al método leerArchivo


     //listaEquipo.cargarEquipos();
        //listaJugadores.cargarJugadores();

        while ((option = verMenu()) != 0) {

            switch (option) {
                case 1:
                    listaEquipo.mostrarEquipos();
                    break;
                case 2:
                    listaEquipo.mostrarEquipos();
                    listaJugadores.mostrarJugadores(preguntarEquipo());
                    break;
                case 3:
                    listaEquipo.mostrarEquipos();
                    listaEquipo.borrarEquipos(preguntarIndiceEquipo());
                    break;
                case 4:
                    listaJugadores.mostrarJugadores();
                    listaJugadores.borrarJugadores(preguntarIndiceJugador());
                    break;
                case 5:
                    listaJugadores.añadirJugadores(listaJugadores.preguntarInformacion());
                    break;
                case 6:
                    listaJugadores.ordenarJugadorPorEdad();
                    listaJugadores.mostrarJugadores();
                    break;
                case 7:
                    listaEquipo.ordenarEquipoPorNombre();
                    listaEquipo.mostrarEquipos();
                    break;
                case 8:
                    listaEquipo.ordenarEquipoPorCiudad();
                    listaEquipo.mostrarEquipos();
                    break;
                case 9:
                    guardarArchivo();

            }
        }
    }

    /**
     * Menu principal donde visualizaremos el menú de opciones
     * @return option
     * Creamos una excepcion para cuando se inserta en el menu un dato que no sea entero vuelva a pedir la opción
     */
    private int verMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;


        System.out.println("##########LIGA DE FÚTBOL PROFESIONAL LFP##############");
        System.out.println("******************************************************");
        System.out.println("* 1 - Mostrar equipos                                *");
        System.out.println("* 2 - Buscar jugadores                               *");
        System.out.println("* 3 - Borrar equipo                                  *");
        System.out.println("* 4 - Borrar jugador                                 *");
        System.out.println("* 5 - Añadir jugador                                 *");
        System.out.println("* 6 - Mostrar jugadores por edad                     *");
        System.out.println("* 7 - Mostrar equipos ordenados alfabeticamente      *");
        System.out.println("* 8 - Mostrar equipos ordenados por ciudad           *");
        System.out.println("* 9 - Guardar archivo                                *");
        System.out.println("* 0 - Salir                                          *");
        System.out.println("******************************************************");

        try {

            System.out.println("Opción: ");
            option = scanner.nextInt();

        }catch (InputMismatchException e) {
            System.out.println("No se reconoce la opción, vuelve a introducir la opción: ");
        }
        return option;
    }

    /**
     * Preguntamos el equipo para mostrar los equipos
     * @return equipo
     */

    public String preguntarEquipo(){
        Scanner s =  new Scanner(System.in);
        String equipo;

        do {
    System.out.println("Elige el equipo: ");
            equipo = s.nextLine();
        }while (equipo.equals(""));

        return equipo;
    }

    /**
     * Metodo que borra del array el indice donde se encuentre el equipo deseado
     * @return indice del array del equipo
     */
    public int preguntarIndiceEquipo(){

        Scanner s = new Scanner(System.in);
        System.out.println("¿Qué equipo quieres borrar?.Introduce su indice. ");
        String index=s.nextLine();
        Integer vuelta;
        try{
            vuelta = Integer.parseInt(index);
        }catch (NumberFormatException e){
            vuelta = -1;
        }
        return vuelta;
    }

    /**
     * Introducimos el indice donde se encuentra nuestro jugador, para asi poder encontrarlo y siguiente borrarlo.
     * @return
     * Le creamos una excepcion para cuando metemos un dato no numérico, no salte la excepción.
     */
    public int preguntarIndiceJugador(){
        Scanner s = new Scanner(System.in);
        System.out.println("¿Qué jugador quieres borrar?.Introduce su indice. ");
        String index=s.nextLine();

        Integer vuelta;
        try{
            vuelta = Integer.parseInt(index);
        }catch (NumberFormatException e){
            vuelta = -1;
        }
        return vuelta;
    }


    /**
     * Leemos el archivo liga.dat,leyendolo posteriormente de guardar.
     */
    public void leerArchivo(){

            try {
                ObjectInputStream flujoLectura = new ObjectInputStream(new FileInputStream("Liga.dat"));
                listaEquipo = (ListaEquipo) flujoLectura.readObject();
                listaJugadores = (ListaJugadores) flujoLectura.readObject();
                flujoLectura.close();
             //for (Equipo equipo: listaEquipo){

             //}
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    /**
     * guardarmos en  liga.dat los datos almacenados en nuestra aplicación
     */
    public void guardarArchivo(){
            try {
                ObjectOutputStream flujoSalida= new ObjectOutputStream(new FileOutputStream("Liga.dat"));
                flujoSalida.writeObject(listaEquipo);
                flujoSalida.writeObject(listaJugadores);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


