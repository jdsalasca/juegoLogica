package modelo.inventario.pociones;

import java.io.Serializable;

/**
 *
 * @author Juan David Salas Camargo
 */
public class Pocion_fuerza implements Serializable, Pociones {
    
    
    private String name;
    private String descripcion;
    private int aumentoDeFuerza;

    public Pocion_fuerza(String name, String descripcion, int aumentoDeFuerza) {
        this.name = name;
        this.descripcion = descripcion;
        this.aumentoDeFuerza = aumentoDeFuerza;
    }


    
    @Override
    public int consumir() {
        return this.aumentoDeFuerza;
    }

    @Override
    public String toString() {
        return "\nnombre: " + this.name + " descripcion: " + this.descripcion + " aumento de fuerza permanente: " + this.aumentoDeFuerza ;
    }

    @Override
    public String nombre() {
        return this.name;
    }

    @Override
    public int efecto() {
        return this.aumentoDeFuerza;
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
     * El valor de pocion fuerza es 0.
     * @return 
     */

    @Override
    public int hashCode() {
        return 0;
    }
    
    
    
}
