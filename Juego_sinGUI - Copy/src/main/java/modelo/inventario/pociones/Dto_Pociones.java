package modelo.inventario.pociones;

import java.util.ArrayList;

/**
 *
 * @author Juan David Salas Camargo
 */
public class Dto_Pociones {
    
    
        ArrayList<Pociones> pociones = new ArrayList<>();

        
        
        public ArrayList<Pociones> inicializarPosiones () {
            
           
            Pocion_vida posion_basica = new Pocion_vida("pocion basica de vida", "te recupera 140 puntos de vida", 140);
            Pocion_vida posion_especial  = new Pocion_vida ("pocion de Merlin", "creada por el gran mago, te da 1000 puntos de vida", 1000); 
            Pocion_fuerza pocionBasicaFuerza = new Pocion_fuerza("pocion de aumento de fuerza", "hay muy pocas en el reino, te hace mas fuerte", 7);
            pociones.add(posion_basica);
            pociones.add (posion_especial);
            pociones.add(pocionBasicaFuerza);
           
           return pociones;
        
        }
        
        public Pociones PocionAlAzar () {
            
            return (pociones.get(((int) (Math.random() * pociones.size()-1) + 0)));
        
        
        }
}
