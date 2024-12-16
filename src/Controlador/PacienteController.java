/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author rober
 */
import ConexionPostgreSQL.ConexionDB;
import Modelo.PacienteModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PacienteController {

   private final PacienteModel pacienteModel;

    public PacienteController() {
        pacienteModel = new PacienteModel();
    }

    public boolean insertarPaciente(String nombre, String apellido, String curp, Date fechaNacimiento, String sexo, String correo, String telefono, String direccion) {
        return pacienteModel.insertarPaciente(nombre, apellido, curp, fechaNacimiento, sexo, correo, telefono, direccion);
    }

    public boolean eliminarPaciente(String curp) {
        return pacienteModel.eliminarPaciente(curp);
    }

    public DefaultTableModel cargarPacientesEnTabla() {
        List<String[]> pacientes = pacienteModel.cargarPacientes();
        String[] columnas = {"Nombre", "Apellido", "CURP", "Fecha de nacimiento", "Sexo", "Correo", "Teléfono", "Dirección"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (String[] paciente : pacientes) {
            modeloTabla.addRow(paciente);
        }

        return modeloTabla;
    }

    public DefaultTableModel buscarPacientes(String nombre, String apellido, String curp, String correo) {
        List<String[]> pacientes = pacienteModel.buscarPacientes(nombre, apellido, curp, correo);
        String[] columnas = {"Nombre", "Apellido", "CURP", "Fecha de nacimiento", "Sexo", "Correo", "Teléfono", "Dirección"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (String[] paciente : pacientes) {
            modeloTabla.addRow(paciente);
        }

        return modeloTabla;
    }
    
public void cargarDatosPaciente(String curp, JTextField txtFecha, JTextField txtHora, JTextField txtNombre,
                                JTextField txtTelefono, JTextField txtCorreo, JDateChooser fechaNacimientoChooser,
                                JRadioButton rdbHombre, JRadioButton rdbMujer, Connection conn) {
    try {
        // Obtener datos del modelo
        HashMap<String, Object> datos = pacienteModel.obtenerDatosPaciente(curp, conn);

        // Rellenar campos
        txtFecha.setText(datos.get("fecha").toString());
        txtHora.setText(datos.get("hora").toString());
        txtNombre.setText(datos.get("nombre_completo").toString());
        txtTelefono.setText(datos.get("telefono").toString());
        txtCorreo.setText(datos.get("correo").toString());

        // Fecha de nacimiento en JDateChooser
        java.util.Date fechaNacimiento = (java.util.Date) datos.get("fecha_nacimiento");
        if (fechaNacimiento != null) {
            fechaNacimientoChooser.setDate(fechaNacimiento);
        }

        // Sexo
        String sexo = (String) datos.get("sexo");
        rdbHombre.setSelected("H".equalsIgnoreCase(sexo));
        rdbMujer.setSelected("M".equalsIgnoreCase(sexo));

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos del paciente: " + ex.getMessage());
    }
}

public boolean modificarPaciente(String curp, String correo, String telefono, String direccion) {
    String query = "UPDATE Pacientes SET correo = ?, telefono = ?, direccion = ? WHERE curp = ?";
    try (Connection conn = ConexionDB.conectar();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, correo);
        pstmt.setString(2, telefono);
        pstmt.setString(3, direccion);
        pstmt.setString(4, curp);

        int filasAfectadas = pstmt.executeUpdate();
        return filasAfectadas > 0;
    } catch (Exception e) {
        System.out.println("Error al modificar paciente: " + e.getMessage());
        return false;
    }
}

public String obtenerCorreoDesdeDB(String curp) {
    String correo = "";
    try (Connection conn = ConexionDB.conectar()) {
        String query = "SELECT correo FROM pacientes WHERE curp = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, curp);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            correo = rs.getString("correo");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el correo: " + e.getMessage());
    }
    return correo;
}


    
}
