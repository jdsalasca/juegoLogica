package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan David Salas Camargo
 */
public class LecturaDeCapitulos {
    private String fileName = "UnionCapitulos.txt";
    public ArrayList <ElementosDeCadaCapitulo> Story;

    public LecturaDeCapitulos (String fileName) {
        this.fileName = fileName;
        this.Story = new ArrayList<ElementosDeCadaCapitulo>();

    }
    public LecturaDeCapitulos () {
        this.fileName = fileName;
        this.Story = new ArrayList<ElementosDeCadaCapitulo>();

    } 

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public ArrayList<ElementosDeCadaCapitulo> getStory() {
        return Story;
    }
    public void setStory(ArrayList<ElementosDeCadaCapitulo> Story) {
        this.Story = Story;
    }

    /** 
     * Este metodo sirve para leer los 9 capitulos que tiene la historia'
     * y convertirlos en un arraylist de x elementos, el numero de elementos lo 
     * determina el numero de lineas de cada capitulo, cada 5 lineas se crea un 
     * nuevo elemento de la lista. Se utiliza solo 9 veces en total.
     * @version 1.0.0
     * Quiero anotar que despues modifique este metodo, es decir ahora solo

     */
     
    public void lectorCapitulos() {
		File inFile = new File(this.fileName);
		try {
			Scanner sc = new Scanner(inFile);
			elementosCapitulo(sc);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo inexistente -- " + this.fileName);
			System.exit(0);
		}
	}
    /** 
     * the function of the method below is create a list of element of the
     * chapter, it's neccesary because when the user is reading the story
     * I need to show him just 5 lines of the story and no everything.
     * 
     * @version 1.0.0 

     */       
       
    
    private void elementosCapitulo(Scanner sc) {
        int a = 0;
		while(sc.hasNextLine()){
        ArrayList<String> text = new ArrayList<>();
            for (int i = 0; i < 5; i++) {                
                text.add(sc.nextLine());
                if (!sc.hasNextLine()){
                    break;
                }
            }      
        ElementosDeCadaCapitulo v = new ElementosDeCadaCapitulo(a, text);a++;this.Story.add(v);       
    }
    sc.close();
	}
   
}
