package modelo;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Juan David Salas Camargo
 */
public class LecturaCarpetaSaves {

    File carpeta = new File("saves");
    Scanner sc = new Scanner(System.in);

    /**
     * este metodo sirve para saber si el usuario es nuevo y quiere empezar de 0
     * o si es un usuario con una partida guardada
     *
     * @param carpeta
     * @return nombre del usuario
     */
    public String usuarios() {
        File carpeta = new File("saves");
        String[] listado = carpeta.list();
        String usuario = null;

        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            System.out.println("Porfavor ingrese el nombre del nuevo usuario");
            return sc.nextLine();
            

        } else {

            System.out.println("Si su usuario esta en esta lista");
            System.out.println("porfavor presione el numero asociado con su usuario");

            for (int i = 0; i < listado.length; i++) {
                System.out.println(i + " " + listado[i]);

            }
            System.out.println(listado.length + " Crear nuevo usuario");
            System.out.println(listado.length +1+" Cerrar programa ");
        }
        
            int a  = sc.nextInt();

        try {

            if (a == listado.length) {
                System.out.println("ingrese el nombre del nuevo usuario");
                sc.skip("\n");
                return sc.nextLine();
            } else if (a == listado.length+1){
                System.out.println("Que tengas un bonito dia c:");
                System.exit(0);
            
            
            }else {

                return listado[a];
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ingreso un numero invalido, porfavor ingrese");
            System.out.println("el numero nuevamente");
            return usuarios();

        }catch (InputMismatchException e) {
            System.out.println("no identificamos que opcion marcaste");
            return usuarios();
        }
        return usuario;
    }
    
    



}
