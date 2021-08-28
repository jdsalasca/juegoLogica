package modelo.inventario.espadas;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;
import modelo.PersonajePrincipal;
import modelo.inventario.espadas.LectoryEscritorDeEspadas;


/**
 *
 * @author Juan David Salas Camargo
 */
public class InventarioPersonajeEspadas   {

    public PersonajePrincipal datos_usuario;
    private final ArrayList<Espadas> espadas_usuario;
    public String ruta1;
    public File file;
    public LectoryEscritorDeEspadas archivo;

    public InventarioPersonajeEspadas(PersonajePrincipal datos_usuario) {
        this.datos_usuario = datos_usuario;
        this.ruta1 = "saves/" + datos_usuario.getName() + "/Inventario_espadas.dat";
        this.file = new File(ruta1);
        this.archivo = new LectoryEscritorDeEspadas(file);
        this.espadas_usuario = archivo.leerArchivo(file);
    }

    public void agregarEspada(Espadas a) {
        archivo.leerArchivo(file);


        if (!agregarSOLOsiNoExiste(a, espadas_usuario)){
            
            espadas_usuario.add(a);

        }
        
        try {
            archivo.escribirEnArchivo(espadas_usuario, file);
        } catch (NullPointerException e) {
            System.out.println("es Null Exeeption, se ha creado un problema en la creacion del inventario de espadas");

        }
//        System.out.println("la espada se ha agregado con exito");
//        return espadas_usuario;
    }
    
    

    public Espadas leerInventario() {
        archivo.leerArchivo(file);
        Scanner sc = new Scanner(System.in);
        Espadas espadaData = null;

        if (importarEspadas() == null || importarEspadas().isEmpty()) {
            System.out.println("No hay elementos dentro de la lista actual");
            return espadaData;
        } else {
            
            System.out.println("porfavor seleccione la espada que quiere equipar");

            for (int i = 0; i < importarEspadas().size(); i++) {
                System.out.println(i + "  " + displayespadaData(importarEspadas().get(i)));
            }
        }
        try {
            espadaData = importarEspadas().get(validarExistenciaObjeto(sc.nextInt()));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ingresaste un numero incorrecto\n"
                    + "vuelve a ingresar el numero porfavor");
            espadaData = leerInventario();
        }catch (IndexOutOfBoundsException e) {
                System.out.println("Ingresaste un numero incorrecto\n"
                + "vuelve a ingresar el numero porfavor");
            espadaData = leerInventario();
        
        }catch (InputMismatchException e) {
            System.out.println("Ingresaste un caracter no reconocido\n"
                + "vuelve a ingresar el numero porfavor");
            espadaData = leerInventario();
        
        }
        return espadaData;
    }
    
    public boolean laListaTieneElementos (){
    return !espadas_usuario.isEmpty();
    }
    

    public String displayespadaData( Espadas espadaData){
    
        return "Nombre: " + espadaData.getName()+ " Fuerza: " + espadaData.getStrong();
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
    private ArrayList<Espadas> importarEspadas() {

        return archivo.leerArchivo(file);

    }
    
    private int validarExistenciaObjeto (int a) {
        
        if (a >= 0 && a<importarEspadas().size()){
        }
        else {
            System.out.println("porfavor ingrese un numero valido");
            leerInventario();
        }
    return a;
    }
    
    public void imprimirTodo () {
        
        importarEspadas().forEach((n) -> System.out.println(displayespadaData(n)));
    
    
    }
    
    private boolean agregarSOLOsiNoExiste (Espadas a, ArrayList<Espadas> e){
        boolean exists = false;
        
        for (int i = 0; i < e.size(); i++) {
            
            if (e.get(i).getName().equals(a.getName())){
                
                exists = true;
            
            }
            
        }
    
    return exists;

    }
    
    
    

}
