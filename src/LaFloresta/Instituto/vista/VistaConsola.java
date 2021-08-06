package LaFloresta.Instituto.vista;

import java.util.Scanner;

public class VistaConsola {
    private Scanner leer;

    public VistaConsola(){
        leer = new Scanner(System.in).useDelimiter("\n");;
    }

    public int leerEntero(String mensaje){
        int dato = 0;
        try{
            System.out.println(mensaje);
            dato = leer.nextInt();
        }catch (Exception e){
            leer.nextLine();
            System.out.println("El dato ingresado no es un número");
            dato = 0;
        }
        return dato;
    }

    public void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public String leerString(String mensaje){
        System.out.println(mensaje);
        String dato = leer.nextLine();
        return dato;
    }
}
