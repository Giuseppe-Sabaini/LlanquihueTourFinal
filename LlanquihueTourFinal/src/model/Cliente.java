package model;

/**
 * Representa a un Cliente dentro del sistema Llanquihue tour.
 * Esta clase hereda los atributos de persona y añade caracteristicas
 * especificas para la gestion comercial, como su identificacion, correo electronico, y tipo de cliente.
 *
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

public class Cliente extends Persona {
    private int idCliente;
    private String correo;
    private String tipoCliente;

    public Cliente(String nombre, int numero, String rut, Direccion direccion, int idCliente, String correo, String tipoCliente) {
        super(nombre, numero, rut, direccion);
        this.idCliente = idCliente;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void registrar(){
        System.out.println("|Nombre Del Cliente: " + getNombre() + " | Guardado Con Exito");
        System.out.println("|Numero del Cliente: " + getNumero() + " | Guardado Con Exito");
        System.out.println("|Rut Del Cliente: " + getRut() + " | Guardado Con Exito");
        System.out.println("|Direccion Del Cliente: " + getDireccion() + " | Guardada Con Exito");
        System.out.println("|Identificacion Del Cliente: " + idCliente + " | Guardada Con Exito");
        System.out.println("|Correo Del Cliente: " + correo + " | Guardado Con Exito");
        System.out.println("|Tipo de Cliente: " + tipoCliente + " | Guardado Con Exito");

    }

    @Override
    public void mostrarDatos(){
        System.out.println("|El Cliente Es : " + getNombre());
        System.out.println("|El Numero Del Cliente Es: "+ getNumero());
        System.out.println("|El Rut Del Cliente Es: "+ getRut());
        System.out.println("|La Direccion Del Cliente Es: " + getDireccion());
        System.out.println("|Su Identificacion Es: " + idCliente);
        System.out.println("|El Correo Del Cliente Es: " + correo);
        System.out.println("|El Tipo De Cliente Es: " + tipoCliente);
    }


    @Override
    public String toString() {
        return super.toString() + " | Detalles Cliente -> " +
                "ID: " + idCliente +
                ", Correo: " + correo +
                ", Tipo: " + tipoCliente;
    }
}
