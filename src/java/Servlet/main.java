/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Connection.BDAccess;
import Modelo.Tipo_Empleado;


import java.text.ParseException;
import java.util.ArrayList;


/**
 *
 * @author denis
 */
public class main {
    public static void main(String[] args) throws ParseException {
        
        BDAccess con=new BDAccess();
//        
//       ArrayList <Tipo_Empleado> lista=con.listaTiposE();
//       if(lista.size()==0){
//           System.out.println("no tenemos nada");
//       }else{
//        for (Tipo_Empleado p : lista) {
//            System.out.println(p.toString());
//        }
//       }
        
    con.eliminarEmpleado("4");
       
 
       
    }
}
