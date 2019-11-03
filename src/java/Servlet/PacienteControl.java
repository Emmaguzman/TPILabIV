/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Connection.PacienteDAO;
import Modelo.Paciente;
import java.io.IOException;
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
@WebServlet(name = "PacienteControl", urlPatterns = {"/PacienteControl"})
public class PacienteControl extends HttpServlet {

    private PacienteDAO conn;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            conn = new PacienteDAO();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

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
                    listarPacientes(request, response);
                    break;
                case "AGREGAR":
                    agregarPaciente(request, response);
                    break;
                case "CARGAR":
                    cargarPaciente(request, response);
                    break;
                case "BORRAR":
                    borrarPaciente(request, response);
                    break;
                case "ACTUALIZAR":
                    actualizarPaciente(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void agregarPaciente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion=request.getParameter("txtDireccion");
        String correo=request.getParameter("txtCorreo");
        String telefono=request.getParameter("txtTelefono");
        String dni=request.getParameter("txtDNI");
        String fechaNac=request.getParameter("txtFechaNac");
                
       
        
        Paciente p = new Paciente(nombre, apellido,direccion,correo,telefono,dni,fechaNac);
        conn.agregarPaciente(p);
        listarPacientes(request, response);
    }

    private void listarPacientes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Paciente> lista = conn.listarPacientes();
        request.setAttribute("ListaP", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/listaPacientes.jsp");
        rd.forward(request, response);
    }

    private void cargarPaciente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Paciente pac = conn.traerPaciente(request.getParameter("idPaciente"));
        request.setAttribute("p", pac);
        RequestDispatcher rd = request.getRequestDispatcher("/actualizarPaciente.jsp");
        rd.forward(request, response);
    }

    private void borrarPaciente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        conn.eliminarPaciente(request.getParameter("idPaciente"));
        listarPacientes(request, response);
    }

    private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id=Integer.parseInt(request.getParameter("idPaciente"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion=request.getParameter("txtDireccion");
        String correo=request.getParameter("txtCorreo");
        String telefono=request.getParameter("txtTelefono");
        String dni=request.getParameter("txtDNI");
        String fechaNac=request.getParameter("txtFechaNac");
        Paciente p=new Paciente(id,nombre,apellido,direccion,correo,telefono,dni,fechaNac);
        conn.actualizarPaciente(p);
        listarPacientes(request, response);
    }


}
