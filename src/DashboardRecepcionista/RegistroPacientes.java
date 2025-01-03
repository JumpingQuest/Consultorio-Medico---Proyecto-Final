/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DashboardRecepcionista;
import Controlador.PacienteController;
import Vista.InicioDeSesion;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rober
 */
public class RegistroPacientes extends javax.swing.JFrame {

  private final PacienteController pacienteController = new PacienteController();

    public RegistroPacientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarPacientesEnTabla();
    }
   
   // Método para cargar pacientes en la tabla
    private void cargarPacientesEnTabla() {
        DefaultTableModel modeloTabla = pacienteController.cargarPacientesEnTabla();
        if (modeloTabla != null) {
            TablaPacientes.setModel(modeloTabla);
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de pacientes.", "Error", JOptionPane.ERROR_MESSAGE);
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

        Sexo = new javax.swing.ButtonGroup();
        btnCerrarSesion = new javax.swing.JButton();
        btnBuscarP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();
        btnUsuarios = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnMedicos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAnadirP = new javax.swing.JButton();
        btnLimpiarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        jDateNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        buttonHombre = new javax.swing.JRadioButton();
        buttonMujer = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnMostrarTodo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
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

        btnBuscarP.setText("Buscar");
        btnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 810, -1, -1));

        TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "CURP", "Fecha de nacimiento", "Sexo", "Correo", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPacientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 490, 650));

        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUsuarios.setText("Registrar pacientes");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 170, 30));

        btnPacientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPacientes.setText("Citas agendadas");
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 170, 30));

        btnMedicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMedicos.setText("Agendar cita");
        btnMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicosActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 170, 30));

        jPanel2.setBackground(new java.awt.Color(233, 240, 218));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 220, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel8.setText("Direccion:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        btnAnadirP.setText("Añadir");
        btnAnadirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirPActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnadirP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        btnLimpiarP.setText("Limpiar");
        btnLimpiarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));

        btnEliminarP.setText("Eliminar");
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel7.setText("Apellido:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 220, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel11.setText("CURP:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel10.setText("Fecha de nacimiento:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 220, -1));
        jPanel2.add(txtCURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 230, -1));
        txtCURP.getAccessibleContext().setAccessibleName("");

        jPanel2.add(jDateNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 150, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel12.setText("Sexo:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel13.setText("Correo:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 230, -1));

        Sexo.add(buttonHombre);
        buttonHombre.setSelected(true);
        buttonHombre.setText("Hombre");
        buttonHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHombreActionPerformed(evt);
            }
        });
        jPanel2.add(buttonHombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        Sexo.add(buttonMujer);
        buttonMujer.setText("Mujer");
        buttonMujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMujerActionPerformed(evt);
            }
        });
        jPanel2.add(buttonMujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel14.setText("Telefono:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 220, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 360, 500));

        btnMostrarTodo.setText("Mostrar todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 810, -1, -1));

        jPanel3.setBackground(new java.awt.Color(143, 158, 138));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATOS DEL PACIENTE ");
        jPanel3.add(jLabel9);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 360, 30));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel5.setText("REGISTRO DE PACIENTES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, 40));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DashboardMedicamentos.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnAnadirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirPActionPerformed
java.util.Date fechaSeleccionada = jDateNacimiento.getDate();
java.sql.Date fechaNacimiento = null; // Declaración fuera del bloque if

if (fechaSeleccionada != null) {
    fechaNacimiento = new java.sql.Date(fechaSeleccionada.getTime());
} else {
    JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha de nacimiento.", "Error", JOptionPane.ERROR_MESSAGE);
    return; // Detiene la ejecución si no hay fecha
}

String nombre = txtNombre.getText().trim();
String apellido = txtApellido.getText().trim();
String curp = txtCURP.getText().trim();
String sexo = buttonHombre.isSelected() ? "Hombre" : "Mujer"; 
String correo = txtCorreo.getText().trim();
String telefono = txtTelefono.getText().trim();
String direccion = txtDireccion.getText().trim();

if (pacienteController.insertarPaciente(nombre, apellido, curp, fechaNacimiento, sexo, correo, telefono, direccion)) {
    JOptionPane.showMessageDialog(this, "Paciente añadido correctamente.");
    cargarPacientesEnTabla();
    limpiarCampos();
} else {
    JOptionPane.showMessageDialog(this, "Error al añadir el paciente.");
}
   
    }//GEN-LAST:event_btnAnadirPActionPerformed

    private void TablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPacientesMouseClicked

    int filaSeleccionada = TablaPacientes.getSelectedRow();
    if (filaSeleccionada >= 0) {
        txtNombre.setText(TablaPacientes.getValueAt(filaSeleccionada, 0).toString());
        txtApellido.setText(TablaPacientes.getValueAt(filaSeleccionada, 1).toString());
        txtCURP.setText(TablaPacientes.getValueAt(filaSeleccionada, 2).toString());
        
        Object fechaNacimiento = TablaPacientes.getValueAt(filaSeleccionada, 3);
        if (fechaNacimiento != null && !fechaNacimiento.toString().isEmpty()) {
            try {
                java.sql.Date fecha = java.sql.Date.valueOf(fechaNacimiento.toString());
                jDateNacimiento.setDate(fecha);
            } catch (Exception e) {
                jDateNacimiento.setDate(null);
            }
        } else {
            jDateNacimiento.setDate(null);
        }
        
        String sexo = TablaPacientes.getValueAt(filaSeleccionada, 4).toString();
        if ("Hombre".equals(sexo)) {
            buttonHombre.setSelected(true);
        } else if ("Mujer".equals(sexo)) {
            buttonMujer.setSelected(true);
        }
        
        txtCorreo.setText(TablaPacientes.getValueAt(filaSeleccionada, 5).toString());
        txtTelefono.setText(TablaPacientes.getValueAt(filaSeleccionada, 6).toString());
        txtDireccion.setText(TablaPacientes.getValueAt(filaSeleccionada, 7).toString());
    }

        
    }//GEN-LAST:event_TablaPacientesMouseClicked

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed

         int filaSeleccionada = TablaPacientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String curp = TablaPacientes.getValueAt(filaSeleccionada, 2).toString();

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este paciente?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                if (pacienteController.eliminarPaciente(curp)) {
                    JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.");
                    cargarPacientesEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el paciente.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un paciente para eliminar.");
        }
        
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnLimpiarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPActionPerformed
        limpiarCampos();  
    }//GEN-LAST:event_btnLimpiarPActionPerformed

    private void btnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPActionPerformed

         String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String curp = txtCURP.getText().trim();
        String correo = txtCorreo.getText().trim();

        if (nombre.isEmpty() && apellido.isEmpty() && curp.isEmpty() && correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa al menos un criterio de búsqueda.");
            return;
        }

        DefaultTableModel modeloTabla = pacienteController.buscarPacientes(nombre, apellido, curp, correo);
        if (modeloTabla != null && modeloTabla.getRowCount() > 0) {
            TablaPacientes.setModel(modeloTabla);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes con los criterios proporcionados.");
        }
        
    }//GEN-LAST:event_btnBuscarPActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        // TODO add your handling code here:
        CitasAgendadas citAgen = new CitasAgendadas();
        citAgen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        cargarPacientesEnTabla();        
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void buttonHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHombreActionPerformed

    private void buttonMujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMujerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMujerActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicosActionPerformed
        // TODO add your handling code here:
        AgendarCitas agendCits = new AgendarCitas();
        agendCits.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMedicosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        dispose();
        InicioDeSesion inSes = new InicioDeSesion();
        inSes.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCURP.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        jDateNacimiento.setDate(null);
        buttonHombre.setSelected(true);
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
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Sexo;
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JButton btnAnadirP;
    private javax.swing.JButton btnBuscarP;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnLimpiarP;
    private javax.swing.JButton btnMedicos;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JRadioButton buttonHombre;
    private javax.swing.JRadioButton buttonMujer;
    private com.toedter.calendar.JDateChooser jDateNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
