package LaFloresta.Instituto.controlador;

import LaFloresta.Instituto.vista.VistaConsola;

import java.util.*;

public class Controlador {

    private VistaConsola vista;

    public Controlador(){
        vista = new VistaConsola();
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
                    vista.imprimir("Ingresar estudiante");
                    break;
                case 2:
                    vista.imprimir("Buscar estudiante");
                    vista.imprimir("Ingresar correo institucional:\n");
                    break;
                case 3:
                    System.out.println("Modificar estudiante");
                    System.out.println("Ingresar correo institucional:\n");
                    break;
                case 4:
                    System.out.println("Eliminar estudiante");
                    System.out.println("Ingresar correo institucional:\n");
                    break;
                case 5:
                    System.out.println("El directorio de los estudiantes\n");
                    break;
                case 6:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opción incorrecta");

            }
        }while (opcion != 6);

    }
}
