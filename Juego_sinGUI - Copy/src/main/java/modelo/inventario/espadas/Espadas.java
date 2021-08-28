package modelo.inventario.espadas;

import java.io.Serializable;

/**
 *
 * @author Juan David Salas Camargo
 */
public class Espadas implements Serializable  {

    protected String name;
    protected int strong;
    protected String description;

    public Espadas(String name, int strong, String description) {
        super();
        this.name = name;
        this.strong = strong;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrong() {
        return strong;
    }

    public void setStrong(int strong) {
        this.strong = strong;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * la idea de este metodo es sumarle al usuario la fuerza de la espada
     * para poder usarla en combate
     * @return 
     */

    public int equipar() {

        return this.strong;

    }
    
    public int poderEspecial (){
    
    return 0;
    }

    @Override
    public String toString() {
        return "Espadas{" + "name=" + name + ", strong=" + strong + ", description=" + description + '}';
    }

}
