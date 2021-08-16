package LaFloresta.Instituto.modelo.persistencia;

import LaFloresta.Instituto.modelo.Estudiante;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class EstudianteDAO {
    private Archivo archivo;

    public EstudianteDAO(Archivo archivo) {
        this.archivo = archivo;
    }

    public String verEstudiantes(File file){
        ArrayList<Estudiante> listaEstudiantes = archivo.leerArchivo(file);
        String texto = "";
        for(int i=0; i<listaEstudiantes.size(); i++){
            texto = texto.concat(listaEstudiantes.get(i)+"\n");
        }
        return texto;
    }

    public Estudiante buscarEstudiante(String correoInstitucional, ArrayList<Estudiante>listaEstudiantes){
        Estudiante encontrado = null;

        if(!listaEstudiantes.isEmpty()){
            for(int i = 0; i<listaEstudiantes.size(); i++){
                if(listaEstudiantes.get(i).getCorreoInstitucional().equals(correoInstitucional)){
                    encontrado = listaEstudiantes.get(i);
                }
            }
        }
        return encontrado;
    }

    public boolean agregarEstudiante(String nombres, String apellidos, String fechaNacimiento, String correoInstitucional,
                                     String correoPersonal, long telefonoCelular, long telefonoFijo, String programa,ArrayList<Estudiante>listaEstudiantes,
                                     File file){
        Estudiante nuevo = new Estudiante(nombres, apellidos, fechaNacimiento, correoInstitucional, correoPersonal, telefonoCelular,
                telefonoFijo, programa);
        if (buscarEstudiante(correoInstitucional, listaEstudiantes)==null){
            listaEstudiantes.add(nuevo);
            archivo.escribirEnArchivo(listaEstudiantes, file);
            return true;
        } else {
            return false;
        }

    }

    public boolean eliminarEstudiante(String correoInstitucional, ArrayList<Estudiante>listaEstudiantes, File file ){
        boolean respuesta = false;
        try{
            Estudiante e = buscarEstudiante(correoInstitucional, listaEstudiantes);

            if(e != null){
                listaEstudiantes.remove(e);
                file.delete();
                file.createNewFile();
                archivo.escribirEnArchivo(listaEstudiantes, file);
                respuesta = true;
            }
        } catch (IOException e1){
            e1.printStackTrace();
        }
        return respuesta;
    }

    public boolean modificarEstudiante(String correoInstitucional, String correoPersonal, long telefonoCelular,
                                       long telefonoFijo, String programa, ArrayList<Estudiante> listaEstudiantes,
                                       File file){
        boolean respuesta = false;
        try{
            for(Estudiante estudiante: listaEstudiantes){
                if(estudiante.getCorreoInstitucional().equals(correoInstitucional)){
                    estudiante.setCorreoPersonal(correoPersonal);
                    estudiante.setTelefonoCelular(telefonoCelular);
                    estudiante.setTelefonoFijo(telefonoFijo);
                    estudiante.setPrograma(programa);
                    file.delete();
                    file.createNewFile();
                    archivo.escribirEnArchivo(listaEstudiantes, file);
                    respuesta = true;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return respuesta;
    }
}
