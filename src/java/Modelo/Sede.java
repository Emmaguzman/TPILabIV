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
public class Sede {
    private int id;
    private String descripcion;

    public Sede(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Sede(String descripcion) {
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
        return "Sede{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
}
