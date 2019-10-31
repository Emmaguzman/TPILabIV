/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author denis
 */
public class Empleado extends Persona {

    private int idTipoEmpleado;
    private String foto;

    public Empleado(int id, int idTipoEmpleado,String nombre, String apellido, String direccion, String correo, String telefono, String dni, String fechaNac,String foto) {
        super(id, nombre, apellido, direccion, correo, telefono, dni, fechaNac);
        this.idTipoEmpleado = idTipoEmpleado;
        this.foto = foto;
    }

    public Empleado(int idTipoEmpleado, String foto, String nombre, String apellido, String direccion, String correo, String telefono, String dni, String fechaNac) {
        super(nombre, apellido, direccion, correo, telefono, dni, fechaNac);
        this.idTipoEmpleado = idTipoEmpleado;
        this.foto = foto;
    }

    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return super.toString()+"Empleado{" + "idTipoEmpleado=" + idTipoEmpleado + ", foto=" + foto + '}';
    }

}
