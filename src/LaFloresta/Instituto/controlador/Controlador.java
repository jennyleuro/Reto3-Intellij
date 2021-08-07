package LaFloresta.Instituto.controlador;

import LaFloresta.Instituto.modelo.EstudianteDTO;
import LaFloresta.Instituto.vista.VistaConsola;

import java.util.*;

public class Controlador {

    private VistaConsola vista;
    private EstudianteDTO estudiante;

    public Controlador(){
        vista = new VistaConsola();
        estudiante = new EstudianteDTO();
        funcionar();

    }

    public void funcionar(){
        int opcion = 0;

        String menu = "INSTITUTO LA FLORESTA\n" + "Seleccione tarea a realizar: \n"
                + "1. Ingresar estudiante\n" + "2. Buscar estudiante\n" + "3. Modificar estudiante\n"+"4. Eliminar Estudiante\n"+
                "5. Ver directorio de estudiantes\n"+"6. Salir\n"+"Opción: \n";
        do {
            opcion = vista.leerEntero(menu);

            switch (opcion) {
                case 1:
                    ingresarEstudiante();
                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    modificarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    directorioEstudiante();
                    break;
                case 6:
                    vista.imprimir("Hasta pronto");
                    break;
                default:
                    vista.imprimir("Opción incorrecta");

            }
        }while (opcion != 6);

    }

    public void ingresarEstudiante(){
        vista.imprimir("Ingresar estudiante");
        String nombre = vista.leerString("Ingresar nombres:\n");
        String apellidos = vista.leerString("Ingresar apellidos:\n");
        String fechaNacimiento = vista.leerString("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
        String correoInstitucional = vista.leerString("Ingresar correo institucional:\n");
        String correoPersonal = vista.leerString("Ingresar correo personal:\n");
        long telefonoCelular = vista.leerLong("Ingresar número de celular:\n");
        long telefonoFijo = vista.leerLong("Ingresar número fijo:\n");
        String programa = vista.leerString("Ingresar programa:");

        if (estudiante.getEstudianteDAO().agregarEstudiante(nombre, apellidos, fechaNacimiento, correoInstitucional,
                correoPersonal, telefonoCelular, telefonoFijo, programa, estudiante.getEstudiantes(), estudiante.getFile())){
            vista.imprimir("\nSe agregó el estudiante\n");
        } else {
            vista.imprimir("\nNo fue posible agregar al estudiante\n");
        }
    }
}
