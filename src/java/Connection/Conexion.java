/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author denis
 */
public class Conexion {
Connection conn=null;
        public  Connection conectar() {
        
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
        
        return conn;
    }

    public void cerrar() {

        try {
            if (!conn.isClosed() && conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            System.out.println("Error al cerrar conexión");
        }
    }
}
