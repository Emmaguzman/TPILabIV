/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Connection.BDAccess;
import java.awt.Image;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author denis
 */
public class main {
    public static void main(String[] args) throws ParseException {
        
        BDAccess con=new BDAccess();
        
        con.traerEmpleado("3");
        
        
Image img;     
       
    }
}
