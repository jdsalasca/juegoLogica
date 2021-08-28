package modelo.inventario.pociones;

import java.io.Serializable;

/**
 *
 * @author Juan David Salas Camargo
 */
public class Pocion_vida implements Serializable, Pociones {

    private String name;
    private String descripcion;
    private int vidaqueda;

    public Pocion_vida(String name, String descripcion, int vidaqueda) {
        this.name = name;
        this.descripcion = descripcion;
        this.vidaqueda = vidaqueda;
    }

    @Override
    public int consumir() {
        return this.vidaqueda;
    }

    @Override
    public String toString() {
        return "\nNombre: " + this.name + " descripcion: " + this.descripcion + "vida que aumenta: " + this.vidaqueda;
    }

    @Override
    public String nombre() {
        return this.name;
    }

    @Override
    public int efecto() {
        return this.vidaqueda;
    }

    @Override
    public boolean equals(Object o) {
        
        //Reflexivo 
        if (o == this) {
            return true;
        }
        //No nulo 
        if (o == null) {
            return false;
        }
        //Simetrico 
        if (this.getClass() != o.getClass()) {
            return false;
        }
        if ( this.nombre() == this.getClass().cast(o).nombre() ) return true; 

//    if (!(o instanceof Pociones)) { mala practica porque Instanceof no garantiza la simetria
//        return false;
//    }
    if ( this.nombre() != null ) return this.nombre().equals( this.getClass().cast(o).nombre() );
        return false;
    
    }
    
    /**
     * el valor de pocion vida es 1
     * @return  1
     */

    @Override
    public int hashCode() {
        return 1;
    }
    
    
    
    

}
