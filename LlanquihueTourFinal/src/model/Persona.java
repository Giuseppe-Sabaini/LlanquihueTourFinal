package model;

/**
 * Representa a una persona dentro del sistema Llanquihue Tour.
 * Esta clase sirve como base para datos comunes de una persona
 * e implementa los comportamientos de registro y visualizacion de datos.
 * esta clase tiene composicion de la clase Direccion
 *
 * @author Giuseppe Sabaini
 * @Version 1.0
 */
public class Persona  implements Registrable {

    private String nombre;
    private int numero;
    private String rut;
    private Direccion direccion;


    public Persona(String nombre, int numero, String rut, Direccion direccion) {
        this.nombre = nombre;
        this.numero = numero;
        this.rut = rut;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public void registrar() {
        System.out.println("|Nombre Registrado: " + nombre + "| Con Exito");
        System.out.println("|Numero Telefonico Registrado: " + numero + " Con Exito");
        System.out.println("|Rut Registrado: " + rut + "| Con Exito");
        System.out.println("|Direccion Registrada: " + direccion + "| Con Exito");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("|Nombre: " + nombre);
        System.out.println("|Numero Telefonico: " + numero);
        System.out.println("|Rut: " + rut);
        System.out.println("|Direccion: " + direccion);

    }


    @Override
    public String toString() {
        return "Nombre: " + nombre + ", " +
                "Numero: " + numero + ", " +
                "Rut: " + rut + ", " +
                "Direccion: " + direccion;
    }
}
