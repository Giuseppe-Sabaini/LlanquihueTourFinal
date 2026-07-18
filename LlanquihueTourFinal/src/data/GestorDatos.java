package data;
/**
 * Clase controladora encargada de gestionar el almacenamiento, persistencia y
 * estadisticas de las entidades del sistema Llanquihue Tour.
 * Administra una lista polimorfica en memoria y sincroniza los cambios con un archivo local
 *
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import model.Cliente;
import model.Direccion;
import model.GuiaTuristico;
import model.Registrable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

    private List<Registrable> listaEntidades;

    public GestorDatos(){
        this.listaEntidades = new ArrayList<>();
    }

    public void cargarDatosDesdeArchivo(){
        String rutaArchivo = "resources/LlanquihueFinal.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String tipo = datos[0];

                if (tipo.equalsIgnoreCase("CLIENTE")) {
                    //Datos Comunes De Persona
                    String nombre = datos[1];
                    int numero = Integer.parseInt(datos[2]);
                    String rut = datos[3];

                    //Datos De Direccion
                    String calle = datos[4];
                    String comuna = datos[5];
                    Direccion dir = new Direccion(calle, comuna);

                    //Atributos Especificos De Cliente
                    int idCliente = Integer.parseInt(datos[6]);
                    String correo = datos[7];
                    String tipoCliente = datos[8];

                    //Guardar en la Lista Polimorfica
                    Cliente cl = new Cliente(nombre, numero, rut, dir, idCliente, correo, tipoCliente);
                    listaEntidades.add(cl);


                } else if (tipo.equalsIgnoreCase("GUIA")) {
                    //Datos comunes de persona
                    String nombre = datos[1];
                    int numero = Integer.parseInt(datos[2]);
                    String rut = datos[3];

                    //datos de Direccion
                    String calle = datos[4];
                    String comuna = datos[5];
                    Direccion dir = new Direccion(calle, comuna);

                    //Atributos de Guia turistico
                    String rol = datos[6];
                    double sueldo = Double.parseDouble(datos[7]);
                    int experiencia = Integer.parseInt(datos[8]);

                    //Guardado en lista Polimorfica
                    GuiaTuristico g = new GuiaTuristico(nombre, numero, rut, dir, rol, sueldo, experiencia);
                    listaEntidades.add(g);
                }
            }
            System.out.println("Datos cargados con Exito en el Archivo.");
        } catch (IOException e) {
            System.err.println("Error al intentar abrir o leer el archivo: " + e.getMessage());
        }
    }

    public void mostrarTodosLosRegistros() {
        System.out.println("");
        System.out.println("===== LISTA COMPLETA LLANQUIHUE TOUR =====");
        for (Registrable r : listaEntidades) {
            r.mostrarDatos();
            System.out.println("------------------------------------------");
        }
    }

    public void mostrarEstadisticas(){
        int totalClientes = 0;
        int totalGuias = 0;
        double sumaSueldosGuias = 0;

        for (Registrable r : listaEntidades){
            if (r instanceof  Cliente){
                totalClientes++;

            }else if (r instanceof GuiaTuristico) {
                totalGuias++;
                GuiaTuristico g = (GuiaTuristico) r;
                sumaSueldosGuias += g.getSueldo();
            }
        }

        System.out.println("===== ESTADISTICAS =====");
        System.out.println("Total De Clientes Registrados: " + totalClientes);
        System.out.println("Total De Guias Registrados: " + totalGuias);
        if (totalGuias > 0) {
            System.out.println("Gasto Total En Sueldo Guias: " + sumaSueldosGuias);

        }
        System.out.println("====================================================");
    }

    public void agregarClientes(Cliente c) {
        listaEntidades.add(c);
        //
        try (java.io.FileWriter filew = new java.io.FileWriter("resources/LlanquihueFinal.txt", true)) {
            filew.write("\nCLIENTE;" + c.getNombre() + ";" + c.getNumero() + ";" + c.getRut() + ";" +
                    c.getDireccion().getCalle() + ";" + c.getDireccion().getComuna() + ";" +
                    c.getIdCliente() + ";" + c.getCorreo() + ";" + c.getTipoCliente());
            System.out.println("¡Cliente guardado en el archivo!");
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    public void agregarGuia(GuiaTuristico g) {
        listaEntidades.add(g);
        //
        try (java.io.FileWriter filew = new java.io.FileWriter("resources/LlanquihueFinal.txt", true)) {
            filew.write("\nGUIA;" + g.getNombre() + ";" + g.getNumero() + ";" + g.getRut() + ";" +
                    g.getDireccion().getCalle() + ";" + g.getDireccion().getComuna() + ";" +
                    g.getRol() + ";" + g.getSueldo() + ";" + g.getExperiencia());
            System.out.println("¡Guía guardado en el archivo!");
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

}

