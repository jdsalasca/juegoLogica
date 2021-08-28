package modelo.inventario.espadas;

import modelo.inventario.espadas.Espadas_Interface;
import java.io.Serializable;

/**
 *
 * @author Juan David Salas Camargo
 */
public class EspadaNormal extends Espadas implements Serializable {

    public EspadaNormal(String name, int strong, String description) {
        super(name, strong, description);

    }

    @Override
    public int equipar() {

        return this.getStrong();

    }
    
    @Override
    public int poderEspecial () {
    
    return 200;
    }

}
