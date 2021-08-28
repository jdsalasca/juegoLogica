package modelo.inventario.pociones;

/**
 *
 * @author Juan David Salas Camargo
 */
public interface Pociones  {
    
    int costo_mana = 20;

    
    public int consumir ();
    
    public String nombre ();
    
    public int efecto ();
    
    
    

    @Override
    public String toString();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();
    
    

    

    
}
