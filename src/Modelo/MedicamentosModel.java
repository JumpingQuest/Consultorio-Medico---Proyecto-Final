/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import ConexionPostgreSQL.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author rober
 */
public class MedicamentosModel {
 
    public boolean insertarMedicamento(String nombre, String presentacion, String tipoVenta, double precio, int unidades) {
        String sql = "INSERT INTO medicamentos (nombre, presentacion, tipo_venta, precio, unidades) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, presentacion);
            ps.setString(3, tipoVenta);
            ps.setDouble(4, precio);
            ps.setInt(5, unidades);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMedicamento(String nombre) {
        String sql = "DELETE FROM medicamentos WHERE nombre = ?";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String[]> buscarMedicamentos(String nombre, String presentacion, String tipoVenta) {
    List<String[]> medicamentos = new ArrayList<>();
    String sql = "SELECT * FROM medicamentos WHERE 1=1";

    if (nombre != null && !nombre.isEmpty()) sql += " AND nombre ILIKE ?";
    if (presentacion != null && !presentacion.isEmpty()) sql += " AND presentacion ILIKE ?";
    if (tipoVenta != null && !tipoVenta.isEmpty()) sql += " AND tipo_venta ILIKE ?";

    try (Connection conexion = ConexionDB.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        int index = 1;

        if (nombre != null && !nombre.isEmpty()) ps.setString(index++, "%" + nombre + "%");
        if (presentacion != null && !presentacion.isEmpty()) ps.setString(index++, "%" + presentacion + "%");
        if (tipoVenta != null && !tipoVenta.isEmpty()) ps.setString(index++, "%" + tipoVenta + "%");

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                medicamentos.add(new String[]{
                    rs.getString("nombre"),
                    rs.getString("presentacion"),
                    rs.getString("tipo_venta"),
                    String.valueOf(rs.getDouble("precio")),
                    String.valueOf(rs.getInt("unidades"))
                });
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return medicamentos;
}


    public void cargarMedicamentosEnTabla(DefaultTableModel modeloTabla) {
        String sql = "SELECT * FROM medicamentos";
try (Connection conexion = ConexionDB.conectar();
     PreparedStatement ps = conexion.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {
    while (rs.next()) {
        modeloTabla.addRow(new Object[]{
            rs.getString("nombre"),
            rs.getString("presentacion"),
            rs.getString("tipo_venta"),
            rs.getDouble("precio"),
            rs.getInt("unidades")
        });
    }
} catch (SQLException e) {
    e.printStackTrace();
}

    }
    
}
