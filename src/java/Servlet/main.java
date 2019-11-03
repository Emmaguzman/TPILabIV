/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Connection.EmpleadoDAO;
import Connection.PacienteDAO;
import Modelo.Paciente;
import Modelo.Tipo_Empleado;


import java.text.ParseException;
import java.util.ArrayList;


/**
 *
 * @author denis
 */
public class main {
    public static void main(String[] args) throws ParseException {
        
        EmpleadoDAO con=new EmpleadoDAO();
        PacienteDAO conp=new PacienteDAO();
//        
//       ArrayList <Tipo_Empleado> lista=con.listaTiposE();
//       if(lista.size()==0){
//           System.out.println("no tenemos nada");
//       }else{
//        for (Tipo_Empleado p : lista) {
//            System.out.println(p.toString());
//        }
//       }
        
   // con.eliminarEmpleado("4");
   

//boolean x=conp.agregarPaciente(new Paciente("Pipi","Guzman","PORACA","NOTIENE@cagate","2999292","011100","19910131"));
//        System.out.println(x);
//            ArrayList<Paciente> lista=conp.listarPacientes();
//       
//        for (Paciente p : lista) {
//            System.out.println(p.toString());
//            
//        }
//
////conp.eliminarPaciente("2");
conp.traerPaciente("3");
}
}
