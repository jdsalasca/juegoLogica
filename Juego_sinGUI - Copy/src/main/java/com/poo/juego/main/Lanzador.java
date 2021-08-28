package com.poo.juego.main;

import modelo.LecturaCarpetaSaves;
import modelo.LecturaDeCapitulos;
import modelo.inventario.pociones.Dto_Pociones;
import vista.MenuPrincipal;


/**
 *
 * @author Juan David Salas Camargo
 */
public class Lanzador {

    static MenuPrincipal mp = new MenuPrincipal();
    static LecturaCarpetaSaves probando = new LecturaCarpetaSaves();
    static LecturaDeCapitulos probando1 = new LecturaDeCapitulos();
    static Dto_Pociones probando2 = new Dto_Pociones();

    public static void main(String[] args) {
//        VistaPrincipal vistaMenu = new VistaPrincipal();
//        
//        vistaMenu.setVisible(true);
//        vistaMenu.musicOn();
        mp.principalMenu();
        
    }

}
