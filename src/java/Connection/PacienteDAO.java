/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Modelo.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 *
 * @author denis
 */
public class PacienteDAO {

    Connection conn;
    ResultSet rs;
    Statement st;
    PreparedStatement prep;

    private void conectar() {
        final String URL = "jdbc:sqlserver://Gamex:1433;databaseName=centroMedicina";
        final String NOM = "Emma";
        final String PASS = "1234";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection(URL, NOM, PASS);
            System.out.println("EXITO");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR EN CONEXION");
        }
    }

    private void cerrar() {

        try {
            if (!conn.isClosed() && conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            System.out.println("Error al cerrar conexión");
        }
    }

    public boolean agregarPaciente(Paciente p) {
        boolean inserto = false;
        final String QUERY = "insert into Pacientes values(?,?,?,?,?,?,?)";
        conectar();
        try {
            prep = conn.prepareStatement(QUERY);
            prep.setString(1, p.getNombre());
            prep.setString(2, p.getApellido());
            prep.setString(3, p.getDireccion());
            prep.setString(4, p.getCorreo());
            prep.setString(5, p.getTelefono());
            prep.setString(6, p.getDni());
            prep.setString(7, p.getFechaNac());

            prep.executeUpdate();
            inserto = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }

        return inserto;
    }

    public ArrayList<Paciente> listarPacientes() {
        ArrayList<Paciente> lista = new ArrayList<>();
        final String QUERY = "Select * from Pacientes";
        Paciente p = null;
        conectar();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(QUERY);
            while (rs.next()) {
                p = new Paciente(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8));
             lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return lista;
    }

    public Paciente traerPaciente(String id) {
        final String QUERY = "Select * from Pacientes where idPaciente=?";
        Paciente p =null;
        conectar();
        try {
            int idPaciente=Integer.parseInt(id);
            prep=conn.prepareStatement(QUERY);
            prep.setInt(1, idPaciente);
            rs =prep.executeQuery();
            while(rs.next()){
            p=new Paciente( rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));
            }
            System.out.println(p.toString());
        } catch (Exception e) {
        }
                

        return p;
    }

    public void actualizarPaciente(Paciente p) {
        final String QUERY = "update Pacientes set nombres=?,"
                                                + "apellidos=?,"                                             
                                                + "direccion=?,"
                                                + "correo=?,"
                                                + "telefono=?,"
                                                + "dni=?,"
                                                + "fechaNacimiento=?"
                                                +"where id=?";
        conectar();
        try {
            prep=conn.prepareStatement(QUERY);
            prep.setString(1, p.getNombre());
            prep.setString(2, p.getApellido());
            prep.setString(3, p.getDireccion());
            prep.setString(4, p.getCorreo());
            prep.setString(5, p.getTelefono());
            prep.setString(6, p.getDni());
            prep.setString(7, p.getFechaNac());
            prep.setInt(8,p.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        cerrar();
        }
    }

    public void eliminarPaciente(String id) {
        int idPaciente=Integer.parseInt(id);
        final String QUERY = "delete Pacientes where idPaciente=?";
        conectar();
        try {
            prep=conn.prepareStatement(QUERY);
            prep.setInt(1, idPaciente);
            prep.execute();
            System.out.println("ELIMINADO CORRECTAMENTE");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR");
        }finally{
        cerrar();
        }
                
    }

}
