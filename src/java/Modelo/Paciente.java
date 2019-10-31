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
public class Paciente extends Persona{

    public Paciente(int id, String nombre, String apellido, String direccion, String correo, String telefono, String dni, String fechaNac) {
        super(id, nombre, apellido, direccion, correo, telefono, dni, fechaNac);
    }

    public Paciente(String nombre, String apellido, String direccion, String correo, String telefono, String dni, String fechaNac) {
        super(nombre, apellido, direccion, correo, telefono, dni, fechaNac);
    }
   
    
    
    
}
