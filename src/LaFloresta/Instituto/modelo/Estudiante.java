package LaFloresta.Instituto.modelo;

import java.io.Serializable;

public class Estudiante implements Serializable{
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private long telefonoCelular;
    private long telefonoFijo;
    private String programa;

    public Estudiante(String nombre, String apellidos, String fechaNacimiento, String correoInstitucional, String correoPersonal,
                      long telefonoCelular, long telefonoFijo, String programa){}
}
