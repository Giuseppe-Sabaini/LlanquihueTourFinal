package model;

/**
 * Esta clase representa la direccion del domicilio de una persona en el sistema.
 * Se utiliza bajo el concepto de composicion, dentro de la clase persona
 * para agrupar los datos de la calle y comuna.
 *
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

public class Direccion {

    private String calle;
    private String comuna;


    public Direccion(String calle, String comuna) {
        this.calle = calle;
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }


    @Override
    public String toString() {
        return " Calle: " + calle + ", Comuna: " + comuna;
    }

}
