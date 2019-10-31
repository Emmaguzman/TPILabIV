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
public class Tipo_Diciplina {
    private int id;
    private String descripcion;

    public Tipo_Diciplina(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Tipo_Diciplina(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "Tipo_Diciplina{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
}
