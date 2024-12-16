/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionPostgreSQL;

/**
 *
 * @author rober
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5433/vitalisMedicalCenter";
    private static final String USER = "postgres"; // Cambia a tu usuario de PostgreSQL
    private static final String PASSWORD = "329274"; // Cambia a tu contraseña

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
           
        } catch (Exception e) {
            
        }
        return conexion;
    }
}
