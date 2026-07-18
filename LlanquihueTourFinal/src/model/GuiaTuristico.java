package model;

/**
 * Representa un Guia Turistico dentro del sistema de Llanquihue Tour.
 * esta clase hereda los atributos clasicos de Persona y añade caracteristicas
 * especificas para el ambito laboral, como su rol, sueldo, y los años de experiencia.
 *
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */
public class GuiaTuristico extends Persona {
    private String rol;
    private double sueldo;
    private int experiencia;

    public GuiaTuristico(String nombre, int numero, String rut, Direccion direccion, String rol, double sueldo, int experiencia) {
        super(nombre, numero, rut, direccion);
        this.rol = rol;
        this.sueldo = sueldo;
        this.experiencia = experiencia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public void registrar(){
        System.out.println("|Procesando Registro De Nuevo Guia Turistico");
        System.out.println("|Nombre Del Guia: " + getNombre() + " | Guardado con Exito");
        System.out.println("|Numero de telefono: " + getNumero() + "| Guardado con Exito");
        System.out.println("|Rut: " + getRut() + " | Guardado con Exito");
        System.out.println("|Direccion: " + getDireccion() + " | Guardado con Exito");
        System.out.println("|Especialidad: " + rol + " | Guardada con Exito");
        System.out.println("|Sueldo: " + sueldo + " | Guardado con Exito");
        System.out.println("|Experiencia en el trabajo: " + experiencia + " | Años, Guardado con Exito");

    }

    @Override
    public void mostrarDatos(){
        System.out.println("|Tu Guia Turisitico Es: " + getNombre());
        System.out.println("|Numero de tu Guia: " + getNumero());
        System.out.println("|Rut de tu Guia: " + getRut());
        System.out.println("|Direccion del Guia: " + getDireccion());
        System.out.println("|La Especialidad de tu Guia Es: " + rol);
        System.out.println("|Sueldo del Guia: " + sueldo);
        System.out.println("|Experiencia en el trabajo: " + experiencia + " Años");

    }

    @Override
    public String toString() {
        return super.toString() + " | Detalles Guía -> " +
                "Especialidad: " + rol +
                ", Sueldo: " + sueldo +
                ", Experiencia: " + experiencia + " Años";
    }

}
