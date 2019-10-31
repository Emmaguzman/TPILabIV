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
public class Orden {
    private int id,id_Paciente,id_Empleado,id_Diciplina,cantSesiones,cantMinimasMensuales;

    public Orden(int id, int id_Paciente, int id_Empleado, int id_Diciplina, int cantSesiones, int cantMinimasMensuales) {
        this.id = id;
        this.id_Paciente = id_Paciente;
        this.id_Empleado = id_Empleado;
        this.id_Diciplina = id_Diciplina;
        this.cantSesiones = cantSesiones;
        this.cantMinimasMensuales = cantMinimasMensuales;
    }

    public Orden(int id_Paciente, int id_Empleado, int id_Diciplina, int cantSesiones, int cantMinimasMensuales) {
        this.id_Paciente = id_Paciente;
        this.id_Empleado = id_Empleado;
        this.id_Diciplina = id_Diciplina;
        this.cantSesiones = cantSesiones;
        this.cantMinimasMensuales = cantMinimasMensuales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public int getId_Diciplina() {
        return id_Diciplina;
    }

    public void setId_Diciplina(int id_Diciplina) {
        this.id_Diciplina = id_Diciplina;
    }

    public int getCantSesiones() {
        return cantSesiones;
    }

    public void setCantSesiones(int cantSesiones) {
        this.cantSesiones = cantSesiones;
    }

    public int getCantMinimasMensuales() {
        return cantMinimasMensuales;
    }

    public void setCantMinimasMensuales(int cantMinimasMensuales) {
        this.cantMinimasMensuales = cantMinimasMensuales;
    }

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", id_Paciente=" + id_Paciente + ", id_Empleado=" + id_Empleado + ", id_Diciplina=" + id_Diciplina + ", cantSesiones=" + cantSesiones + ", cantMinimasMensuales=" + cantMinimasMensuales + '}';
    }
    
}
