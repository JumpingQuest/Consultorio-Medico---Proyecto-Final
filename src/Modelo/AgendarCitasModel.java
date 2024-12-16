/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author rober
 */
public class AgendarCitasModel {
    
    public boolean registrarCita(String curp, Time hora, Date fecha, Connection conn) throws Exception {
    // Consulta para obtener datos del paciente desde la tabla Pacientes
    String queryPaciente = "SELECT nombre, apellido, correo, telefono FROM Pacientes WHERE curp = ?";
    
    // Consulta para insertar la cita en HistorialCitas (añadimos curp_paciente)
    String queryInsertCita = "INSERT INTO HistorialCitas (hora, fecha, estatus, nombre_paciente, apellidos_paciente, correo_paciente, telefono_paciente, curp_paciente) "
                            + "VALUES (?, ?, 'Confirmada', ?, ?, ?, ?, ?)";

    try (PreparedStatement pstmtPaciente = conn.prepareStatement(queryPaciente)) {
        // Buscar los datos del paciente
        pstmtPaciente.setString(1, curp);
        ResultSet rs = pstmtPaciente.executeQuery();
        
        if (rs.next()) {
            // Datos del paciente
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellido");
            String correo = rs.getString("correo");
            String telefono = rs.getString("telefono");

            // Registrar la cita en HistorialCitas
            try (PreparedStatement pstmtCita = conn.prepareStatement(queryInsertCita)) {
                pstmtCita.setTime(1, hora);
                pstmtCita.setDate(2, (java.sql.Date) fecha);
                pstmtCita.setString(3, nombre);
                pstmtCita.setString(4, apellidos);
                pstmtCita.setString(5, correo);
                pstmtCita.setString(6, telefono);
                pstmtCita.setString(7, curp); // Insertamos el CURP del paciente en curp_paciente
                pstmtCita.executeUpdate();
                return true; // Registro exitoso
            }
        } else {
            throw new Exception("No se encontró un paciente con la CURP proporcionada.");
        }
    }
}

    
    public boolean verificarCitaExistente(Time hora, Date fecha, Connection conn) throws Exception {
    String query = "SELECT COUNT(*) AS total FROM HistorialCitas WHERE hora = ? AND fecha = ? AND estatus = 'Confirmada'";
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setTime(1, hora);
        pstmt.setDate(2, (java.sql.Date) fecha);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            int total = rs.getInt("total");
            return total > 0; // Retorna true si existe al menos una cita "Confirmada"
        }
    }
    return false; // No hay conflicto
}

    public boolean cancelarCita(String curp, Time hora, Date fecha, Connection conn) throws Exception {
    String query = "UPDATE HistorialCitas SET estatus = 'Cancelada' " +
                   "WHERE curp_paciente = ? AND hora = ? AND fecha = ? AND estatus = 'Confirmada'";

    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, curp);
        pstmt.setTime(2, hora);
        pstmt.setDate(3, (java.sql.Date) fecha);

        int filasActualizadas = pstmt.executeUpdate();
        return filasActualizadas > 0; // True si se actualizó la cita
    }
}


   public boolean verificarCitaCancelada(String curp, Time hora, Date fecha, Connection conn) throws Exception {
    String query = "SELECT COUNT(*) AS total FROM HistorialCitas " +
                   "WHERE curp_paciente = ? AND hora = ? AND fecha = ? AND estatus = 'Cancelada'";

    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, curp);
        pstmt.setTime(2, hora);
        pstmt.setDate(3, (java.sql.Date) fecha);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("total") > 0; // True si la cita ya fue cancelada
        }
    }
    return false;
}

public ArrayList<String> obtenerCitasPorFecha(java.sql.Date fecha, Connection conn) throws Exception {
    ArrayList<String> citas = new ArrayList<>();
    String query = "SELECT nombre_paciente, apellidos_paciente, hora, telefono_paciente, correo_paciente " +
                   "FROM HistorialCitas WHERE fecha = ? AND estatus = 'Confirmada'";

    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setDate(1, fecha);
        ResultSet rs = pstmt.executeQuery();

        int contador = 1;
        while (rs.next()) {
            String nombre = rs.getString("nombre_paciente");
            String apellidos = rs.getString("apellidos_paciente");
            String hora = rs.getTime("hora").toString();
            String telefono = rs.getString("telefono_paciente");
            String correo = rs.getString("correo_paciente");

            // Formatear la cita SIN incluir la fecha
            String cita = contador + ".- El paciente " + nombre + " " + apellidos +
                          " tiene una cita a las " + hora + " horas.\n" +
                          "Teléfono de contacto: " + telefono + "\n" +
                          "Correo: " + correo + "\n";
            citas.add(cita);
            contador++;
        }
    }
    return citas;
}

    
    public ArrayList<String> obtenerTodasLasCitas(Connection conn) throws Exception {
    ArrayList<String> citas = new ArrayList<>();
    String query = "SELECT nombre_paciente, apellidos_paciente, fecha, hora, telefono_paciente, correo_paciente " +
                   "FROM HistorialCitas WHERE estatus = 'Confirmada'";

    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        ResultSet rs = pstmt.executeQuery();
        int contador = 1;
        while (rs.next()) {
            String nombre = rs.getString("nombre_paciente");
            String apellidos = rs.getString("apellidos_paciente");
            String fecha = rs.getDate("fecha").toString();
            String hora = rs.getTime("hora").toString();
            String telefono = rs.getString("telefono_paciente");
            String correo = rs.getString("correo_paciente");

            // Formatear la salida
            String cita = contador + ".- El paciente " + nombre + " " + apellidos +
                          " realizó una cita el día " + fecha + " a las " + hora + " horas.\n" +
                          "Teléfono de contacto: " + telefono + "\n" +
                          "Correo: " + correo + "\n";
            citas.add(cita);
            contador++;
        }
    }
    return citas;
}

    
}
