package app;
import data.GestorDatos;
import model.Cliente;
import model.Direccion;
import model.GuiaTuristico;
import java.util.Scanner;

/**
 * Punto de entrada principal para la aplicacion Llanquihue Tour.
 * Esta clase se encarga de gestionar la interfaz de usuario por consola, despliega
 * el menú interactivo y actua como puente de comunicacion directo con el controlador.
 *
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        GestorDatos gestor = new GestorDatos();

        gestor.cargarDatosDesdeArchivo();

        int opcion = 0;
        do {
            System.out.println("\n==================================================");
            System.out.println("                 LLANQUIHUE TOUR MENU               ");
            System.out.println("==================================================");
            System.out.println("");
            System.out.println("1.→ Registrar Nuevo Cliente");
            System.out.println("2.→ Registrar Nuevo Guia Turistico");
            System.out.println("3.→ Mostrar Todos Los Registros Del Sistema");
            System.out.println("4.→ Ver Estadisticas e Informes De Sueldo");
            System.out.println("5.→ Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR NUEVO CLIENTE ---");
                    //Datos comunes de persona
                    System.out.println("Nombre del Cliente: ");
                    String nombreCliente = teclado.nextLine();
                    System.out.println("Numero de telefono: ");
                    int telefonoCliente = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Rut: ");
                    String rutCliente = teclado.nextLine();

                    //Datos de direccion
                    System.out.println("Calle de residencia: ");
                    String calleCliente = teclado.nextLine();
                    System.out.println("Comuna: ");
                    String comunaCliente = teclado.nextLine();
                    Direccion direccionCliente = new Direccion(calleCliente, comunaCliente);

                    //Atributos especificos de Cliente
                    System.out.println("ID del Cliente: ");
                    int idCliente = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Correo electronico: ");
                    String mailCliente = teclado.nextLine();
                    System.out.println("Tipo de Cliente  (Habitual/Nuevo): ");
                    String tipoCliente = teclado.nextLine();

                    //Instanciar, ejecuta Registrar() y lo guarda en gestor
                    Cliente nuevoCliente = new Cliente(nombreCliente, telefonoCliente, rutCliente, direccionCliente, idCliente, mailCliente, tipoCliente);
                    nuevoCliente.registrar();
                    gestor.agregarClientes(nuevoCliente);// Esto lo manda al ArrayList
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR NUEVO GUÍA TURÍSTICO ---");
                    //Datos comunes de persona
                    System.out.println("Nombre del Guia: ");
                    String nombreGuia = teclado.nextLine();
                    System.out.println("Numero de telefono: ");
                    int telefonoGuia = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Rut: ");
                    String rutGuia = teclado.nextLine();

                    //Datos de direccion
                    System.out.println("Calle de residencia: ");
                    String calleGuia = teclado.nextLine();
                    System.out.println("Comuna: ");
                    String comunaGuia = teclado.nextLine();
                    Direccion direccionGuia = new Direccion(calleGuia, comunaGuia);

                    //Atributos especificos del Guia
                    System.out.println("Especialidad (Rol): ");
                    String rolGuia = teclado.nextLine();
                    System.out.println("Sueldo mensual: ");
                    double sueldoGuia = teclado.nextDouble();
                    System.out.println("Años de Experiencia: ");
                    int experienciaGuia = teclado.nextInt();
                    teclado.nextLine();

                    //Instanciar, ejecuta Registrar() y lo guarda en gestor
                    GuiaTuristico nuevoGuia = new GuiaTuristico(nombreGuia, telefonoGuia, rutGuia, direccionGuia, rolGuia, sueldoGuia, experienciaGuia);
                    nuevoGuia.registrar();
                    gestor.agregarGuia(nuevoGuia);// Lo manda al ArrayList
                    break;

                case 3:
                    //Muestra todo los datos del .txt
                    gestor.mostrarTodosLosRegistros();
                    break;

                case 4:
                    gestor.mostrarEstadisticas();
                    break;

                case 5:
                    System.out.println("Gracias por utilizar Llanquihue tour App! saliendo...");
                    break;

                default:
                    System.out.println("Opcion Invalida. Intente nuevamente.");


            }

        } while (opcion != 5);

        teclado.close();

    }
}