/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author rober
 */


import Modelo.UsuarioModel;
import javax.swing.*;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsuarioController {

    private final UsuarioModel usuarioModel;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
    }

  public boolean validarCampos(String nombre, String apellido, String curp, Date fechaNacimiento, String correo, String tipoUsuario, String contraseña, String confirmarContraseña, String codigoAutorizacion) {
    if (nombre.isEmpty() || apellido.isEmpty() || curp.isEmpty() || fechaNacimiento == null || correo.isEmpty() || tipoUsuario.isEmpty() || contraseña.isEmpty() || confirmarContraseña.isEmpty() || codigoAutorizacion.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        return false;
    }

    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        JOptionPane.showMessageDialog(null, "El nombre no debe contener caracteres numéricos ni especiales.");
        return false;
    }

    if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        JOptionPane.showMessageDialog(null, "El apellido no debe contener caracteres numéricos ni especiales.");
        return false;
    }

    if (curp.length() != 18) {
        JOptionPane.showMessageDialog(null, "El CURP debe tener exactamente 18 caracteres.");
        return false;
    }

    if (!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
        JOptionPane.showMessageDialog(null, "El correo electrónico no tiene un formato válido.");
        return false;
    }

    if (!contraseña.equals(confirmarContraseña)) {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        return false;
    }

    return true;
}

    public boolean guardarUsuario(String nombre, String apellido, String curp, Date fechaNacimiento, String correo, String tipoUsuario, String contraseña, String codigoAutorizacion) {
    return usuarioModel.guardarUsuario(nombre, apellido, curp, fechaNacimiento, correo, tipoUsuario, contraseña, codigoAutorizacion);
}
 //-----------METODOS PARA EL REGISTRO----------   
    public boolean iniciarSesion(String correo, String contraseña, String tipoUsuario) {
    return usuarioModel.validarCredenciales(correo, contraseña, tipoUsuario);
}
//-----------METODOS PARA EL iNICIO DE SESION----------
    
    // Método para insertar un usuario
    public boolean insertarUsuario(String nombre, String apellido, String curp, Date fechaNacimiento, String codigo, String correo, String tipoUsuario, String contraseña) {
        return usuarioModel.insertarUsuario(nombre, apellido, curp, fechaNacimiento, codigo, correo, tipoUsuario, contraseña);
    }

    // Método para eliminar un usuario
    public boolean eliminarUsuario(String curp) {
        return usuarioModel.eliminarUsuario(curp);
    }

    // Método para actualizar un usuario
    public boolean actualizarUsuario(String nombre, String apellido, String curp, Date fechaNacimiento, String codigo, String correo, String tipoUsuario, String contraseña) {
        return usuarioModel.actualizarUsuario(nombre, apellido, curp, fechaNacimiento, codigo, correo, tipoUsuario, contraseña);
    }
    
    public List<String[]> buscarUsuarios(String nombre, String apellido, String curp, String codigo, String correo) {
    return usuarioModel.buscarUsuarios(nombre, apellido, curp, codigo, correo);
}


    public DefaultTableModel cargarUsuariosEnTabla() {
    UsuarioModel usuarioModel = new UsuarioModel();
    List<String[]> usuarios = usuarioModel.cargarUsuarios();

    // Define las columnas del modelo de tabla
    String[] columnas = {"Nombre", "Apellido", "CURP", "Fecha de nacimiento", "Codigo", "Correo", "Tipo de cuenta", "Contraseña"};
    DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

    // Agrega los datos al modelo
    for (String[] usuario : usuarios) {
        modeloTabla.addRow(usuario);
    }

    return modeloTabla;
}

    
    
}
