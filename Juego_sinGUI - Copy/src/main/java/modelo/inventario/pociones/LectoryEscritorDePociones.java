package modelo.inventario.pociones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.inventario.pociones.Pociones;

public class LectoryEscritorDePociones {

    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public  LectoryEscritorDePociones(File archivo) {
        if (archivo.exists()) {

        } else {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    public void escribirEnArchivo(ArrayList<Pociones> pociones, File archivo) {
        try {
            archivo.getParentFile().mkdirs();
            System.out.println(pociones);
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            salida.writeObject(pociones);
            salida.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");
        }

    }

    public ArrayList<Pociones> leerArchivo(File archivo) {
        ArrayList<Pociones> pociones = new ArrayList<>();
        if (archivo.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(archivo));
                pociones = (ArrayList<Pociones>) entrada.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            
        }

        return pociones;
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
