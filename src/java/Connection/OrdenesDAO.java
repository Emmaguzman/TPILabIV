/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Modelo.Orden;
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
public class OrdenesDAO {

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

    public boolean agregarOrden(Orden o) {
        boolean ingreso = false;
        final String QUERY = "Insert into Ordenes values(?,?,?,?,?)";
        conectar();
        try {
            prep = conn.prepareStatement(QUERY);
            prep.setInt(1, o.getId_Paciente());
            prep.setInt(2, o.getId_Empleado());
            prep.setInt(3, o.getId_Disciplina());
            prep.setInt(4, o.getCantSesiones());
            prep.setInt(5, o.getCantMinimasMensuales());

            prep.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }

        return ingreso;
    }

    public ArrayList<Orden> listaOrdenes() {
        ArrayList<Orden> lista = new ArrayList<>();
        final String QUERY = "select * from Ordenes";
        conectar();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(QUERY);
            while (rs.next()) {
                lista.add(new Orden(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getInt(6)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Orden traerOrden(String id) {
        Orden o = null;
        final String QUERY = "select * from Ordenes where idOrden=?";
        conectar();
        try {
            int idOrden = Integer.parseInt(id);
            prep = conn.prepareStatement(QUERY);
            prep.setInt(1, idOrden);
            rs = prep.executeQuery();
            while (rs.next()) {
                o = new Orden(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }

        } catch (Exception e) {
        }
        return o;
    }

    public void actualizarOrden(Orden o) {
        final String QUERY = "update Ordenes set idPaciente=?,idEmpleado=?,idDisciplina=?,cantSesiones=?,cantMinMensuales=? where idOrden=?";
        conectar();
        try {
            prep = conn.prepareStatement(QUERY);
            prep.setInt(1, o.getId_Paciente());
            prep.setInt(2, o.getId_Empleado());
            prep.setInt(3, o.getId_Disciplina());
            prep.setInt(4, o.getCantSesiones());
            prep.setInt(5, o.getCantMinimasMensuales());
            prep.setInt(6, o.getId());
            
            prep.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
    }

    public void eliminarOrden(String id) {
       int idOrden=Integer.parseInt(id);
       final String QUERY="delete Ordenes where idOrden=?";
       conectar();
        try {
            prep=conn.prepareStatement(QUERY);
            prep.setInt(1, idOrden);
            prep.execute();
            System.out.println("OrdenEliminada");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        cerrar();
        }
        
    }
}
