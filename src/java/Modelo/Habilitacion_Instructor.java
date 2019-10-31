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
public class Habilitacion_Instructor {
    private int id_Empelado,id_Diciplina;

    public Habilitacion_Instructor(int id_Empelado, int id_Diciplina) {
        this.id_Empelado = id_Empelado;
        this.id_Diciplina = id_Diciplina;
    }

    public int getId_Empelado() {
        return id_Empelado;
    }

    public void setId_Empelado(int id_Empelado) {
        this.id_Empelado = id_Empelado;
    }

    public int getId_Diciplina() {
        return id_Diciplina;
    }

    public void setId_Diciplina(int id_Diciplina) {
        this.id_Diciplina = id_Diciplina;
    }

    @Override
    public String toString() {
        return "Habilitacion_Instructor{" + "id_Empelado=" + id_Empelado + ", id_Diciplina=" + id_Diciplina + '}';
    }
    
}
