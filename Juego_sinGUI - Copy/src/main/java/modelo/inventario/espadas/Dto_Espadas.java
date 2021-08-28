package modelo.inventario.espadas;

import modelo.inventario.espadas.EspadaConPoderes;
import modelo.inventario.espadas.EspadaNormal;
import java.util.ArrayList;

/**
 *
 * @author Juan David Salas Camargo
 */
public class Dto_Espadas {

    ArrayList<Espadas> espadas = new ArrayList<Espadas>();

    EspadaConPoderes p1 = new EspadaConPoderes("Escalibur", 50, "Esta espada fue creada por Merlin buscando un arma tan poderosa que trajera la paz mundial", 100);
    EspadaNormal espadaComun = new EspadaNormal("espada comun", 20, "Esta espada se puede encontrar en todo el reino es abandonada por bandidos o por viajeros");
    EspadaNormal espadadeguerrero = new EspadaNormal("Espada de guerrero", 40, "esta espada suele abundar en el reino tras las constantes luchas de poder");

    public Dto_Espadas() {
        this.espadas = espadas;
    }

    /**
     * Con este metodo busco inicializar y establecer las espadas que se pueden
     * encontrar en el juego, posteriormente se usara para actualizar la lista
     */
    public void inicializarEspadas() {

        espadas.add(p1);
        espadas.add(espadaComun);
        espadas.add(espadadeguerrero);
    }

    /**
     * Este metodo se implementara para agregar espadas al usuario
     *
     * @return Espada
     */
    public Espadas espadaAlazar() {

        return (espadas.get((int) (Math.random() * espadas.size()-1) + 0));
    }

}
