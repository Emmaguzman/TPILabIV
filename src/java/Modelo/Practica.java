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
public class Practica {
    private int id,id_Inscripcion,id_Empleado,id_Sede,minutosOcupados;
    private String fechaPractica;

    public Practica(int id, int id_Inscripcion, int id_Empleado, int id_Sede, int minutosOcupados, String fechaPractica) {
        this.id = id;
        this.id_Inscripcion = id_Inscripcion;
        this.id_Empleado = id_Empleado;
        this.id_Sede = id_Sede;
        this.minutosOcupados = minutosOcupados;
        this.fechaPractica = fechaPractica;
    }

    public Practica(int id_Inscripcion, int id_Empleado, int id_Sede, int minutosOcupados, String fechaPractica) {
        this.id_Inscripcion = id_Inscripcion;
        this.id_Empleado = id_Empleado;
        this.id_Sede = id_Sede;
        this.minutosOcupados = minutosOcupados;
        this.fechaPractica = fechaPractica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Inscripcion() {
        return id_Inscripcion;
    }

    public void setId_Inscripcion(int id_Inscripcion) {
        this.id_Inscripcion = id_Inscripcion;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public int getId_Sede() {
        return id_Sede;
    }

    public void setId_Sede(int id_Sede) {
        this.id_Sede = id_Sede;
    }

    public int getMinutosOcupados() {
        return minutosOcupados;
    }

    public void setMinutosOcupados(int minutosOcupados) {
        this.minutosOcupados = minutosOcupados;
    }

    public String getFechaPractica() {
        return fechaPractica;
    }

    public void setFechaPractica(String fechaPractica) {
        this.fechaPractica = fechaPractica;
    }

    @Override
    public String toString() {
        return "Practica{" + "id=" + id + ", id_Inscripcion=" + id_Inscripcion + ", id_Empleado=" + id_Empleado + ", id_Sede=" + id_Sede + ", minutosOcupados=" + minutosOcupados + ", fechaPractica=" + fechaPractica + '}';
    }
    
}
