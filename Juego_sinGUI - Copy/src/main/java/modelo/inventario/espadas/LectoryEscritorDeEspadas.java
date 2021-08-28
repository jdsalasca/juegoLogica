package modelo.inventario.espadas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class LectoryEscritorDeEspadas {

    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public  LectoryEscritorDeEspadas(File archivo) {
        if (archivo.exists()) {

        } else {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    public void escribirEnArchivo(ArrayList<Espadas> espadas, File archivo) {
        try {
            archivo.getParentFile().mkdirs();
//            System.out.println(espadas); quite esta linea para que no se imprimieran las espadas
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            salida.writeObject(espadas);
            salida.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");
        }

    }

    public ArrayList<Espadas> leerArchivo(File archivo) {
        ArrayList<Espadas> espadas = new ArrayList<>();
        if (archivo.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(archivo));
                espadas = (ArrayList<Espadas>) entrada.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
//            System.out.println("no hay archivo");
        }

        return espadas;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }

}
