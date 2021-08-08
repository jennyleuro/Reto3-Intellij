package LaFloresta.Instituto.modelo.persistencia;

import LaFloresta.Instituto.modelo.Estudiante;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public Archivo(File archivo){
        if(archivo.exists()){

        } else {
            try {
                archivo.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void escribirEnArchivo(ArrayList<Estudiante> listaEstudiantes, File archivo){
        try{
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            salida.writeObject(listaEstudiantes);
            salida.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Estudiante> leerArchivo(File archivo){
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
        if(archivo.length() != 0){
            try{
                entrada = new ObjectInputStream(new FileInputStream(archivo));
                listaEstudiantes = (ArrayList<Estudiante>)entrada.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return listaEstudiantes;
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
