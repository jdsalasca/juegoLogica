package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import modelo.PersonajePrincipal;
import modelo.inventario.espadas.Dto_Espadas;
import modelo.inventario.espadas.Espadas;
import modelo.inventario.espadas.InventarioPersonajeEspadas;
import modelo.inventario.pociones.Dto_Pociones;
import modelo.inventario.pociones.InventarioPersonajePociones;
import modelo.inventario.pociones.Pociones;

/**
 *
 * @author Juan David Salas Camargo
 */
public class InventarioUsuario {

    private int daño_espada;
    private final PersonajePrincipal datos_usuario;
    private final Dto_Espadas total_espadas = new Dto_Espadas();
    private final Dto_Pociones total_pociones = new Dto_Pociones();
    private final InventarioPersonajeEspadas espadas_usuario;
    private final InventarioPersonajePociones pociones_usuario;

    public InventarioUsuario(PersonajePrincipal datos_usuario) {
        this.espadas_usuario = new InventarioPersonajeEspadas(datos_usuario);
        this.pociones_usuario = new InventarioPersonajePociones(datos_usuario);
        this.datos_usuario = datos_usuario;
    }

    public int getDaño_espada() {
        return daño_espada;
    }

    public int setDaño_espada(int daño_espada) {
        return this.daño_espada = daño_espada;
    }

    boolean salir = false;
    Scanner sc = new Scanner(System.in);

    public int menuDelInventario() {

        while (!salir) {

            System.out.println("Inventario ");
            System.out.println("1. Espadas");
            System.out.println("2. Posiones");
            System.out.println("3. volver al menu principal");
            System.out.println("Ingresa un numero porfavor");
            try {
                switch (sc.nextInt()) {
                    case 1:
                        return setDaño_espada(uso_Espada(verEspadas()));

                    case 2:
                        consumo(verPociones());

                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("ingresa un numero nuevamente");

                }

            } catch (ArithmeticException e) {
                System.out.println("Ingrese un numero correcto");

            }

        }
        return 0;
    }

    public void agregarEspadaAlAzar() {
        total_espadas.inicializarEspadas();
        espadas_usuario.agregarEspada(total_espadas.espadaAlazar());

//        return espadas_usuario; //activar en casa de necesitar comprobar que atributo se esta retornando
// para ello se debe retornar Espadas en este metodo y activar la linea de return
    }

    /**
     * con este metodo se agrega una nueva pocion en el intenvario del personaje
     * principal, la idea es que las pociones puedar ser usadas desde el
     * menuDelInventario principal
     *
     * @return
     */
    public InventarioPersonajePociones agregarPocion() {
        total_pociones.inicializarPosiones();
        pociones_usuario.agregarPocion(total_pociones.PocionAlAzar());
        return pociones_usuario;
    }

    public Pociones verPociones() {
        Pociones a = null;
        if (pociones_usuario.laListaDepocionesTieneElemenetos()) {
            if (deseaVerelinventario(1)) {

                return pociones_usuario.leerInventario();

            }
        }

        return a;

    }

    /**
     * este metodo necesita ser corregido en futuras versiones dado que tiene
     * demasiado anidamiento
     *
     * @param a
     * @return
     */
    public int uso_Espada(Espadas a) {
        int ataque = 0;
        if (espadas_usuario.laListaTieneElementos()) {

            return validarPoderEspecial(a);
        } else {
            System.out.println("No tienes espadas");
        }
        return 0;
    }

    private int validarPoderEspecial(Espadas a) {

        if (a.poderEspecial() != 0) {
            System.out.println("Que desea hacer con la espada");
            System.out.println("1. ataque normal 2.ataque Especial");

            if (sc.nextInt() == 1) {
                System.out.println("Espada Equipada, ahora haras mas daño en batalla c:");

                return a.equipar();
            } else if (sc.nextInt() == 2) {
                System.out.println("el uso del poder te ha costado 20 de mana");
                datos_usuario.setMana(datos_usuario.getMana() - 20);
                System.out.println("mana restante: " + datos_usuario.getMana());
                return a.poderEspecial();
            }
        } else {
            System.out.println("Esta espada no tiene poder especial");
            return a.equipar();
        }
        return 0;
    }

    public int consumo(Pociones a) {
        int consumo = 0;

        System.out.println("desea consumir la posicion?");
        System.out.println("1.si 2.no");
        if (sc.nextInt() == 1) {

            if (a.hashCode() == 0) {
                datos_usuario.setStrong(datos_usuario.getStrong() + a.consumir());

            } else if (a.hashCode() == 1) {
                datos_usuario.setLife(datos_usuario.getLife() + a.consumir());

            }
        }

        pociones_usuario.EliminarPocionTrasConsumo(a);

        return consumo;
    }

    public Espadas verEspadas() {
        Espadas a = null;
        if (deseaVerelinventario()) {

            a = espadas_usuario.leerInventario();

        }

        return a;
    }

    /**
     * para ver las pociones
     *
     * @param se usa solo para poder usar polimorfismo parametrico, al indicar
     * un numero se diferencia del otro metodo que tiene el mismo nombre
     * @return
     */
    private boolean deseaVerelinventario(int a) {
        boolean desicion = false;
        if (pociones_usuario.laListaDepocionesTieneElemenetos()) {
            System.out.println("desea ver sus pociones?");
            if (sc.nextInt() == 1) {
                desicion = true;
            } else {

                System.out.println("No tienes pociones :c");
            }
        }

        return desicion;

    }

    /**
     * The user decide if wanna see the sword in his inventory
     *
     * @return the choise
     */
    private boolean deseaVerelinventario() {
        boolean desicion = false;
        if (espadas_usuario.laListaTieneElementos()) {
            System.out.println("desea ver sus armas?");
            System.out.println("1. si 2. no");
            if (sc.nextInt() == 1) {
                desicion = true;
            }
        }

        return desicion;

    }

}

//    private InventarioPersonajePosciones agregarEspadaAlAzar (){
//                total_pociones.inicializarPosiones();
//                pociones_usuario.agregarPocion(total_pociones.PocionAlazar());
//
//        return espadas_usuario; }

