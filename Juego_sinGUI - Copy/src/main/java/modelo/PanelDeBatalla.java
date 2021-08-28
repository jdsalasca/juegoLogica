package modelo;

import controlador.Dado;
import java.util.Scanner;
import controlador.InventarioUsuario;
import modelo.inventario.espadas.Espadas;

/**
 *
 * @author Juan David Salas Camargo
 */
public class PanelDeBatalla {

    private int dmg = 0;
    private int vida_restante_enemigo = 0;
    public Scanner leer = new Scanner(System.in);
    private final int strong;
    private int life;
    private PersonajePrincipal datos_usuario;
    private final InventarioUsuario acceso_inventario;
    private int dmg_sword = 0;
    
    

    Scanner sc = new Scanner(System.in);

    public PanelDeBatalla(PersonajePrincipal datos_usuario) {
        this.datos_usuario = datos_usuario;
        this.strong = 10;
        this.life = 100;
        this.acceso_inventario = new InventarioUsuario(datos_usuario);
    }

    public int randomAttack(int strong) {
        int a = (int) (Math.random() * ((strong - 0) + 1)) + 0;
        a = a * 3;
        return a;
    }

    /**
     * REVISAR METODO
     */
//
//    public void ganador(){
//        inicializeGame();
//        int lifePrincipal = datos_usuario.getLife();
//        if (dmg>=30){System.out.println("has derrotado a tu enemigo"); cambiostraslabatalla();}
//        if (lifePrincipal<=0) {
//            System.out.println("perdiste :c ");
//            
//        }
//    }
    public int ataque(PersonajePrincipal datos_usuario ) {
        int ataque = randomAttack(datos_usuario.getStrong() + acceso_inventario.getDaño_espada() );
        int ataqueNPC = randomAttack(strong);
        int set_life = 0;
        if (this.life <= 0) {
            System.out.println("El enemigo ha muerto");
            set_life = datos_usuario.getLife();
        }
        if (this.life <= 30 && this.life >= 7) {
            System.out.println("El enemigo esta proximo a su muerte");
            set_life = datos_usuario.getLife();
        }
        if (ataque < ataqueNPC) {
            int lifePrincipal = datos_usuario.getLife();
            System.out.println("te han  causado " + (ataqueNPC - ataque) + " de ");
            System.out.println("tu vida restante es " + lifePrincipal);
            datos_usuario.setLife(lifePrincipal - (ataqueNPC - ataque));
        } else if (ataque > ataqueNPC) {
            dmg = dmg + (ataque - ataqueNPC);
            vida_restante_enemigo = this.life - (ataque - ataqueNPC);

            life = life - (ataque - ataqueNPC);
            System.out.println("has causado " + (ataque - ataqueNPC) + " de dmg");
            System.out.println("Vida restante del enemigo " + vida_restante_enemigo);
        } else {
            System.out.println("el enemigo esquivo el ataque");
        }
        return set_life;

    }
//    
//        public int ataque(PersonajePrincipal datos_usuario ) {
//        int ataque;
//        ataque = randomAttack(datos_usuario.getStrong() +  );
//        int ataqueNPC = randomAttack(strong);
//        int set_life = 0;
//        if (this.life <= 0) {
//            System.out.println("El enemigo ha muerto");
//            set_life = datos_usuario.getLife();
//        }
//        if (this.life <= 30 && this.life >= 7) {
//            System.out.println("El enemigo esta proximo a su muerte");
//            set_life = datos_usuario.getLife();
//        }
//        if (ataque < ataqueNPC) {
//            int lifePrincipal = datos_usuario.getLife();
//            System.out.println("te han  causado " + (ataqueNPC - ataque) + " de ");
//            System.out.println("tu vida restante es " + lifePrincipal);
//            datos_usuario.setLife(lifePrincipal - (ataqueNPC - ataque));
//        } else if (ataque > ataqueNPC) {
//            dmg = dmg + (ataque - ataqueNPC);
//            vida_restante_enemigo = this.life - (ataque - ataqueNPC);
//
//            life = life - (ataque - ataqueNPC);
//            System.out.println("has causado " + (ataque - ataqueNPC) + " de dmg");
//            System.out.println("Vida restante del enemigo " + vida_restante_enemigo);
//        } else {
//            System.out.println("el enemigo esquivo el ataque");
//        }
//        return set_life;
//
//    }

    /**
     * se actualizo el viernes 20 de agosto se paso de un switch case a un if,
     * porque el if permite controlar la probabilidad del suceso del manera mas
     * eficiente
     */
    public boolean huir() {
        boolean escape = false;
        //probabilidad de huir = 0.8
        if ((int) (Math.random() * 5) + 1 != 1) {
            escape = true;

        } else {
            System.out.println("escapaste sin exito");
            ataque(datos_usuario);

        }
        return true;
    }

    public void invetory() {
        System.out.println("aun no se ha implementado");
    }

    public void invocation() {
        System.out.println("aun no se ha implementado");
    }

    public int Scanner() {
        int c;
        c = leer.nextInt();
        return c;
    }

    public void battlePanel(PersonajePrincipal datos_usuario) {

        

        while (this.life > 0 && datos_usuario.getLife() > 0) {
            System.out.println("1.atacar");
            System.out.println("2.inventario");
            System.out.println("3.huir");
            try {
                System.out.println("escribe una de las opciones");
                var opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        ataque(datos_usuario);

                        break;
                    case 2:
                        acceso_inventario.menuDelInventario();
                        
                        
                        break;
                    case 3:

                        break;
                    case 4:
                        if (huir()) {
                            break;
                        }

                    default:
                        break;
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

    }

    /**
     *
     * @deprecated se elimino para favorecer la alta cohesion y el bajo
     * acoplamiento 22/08/21
     *
     */
    @Deprecated
    private void inicializeGame() {
//        cargar_y_Guardar.setFileName("Lore.txt");
//        cargar_y_Guardar.setnuevoJuego(datos_usuario);
//        cargar_y_Guardar.cargarPartida(datos_usuario.getName());
    }

    /**
     * Este metodo lo que hace es que cada vez que termine una batalla, entonces
     * la historia se retrocede un poco, asi el usuario no va a estar perdido
     * Salio de funcionamiento el 22/08/2021 para mejorar la comunicacion entre
     * clases
     *
     * @deprecated
     */
    @Deprecated
    public void cambiostraslabatalla() {
        Dado d = new Dado(datos_usuario);

        inicializeGame();
//        lector_de_Capitulos.lectorCapitulos();

        datos_usuario.setProgress(datos_usuario.getProgress() - 1);
//        cargar_y_Guardar.guardarPartida(datos_usuario.getName());
        int a = datos_usuario.getProgress();
//        for (a = datos_usuario.getProgress(); a < lector_de_Capitulos.Story.size(); a++) {

        d.opcionesDato();
//            System.out.println((a * 100 / lector_de_Capitulos.Story.size()) + "% de la Historia");
        // dado.opcionesDato();
//            System.out.println(lector_de_Capitulos.Story.get(a));
        System.out.println("deseas continuar? 1. si 2. salir");
        if (sc.nextInt() == 2) {
            datos_usuario.setProgress(a);
//                cargar_y_Guardar.guardarPartida(datos_usuario.getName());
            System.exit(0);
        }
    }

    @Deprecated
    public void ganador_o_perdedor() {
        if (life <= 0) {
            System.out.println("Ganaste");

        } else {
            System.out.println("perdiste");
        }
    }

}
