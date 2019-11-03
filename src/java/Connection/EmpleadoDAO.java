/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Modelo.Empleado;
import Connection.Conexion;
import Modelo.Tipo_Empleado;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
public class EmpleadoDAO {
    
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

    public BufferedImage convertBlobAtImg(Blob blob) throws SQLException, IOException {
        byte[] imgAsByte = blob.getBytes(1, (int) blob.length());
        InputStream in = new ByteArrayInputStream(imgAsByte);
        BufferedImage img = ImageIO.read(in);

        return img;
    }

    public void actualizarEmpleado(Empleado p) {
        final String QUERY = "update Empleados set nombres=?,"
                                                + "apellidos=?,"
                                                + "idTipoEmpleado=?,"
                                                + "direccion=?,"
                                                + "correo=?,"
                                                + "telefono=?,"
                                                + "dni=?,"
                                                + "fechaNacimiento=?"
                                                + ",foto=? "
                                                + "where id=?";
        try {
            conectar();
            prep = conn.prepareStatement(QUERY);
            prep.setString(1, p.getNombre());
            prep.setString(2, p.getApellido());
            prep.setInt(3,p.getIdTipoEmpleado());
            prep.setString(4,p.getDireccion());
            prep.setString(5, p.getCorreo());
            prep.setString(6, p.getTelefono());
            prep.setString(7, p.getDni());
            prep.setString(8, p.getFechaNac());
            prep.setBlob(9, p.getFoto());            
            prep.setInt(10, p.getId());

            prep.execute();
        } catch (Exception e) {

        } finally {
            cerrar();
        }

    }

    public Empleado traerEmpleado(String id) {
        Empleado p = null;
        final String QUERY = "select * from empleados where idEmpleado=?";
        try {
            int idEmpelado = Integer.parseInt(id);
            conectar();
            prep = conn.prepareStatement(QUERY);
            prep.setInt(1, idEmpelado);
            rs = prep.executeQuery();
            while (rs.next()) {
                p = new Empleado(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBinaryStream(10));
               
            }
            System.out.println(p.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }

        return p;
    }

    public void listarImagenes(int id, HttpServletResponse response) {
        final String QUERY = "Select * from Empleados where id=" + id;
        InputStream in = null;
        OutputStream out = null;
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        response.setContentType("image/*");

        try {
            out = response.getOutputStream();
            conectar();
            prep = conn.prepareStatement(QUERY);
            rs = prep.executeQuery();
            if (rs.next()) {
                in = rs.getBinaryStream("foto");
            }
            bin = new BufferedInputStream(in);
            bout = new BufferedOutputStream(out);
            int i = 0;
            while ((i = bin.read()) != -1) {
                bout.write(i);
            }

        } catch (Exception e) {
        }

    }

    public ArrayList<Empleado> listarEmpleados() throws IOException {
        final String QUERY = "Select * from Empleados";
        ArrayList<Empleado> listado = new ArrayList<>();
        Empleado p = null;
        try {
            conectar();
            st = conn.createStatement();
            rs = st.executeQuery(QUERY);
            while (rs.next()) {
                p = new Empleado(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBinaryStream("foto"));
                listado.add(p);
            }
            System.out.println(p.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            cerrar();
        }
        return listado;
    }

    public boolean agregarEmpleado(Empleado p) {
        boolean inserto = false;
        final String QUERY = "insert into Empleado values(?,?,?,?,?,?,?,?,?)";
        conectar();
        try {
            prep = conn.prepareStatement(QUERY);
            prep.setInt(1,p.getIdTipoEmpleado());
            prep.setString(2, p.getNombre());
            prep.setString(3, p.getApellido());
            prep.setString(4, p.getDireccion());
            prep.setString(5, p.getCorreo());
            prep.setString(6, p.getTelefono());
            prep.setString(7, p.getDni());
            prep.setString(8, p.getFechaNac());
            prep.setBlob(9, p.getFoto());             
            
            prep.executeUpdate();
            inserto = true;
            System.out.println("Insercion Correcta");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return inserto;
    }

    public ArrayList<Tipo_Empleado> listaTiposE() {
        ArrayList<Tipo_Empleado> lista = new ArrayList<>();
        final String QUERY = "Select * from TiposEmpleado";

        try {
            conectar();
            st = conn.createStatement();
            rs = st.executeQuery(QUERY);
            while (rs.next()) {
                Tipo_Empleado te = new Tipo_Empleado(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(te);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void eliminarEmpleado(String id) {
        int idEmpleado = Integer.parseInt(id);
        final String QUERY = "delete from Empleados where idEmpleado=?";
        try {
            conectar();
            prep = conn.prepareStatement(QUERY);
            prep.setInt(1, idEmpleado);
            prep.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar");
            e.printStackTrace();
        } finally {
            cerrar();
        }
    }

}
