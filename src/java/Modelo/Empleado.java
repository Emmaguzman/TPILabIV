/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author denis
 */
public class Empleado extends Persona {

    private int idTipoEmpleado;    
    private InputStream foto;

    public Empleado() {       
    }

    public Empleado(int id,int idTipoEmpleado, String nombre, String apellido, String direccion, String correo, String telefono, String dni, String fechaNac, InputStream foto) {
        super(id, nombre, apellido, direccion, correo, telefono, dni, fechaNac);
        this.idTipoEmpleado = idTipoEmpleado;
        this.foto = foto;
    }

    public Empleado( String nombre, String apellido, String direccion, String correo, String telefono, String dni, String fechaNac,int idTipoEmpleado, InputStream foto) {
        super(nombre, apellido, direccion, correo, telefono, dni, fechaNac);
        this.idTipoEmpleado = idTipoEmpleado;
        this.foto = foto;
    }

    public Empleado( String nombre, String apellido, String direccion, String correo, String telefono, String dni, String fechaNac,InputStream foto, int id) {
        super(id, nombre, apellido, direccion, correo, telefono, dni, fechaNac);
        this.foto = foto;
    }

    
    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return super.toString()+"Empleado{" + "idTipoEmpleado=" + idTipoEmpleado + ", foto=" + foto + '}';
    }
    
 

}
