/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.Scanner;
import modelo.PanelDeBatalla;
import modelo.PersonajePrincipal;
import modelo.inventario.espadas.Dto_Espadas;
import modelo.inventario.espadas.InventarioPersonajeEspadas;
import modelo.inventario.pociones.Dto_Pociones;

/**
 * @author Juan David Salas Camargo
 */
public class Dado {
    private final PersonajePrincipal datos_usuario;
    private final Scanner sc = new Scanner(System.in);
    private final PanelDeBatalla pb;
    private final InventarioUsuario accesoInventario;

    
    public Dado(PersonajePrincipal datos_usuario) {
        this.datos_usuario = datos_usuario;
        this.accesoInventario =  new InventarioUsuario(datos_usuario);
        this.pb = new PanelDeBatalla(datos_usuario);
    }
    /**
     * La funcion de este dado es dar un nuumero aleatorio de 1 a 6 y a cada
     * numero asignarle una funcion, probablemente sea necesario implementar mas
     * datos en el futuros
     *
     * @version 22-07-2021
     * @return el numero que sacaras en el dado
     */
    public int numerodado() {
        return (int) (Math.random() * 9 + 3);
    }
    public void opcionesDato() {
        switch (numerodado()) {
            case 3:
                System.out.println("detras de un arbol te has encontrado con un enemigo");
                if ((int) (Math.random() * 5) + 1 ==1){

                pb.battlePanel(datos_usuario);
                }
                break;
            case 4:
                System.out.println("has encontrado algo en la maleza, revisa tu inventario: ");
                accesoInventario.agregarEspadaAlAzar();

                break;
            case 5:
                System.out.println("te has encontrado una pocion");
                accesoInventario.agregarPocion();
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:

                break;
        }

    }

}
