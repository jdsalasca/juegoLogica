package modelo;

import java.util.ArrayList;
/**
 *
 * @author Juan David Salas Camargo
 */
public class ElementosDeCadaCapitulo {
    
    private int number;
    private ArrayList text;
    
    public ElementosDeCadaCapitulo (int number, ArrayList text) {
        this.number = number;
        this.text = text;
    }


    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList getText() {
        return this.text;
    }

    public void setText(ArrayList text) {
        this.text = text;
    }

/**
 * @version  01/06/21
 * @return lo que hace es crear un archivo de texto que es la historia, cada salto
 * de linea es un nuevo elemento. y el usuario cada vez que avance en la historia lo que hace
 * es avanzar en una lista que tiene como elementos la historia dividida
 * en fragmentos de cinco lineas
 */
@Override
public String toString() {
    String h = "";
    for (int i = 0; i < this.text.size(); i++) {
        
        h = h + "\n" + this.text.get(i);
               
    }
    return h;    
        
    }
    
    
}
