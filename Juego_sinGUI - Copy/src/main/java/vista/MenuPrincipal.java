/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import java.util.logging.Logger;
import controlador.Dado;
import modelo.GuardarPartida;
import modelo.LecturaCarpetaSaves;
import modelo.LecturaDeCapitulos;
import modelo.PersonajePrincipal;
import controlador.InventarioUsuario;

/**
 * Este es un controlador, que posteriormente comunicara informacion a la vista
 * final
 *
 * @author Juan David Salas Camargo
 */
public class MenuPrincipal {

    private final Scanner sc = new Scanner(System.in);
    private final LecturaCarpetaSaves usuarios_guardados = new LecturaCarpetaSaves();
    private final GuardarPartida carga_Datos_Usuario = new GuardarPartida();
    private final PersonajePrincipal datos_usuario = new PersonajePrincipal();
    private final LecturaDeCapitulos historia_general = new LecturaDeCapitulos();

    private final int tamaño_historia = 321;

    private void nuevoJuego() {
        System.out.println("Estas seguro? Si le das aceptar perderas tu progreso, pero no tus atributos");
        empezarDeCero();

    }

    private boolean empezarDeCero() {
        boolean f = true;
        System.out.println("1. empezar de cero 2.cancelar");
        if (sc.nextInt() == 1) {

            recorrer_historia(0);
        }
        return f;
    }

    /**
     * este metodo repite mucho codigo del metodo nuevoJuego por lo tanto podria
     * quitarse ademas estoy pensando en pasar todos estos metodos a una nueva
     * clase para respetar el principio de Clase-Responsabilidad-Colaboracion
     * dado que esta clase al parecer va a tener mas de 3 responsabilidades. En
     * la actulizacion del 22/07/21 se unio la historia de 8 capitulos se paso a
     * uno general.
     *
     * @version 22/07/21
     * @author Juan David Salas Camargo
     */
    public void retomarJuego() {
        recorrer_historia();

    }

    /**
     * Este menuDelInventario se usa para cargar el juego por primera vez, es la
     * diferencia con el otro metodo de Menu_Principal, este es un ejemplo de
     * polimorfismo parametrico
     *
     * @param a = sirve para usar polimorfismo parametrico
     */
    public void principalMenu(int a) {

        displayMenu();
    }

    public void principalMenu() {
        inicializeGame(usuarios_guardados.usuarios());

        displayMenu();

    }

    private void displayMenu() {
        int opcion;
        boolean salir = false;
        InventarioUsuario intentario_personaje = new InventarioUsuario(datos_usuario);

        while (!salir) {
            System.out.println(" Hola  " + datos_usuario.getName());
            System.out.println("tu progreso en la historia es de " + (datos_usuario.getProgress() * 100 / tamaño_historia) + " %");
            System.out.println("1. Nueva partida");
            System.out.println("2. Cargar partida");
            System.out.println("3. Ver Espadas-Consumir Pociones");
            System.out.println("4.salir");
//            try {
            System.out.println("Escribe una de las opciones");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    nuevoJuego();
                case 2:
                    retomarJuego();
                    break;
                case 3:
                    intentario_personaje.menuDelInventario();
                    guardar_cambios(datos_usuario);

                    break;
                case 4:
                    System.out.println("Vuelve pronto :3");
                    System.exit(0);
                    break;
                default:
                    System.out.println("solo numeros entre 1 y 4 c:");
            }
        }
    }

    private void guardar_cambios(PersonajePrincipal datos_usuario) {
        carga_Datos_Usuario.guardarPartida(datos_usuario.getName());

    }

    private void establecer_progreso(int i, String nombre_personaje) {
        datos_usuario.setProgress(i);

        carga_Datos_Usuario.guardarPartida(nombre_personaje);

    }

    private void establecer_vida(int i, String nombre_personaje) {
        datos_usuario.setLife(i);

        carga_Datos_Usuario.guardarPartida(nombre_personaje);

    }
    /**
     * polimorfismo parametrico
     */
    private void recorrer_historia() {
        inicializeGame(datos_usuario.getName());

        historia_general.lectorCapitulos();

        for (int a = datos_usuario.getProgress(); a < historia_general.Story.size(); a++) {

            System.out.println((a * 100 / tamaño_historia) + "% de la Historia");
            System.out.println(historia_general.Story.get(a));
            lanzarDadoyActualizarDatos(datos_usuario.getName());
            if (finDelaHistoria(a)) {
                System.out.println(creditos());
                System.out.println("dado que ya terminaste la historia el programa se cerrara automaticamente\n presiona enter para continuar :3 ");
                sc.nextLine();
                System.exit(0);
            }
            System.out.println("deseas continuar? 1. si 2. salir");
            if (sc.nextInt() == 2) {
                System.out.println("desea guardar el progreso del juego 1.Si 2.No");
                if (sc.nextInt() == 1) {
                    establecer_progreso(a, datos_usuario.getName());
                    principalMenu(1);
                } else {
                    principalMenu(1);
                }
            }
        }
    }

    /**
     * Esta version de recorrer historia te permite determinar en que posicion
     * de la historia quieres empezar el recorrido se usa para cuando el usuario
     * empieza de 0
     *
     * @param el progreso que se va a ingresar en el usuario
     */
    private void recorrer_historia(int b) {

        inicializeGame(datos_usuario.getName());
        historia_general.lectorCapitulos();

        for (int a = b; a < historia_general.Story.size(); a++) {
            System.out.println((a * 100 / tamaño_historia) + "% de la Historia");
            lanzarDadoyActualizarDatos(datos_usuario.getName());
            System.out.println(historia_general.Story.get(a));

            if (finDelaHistoria(a)) {
                System.out.println(creditos());
            }
            System.out.println("deseas continuar? 1. si 2. salir");
            if (sc.nextInt() == 2) {
                System.out.println("desea guardar el progreso del juego 1.Si 2.No");
                if (sc.nextInt() == 1) {
                    establecer_progreso(a, datos_usuario.getName());
                    principalMenu(1);
                } else {
                    principalMenu(1);
                }
            }

        }
    }

    /**
     * En este metodo Utilice polimorfismo parametrico para poder en primer
     * lugar abrir el juego en los metodos comunes, mientras que en el segundo
     * metodo lo hago para poder crear el archivo de guardado
     */
    private void inicializeGame(String nombre_personaje) {
        historia_general.lectorCapitulos();
        carga_Datos_Usuario.setFileName("saves/" + nombre_personaje + "/lore.txt");
        datos_usuario.setName(nombre_personaje);
        carga_Datos_Usuario.setnuevoJuego(datos_usuario);

        carga_Datos_Usuario.cargarPartida(datos_usuario.getName());
    }

    private boolean finDelaHistoria(int a) {
        boolean fin = false;
        if (a >= 320) {
            fin = true;
        }

        return fin;
    }
    private void lanzarDadoyActualizarDatos(String nombre_personaje) {
        Dado dado = new Dado(datos_usuario);
//        
        dado.opcionesDato(); // se lanza el dado        

        establecer_vida(datos_usuario.getLife(), nombre_personaje); // se guarda todo el progreso

    }

    private String creditos() {

        return "Fin\n\n"
                + "Muchas gracias por jugar \n"
                + "espero que te hayas divertido\n"
                + "Este proyecto fue creado por\n"
                + "Juan David Salas Camargo\n"
                + "ten un lindo dia\n";
    }

    /**
     * Este metodo es el menuDelInventario de inicio, lo que hace es permitir
     * que el usuario empiece el juego desde 0 o cargue una partida
     *
     * @version 22-07-21
     * @author Juan David Salas Camargo
     * @deprecated en la version 8/23/2021 se quito este metodo por el exceso
     * innecesario de lineas
     */
    public void Antiguo_loadGame() {

        inicializeGame(datos_usuario.getName());
        historia_general.lectorCapitulos();

        int a = datos_usuario.getProgress();
        for (a = datos_usuario.getProgress(); a < historia_general.Story.size(); a++) {
//            dado.opcionesDato();
            System.out.println((a * 100 / tamaño_historia) + "% de la Historia");

            System.out.println(historia_general.Story.get(a));
            if (finDelaHistoria(a)) {
                System.out.println(creditos());
            }
            System.out.println("deseas continuar? 1. si 2. salir");
            if (sc.nextInt() == 2) {
                datos_usuario.setProgress(a);
                carga_Datos_Usuario.guardarPartida(datos_usuario.getName());
                principalMenu();
            }
        }
    }

}
