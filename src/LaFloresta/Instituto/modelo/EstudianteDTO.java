package LaFloresta.Instituto.modelo;

import LaFloresta.Instituto.modelo.persistencia.Archivo;
import LaFloresta.Instituto.modelo.persistencia.EstudianteDAO;
import java.io.File;
import java.util.ArrayList;

public class EstudianteDTO {
    private ArrayList<Estudiante> listaEstudiantes;
    private EstudianteDAO estudianteDAO;
    private File file = new File("datos_estudiantes.dat");
    private Archivo archivo;

    public EstudianteDTO() {
        listaEstudiantes = new ArrayList<Estudiante>();
        archivo = new Archivo(file);
        estudianteDAO = new EstudianteDAO(archivo);
        listaEstudiantes = archivo.leerArchivo(file);
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }

    public void setEstudianteDAO(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
}
