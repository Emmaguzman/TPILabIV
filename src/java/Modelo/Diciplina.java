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
public class Diciplina {
    private int id,idTipoDiciplina;
    private String descripcion;

    public Diciplina(int id, int idTipoDiciplina, String descripcion) {
        this.id = id;
        this.idTipoDiciplina = idTipoDiciplina;
        this.descripcion = descripcion;
    }

    public Diciplina(int idTipoDiciplina, String descripcion) {
        this.idTipoDiciplina = idTipoDiciplina;
        this.descripcion = descripcion;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoDiciplina() {
        return idTipoDiciplina;
    }

    public void setIdTipoDiciplina(int idTipoDiciplina) {
        this.idTipoDiciplina = idTipoDiciplina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Diciplina{" + "id=" + id + ", idTipoDiciplina=" + idTipoDiciplina + ", descripcion=" + descripcion + '}';
    }
    

}
