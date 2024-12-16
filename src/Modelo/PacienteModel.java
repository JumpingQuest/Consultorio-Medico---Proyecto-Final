/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author rober
 */

import ConexionPostgreSQL.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PacienteModel {

    public boolean insertarPaciente(String nombre, String apellido, String curp, Date fechaNacimiento, String sexo, String correo, String telefono, String direccion) {
        String query = "INSERT INTO pacientes (nombre, apellido, curp, fecha_nacimiento, sexo, correo, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, curp);
            ps.setDate(4, fechaNacimiento);
            ps.setString(5, sexo);
            ps.setString(6, correo);
            ps.setString(7, telefono);
            ps.setString(8, direccion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar paciente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPaciente(String curp) {
        String query = "DELETE FROM pacientes WHERE curp = ?";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, curp);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar paciente: " + e.getMessage());
            return false;
        }
    }

    public List<String[]> cargarPacientes() {
        List<String[]> pacientes = new ArrayList<>();
        String query = "SELECT * FROM pacientes";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                pacientes.add(new String[]{
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("curp"),
                        rs.getDate("fecha_nacimiento").toString(),
                        rs.getString("sexo"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar pacientes: " + e.getMessage());
        }
        return pacientes;
    }

    public List<String[]> buscarPacientes(String nombre, String apellido, String curp, String correo) {
        List<String[]> pacientes = new ArrayList<>();
        String query = "SELECT * FROM pacientes WHERE 1=1";
        if (!nombre.isEmpty()) query += " AND nombre ILIKE ?";
        if (!apellido.isEmpty()) query += " AND apellido ILIKE ?";
        if (!curp.isEmpty()) query += " AND curp = ?";
        if (!correo.isEmpty()) query += " AND correo ILIKE ?";

        try (Connection conn = ConexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            int index = 1;
            if (!nombre.isEmpty()) ps.setString(index++, "%" + nombre + "%");
            if (!apellido.isEmpty()) ps.setString(index++, "%" + apellido + "%");
            if (!curp.isEmpty()) ps.setString(index++, curp);
            if (!correo.isEmpty()) ps.setString(index++, "%" + correo + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pacientes.add(new String[]{
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("curp"),
                            rs.getDate("fecha_nacimiento").toString(),
                            rs.getString("sexo"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("direccion")
                    });
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar pacientes: " + e.getMessage());
        }
        return pacientes;
    }
    
    public HashMap<String, Object> obtenerDatosPaciente(String curp, Connection conn) throws SQLException {
        String query = "SELECT hc.fecha AS fecha_cita, hc.hora, " +
                       "CONCAT(hc.nombre_paciente, ' ', hc.apellidos_paciente) AS nombre_completo, " +
                       "hc.telefono_paciente, hc.correo_paciente, p.fecha_nacimiento, p.sexo " +
                       "FROM HistorialCitas hc " +
                       "JOIN Pacientes p ON hc.curp_paciente = p.curp " +
                       "WHERE hc.curp_paciente = ? AND hc.estatus = 'Confirmada' " +
                       "ORDER BY hc.fecha DESC, hc.hora DESC LIMIT 1";

        HashMap<String, Object> datosPaciente = new HashMap<>();

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, curp);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                datosPaciente.put("fecha", rs.getDate("fecha_cita"));
                datosPaciente.put("hora", rs.getTime("hora"));
                datosPaciente.put("nombre_completo", rs.getString("nombre_completo"));
                datosPaciente.put("telefono", rs.getString("telefono_paciente"));
                datosPaciente.put("correo", rs.getString("correo_paciente"));
                datosPaciente.put("fecha_nacimiento", rs.getDate("fecha_nacimiento"));
                datosPaciente.put("sexo", rs.getString("sexo"));
            }
        }
        return datosPaciente;
    }

}
