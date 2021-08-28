package modelo.inventario.espadas;

import java.io.Serializable;

/**
 *
 * @author Juan David Salas Camargo
 */
public class EspadaConPoderes extends Espadas implements Serializable {

    int mana;

    public EspadaConPoderes(String name, int strong, String description, int mana) {
        super(name, strong, description);
        this.mana = mana;
    }

    @Override
    public int equipar() {

        System.out.println("has invocado la obra y gracia del mas grande hechicero");

        return 1000;
    }

    @Override
    public int poderEspecial() {

        System.out.println("Has sido bendecido por la gracia de los dioses");

        return 100;
    }

}
