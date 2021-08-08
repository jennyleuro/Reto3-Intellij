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


}
