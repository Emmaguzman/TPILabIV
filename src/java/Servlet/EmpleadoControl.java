/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Connection.BDAccess;
import Modelo.Empleado;
import Modelo.Persona;
import Modelo.Tipo_Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
@WebServlet(name = "EmpleadoControl", urlPatterns = {"/EmpleadoControl"})

public class EmpleadoControl extends HttpServlet {    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
      private BDAccess conn;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            conn = new BDAccess();
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String control = request.getParameter("Comando");
        try {
            if (control == null) {
                control = "LISTA";
            }
            switch (control) {
                case "LISTA":
                    listaEmpleados(request, response);
                    mostrarImg(request, response);
                    break;           
                case "LISTATIPOSE":
                    listaTiposEmpleado(request,response);                    
                    break;
                case "ACTUALIZAE":
                    actualizarEmpleado(request,response);
                    break;
                case "ELIMINARE":
                    eliminarEmpleado(request,response);                    
                    break;
                default:
                    listaEmpleados(request, response);
                    break;
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    
    }

    private void listaEmpleados(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Empleado> lista = conn.listarEmpleados();
        request.setAttribute("List", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpleados.jsp");
        rd.forward(request, response);
    }
    private void mostrarImg(HttpServletRequest request, HttpServletResponse response)throws Exception{
        int id=Integer.parseInt(request.getParameter("id"));
        conn.listarImagenes(id, response);
    }
    private void listaTiposEmpleado(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ArrayList <Tipo_Empleado> lista=conn.listaTiposE();
      request.setAttribute("ListaTiposE", lista);
      RequestDispatcher rd = request.getRequestDispatcher("/agregarEmpleado.jsp");
      rd.forward(request, response);      
    }
    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) throws Exception{
      int id=Integer.parseInt(request.getParameter("idEmpelado"));
      
       String nombre=request.getParameter("txtNombre");
       String apellido=request.getParameter("txtApellido");
       String direccion=request.getParameter("txtDireccion");
       String correo=request.getParameter("txtCorreo");
       String dni=request.getParameter("txtDni");
       String fechaN=request.getParameter("fechaN");  
       
      
    }
    private void agregarEmpleado(HttpServletRequest request, HttpServletResponse response) throws Exception{
       String nombre=request.getParameter("txtNombre");
       String apellido=request.getParameter("txtApellido");
       String direccion=request.getParameter("txtDireccion");
       String telefono=request.getParameter("txtTelefono");
       String correo=request.getParameter("txtCorreo");
       String dni=request.getParameter("txtDni");
       String fechaN=request.getParameter("fechaN"); 
       int idtipoEmpleado=Integer.parseInt(request.getParameter("idTipoE"));
       
       
        Empleado p=new Empleado(nombre,apellido,direccion,correo,telefono,dni,fechaN,idtipoEmpleado);
        conn.agregarEmpleado(p);
        listaEmpleados(request, response);
       
        
    }
    private void eliminarEmpleado (HttpServletRequest request, HttpServletResponse response) throws Exception{
    conn.eliminarEmpleado(request.getParameter("idEmpelado"));
    listaEmpleados(request,response);    
    }
    

}
