/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DashboardAdministrador;
import Controlador.UsuarioController;
import Vista.InicioDeSesion;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rober
 */
public class Inicio extends javax.swing.JFrame {

    private final UsuarioController usuarioController = new UsuarioController();
    
    public Inicio() {
    initComponents();
    this.setLocationRelativeTo(null);
    cargarUsuariosEnTabla();
    jPwContrasena.setEchoChar((char) 0);
}

    // Método para cargar usuarios
private void cargarUsuariosEnTabla() {
    DefaultTableModel modeloTabla = usuarioController.cargarUsuariosEnTabla();
    if (modeloTabla != null) {
        TablaUsuarios.setModel(modeloTabla);
    } else {
        JOptionPane.showMessageDialog(this, "Error al cargar los datos de usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrarSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        btnUsuarios = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();
        btnMedicamentos = new javax.swing.JButton();
        txtFcodigo = new javax.swing.JTextField();
        txtFNombre = new javax.swing.JTextField();
        txtFApellido = new javax.swing.JTextField();
        txtFCurp = new javax.swing.JTextField();
        txtFCorreo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnLimpiarFields = new javax.swing.JButton();
        btnLimpiarFields1 = new javax.swing.JButton();
        jDate = new com.toedter.calendar.JDateChooser();
        combxTipoUser = new javax.swing.JComboBox<>();
        jPwContrasena = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(970, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 810, 170, 30));

        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "CURP", "Fecha de nacimiento", "Codigo", "Correo", "Tipo de cuenta", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 880, 360));

        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUsuarios.setText("Usuarios");
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 170, 30));

        btnPacientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPacientes.setText("Pacientes");
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 170, 30));

        btnCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCitas.setText("Citas");
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });
        getContentPane().add(btnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 170, 30));

        btnMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMedicamentos.setText("Medicamentos");
        btnMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicamentosActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 170, 30));
        getContentPane().add(txtFcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 190, -1));

        txtFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 290, -1));

        txtFApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFApellidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 330, -1));
        getContentPane().add(txtFCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 130, -1));
        getContentPane().add(txtFCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 250, -1));
        txtFCorreo.getAccessibleContext().setAccessibleName("");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 410, -1, -1));

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, -1, -1));

        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, -1));

        btnLimpiarFields.setText("Limpiar");
        btnLimpiarFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFieldsActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiarFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, -1, -1));

        btnLimpiarFields1.setText("Mostrar todo");
        btnLimpiarFields1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFields1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiarFields1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 410, -1, -1));
        getContentPane().add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 150, -1));

        combxTipoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "MEDICO", "RECEPCIONISTA" }));
        combxTipoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combxTipoUserActionPerformed(evt);
            }
        });
        getContentPane().add(combxTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 330, 250, -1));
        getContentPane().add(jPwContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 240, -1));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel13.setText("Contraseña:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel12.setText("Tipo de cuenta:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel11.setText("Correo electronico:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel10.setText("Codigo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel9.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel8.setText("CURP:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel7.setText("Apellido:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setText("Nombre:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel5.setText("USUARIOS REGISTRADOS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Cuenta");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("MEDICAL CENTER");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("VITALIS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dashboard Admin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
        // TODO add your handling code here:
        HistorialCitas hC = new HistorialCitas();
        hC.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicamentosActionPerformed
        // TODO add your handling code here:
        Medicamentos medi = new Medicamentos();
        medi.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMedicamentosActionPerformed

    private void txtFApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFApellidoActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed

    // Habilitar el campo del correo electrónico para añadir un nuevo usuario
    txtFCorreo.setEnabled(true);

    String nombre = txtFNombre.getText().trim();
    String apellido = txtFApellido.getText().trim();
    String curp = txtFCurp.getText().trim();
    String codigo = txtFcodigo.getText().trim();
    String correo = txtFCorreo.getText().trim();
    String tipoUsuario = combxTipoUser.getSelectedItem().toString();
    String contrasena = new String(jPwContrasena.getPassword()).trim();
    java.sql.Date fechaNacimiento = new java.sql.Date(jDate.getDate().getTime());

    if (usuarioController.insertarUsuario(nombre, apellido, curp, fechaNacimiento, codigo, correo, tipoUsuario, contrasena)) {
        JOptionPane.showMessageDialog(this, "Usuario añadido correctamente.");
        cargarUsuariosEnTabla(); // Actualizar la tabla
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "Error al añadir el usuario.");
    }

    }//GEN-LAST:event_btnAnadirActionPerformed

    private void TablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaUsuariosMouseClicked

    // Verifica si es un clic o doble clic
    if (evt.getClickCount() == 1) { // Cambiar a == 2 si solo necesitas que funcione con doble clic
        // Obtiene la fila seleccionada
        int filaSeleccionada = TablaUsuarios.getSelectedRow();

        // Verifica que se haya seleccionado una fila válida
        if (filaSeleccionada >= 0) {
            // Extrae y asigna cada valor de la tabla a su campo correspondiente
            txtFNombre.setText(TablaUsuarios.getValueAt(filaSeleccionada, 0).toString());
            txtFApellido.setText(TablaUsuarios.getValueAt(filaSeleccionada, 1).toString());
            txtFCurp.setText(TablaUsuarios.getValueAt(filaSeleccionada, 2).toString());

            // Convertir la fecha de nacimiento si está presente
            Object fechaNacimiento = TablaUsuarios.getValueAt(filaSeleccionada, 3);
            if (fechaNacimiento != null && !fechaNacimiento.toString().isEmpty()) {
                try {
                    java.sql.Date fecha = java.sql.Date.valueOf(fechaNacimiento.toString());
                    jDate.setDate(fecha);
                } catch (Exception e) {
                    jDate.setDate(null); // Si hay un error, limpia el campo
                }
            } else {
                jDate.setDate(null);
            }

            txtFcodigo.setText(TablaUsuarios.getValueAt(filaSeleccionada, 4).toString());
            txtFCorreo.setText(TablaUsuarios.getValueAt(filaSeleccionada, 5).toString());
            combxTipoUser.setSelectedItem(TablaUsuarios.getValueAt(filaSeleccionada, 6).toString());
            jPwContrasena.setText(TablaUsuarios.getValueAt(filaSeleccionada, 7).toString());

            // Bloquear el campo del correo electrónico
            txtFCorreo.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro válido.");
        }
    }

    }//GEN-LAST:event_TablaUsuariosMouseClicked

    private void combxTipoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combxTipoUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combxTipoUserActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed

        String nombre = txtFNombre.getText().trim();
    String apellido = txtFApellido.getText().trim();
    String curp = txtFCurp.getText().trim();
    String codigo = txtFcodigo.getText().trim();
    String correo = txtFCorreo.getText().trim();
    String tipoUsuario = combxTipoUser.getSelectedItem().toString();
    String contrasena = new String(jPwContrasena.getPassword()).trim();
    java.sql.Date fechaNacimiento = new java.sql.Date(jDate.getDate().getTime());

    if (usuarioController.actualizarUsuario(nombre, apellido, curp, fechaNacimiento, codigo, correo, tipoUsuario, contrasena)) {
        JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.");
        cargarUsuariosEnTabla(); // Actualizar la tabla
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "Error al modificar el usuario.");
    }
        
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed

    String curp = txtFCurp.getText().trim();

    if (curp.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para eliminar.");
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        if (usuarioController.eliminarUsuario(curp)) {
            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
            cargarUsuariosEnTabla(); // Actualizar la tabla
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.");
        }
    }

    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void txtFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNombreActionPerformed

    private void btnLimpiarFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFieldsActionPerformed
    limpiarCampos();
    }//GEN-LAST:event_btnLimpiarFieldsActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
                                       
    // Obtiene los valores de los campos de texto
    String nombre = txtFNombre.getText().trim();
    String apellido = txtFApellido.getText().trim();
    String curp = txtFCurp.getText().trim();
    String codigo = txtFcodigo.getText().trim();
    String correo = txtFCorreo.getText().trim();

    // Verifica que al menos un criterio de búsqueda tenga un valor
    if (nombre.isEmpty() && apellido.isEmpty() && curp.isEmpty() && codigo.isEmpty() && correo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa al menos un criterio de búsqueda.");
        return;
    }

    // Llama al método buscarUsuarios del controlador
    List<String[]> resultados = usuarioController.buscarUsuarios(nombre, apellido, curp, codigo, correo);

    // Verifica si se encontraron resultados
    if (resultados.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron usuarios con los criterios proporcionados.");
    } else {
        // Limpia la tabla y muestra los resultados
        DefaultTableModel modeloTabla = (DefaultTableModel) TablaUsuarios.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla antes de mostrar los nuevos datos

        for (String[] usuario : resultados) {
            modeloTabla.addRow(usuario); // Agrega los usuarios encontrados a la tabla
        }
    }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarFields1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFields1ActionPerformed
        // TODO add your handling code here:
         cargarUsuariosEnTabla();
    }//GEN-LAST:event_btnLimpiarFields1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        dispose();
        InicioDeSesion inSes = new InicioDeSesion();
        inSes.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        // TODO add your handling code here:
        Pacientes pacientesR = new Pacientes();
        pacientesR.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPacientesActionPerformed

private void limpiarCampos() {
    txtFNombre.setText("");
    txtFApellido.setText("");
    txtFCurp.setText("");
    txtFcodigo.setText("");
    txtFCorreo.setText("");
    jPwContrasena.setText("");
    jDate.setDate(null);
    combxTipoUser.setSelectedIndex(0);

    // Habilitar el campo del correo electrónico
    txtFCorreo.setEnabled(true);
}


    
private String obtenerValorDeCelda(int fila, int columna) {
    Object valor = TablaUsuarios.getValueAt(fila, columna);
    return valor != null ? valor.toString() : "";
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnLimpiarFields;
    private javax.swing.JButton btnLimpiarFields1;
    private javax.swing.JButton btnMedicamentos;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JComboBox<String> combxTipoUser;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPwContrasena;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFApellido;
    private javax.swing.JTextField txtFCorreo;
    private javax.swing.JTextField txtFCurp;
    private javax.swing.JTextField txtFNombre;
    private javax.swing.JTextField txtFcodigo;
    // End of variables declaration//GEN-END:variables
}
