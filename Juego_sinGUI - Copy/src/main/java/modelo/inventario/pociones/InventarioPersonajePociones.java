package modelo.inventario.pociones;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.PersonajePrincipal;

import modelo.inventario.espadas.Espadas;

/**
 *
 * @author Juan David Salas Camargo
 */
public class InventarioPersonajePociones {

    public PersonajePrincipal datos_usuario;
    private final ArrayList<Pociones> pociones_usuario;
    public String ruta1;
    public File file;
    public LectoryEscritorDePociones archivo;

    public InventarioPersonajePociones(PersonajePrincipal datos_usuario) {
        this.datos_usuario = datos_usuario;
        this.ruta1 = "saves/" + datos_usuario.getName() + "/Inventario_pociones.dat";
        this.file = new File(ruta1);
        this.archivo = new LectoryEscritorDePociones(file);
        this.pociones_usuario = archivo.leerArchivo(file);
    }

    public ArrayList<Pociones> agregarPocion(Pociones a) {
        archivo.leerArchivo(file);
        
        if (pociones_usuario.size()<= 10) {

        pociones_usuario.add(a);

        try {
            archivo.escribirEnArchivo(pociones_usuario, file);
        } catch (NullPointerException e) {
            System.out.println("es Null Exeeption, se ha creado un problema en la creacion del inventario de las pociones");
        }
        System.out.println("la pocion se ha agregado con exito");
        return pociones_usuario;
    }else {
            System.out.println("Inventario de pociones lleno");
        }
        return null;
    }

    public Pociones leerInventario() {
        archivo.leerArchivo(file);
        Scanner sc = new Scanner(System.in);
        Pociones pocionData = null;

        if (importarPociones() == null || importarPociones().isEmpty()) {
            System.out.println("No hay elementos dentro de la lista actual");
            pocionData = null;
        } else {

            System.out.println("porfavor seleccione la pocion que quiere usar");

            for (int i = 0; i < importarPociones().size(); i++) {
                System.out.println(i + "  " + (importarPociones().get(i)));
            }
        }
        try {
            pocionData = importarPociones().get(validarExistenciaObjeto(sc.nextInt()));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ingresaste un numero incorrecto\n"
                    + "vuelve a ingresar el numero porfavor");
            pocionData = leerInventario();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ingresaste un numero incorrecto\n"
                    + "vuelve a ingresar el numero porfavor");
            pocionData = leerInventario();

        } catch (InputMismatchException e) {
            System.out.println("Ingresaste un caracter no reconocido\n"
                    + "vuelve a ingresar el numero porfavor");
            pocionData = leerInventario();

        }
        return pocionData;
    }

    public ArrayList<Pociones> EliminarPocionTrasConsumo(Pociones a) {
        archivo.leerArchivo(file);
        pociones_usuario.remove(a);
                try {
                    
            archivo.escribirEnArchivo(pociones_usuario, file);
        } catch (NullPointerException e) {
            System.out.println("es Null Exeeption, se ha creado un problema en la creacion del inventario de las pociones");
        }
        System.out.println("pocion consumida");
        return pociones_usuario;
    }
    
    public boolean laListaDepocionesTieneElemenetos (){
    return !pociones_usuario.isEmpty();
    }

    /**
     * Este metodo lo usamos para mostrar el inventario de espadas pero en el
     * caso de las pociones no lo usamos dado que al usar una inferfaz en vez de
     * herencia podemos modificar cada ToString () en las clases que implementan
     * la interfaz Posiones
     *
     * @param PocionDaa = informacion del objeto que se quiere leer
     * @return = una lectura del objeto util para mostrar en un menu de opciones
     * @deprecated
     */
    @Deprecated
    public String displayPocionesData(Pociones PocionDaa) {
//                

        return "Nombre: " + PocionDaa.nombre() + " Efecto: " + PocionDaa.efecto();
    }

    /**
     * lo que hace es leer el archivo donde estan guardada las espadas por
     * decirlo asi lo descomprime y retorna un arraylist listo para operarlo
     *
     * @param file ; no obstante para favorecer la alta cohesion, esta operacion
     * le pide el parametro a su misma clase, no necesita ser definido por
     * externos
     * @return la lista de espadas del usuario
     */
    private ArrayList<Pociones> importarPociones() {

        return archivo.leerArchivo(file);

    }

    private int validarExistenciaObjeto(int a) {

        if (a >= 0 && a < importarPociones().size()) {
        } else {
            System.out.println("porfavor ingrese un numero valido");
            leerInventario();
        }
        return a;
    }

    public void imprimirTodo() {

        importarPociones().forEach((n) -> {
            System.out.println((n));
        });

    }

    /**
     * this method was made for add to the inventory of the user just the items
     * that the user didn't have. that was the use of this method about swords,
     * however The user can have more that one poisons of any kind, so this is
     * not necessary
     *
     * @param The object that we wanna put inside the inventory
     * @param the list of the user
     * @return true it means that the items is in the list. so the item is not
     * added.
     * @deprecated
     */
    @Deprecated
    private boolean agregarSOLOsiNoExiste(Pociones a, ArrayList<Pociones> e) {
        boolean exists = false;

        for (int i = 0; i < e.size(); i++) {

            if (e.get(i).equals(a)) {

                exists = true;

            }

        }

        return exists;

    }

}
