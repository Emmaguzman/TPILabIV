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
public class Tipo_Empleado {
    private int id;
    private String descripcion,codigo;

    public Tipo_Empleado(int id, String descripcion, String codigo) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Tipo_Empleado{" + "id=" + id + ", descripcion=" + descripcion + ", codigo=" + codigo + '}';
    }
    
}
