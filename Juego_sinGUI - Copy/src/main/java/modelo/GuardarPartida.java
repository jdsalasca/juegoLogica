
package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan David Salas Camargo
 */
public class GuardarPartida {
    
    
    PersonajePrincipal nuevoJuego = new PersonajePrincipal();
    private String fileName;


    public PersonajePrincipal getnuevoJuego() {
        return nuevoJuego;
    }

    public void setnuevoJuego(PersonajePrincipal nuevoJuego) {
        this.nuevoJuego = nuevoJuego;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Este metodo sirve para crear la carpeta de saves y adicionalmente organizar 
     * las distintas partidas de los usuarios del juego
     * @param nombre_personaje 
     */


    public void guardarPartida(String nombre_personaje) {
        File saves = new File("saves\\" + nombre_personaje + "\\lore.txt");
        saves.getParentFile().mkdirs();
        try {
                    FileWriter myWriter = new FileWriter(saves);
                    myWriter.write(this.nuevoJuego.toString());
                    myWriter.write("\n");                    
                    myWriter.close();                
                } 
                
        catch (Exception e) {
                    System.out.println("Error al guardar");
                }
            }
    
    public void cargarPartida(String nombre_personaje) {
		File inFile = new File(this.fileName);
		try {
			Scanner sc = new Scanner(inFile);
			readGameLine(sc);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo inexistente -- " + this.fileName);
                        guardarPartida(nombre_personaje);
                        System.out.println("Se ha creado un nuevo archivo con el nombre " + this.fileName);
			
                        
		}
	}
    private void readGameLine(Scanner sc){
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            processLine(line);  
        }
    }
    
     /** 
     * ProcessLine is one the most beautiful methods of my proyect, what it do is 
     * change the vale of each line accord to the changes made for the user
     * in his game, adiccionally, the method who embboded processLine often is 
     * called when the user read the Story like a form to save the progress.
     * 
     * @version 1.0.0 

     */
     
    private void processLine(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(" ");
        String category = sc.next().trim().toLowerCase();
        switch (category) {
            case "name":this.nuevoJuego.setName(sc.next().trim());               
            break;
            case "life":this.nuevoJuego.setLife(Integer.parseInt(sc.next().trim()));
            break;
            case "strong":this.nuevoJuego.setStrong(Integer.parseInt(sc.next().trim())); 
            break;
            case "defense":this.nuevoJuego.setDefense(Integer.parseInt(sc.next().trim()));
            break;
            case "agility":this.nuevoJuego.setAgility(Integer.parseInt(sc.next().trim()));                    
            break;
            case "mana":this.nuevoJuego.setMana(Integer.parseInt(sc.next().trim()));                    
            break;
            case "wisdom":this.nuevoJuego.setWisdom(Integer.parseInt(sc.next().trim()));                    
            break;
            case "progress":this.nuevoJuego.setProgress(Integer.parseInt(sc.next().trim()));                    
            break;
            default:System.out.println("error al cargar los datos del usuario");
            break;
        }        
        sc.close();
    }
    
}
