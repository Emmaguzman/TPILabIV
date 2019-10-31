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
public class Inscripcion {
    private int id,idOrden;
    private String fechaInscripcion;

    public Inscripcion(int id, int idOrden, String fechaInscripcion) {
        this.id = id;
        this.idOrden = idOrden;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion(int idOrden, String fechaInscripcion) {
        this.idOrden = idOrden;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", idOrden=" + idOrden + ", fechaInscripcion=" + fechaInscripcion + '}';
    }
    
    
}
