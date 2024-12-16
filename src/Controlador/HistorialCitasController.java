/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ConexionPostgreSQL.ConexionDB;
import Modelo.HistorialCitasModel;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.PreparedStatement;

public class HistorialCitasController {
    private final HistorialCitasModel model;

    public HistorialCitasController() {
        this.model = new HistorialCitasModel();
    }

    // Método para obtener citas por fecha y retornar como lista
    public ArrayList<String> obtenerCitasPorFecha(Date fecha, Connection conn) {
        try {
            return model.obtenerCitasPorFecha(fecha, conn);
        } catch (Exception e) {
            System.err.println("Error al obtener citas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public ArrayList<HashMap<String, String>> obtenerCitas(Connection conn) {
        try {
            return model.obtenerTodasLasCitas(conn);
        } catch (Exception e) {
            System.err.println("Error al obtener citas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
  public ArrayList<HashMap<String, String>> buscarCitas(String curp, Date fecha, String hora) {
    try (Connection conn = ConexionDB.conectar()) {
        HistorialCitasModel modelo = new HistorialCitasModel();
        return modelo.buscarCitas(curp, fecha, hora, conn);
    } catch (Exception e) {
        System.err.println("Error al buscar citas: " + e.getMessage());
        return new ArrayList<>();
    }
}

public boolean eliminarCita(String curp, String fecha, String hora, Connection conn) {
    String query = "DELETE FROM HistorialCitas WHERE curp_paciente = ? AND fecha = ? AND hora = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, curp);
        pstmt.setDate(2, java.sql.Date.valueOf(fecha)); // Convertir a java.sql.Date
        pstmt.setTime(3, java.sql.Time.valueOf(hora)); // Convertir a java.sql.Time

        int filasAfectadas = pstmt.executeUpdate();
        return filasAfectadas > 0; // Devuelve true si al menos una fila fue eliminada
    } catch (Exception e) {
        System.out.println("Error al eliminar la cita: " + e.getMessage());
        return false;
    }
}

    
}
