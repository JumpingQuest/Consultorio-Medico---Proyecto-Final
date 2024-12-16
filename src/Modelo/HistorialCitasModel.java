/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Time;

public class HistorialCitasModel {
    // Método para obtener citas por fecha
    public ArrayList<String> obtenerCitasPorFecha(Date fecha, Connection conn) throws Exception {
        ArrayList<String> citas = new ArrayList<>();
        String query = "SELECT hora, nombre_paciente, apellidos_paciente, estatus " +
                       "FROM HistorialCitas WHERE fecha = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, fecha);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String hora = rs.getTime("hora").toString();
                String nombre = rs.getString("nombre_paciente");
                String apellido = rs.getString("apellidos_paciente");
                String estatus = rs.getString("estatus");

                // Formato de la cita
                String cita = String.format("- Hora: %s\n  Paciente: %s %s\n  Estatus: %s\n",
                                            hora, nombre, apellido, estatus);
                citas.add(cita);
            }
        }
        return citas;
    }
    
    public ArrayList<HashMap<String, String>> obtenerTodasLasCitas(Connection conn) throws Exception {
        ArrayList<HashMap<String, String>> listaCitas = new ArrayList<>();
        String query = "SELECT hora, fecha, estatus, nombre_paciente, apellidos_paciente, correo_paciente, " +
                       "telefono_paciente, curp_paciente FROM HistorialCitas";

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                HashMap<String, String> cita = new HashMap<>();
                cita.put("hora", rs.getTime("hora").toString());
                cita.put("fecha", rs.getDate("fecha").toString());
                cita.put("estatus", rs.getString("estatus"));
                cita.put("nombre", rs.getString("nombre_paciente"));
                cita.put("apellido", rs.getString("apellidos_paciente"));
                cita.put("correo", rs.getString("correo_paciente"));
                cita.put("telefono", rs.getString("telefono_paciente"));
                cita.put("curp", rs.getString("curp_paciente"));
                listaCitas.add(cita);
            }
        }
        return listaCitas;
    }
    
   public ArrayList<HashMap<String, String>> buscarCitas(String curp, Date fecha, String hora, Connection conn) throws Exception {
    ArrayList<HashMap<String, String>> listaCitas = new ArrayList<>();
    StringBuilder query = new StringBuilder("SELECT hora, fecha, estatus, nombre_paciente, apellidos_paciente, correo_paciente, telefono_paciente, curp_paciente FROM HistorialCitas WHERE 1=1");

    // Construir el query dinámico según los filtros
    if (!curp.isEmpty()) query.append(" AND curp_paciente = ?");
    if (fecha != null) query.append(" AND fecha = ?");
    if (!hora.isEmpty()) query.append(" AND hora = ?");

    try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
        int index = 1; // Contador para los parámetros dinámicos

        if (!curp.isEmpty()) pstmt.setString(index++, curp);
        if (fecha != null) pstmt.setDate(index++, fecha);
        if (!hora.isEmpty()) pstmt.setTime(index++, Time.valueOf(hora));

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                HashMap<String, String> cita = new HashMap<>();
                cita.put("hora", rs.getTime("hora").toString());
                cita.put("fecha", rs.getDate("fecha").toString());
                cita.put("estatus", rs.getString("estatus"));
                cita.put("nombre", rs.getString("nombre_paciente"));
                cita.put("apellido", rs.getString("apellidos_paciente"));
                cita.put("correo", rs.getString("correo_paciente"));
                cita.put("telefono", rs.getString("telefono_paciente"));
                cita.put("curp", rs.getString("curp_paciente"));
                listaCitas.add(cita);
            }
        }
    }
    return listaCitas;
}


    
}
