package LaFloresta.Instituto.modelo;

import LaFloresta.Instituto.modelo.persistencia.EstudianteDAO;
import java.io.File;
import java.util.ArrayList;

public class EstudianteDTO {
    private ArrayList<Estudiante> estudiantes;
    private EstudianteDAO computadorDao;
    private File archivo = new File("datos_estudiantes.dat");
    private Archivo archivo;

}
