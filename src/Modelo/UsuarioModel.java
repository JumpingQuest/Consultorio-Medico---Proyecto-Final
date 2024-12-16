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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioModel {
    
    private final Connection conexion;

    public UsuarioModel() {
        this.conexion = ConexionPostgreSQL.ConexionDB.conectar();
    }
    
   public boolean guardarUsuario(String nombre, String apellido, String curp, Date fechaNacimiento, String correo, String tipoUsuario, String contrasena, String codigoAutorizacion) {
    String query = "INSERT INTO usuarios (nombre, apellido, curp, fecha_nacimiento, correo, tipo_usuario, contrasena, codigo_autorizacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conexion = ConexionPostgreSQL.ConexionDB.conectar();
         PreparedStatement pst = conexion.prepareStatement(query)) {

        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, curp);
        pst.setDate(4, (java.sql.Date) fechaNacimiento);
        pst.setString(5, correo);
        pst.setString(6, tipoUsuario);
        pst.setString(7, contrasena);
        pst.setString(8, codigoAutorizacion);

        int filasAfectadas = pst.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException e) {
        if (e.getSQLState().equals("23505")) { // Código de error para valores duplicados en PostgreSQL
            if (e.getMessage().contains("curp")) {
                JOptionPane.showMessageDialog(null, "El CURP ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (e.getMessage().contains("correo")) {
                JOptionPane.showMessageDialog(null, "El correo ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.err.println("Error al guardar usuario: " + e.getMessage());
        }
        return false;
    }
}

   public boolean validarCredenciales(String correo, String contraseña, String tipoUsuario) {
    String query = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ? AND tipo_usuario = ?";
    try (Connection conexion = ConexionPostgreSQL.ConexionDB.conectar();
         PreparedStatement pst = conexion.prepareStatement(query)) {
        pst.setString(1, correo);
        pst.setString(2, contraseña);
        pst.setString(3, tipoUsuario);
        try (var rs = pst.executeQuery()) {
            return rs.next(); // Devuelve true si hay un registro que coincide
        }
    } catch (SQLException e) {
        System.err.println("Error al validar credenciales: " + e.getMessage());
    }
    return false;
}

 //----------------------------METODOS PARA LA TABLA DE USUARIOS---------------------------
    public List<String[]> cargarUsuarios() {
        List<String[]> usuarios = new ArrayList<>();
        String query = "SELECT nombre, apellido, curp, fecha_nacimiento, codigo_autorizacion, correo, tipo_usuario, contrasena FROM usuarios";

        try (PreparedStatement ps = conexion.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String[] usuario = new String[]{
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("curp"),
                    rs.getDate("fecha_nacimiento").toString(),
                    rs.getString("codigo_autorizacion"),
                    rs.getString("correo"),
                    rs.getString("tipo_usuario"),
                    rs.getString("contrasena")
                };
                usuarios.add(usuario);

                // Depuración: Verifica que los datos se están obteniendo correctamente
                //System.out.println(String.join(", ", usuario));
            }
        } catch (SQLException e) {
            //System.err.println("Error al cargar usuarios: " + e.getMessage());
        }

        return usuarios;
    }
   
   // Método para insertar un nuevo usuario
    public boolean insertarUsuario(String nombre, String apellido, String curp, Date fechaNacimiento, String codigo, String correo, String tipoUsuario, String contraseña) {
        String query = "INSERT INTO usuarios (nombre, apellido, curp, fecha_nacimiento, codigo_autorizacion, correo, tipo_usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, curp);
            ps.setDate(4, (java.sql.Date) fechaNacimiento);
            ps.setString(5, codigo);
            ps.setString(6, correo);
            ps.setString(7, tipoUsuario);
            ps.setString(8, contraseña);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }
    
    // Método para eliminar un usuario
    public boolean eliminarUsuario(String curp) {
        String query = "DELETE FROM usuarios WHERE curp = ?";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, curp);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }

    
    // Método para actualizar un usuario
    public boolean actualizarUsuario(String nombre, String apellido, String curp, Date fechaNacimiento, String codigo, String correo, String tipoUsuario, String contraseña) {
        String query = "UPDATE usuarios SET nombre = ?, apellido = ?, fecha_nacimiento = ?, codigo_autorizacion = ?, correo = ?, tipo_usuario = ?, contrasena = ? WHERE curp = ?";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setDate(3, (java.sql.Date) fechaNacimiento);
            ps.setString(4, codigo);
            ps.setString(5, correo);
            ps.setString(6, tipoUsuario);
            ps.setString(7, contraseña);
            ps.setString(8, curp);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }
    
  
    public List<String[]> buscarUsuarios(String nombre, String apellido, String curp, String codigo, String correo) {
    List<String[]> usuarios = new ArrayList<>();
    String query = "SELECT nombre, apellido, curp, fecha_nacimiento, codigo_autorizacion, correo, tipo_usuario, contrasena FROM usuarios WHERE 1=1";

    // Construye dinámicamente la consulta según los criterios
    if (!nombre.isEmpty()) query += " AND nombre ILIKE ?";
    if (!apellido.isEmpty()) query += " AND apellido ILIKE ?";
    if (!curp.isEmpty()) query += " AND curp = ?";
    if (!codigo.isEmpty()) query += " AND codigo_autorizacion = ?";
    if (!correo.isEmpty()) query += " AND correo ILIKE ?";

    try (Connection conn = ConexionDB.conectar();
         PreparedStatement ps = conn.prepareStatement(query)) {

        int index = 1;
        if (!nombre.isEmpty()) ps.setString(index++, "%" + nombre + "%");
        if (!apellido.isEmpty()) ps.setString(index++, "%" + apellido + "%");
        if (!curp.isEmpty()) ps.setString(index++, curp);
        if (!codigo.isEmpty()) ps.setString(index++, codigo);
        if (!correo.isEmpty()) ps.setString(index++, "%" + correo + "%");

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String[] usuario = {
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("curp"),
                    rs.getDate("fecha_nacimiento").toString(),
                    rs.getString("codigo_autorizacion"),
                    rs.getString("correo"),
                    rs.getString("tipo_usuario"),
                    rs.getString("contrasena")
                };
                usuarios.add(usuario);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar usuarios: " + e.getMessage());
    }

    return usuarios;
}


    
}
