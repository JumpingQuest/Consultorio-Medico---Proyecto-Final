/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DashboardAdministrador;
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
public class Pacientes extends javax.swing.JFrame {

    public Pacientes() {
        initComponents();
        this.setLocationRelativeTo(null);
         cargarPacientesEnTabla();
    }
    
     private final PacienteController pacienteController = new PacienteController();
    
     private void cargarPacientesEnTabla() {
        DefaultTableModel modeloTabla = pacienteController.cargarPacientesEnTabla();
        if (modeloTabla != null) {
            TablaPacientes5.setModel(modeloTabla);
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

        Sexo5 = new javax.swing.ButtonGroup();
        btnCerrarSesion = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        buttonMujer5 = new javax.swing.JRadioButton();
        buttonHombre5 = new javax.swing.JRadioButton();
        txtDireccion5 = new javax.swing.JTextField();
        txtTelefono5 = new javax.swing.JTextField();
        txtCorreo5 = new javax.swing.JTextField();
        jDateNacimiento5 = new com.toedter.calendar.JDateChooser();
        txtCurp5 = new javax.swing.JTextField();
        txtNombre5 = new javax.swing.JTextField();
        txtApellido5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes5 = new javax.swing.JTable();
        btnUsuarios = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();
        btnMedicamentos = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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

        btnLimpiar1.setText("Mostrar todo");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 800, -1, -1));

        Sexo5.add(buttonMujer5);
        buttonMujer5.setText("Mujer");
        buttonMujer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMujer5ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMujer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, -1, -1));

        Sexo5.add(buttonHombre5);
        buttonHombre5.setSelected(true);
        buttonHombre5.setText("Hombre");
        buttonHombre5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHombre5ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonHombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 190, -1, -1));
        getContentPane().add(txtDireccion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 230, -1));
        getContentPane().add(txtTelefono5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 220, -1));

        txtCorreo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo5ActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 230, -1));
        getContentPane().add(jDateNacimiento5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, 150, -1));
        getContentPane().add(txtCurp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 230, -1));

        txtNombre5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre5ActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 230, -1));

        txtApellido5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido5ActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 220, -1));

        TablaPacientes5.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaPacientes5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPacientes5MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPacientes5);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 860, 310));

        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 170, 30));

        btnPacientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPacientes.setText("Pacientes");
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

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, -1, -1));

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 360, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel10.setText("Sexo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 190, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel16.setText("Direcion:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel15.setText("Telefono:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel14.setText("Correo:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel9.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel8.setText("CURP:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel7.setText("Apellido:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setText("Nombre:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel5.setText("PACIENTES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

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
        HistorialCitas historial = new HistorialCitas();
        historial.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicamentosActionPerformed
        // TODO add your handling code here:
        Medicamentos medicamento = new Medicamentos();
        medicamento.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMedicamentosActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
                                      
    String nombre = txtNombre5.getText().trim();
    String apellido = txtApellido5.getText().trim();
    String curp = txtCurp5.getText().trim();
    Date fechaNacimiento = jDateNacimiento5.getDate();
    String sexo = buttonHombre5.isSelected() ? "Hombre" : "Mujer";
    String correo = txtCorreo5.getText().trim();
    String telefono = txtTelefono5.getText().trim();
    String direccion = txtDireccion5.getText().trim();

    // Validaciones
    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras.");
        return;
    }

    if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        JOptionPane.showMessageDialog(null, "El apellido solo puede contener letras.");
        return;
    }

    if (!curp.matches("^[A-Z0-9]{18}$")) {
        JOptionPane.showMessageDialog(this, "La CURP debe tener exactamente 18 caracteres alfanuméricos en mayúsculas.");
        return;
    }

    if (!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un correo electrónico válido.");
        return;
    }

    if (fechaNacimiento == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha de nacimiento.");
        return;
    }

    // Convertir fecha a java.sql.Date
    java.sql.Date fechaNacimientoSQL = new java.sql.Date(fechaNacimiento.getTime());

    // Llamada al controlador para insertar
    if (pacienteController.insertarPaciente(nombre, apellido, curp, fechaNacimientoSQL, sexo, correo, telefono, direccion)) {
        JOptionPane.showMessageDialog(this, "Paciente añadido correctamente.");
        cargarPacientesEnTabla();
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "Error al añadir el paciente.");
    }

    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
                                             
    int filaSeleccionada = TablaPacientes5.getSelectedRow();

    if (filaSeleccionada >= 0) {
        // Obtener valores actualizados de los campos que sí se pueden modificar
        String curp = txtCurp5.getText().trim(); // No modificable, pero necesario para actualizar en la base de datos
        String correo = txtCorreo5.getText().trim();
        String telefono = txtTelefono5.getText().trim();
        String direccion = txtDireccion5.getText().trim();

        // Validaciones para los campos modificables
        if (!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un correo electrónico válido.");
            return;
        }

        if (!telefono.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "El teléfono debe contener exactamente 10 dígitos.");
            return;
        }

        // Confirmación de la acción
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de modificar este paciente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Llamar al controlador para actualizar el paciente
            if (pacienteController.modificarPaciente(curp, correo, telefono, direccion)) {
                JOptionPane.showMessageDialog(this, "Paciente modificado correctamente.");
                cargarPacientesEnTabla(); // Actualizar la tabla
                limpiarCampos(); // Limpiar los campos
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar el paciente.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente para modificar.");
    }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

         int filaSeleccionada = TablaPacientes5.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String curp = TablaPacientes5.getValueAt(filaSeleccionada, 2).toString();

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
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
 limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

         String nombre = txtNombre5.getText().trim();
        String apellido = txtApellido5.getText().trim();
        String curp = txtCurp5.getText().trim();
        String correo = txtCorreo5.getText().trim();

        if (nombre.isEmpty() && apellido.isEmpty() && curp.isEmpty() && correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa al menos un criterio de búsqueda.");
            return;
        }

        DefaultTableModel modeloTabla = pacienteController.buscarPacientes(nombre, apellido, curp, correo);
        if (modeloTabla != null && modeloTabla.getRowCount() > 0) {
            TablaPacientes5.setModel(modeloTabla);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes con los criterios proporcionados.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void TablaPacientes5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPacientes5MouseClicked

        int filaSeleccionada = TablaPacientes5.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtNombre5.setText(TablaPacientes5.getValueAt(filaSeleccionada, 0).toString());
            txtApellido5.setText(TablaPacientes5.getValueAt(filaSeleccionada, 1).toString());
            txtCurp5.setText(TablaPacientes5.getValueAt(filaSeleccionada, 2).toString());

            Object fechaNacimiento = TablaPacientes5.getValueAt(filaSeleccionada, 3);
            if (fechaNacimiento != null && !fechaNacimiento.toString().isEmpty()) {
                try {
                    java.sql.Date fecha = java.sql.Date.valueOf(fechaNacimiento.toString());
                    jDateNacimiento5.setDate(fecha);
                } catch (Exception e) {
                    jDateNacimiento5.setDate(null);
                }
            } else {
                jDateNacimiento5.setDate(null);
            }

            String sexo = TablaPacientes5.getValueAt(filaSeleccionada, 4).toString();
            if ("Hombre".equals(sexo)) {
                buttonHombre5.setSelected(true);
            } else if ("Mujer".equals(sexo)) {
                buttonMujer5.setSelected(true);
            }

            txtCorreo5.setText(TablaPacientes5.getValueAt(filaSeleccionada, 5).toString());
            txtTelefono5.setText(TablaPacientes5.getValueAt(filaSeleccionada, 6).toString());
            txtDireccion5.setText(TablaPacientes5.getValueAt(filaSeleccionada, 7).toString());
        }

    }//GEN-LAST:event_TablaPacientes5MouseClicked

    private void txtNombre5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre5ActionPerformed

    private void txtApellido5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido5ActionPerformed

    private void txtCorreo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo5ActionPerformed

    private void buttonHombre5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHombre5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHombre5ActionPerformed

    private void buttonMujer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMujer5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMujer5ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        // TODO add your handling code here:
        cargarPacientesEnTabla();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        Inicio usuarios = new Inicio();
        usuarios.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        dispose();
        InicioDeSesion inSes = new InicioDeSesion();
        inSes.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed
    
     private void limpiarCampos() {
        txtNombre5.setText("");
        txtApellido5.setText("");
        txtCurp5.setText("");
        txtCorreo5.setText("");
        txtTelefono5.setText("");
        txtDireccion5.setText("");
        jDateNacimiento5.setDate(null);
        buttonHombre5.setSelected(true);
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
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Sexo5;
    private javax.swing.JTable TablaPacientes5;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnMedicamentos;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JRadioButton buttonHombre5;
    private javax.swing.JRadioButton buttonMujer5;
    private com.toedter.calendar.JDateChooser jDateNacimiento5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido5;
    private javax.swing.JTextField txtCorreo5;
    private javax.swing.JTextField txtCurp5;
    private javax.swing.JTextField txtDireccion5;
    private javax.swing.JTextField txtNombre5;
    private javax.swing.JTextField txtTelefono5;
    // End of variables declaration//GEN-END:variables
}
