# Consultorio-Medico---Proyecto-Final
Este proyecto es un sistema de gestión para una clínica médica llamado "VITALIS MEDICAL CENTER". La aplicación permite administrar y organizar de manera eficiente las actividades de una clínica, desde el registro de pacientes hasta la emisión de diagnósticos y recetas médicas en PDF con capacidad de envío automático por correo electrónico.

Descripción General del Proyecto
El proyecto consiste en un software para la gestión de un consultorio médico diseñado específicamente para facilitar las tareas de las personas que trabajan en la clínica: recepcionistas, médicos y administradores.
El sistema automatiza tareas clave, como:
* Registro y gestión de pacientes.
* Agendamiento de citas médicas.
* Diagnóstico y generación de recetas.
* Generación de reportes en PDF.
* Envío de información por correo electrónico.

ROLES PRINCIPALES

RECEPCIONISTA
- Se encarga de registrar nuevos pacientes y gestionar sus citas.
- Funcionalidades principales:
- Añadir, editar y eliminar registros de pacientes.
- Buscar pacientes por criterios específicos.
- Agendar citas y consultar el historial de citas.

MEDICO
- Realiza consultas médicas y emite diagnósticos.
- Funcionalidades principales:
- Crear diagnósticos detallados.
- Recetar medicamentos y recomendaciones.
- Generar archivos PDF con la información del diagnóstico.
- Enviar automáticamente el archivo PDF por correo electrónico al paciente.

ADMINISTRADOR
- Supervisa y administra el sistema completo.
- Funcionalidades principales:
- Gestión de usuarios y roles.
- Supervisión de todas las actividades registradas en el sistema.

FLUJO GENERAL DEL SISTEMA
Inicio de Sesión: Cada usuario accede al sistema con sus credenciales. Dependiendo del tipo de usuario (Recepcionista, Médico, o Administrador), se muestran las funcionalidades correspondientes.

Recepción de Pacientes: La recepcionista puede registrar nuevos pacientes, actualizar sus datos y buscar información de pacientes existentes.También puede gestionar el agendamiento de citas.

Consulta Médica: El médico selecciona un paciente, revisa su historial y completa la consulta. Registra el motivo de la consulta, diagnóstico, recomendaciones y medicación sugerida. Genera un reporte en PDF con los detalles de la consulta. Envía automáticamente el PDF al correo electrónico del paciente.

Administración: El administrador puede gestionar usuarios y realizar un seguimiento de todas las operaciones realizadas en el sistema.

# La lógica de la conexión a la base de datos (ConexionDB) 

La clase Conexion DB se encarga de establecer una conexión entre la aplicación Java y una base de datos PostgreSQL. A continuación, te detallo cómo funciona el código:

Importación de Librerías Necesarias:

Se importan las clases necesarias de java.sql para manejar conexiones y ejecutar sentencias SQL:

      import java.sql.Connection;
      import java.sql.DriverManager;
      import java.sql.PreparedStatement;

Definición de Parámetros de Conexión:

Se definen los parámetros esenciales para conectarse a la base de datos:

URL: Dirección de la base de datos, donde:

* localhost: La máquina local donde está corriendo PostgreSQL.
* 5433: El puerto en el que escucha PostgreSQL (generalmente es 5432, pero aquí fue modificado).
* vitalisMedicalCenter: El nombre de la base de datos.
* USER: Usuario de PostgreSQL.
* PASSWORD: Contraseña del usuario de PostgreSQL.

      private static final String URL = "jdbc:postgresql://localhost:5433/vitalisMedicalCenter";
      private static final String USER = "postgres";
      private static final String PASSWORD = "";
      Método conectar():

Objetivo: Retorna una instancia de conexión activa a la base de datos.

Implementación Lógica:

- Se declara un objeto Connection inicialmente como null.
- Se utiliza un bloque try-catch para capturar errores en la conexión.
- 
Carga del Driver JDBC:

- Se llama a Class.forName("org.postgresql.Driver"), lo cual carga el driver de PostgreSQL requerido para que Java pueda interactuar con la base de datos.

Establecimiento de la Conexión:

- DriverManager.getConnection(URL, USER, PASSWORD) crea la conexión usando los parámetros definidos.
- Si la conexión es exitosa, el objeto conexion contendrá la conexión activa.
- 
Manejo de Errores:

- Si ocurre algún error (por ejemplo, credenciales incorrectas, servidor inalcanzable), se captura en el bloque catch, aunque no se imprime en este caso (deberías agregar un e.printStackTrace() para depuración).

      public static Connection conectar() {
          Connection conexion = null;
          try {
              Class.forName("org.postgresql.Driver");
              conexion = DriverManager.getConnection(URL, USER, PASSWORD);
          } catch (Exception e) {
              // Manejo de errores (se recomienda imprimirlos)
          }
          return conexion;
      }

Retorno de la Conexión:

Finalmente, el método devuelve el objeto Connection. Si la conexión falló, el método devolverá null.

Flujo de Ejecución:

- El método conectar() es llamado desde cualquier parte de la aplicación cuando se necesita acceso a la base de datos.
- Si el driver JDBC está configurado correctamente y los parámetros (URL, usuario, contraseña) son válidos, se establece la conexión.
- Si la conexión se establece exitosamente, se devuelve un objeto Connection que puede ser utilizado para ejecutar consultas SQL.
- Si falla la conexión, se retorna null.
- 
Mejora Recomendada:

Se recomienda agregar un manejo de errores más explícito en el bloque catch para depurar problemas fácilmente:

      } catch (Exception e) {
          e.printStackTrace(); // Muestra el error en la consola
          System.out.println("Error al conectar a la base de datos: " + e.getMessage());
      }



INICIO DE SESION 

![image](https://github.com/user-attachments/assets/35cb521e-f990-4461-a9e4-c38a0d3c0bde)

Pantalla de Inicio de Sesión

La clase InicioDeSesion implementa la pantalla inicial del sistema, donde los usuarios ingresan sus credenciales para acceder al sistema según su rol: Administrador, Médico o Recepcionista.

1. Propósito General
   
Este código proporciona la interfaz gráfica (GUI) para el inicio de sesión en un consultorio médico.
Se utiliza Swing, una biblioteca estándar de Java, para construir la interfaz de usuario y manejar los eventos asociados.

3. Flujo de Trabajo: Botón "Entrar"
   
🔹 Proceso de Inicio de Sesión
El método btnEntrarActionPerformed maneja la lógica principal:

Recupera los datos ingresados por el usuario:

    String correo = txtFiedlCorreo.getText().trim();
    String contraseña = new String(jContraseña.getPassword());
    String tipoUsuario = combxTipoUsuario.getSelectedItem().toString();
    
Los campos se limpian utilizando .trim() para evitar espacios innecesarios.
La contraseña se obtiene de JPasswordField como un arreglo de caracteres.
Valida si los campos están vacíos:

    if (correo.isEmpty() || contraseña.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Por favor, ingresa el correo electrónico y la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
    }
    
Verifica las credenciales usando UsuarioController: Se delega la validación al método iniciarSesion del controlador:

    if (usuarioController.iniciarSesion(correo, contraseña, tipoUsuario)) {
    JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso. Bienvenido " + tipoUsuario.toLowerCase() + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
Si las credenciales son correctas, se da la bienvenida al usuario.

Redirección según el tipo de usuario: La ventana Verificación se muestra primero (posiblemente para implementar un CAPTCHA o verificación adicional):

    Verificacion ventanaVerificacion = new Verificacion();
    ventanaVerificacion.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    ventanaVerificacion.setVisible(true);
    
Se utiliza un WindowListener para detectar el cierre de la ventana de verificación y abrir el dashboard adecuado:

    ventanaVerificacion.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        if (tipoUsuario.equalsIgnoreCase("ADMINISTRADOR")) {
            new DashboardAdministrador.Inicio().setVisible(true);
        } else if (tipoUsuario.equalsIgnoreCase("MEDICO")) {
            new DashboardMedico.CitasAgendadas().setVisible(true);
        } else if (tipoUsuario.equalsIgnoreCase("RECEPCIONISTA")) {
            new DashboardRecepcionista.AgendarCitas().setVisible(true);
        }
    }
    });
4. Botón "Registrarse"
   
Abre la ventana de registro de usuario:

        RegistroUsuario registro = new RegistroUsuario();
        registro.setVisible(true);
        dispose();
dispose() cierra la ventana de inicio de sesión actual.

5. Diseño de la Interfaz
   
El diseño utiliza AbsoluteLayout para colocar los componentes en posiciones exactas con coordenadas (x, y).
Cada componente se añade con su respectiva posición, por ejemplo:

        getContentPane().add(txtFiedlCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 390, 30));
   
7. Lógica Modular
   
El controlador UsuarioController realiza las operaciones de validación de credenciales. Esto mantiene la lógica de negocios separada de la interfaz gráfica, siguiendo el patrón MVC (Modelo-Vista-Controlador).
La ventana de verificación se utiliza como un paso intermedio de seguridad antes de acceder a las demás secciones.

Registro de Usuarios

![image](https://github.com/user-attachments/assets/26b1926f-f18d-4729-bfd5-6466e534957d)


La clase RegistroUsuario implementa la pantalla de registro de nuevos usuarios en el sistema. Es una extensión de la interfaz gráfica de Java Swing que permite a los administradores agregar usuarios con diferentes roles al sistema.

1. Propósito General
   
El propósito de esta clase es registrar usuarios con los siguientes datos:

- Nombre y apellido.

- CURP (Clave Única de Registro de Población

- Fecha de nacimiento.

- Correo electrónico.

- Contraseña y confirmación.

- Código de autorización (para usuarios especiales como administradores).

- Tipo de cuenta (Administrador, Médico o Recepcionista).

- Se comunica con el UsuarioController para validar y guardar los datos en el sistema.


2. Componentes de la Interfaz
   
Campos de Entrada - Nombre y Apellido:

    txtNombre, txtApellido
    
CURP - Campo para ingresar una CURP válida.

    txtCURP
    
Fecha de Nacimiento - Utiliza JDateChooser para seleccionar una fecha.

    JCalendarF
    
Correo Electrónico

    txtCorreo
    
Contraseña y Confirmación - Utiliza dos JPasswordField para la seguridad.

    pwField, pwFieldConfirmacion
    
Código de Autorización - Campo adicional para roles específicos.

    txtCodigoAutorizacion
    
Tipo de Cuenta - Utiliza un JComboBox para seleccionar el tipo de usuario.

    comboxTipo
    
4. Flujo de Trabajo: Botón "Guardar"
   
El método btnGuardarAdminActionPerformed gestiona la lógica principal para registrar un usuario.

Flujo General

Recuperar datos del formulario:

    String nombre = txtNombre.getText();
    String apellido = txtApellido.getText();
    String curp = txtCURP.getText();
    java.util.Date fechaSeleccionada = JCalendarF.getDate();
    
Se validan todos los campos y se convierte la fecha a java.sql.Date para ser compatible con la base de datos.

Validar los campos: Se llama al método validarCampos del controlador:

    if (usuarioController.validarCampos(nombre, apellido, curp, fechaNacimiento, correo, tipoUsuario, contraseña, confirmarContraseña, codigoAutorizacion)) {
  
Verifica que:

- Los campos no estén vacíos.
- Las contraseñas coincidan
- La CURP tenga el formato correcto
- La fecha sea válida.
- 
Guardar en la base de datos: Si la validación es exitosa, se intenta guardar el usuario:

      if (usuarioController.guardarUsuario(nombre, apellido, curp, fechaNacimiento, correo, tipoUsuario, contraseña, codigoAutorizacion)) {
          JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
          limpiarCampos();
      } else {
          JOptionPane.showMessageDialog(this, "Error al guardar el usuario. Por favor, verifica los datos.", "Error", JOptionPane.ERROR_MESSAGE);
      }
  
El método guardarUsuario inserta el nuevo usuario en la base de datos.

Limpiar el formulario: Al completar el registro, los campos se limpian con limpiarCampos():

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCURP.setText("");
        JCalendarF.setDate(null);
        txtCorreo.setText("");
        comboxTipo.setSelectedIndex(0);
        pwField.setText("");
        pwFieldConfirmacion.setText("");
        txtCodigoAutorizacion.setText("");
    }
    
4. Botón "Cancelar"
   
Permite cancelar el proceso actual sin realizar cambios.

6. Validaciones y Seguridad
   
Validación de contraseñas: El sistema verifica que las contraseñas coincidan.
    
    String contraseña = new String(pwField.getPassword());
    String confirmarContraseña = new String(pwFieldConfirmacion.getPassword());

Validación del formato de CURP: Se asume que el controlador maneja la lógica de validación.

Código de autorización: Este campo adicional proporciona un nivel extra de seguridad para roles importantes como el Administrador.

Módulo de Agendamiento de Citas

![image](https://github.com/user-attachments/assets/14bee485-3645-44d6-8d85-87c57ccf5870)

La clase AgendarCitas pertenece al paquete DashboardRecepcionista y se encarga de permitir la gestión y organización de citas en el consultorio médico. Esta funcionalidad está diseñada para ser utilizada principalmente por recepcionistas, quienes pueden agendar, confirmar y cancelar citas de los pacientes.

⚙️ Características Principales

Validación de CURP en Tiempo Real: Utiliza un KeyListener que permite validar la CURP del paciente y buscar automáticamente sus datos en la base de datos una vez que se introducen 18 caracteres.

    txtCurp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            buscarPacientePorCurp(txtCurp.getText().trim());
        }
    });
    
Selección de Fecha y Hora de la Cita: La fecha se selecciona a través del componente JCalendar. La hora se selecciona mediante un JComboBox con horarios predefinidos.

    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String fechaFormateada = sdf.format(fechaSeleccionada);
    txtFecha.setText(fechaFormateada);
    
Mostrar Resumen de Citas: Al seleccionar una fecha en el calendario, el sistema busca las citas registradas en la base de datos y las muestra en un JTextArea.

    ArrayList<String> citas = modelo.obtenerCitasPorFecha(fechaSQL, conn);
    if (citas.isEmpty()) {
        jtxtAreaCitas.setText("No hay citas agendadas para este día.");
    } else {
        for (String cita : citas) {
            jtxtAreaCitas.append(cita + "\n");
        }
    }
    
Confirmación y Cancelación de Citas: El sistema permite confirmar una nueva cita y cancelarla utilizando botones específicos.

Confirmar Cita:

    controlador.confirmarCita(curp, horaCompleta, fechaTexto, jtxtAreaCitas, jCalendarCitas);
    
Cancelar Cita:

    controlador.cancelarCita(curp, horaTexto, fechaTexto);
    
Cierre de Sesión: Al presionar el botón "Cerrar sesión", el sistema vuelve a la pantalla de Inicio de Sesión.

    dispose();
    InicioDeSesion inSes = new InicioDeSesion();
    inSes.setVisible(true);
    
🖥️ Interfaz Gráfica

La interfaz cuenta con:

- Campos de Texto para CURP, nombre, apellido, correo y teléfono.
- JCalendar para la selección de fechas.
- JComboBox con horarios disponibles.
- JTextArea para visualizar las citas programadas en una fecha seleccionada.
 
Botones:

- Confirmar Cita.
- Cancelar Cita.
- Cerrar Sesión.
- 
Paneles y Etiquetas que organizan y muestran información de manera clara.

🔍 Flujo de Uso

* Ingreso de CURP: El usuario introduce la CURP del paciente. Si coincide con la base de datos, se rellenan automáticamente los campos de información personal.

* Selección de Fecha y Hora: La recepcionista selecciona una fecha utilizando el calendario. El sistema muestra en el JTextArea todas las citas registradas para esa fecha.Se selecciona una hora en el JComboBox.

* Confirmación de la Cita: Una vez que la información está completa, se presiona el botón Confirmar Cita.
La cita se guarda en la base de datos.

* Cancelación de la Cita:Para cancelar una cita, se selecciona la fecha y hora correspondiente y se presiona el botón Cancelar Cita.

* Cierre de Sesión: El usuario puede cerrar sesión en cualquier momento y volver a la ventana de inicio.

💾 Integración con Base de Datos

El sistema se conecta a la base de datos PostgreSQL utilizando la clase ConexionDB. Se realizan las siguientes consultas:

Búsqueda de Paciente:

    SELECT nombre, apellido, correo, telefono FROM Pacientes WHERE curp = ?;
    
Obtener Citas por Fecha:

    SELECT hora, nombre, apellido FROM Citas WHERE fecha = ?;
    
Módulo de Citas Agendadas

![image](https://github.com/user-attachments/assets/93729a90-d4be-47bc-9504-e88cdad380e6)

La clase CitasAgendadas pertenece al paquete DashboardRecepcionista y proporciona la funcionalidad para visualizar, buscar y gestionar el historial de citas agendadas en el consultorio médico. Esta herramienta facilita el seguimiento y actualización de las citas, permitiendo al personal encargado llevar un control eficiente.

⚙️ Características Principales

Visualización del Historial de Citas: Al iniciar, el sistema carga automáticamente las citas agendadas en una tabla (JTable) a partir de los datos almacenados en la base de datos.
Utiliza el método cargarHistorialCitas() para llenar la tabla con datos actualizados.
Código:
    
    DefaultTableModel modeloTabla = (DefaultTableModel) tablaHistorialC.getModel();
    modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
    ArrayList<HashMap<String, String>> listaCitas = controlador.obtenerCitas(conn);
    
    for (HashMap<String, String> cita : listaCitas) {
        modeloTabla.addRow(new Object[]{
            cita.get("hora"),
            cita.get("fecha"),
            cita.get("estatus"),
            cita.get("nombre"),
            cita.get("apellido"),
            cita.get("correo"),
            cita.get("telefono"),
            cita.get("curp")
        });
    }
    
Búsqueda de Citas por CURP, Fecha y Hora: Permite filtrar citas utilizando el CURP, fecha y hora como criterios de búsqueda. Los resultados de la búsqueda se muestran en la misma tabla.
Código:

    String curp = txtCurpF.getText().trim();
    java.sql.Date sqlFecha = fechaSeleccionada != null ? new java.sql.Date(fechaSeleccionada.getTime()) : null;
    ArrayList<HashMap<String, String>> listaCitas = controlador.buscarCitas(curp, sqlFecha, horaTexto);
    
    for (HashMap<String, String> cita : listaCitas) {
        modeloTabla.addRow(new Object[]{
            cita.get("hora"), cita.get("fecha"), cita.get("estatus"),
            cita.get("nombre"), cita.get("apellido"), cita.get("correo"),
            cita.get("telefono"), cita.get("curp")
        });
    }
    
Visualización Detallada de la Cita Seleccionada: Al seleccionar una fila en la tabla, los detalles de la cita se muestran automáticamente en los campos de texto correspondientes.
Código:

    tablaHistorialC.getSelectionModel().addListSelectionListener(event -> {
        int selectedRow = tablaHistorialC.getSelectedRow();
        if (selectedRow != -1) {
            txtCurpF.setText(tablaHistorialC.getValueAt(selectedRow, 7).toString());
            txtNombreF.setText(tablaHistorialC.getValueAt(selectedRow, 3).toString());
            txtApellidoF.setText(tablaHistorialC.getValueAt(selectedRow, 4).toString());
            txtHoraF.setText(tablaHistorialC.getValueAt(selectedRow, 0).toString());
            txtEstatusF.setText(tablaHistorialC.getValueAt(selectedRow, 2).toString());
            txtCorreoF.setText(tablaHistorialC.getValueAt(selectedRow, 5).toString());
            txtTelefonoF.setText(tablaHistorialC.getValueAt(selectedRow, 6).toString());
        }
    });
    
Limpieza de Campos: Proporciona un botón para limpiar todos los campos de texto después de realizar una operación.
Código:

    private void btnLimpiarFieldsActionPerformed(java.awt.event.ActionEvent evt) {
        txtCurpF.setText("");
        txtNombreF.setText("");
        txtApellidoF.setText("");
        txtHoraF.setText("");
        txtEstatusF.setText("");
        txtCorreoF.setText("");
        txtTelefonoF.setText("");
    }
    
Botón de Mostrar Todas las Citas: Al presionar este botón, se vuelve a cargar el historial completo de citas sin aplicar filtros.
Código:
    
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {
        cargarHistorialCitas();
    }

Módulo de Registro de Pacientes

![image](https://github.com/user-attachments/assets/51111123-728e-4817-9b17-6951cbd3aa5f)

El módulo RegistroPacientes forma parte del paquete DashboardRecepcionista y está diseñado para gestionar el registro y mantenimiento de información de los pacientes en un consultorio médico. Permite añadir, editar, eliminar, buscar y listar pacientes en una interfaz amigable y funcional.

⚙️ Funcionalidades Principales

Registro de Nuevos Pacientes: Permite ingresar los datos personales de los pacientes, como nombre, apellido, CURP, fecha de nacimiento, género, correo, teléfono y dirección. Al confirmar, los datos se almacenan en la base de datos.
    
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
    }
    
Visualización de Pacientes: Los pacientes registrados se muestran en una tabla JTable con columnas como Nombre, CURP, Fecha de Nacimiento, Sexo, Correo, etc. Los datos se cargan al iniciar la ventana mediante el método cargarPacientesEnTabla().

    private void cargarPacientesEnTabla() {
        DefaultTableModel modeloTabla = pacienteController.cargarPacientesEnTabla();
        if (modeloTabla != null) {
            TablaPacientes.setModel(modeloTabla);
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de pacientes.");
        }
    }

Edición de Pacientes: Al seleccionar una fila de la tabla, los datos del paciente se muestran automáticamente en los campos de texto para facilitar su edición.

    private void TablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {
        int filaSeleccionada = TablaPacientes.getSelectedRow();
        txtNombre.setText(TablaPacientes.getValueAt(filaSeleccionada, 0).toString());
        txtApellido.setText(TablaPacientes.getValueAt(filaSeleccionada, 1).toString());
        txtCURP.setText(TablaPacientes.getValueAt(filaSeleccionada, 2).toString());
        // Fecha y demás campos...
    }

Eliminación de Pacientes: Permite eliminar un paciente seleccionado en la tabla tras confirmar la acción con un cuadro de diálogo.

    int filaSeleccionada = TablaPacientes.getSelectedRow();
    String curp = TablaPacientes.getValueAt(filaSeleccionada, 2).toString();
    if (pacienteController.eliminarPaciente(curp)) {
        JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.");
        cargarPacientesEnTabla();
    }
    
Búsqueda de Pacientes: El usuario puede buscar pacientes ingresando uno o más criterios como nombre, apellido, CURP o correo. Los resultados se muestran en la tabla.
    
    String nombre = txtNombre.getText().trim();
    String apellido = txtApellido.getText().trim();
    String curp = txtCURP.getText().trim();
    String correo = txtCorreo.getText().trim();
    
    DefaultTableModel modeloTabla = pacienteController.buscarPacientes(nombre, apellido, curp, correo);
    if (modeloTabla != null) {
        TablaPacientes.setModel(modeloTabla);
    }
    
Limpieza de Campos: Proporciona una opción para limpiar todos los campos de texto y restablecer el formulario.

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
    
Mostrar Todos los Pacientes: El botón "Mostrar todo" recarga la tabla con todos los pacientes almacenados en la base de datos.

Cierre de Sesión: El botón Cerrar Sesión devuelve al usuario a la ventana principal de inicio de sesión.

🖥️ Interfaz Gráfica

La interfaz contiene:

Formulario de registro:

* Campos de texto: Nombre, Apellido, CURP, Correo, Teléfono, Dirección.
* JDateChooser: Para seleccionar la fecha de nacimiento.
* Botones de radio: Selección de género (Hombre/Mujer).
  
JTable:

- Visualiza la lista de pacientes con sus respectivos datos.
- 
Botones:
- Añadir, Eliminar, Buscar, Mostrar todo y Limpiar.
- Cerrar sesión para salir del módulo.
- 
Paneles y etiquetas:

- Organización visual de la interfaz.
- 
🔍 Flujo de Uso
* Añadir Pacientes:
  
Completar el formulario y presionar el botón "Añadir".

* Buscar Pacientes:
  
Ingresar uno o más criterios de búsqueda y presionar "Buscar".

* Eliminar Pacientes:
  
Seleccionar una fila de la tabla y presionar "Eliminar".

* Mostrar Todo:
  
Presionar el botón "Mostrar todo" para recargar la tabla con todos los pacientes.

* Editar Pacientes:
  
Seleccionar una fila, modificar los campos necesarios y realizar las acciones correspondientes.

* Cerrar Sesión:
  
Regresar a la pantalla principal de inicio.

Módulo de Citas Agendadas - Médico

![image](https://github.com/user-attachments/assets/cbc503f0-c919-485b-9346-f5856e17d789)
   
El módulo CitasAgendadas forma parte del paquete DashboardMedico y está diseñado para que el médico pueda visualizar las citas programadas en una fecha específica. Este módulo incluye una interfaz amigable que facilita la interacción del médico con el sistema.

⚙️ Funcionalidades Principales

Visualización de Citas Agendadas: El médico puede seleccionar una fecha utilizando el JCalendar y ver las citas programadas para ese día. Las citas se muestran en un JTextArea.
    
        private void configurarEventosJCalendar() {
            jCalendarCitas1.addPropertyChangeListener("calendar", evt -> {
                java.util.Date fechaSeleccionada = jCalendarCitas1.getDate();
                if (fechaSeleccionada != null) {
                    cargarCitasPorFecha(new java.sql.Date(fechaSeleccionada.getTime()));
                }
            });
        }
    
        private void cargarCitasPorFecha(Date fecha) {
            try (Connection conn = ConexionDB.conectar()) {
                ArrayList<String> citas = controlador.obtenerCitasPorFecha(fecha, conn);
    
            txtCitasVisualizadas.setText("");
            if (citas.isEmpty()) {
                txtCitasVisualizadas.setText("No hay citas programadas para esta fecha.");
            } else {
                for (String cita : citas) {
                    txtCitasVisualizadas.append(cita + "\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar citas: " + e.getMessage());
        }
    }
    
Proceso:

El evento PropertyChangeListener detecta un cambio en la fecha seleccionada en el JCalendar.
El método cargarCitasPorFecha() recupera las citas correspondientes a la fecha seleccionada utilizando el controlador HistorialCitasController.
Las citas recuperadas se muestran en el JTextArea.

Botones de Navegación:

Consulta: Redirige a la ventana donde el médico puede realizar consultas y diagnósticos.

Detalles de Citas: Muestra información detallada de las citas seleccionadas.

Cerrar Sesión: Finaliza la sesión actual y regresa a la ventana de inicio de sesión.

    
    private void btnCerrarSesion2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        InicioDeSesion inSes = new InicioDeSesion();
        inSes.setVisible(true);
    }
    
    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {
        ConsultaDiagnosticoReceta conDiagR = new ConsultaDiagnosticoReceta();
        conDiagR.setVisible(true);
        dispose();
    }
    
Interfaz de Usuario:

* JCalendar: Permite seleccionar una fecha para consultar las citas programadas.
* JTextArea: Muestra las citas recuperadas desde la base de datos.
* Botones de Navegación: Facilitan la transición entre diferentes módulos.
* Diseño: El fondo incluye imágenes y estilos personalizados.
  
🖥️ Flujo de Uso
- Seleccionar Fecha: El usuario selecciona una fecha en el JCalendar.
- Visualización de Citas: El sistema consulta las citas programadas para la fecha seleccionada y las muestra en el JTextArea.
- Navegación: El médico puede dirigirse a otros módulos como Consulta o Detalles de Citas.
- Cierre de Sesión: El botón Cerrar Sesión finaliza la sesión y redirige a la pantalla de inicio.

🔗 Integración con el Controlador

El módulo utiliza la clase HistorialCitasController para obtener las citas desde la base de datos. Este controlador interactúa con la base de datos mediante consultas SQL.

    public ArrayList<String> obtenerCitasPorFecha(Date fecha, Connection conn) throws SQLException {
        ArrayList<String> citas = new ArrayList<>();
        String query = "SELECT hora, nombre, apellido FROM Citas WHERE fecha = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, fecha);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String hora = rs.getString("hora");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                citas.add(hora + " - " + nombre + " " + apellido);
            }
        }
        return citas;
    }

Módulo de Consulta, Diagnóstico y Receta
    
![image](https://github.com/user-attachments/assets/b161e9c6-9b56-4e50-ae3f-6f9a27fd7e15)


El módulo ConsultaDiagnosticoReceta es parte del DashboardMedico, donde los médicos pueden gestionar consultas, realizar diagnósticos, recetar medicamentos y generar un reporte en formato PDF, además de enviarlo por correo electrónico al paciente.

⚙️ Funcionalidades Principales

Cargar Datos Automáticamente al Ingresar CURP

Al ingresar la CURP del paciente, el sistema consulta la base de datos y carga automáticamente los datos personales del paciente y su historial de consultas.



    private void configurarKeyListenerCurp() {
        txtCurp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String curp = txtCurp.getText().trim();

              if (curp.length() == 18) { // CURP válida (18 caracteres)
                  cargarDatosPaciente(curp);
                  filtrarHistorialPorCurp(curp);
              } else if (curp.isEmpty()) {
                  cargarHistorialPacientes(); 
                  limpiarCampos();
              }
          }
      });
    }
    
Acciones:

* Carga datos personales como nombre, fecha de nacimiento, teléfono y correo.
* Filtra el historial de consultas del paciente.
* Guardar Consulta en la Base de Datos

Permite al médico registrar una consulta médica, incluyendo:

* Motivo de consulta
* Diagnóstico
* Recomendaciones
* Medicación recomendada
* Tipo de consulta (primera o seguimiento)
* Acompañante (opcional)
      
      private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
          try (Connection conn = ConexionDB.conectar()) {
              String query = "INSERT INTO Consultas (curp_paciente, fecha, hora, motivo_consulta, diagnostico, recomendaciones, medicacion_recomendada, tipo_consulta, acompanante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, txtCurp.getText().trim());
        pstmt.setDate(2, new java.sql.Date(new Date().getTime())); // Fecha actual
        pstmt.setTime(3, new java.sql.Time(new Date().getTime())); // Hora actual
        pstmt.setString(4, txtMotivoConsulta.getText().trim());
        pstmt.setString(5, txtDiagnostico.getText().trim());
        pstmt.setString(6, txtRecomendaciones.getText().trim());
        pstmt.setString(7, txtMedicacionRecomendada.getText().trim());
        pstmt.setString(8, comboTipoConsulta.getSelectedItem().toString());
        pstmt.setString(9, txtAcompanante.getText().trim());

        if (pstmt.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Consulta guardada correctamente.");
            limpiarCampos();
        }
      } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
      }
  
-- Generar y Enviar PDF con Reporte de Consulta -- 

- Genera un reporte PDF con los detalles de la consulta médica.
- Envía el reporte al correo electrónico del paciente utilizando la clase CorreoUtils.

  
      private void btnGyEActionPerformed(java.awt.event.ActionEvent evt) {
          String destino = "reporte_consulta.pdf";
          try {
              PdfWriter writer = new PdfWriter(destino);
              PdfDocument pdf = new PdfDocument(writer);
              Document document = new Document(pdf);

        document.add(new Paragraph("VITALIS MEDICAL CENTER").setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(20));
        document.add(new Paragraph("Reporte de Consulta Médica").setTextAlignment(TextAlignment.CENTER));

        document.add(new Paragraph("Nombre: " + txtNombre.getText()));
        document.add(new Paragraph("CURP: " + txtCurp.getText()));
        document.add(new Paragraph("Motivo de Consulta:").setBold());
        document.add(new Paragraph(txtMotivoConsulta.getText()));
        document.close();

        CorreoUtils.enviarCorreoConAdjunto(txtCorreo.getText(), "Reporte de Consulta", "Adjunto encontrará su reporte.", new File(destino));
        JOptionPane.showMessageDialog(this, "PDF generado y enviado correctamente.");
      } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
      }
  
PDF Contiene:

* Información del paciente (nombre, CURP, fecha de nacimiento).
* Detalles de la consulta (motivo, diagnóstico, recomendaciones, medicación).
  
Gestión de Medicamentos

- Permite seleccionar medicamentos de una tabla y agregarlos a la lista de medicación recomendada.
      
      private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
          int selectedRow = TablaMedConsulta.getSelectedRow();
          if (selectedRow != -1) {
              String nombre = (String) TablaMedConsulta.getValueAt(selectedRow, 0);
              String presentacion = (String) TablaMedConsulta.getValueAt(selectedRow, 1);
              txtMedicacionRecomendada.append(String.format("%s - %s\n", nombre, presentacion));
          }
      }
  
Cargar Historial de Pacientes

El historial de consultas del paciente se muestra en una tabla, permitiendo su revisión rápida.

    private void cargarHistorialPacientes() {
        DefaultTableModel modelo = (DefaultTableModel) tableHistorialPaciente.getModel();
        modelo.setRowCount(0);
        String query = "SELECT curp_paciente, fecha, hora, tipo_consulta FROM Consultas";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("curp_paciente"), rs.getDate("fecha"), rs.getTime("hora"), rs.getString("tipo_consulta")});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

Módulo: Detalles de Citas

![image](https://github.com/user-attachments/assets/da8fb890-eb66-4943-afa6-ec38550510d6)


El módulo DetallesCitas pertenece al DashboardMedico, y está diseñado para mostrar un historial detallado de citas, permitir búsquedas con filtros personalizados, y mostrar la información seleccionada en campos específicos.

⚙️ Funcionalidades Principales

1. Carga del Historial de Citas

Se conecta a la base de datos y recupera todas las citas registradas.
Los datos se muestran en la tabla principal.

    private void cargarHistorialCitas() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaHistorialC.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla

    try (Connection conn = ConexionDB.conectar()) {
        HistorialCitasController controlador = new HistorialCitasController();
        ArrayList<HashMap<String, String>> listaCitas = controlador.obtenerCitas(conn);

        for (HashMap<String, String> cita : listaCitas) {
            modeloTabla.addRow(new Object[]{
                cita.get("hora"),
                cita.get("fecha"),
                cita.get("estatus"),
                cita.get("nombre"),
                cita.get("apellido"),
                cita.get("correo"),
                cita.get("telefono"),
                cita.get("curp")
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar el historial de citas: " + e.getMessage());
      }
    }
    
Acción: Llama al controlador HistorialCitasController y llena la tabla con los datos.

2. Búsqueda con Filtros Personalizados
   
Permite buscar citas filtrando por:

* CURP
* Fecha
* Hora
* Código Clave:

      private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
          String curp = txtCurpF.getText().trim();
          java.util.Date fechaSeleccionada = jDateChooser1.getDate();
          String horaTexto = txtHoraF.getText().trim();
    
        java.sql.Date sqlFecha = fechaSeleccionada != null ? new java.sql.Date(fechaSeleccionada.getTime()) : null;
    
        if (!horaTexto.isEmpty() && horaTexto.length() == 5) {
            horaTexto += ":00"; // Asegurar formato HH:mm:ss
        }
    
        try {
            HistorialCitasController controlador = new HistorialCitasController();
            ArrayList<HashMap<String, String>> listaCitas = controlador.buscarCitas(curp, sqlFecha, horaTexto);

        DefaultTableModel modeloTabla = (DefaultTableModel) tablaHistorialC.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla

        for (HashMap<String, String> cita : listaCitas) {
            modeloTabla.addRow(new Object[]{
                cita.get("hora"),
                cita.get("fecha"),
                cita.get("estatus"),
                cita.get("nombre"),
                cita.get("apellido"),
                cita.get("correo"),
                cita.get("telefono"),
                cita.get("curp")
            });
        }

        if (listaCitas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron citas con los filtros proporcionados.");
        }
      } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Error al buscar citas: " + ex.getMessage());
        }
      }
  
Acción: Filtra la búsqueda y actualiza la tabla con los resultados.

3. Selección de Cita para Visualización
   
Al seleccionar una fila en la tabla, se muestran los detalles de la cita en campos de texto y un JDateChooser.

    private void configurarEventoSeleccionTabla() {
        tablaHistorialC.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = tablaHistorialC.getSelectedRow();

            if (selectedRow != -1) {
                txtCurpF.setText(tablaHistorialC.getValueAt(selectedRow, 7).toString());
                txtNombreF.setText(tablaHistorialC.getValueAt(selectedRow, 3).toString());
                txtApellidoF.setText(tablaHistorialC.getValueAt(selectedRow, 4).toString());
                txtHoraF.setText(tablaHistorialC.getValueAt(selectedRow, 0).toString());
                txtEstatusF.setText(tablaHistorialC.getValueAt(selectedRow, 2).toString());
                txtCorreoF.setText(tablaHistorialC.getValueAt(selectedRow, 5).toString());
                txtTelefonoF.setText(tablaHistorialC.getValueAt(selectedRow, 6).toString());

                try {
                    java.util.Date fechaSeleccionada = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(tablaHistorialC.getValueAt(selectedRow, 1).toString());
                    jDateChooser1.setDate(fechaSeleccionada);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al establecer la fecha: " + e.getMessage());
                }
            }
        }
      });
    }
    
Acción: Llena los campos de texto al seleccionar una fila.

4. Limpiar Campos
   
Limpia los campos de texto y restablece los filtros.

    private void btnLimpiarFieldsActionPerformed(java.awt.event.ActionEvent evt) {
        txtCurpF.setText("");
        txtNombreF.setText("");
        txtApellidoF.setText("");
        txtHoraF.setText("");
        txtEstatusF.setText("");
        txtCorreoF.setText("");
        txtTelefonoF.setText("");
        jDateChooser1.setDate(null);
    }
    
5. Navegación entre Módulos
   
Botones que permiten navegar a otros módulos:

* Consultas → ConsultaDiagnosticoReceta
* Citas Agendadas → CitasAgendadas
  
      private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {
          ConsultaDiagnosticoReceta consultaDiagR = new ConsultaDiagnosticoReceta();
          consultaDiagR.setVisible(true);
          dispose();
      }
      
      private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {
          CitasAgendadas citasAgendas = new CitasAgendadas();
          citasAgendas.setVisible(true);
          dispose();
      }

🗂️ Módulo: Gestión de Usuarios (Administrador)

  ![image](https://github.com/user-attachments/assets/2de86339-6aac-49d3-bf46-9ea8e890b795)

  
El módulo Inicio del paquete DashboardAdministrador facilita la administración de los usuarios registrados en el sistema. Permite añadir, modificar, eliminar, buscar y visualizar usuarios, además de navegar a otros módulos como Citas, Pacientes y Medicamentos.

⚙️ Funcionalidades Principales

1. Cargar Usuarios en la Tabla - Al iniciar, la tabla se llena automáticamente con los datos de usuarios extraídos de la base de datos.

        private void cargarUsuariosEnTabla() {
            DefaultTableModel modeloTabla = usuarioController.cargarUsuariosEnTabla();
            if (modeloTabla != null) {
                TablaUsuarios.setModel(modeloTabla);
            } else {
                JOptionPane.showMessageDialog(this, "Error al cargar los datos de usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
   
Acción: Llama al controlador UsuarioController para obtener el modelo de la tabla con los datos.

3. Añadir un Nuevo Usuario - Valida los campos de entrada, añade el usuario a la base de datos y actualiza la tabla.

        private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {
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
                cargarUsuariosEnTabla(); 
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al añadir el usuario.");
            }
        }

Acción: Inserta un nuevo usuario utilizando UsuarioController.

3. Modificar Usuario Existente - Permite modificar un usuario seleccionado en la tabla.
      
              private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
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
                cargarUsuariosEnTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar el usuario.");
            }
        }

Acción: Modifica el usuario utilizando el CURP como identificador único.

4. Eliminar un Usuario - Permite eliminar un usuario seleccionado.

        private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
            String curp = txtFCurp.getText().trim();
        
            if (curp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para eliminar.");
                return;
            }
        
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                if (usuarioController.eliminarUsuario(curp)) {
                    JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
                    cargarUsuariosEnTabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.");
                }
            }
        }

Acción: Elimina el usuario utilizando el CURP.

5. Buscar Usuarios - Realiza una búsqueda filtrada por nombre, apellido, CURP, código o correo.

            private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
            String nombre = txtFNombre.getText().trim();
            String apellido = txtFApellido.getText().trim();
            String curp = txtFCurp.getText().trim();
            String codigo = txtFcodigo.getText().trim();
            String correo = txtFCorreo.getText().trim();
        
            if (nombre.isEmpty() && apellido.isEmpty() && curp.isEmpty() && codigo.isEmpty() && correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa al menos un criterio de búsqueda.");
                return;
            }
        
            List<String[]> resultados = usuarioController.buscarUsuarios(nombre, apellido, curp, codigo, correo);
        
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron usuarios con los criterios proporcionados.");
            } else {
                DefaultTableModel modeloTabla = (DefaultTableModel) TablaUsuarios.getModel();
                modeloTabla.setRowCount(0);
        
                for (String[] usuario : resultados) {
                    modeloTabla.addRow(usuario);
                }
            }
        }
   
Acción: Llama al método buscarUsuarios del controlador para buscar usuarios.

6. Seleccionar Usuario en la Tabla - Muestra los detalles del usuario seleccionado en los campos de texto.

        private void TablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {
            int filaSeleccionada = TablaUsuarios.getSelectedRow();
        
            if (filaSeleccionada >= 0) {
                txtFNombre.setText(TablaUsuarios.getValueAt(filaSeleccionada, 0).toString());
                txtFApellido.setText(TablaUsuarios.getValueAt(filaSeleccionada, 1).toString());
                txtFCurp.setText(TablaUsuarios.getValueAt(filaSeleccionada, 2).toString());
        
                Object fechaNacimiento = TablaUsuarios.getValueAt(filaSeleccionada, 3);
                if (fechaNacimiento != null && !fechaNacimiento.toString().isEmpty()) {
                    try {
                        java.sql.Date fecha = java.sql.Date.valueOf(fechaNacimiento.toString());
                        jDate.setDate(fecha);
                    } catch (Exception e) {
                        jDate.setDate(null);
                    }
                }
                txtFcodigo.setText(TablaUsuarios.getValueAt(filaSeleccionada, 4).toString());
                txtFCorreo.setText(TablaUsuarios.getValueAt(filaSeleccionada, 5).toString());
                combxTipoUser.setSelectedItem(TablaUsuarios.getValueAt(filaSeleccionada, 6).toString());
                jPwContrasena.setText(TablaUsuarios.getValueAt(filaSeleccionada, 7).toString());
                txtFCorreo.setEnabled(false);
            }
       }

Acción: Llena los campos con los datos seleccionados.

7. Limpiar Campos - Restaura los campos a su estado inicial.

        private void limpiarCampos() {
            txtFNombre.setText("");
            txtFApellido.setText("");
            txtFCurp.setText("");
            txtFcodigo.setText("");
            txtFCorreo.setText("");
            jPwContrasena.setText("");
            jDate.setDate(null);
            combxTipoUser.setSelectedIndex(0);
            txtFCorreo.setEnabled(true);
        }

🗂️ Módulo: Gestión de Medicamentos

![image](https://github.com/user-attachments/assets/9fddc25c-c791-4606-8f2b-3e508af39f2e)


El módulo Medicamentos del paquete DashboardAdministrador está diseñado para administrar los medicamentos en el sistema. Proporciona funcionalidades para añadir, eliminar, buscar, y visualizar medicamentos, facilitando la gestión de inventario.

⚙️ Funcionalidades Principales

1. Cargar Medicamentos en la Tabla: Al iniciar la interfaz, la tabla se carga automáticamente con los datos de los medicamentos extraídos de la base de datos.

        private void cargarMedicamentosEnTabla() {
            DefaultTableModel modeloTabla = (DefaultTableModel) TablaMedicamentos.getModel();
            modeloTabla.setRowCount(0); // Limpiar la tabla
        
            MedicamentosModel metodos = new MedicamentosModel();
            try {
                metodos.cargarMedicamentosEnTabla(modeloTabla);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar los medicamentos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

Acción: Llama al método cargarMedicamentosEnTabla() del modelo para llenar la tabla con medicamentos.

2. Añadir un Nuevo Medicamento: Permite añadir un medicamento con detalles como nombre, presentación, tipo de venta, precio y unidades.

        private void btnAnadirMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {
            String nombre = txtNombre.getText().trim();
            String presentacion = txtPresentacion.getText().trim();
            String tipoVenta = txtTipoVenta.getText().trim();
            double precio;
            int unidades;
        
            if (nombre.isEmpty() || presentacion.isEmpty() || tipoVenta.isEmpty() || txtPrecio.getText().trim().isEmpty() || txtUnidades.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
                return;
            }
        
            try {
                precio = Double.parseDouble(txtPrecio.getText().trim());
                unidades = Integer.parseInt(txtUnidades.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El precio y las unidades deben ser valores numéricos.");
                return;
            }
        
            MedicamentosModel metodos = new MedicamentosModel();
            if (metodos.insertarMedicamento(nombre, presentacion, tipoVenta, precio, unidades)) {
                JOptionPane.showMessageDialog(this, "Medicamento añadido con éxito.");
                cargarMedicamentosEnTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al añadir el medicamento.");
            }
        }

Acción: Valida los campos, convierte datos numéricos y llama al modelo para insertar el medicamento.

3. Eliminar un Medicamento: Elimina un medicamento seleccionado de la tabla.

        private void btnEliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {
            int filaSeleccionada = TablaMedicamentos.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un medicamento para eliminar.");
                return;
            }
        
            String nombre = TablaMedicamentos.getValueAt(filaSeleccionada, 0).toString();
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el medicamento '" + nombre + "'?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                MedicamentosModel metodos = new MedicamentosModel();
                if (metodos.eliminarMedicamento(nombre)) {
                    JOptionPane.showMessageDialog(this, "Medicamento eliminado con éxito.");
                    cargarMedicamentosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el medicamento.");
                }
            }
        }

Acción: Elimina el medicamento usando su nombre como identificador.

4. Buscar Medicamentos: Realiza una búsqueda filtrada por nombre, presentación y tipo de venta.

        private void btnBuscarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {
            String nombre = txtNombre.getText().trim();
            String presentacion = txtPresentacion.getText().trim();
            String tipoVenta = txtTipoVenta.getText().trim();
        
            MedicamentoControlador controlador = new MedicamentoControlador();
            List<String[]> medicamentosFiltrados = controlador.buscarMedicamentos(nombre, presentacion, tipoVenta);
        
            DefaultTableModel modeloTabla = (DefaultTableModel) TablaMedicamentos.getModel();
            modeloTabla.setRowCount(0);
        
            for (String[] medicamento : medicamentosFiltrados) {
                modeloTabla.addRow(medicamento);
            }
        
            if (medicamentosFiltrados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron medicamentos con los criterios especificados.");
            }
        }

Acción: Realiza una búsqueda usando el MedicamentoControlador y actualiza la tabla con los resultados.

5. Seleccionar Medicamento (Doble Clic): Al hacer doble clic en un medicamento en la tabla, sus detalles se rellenan en los campos de texto.

        private void TablaMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                int filaSeleccionada = TablaMedicamentos.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) TablaMedicamentos.getModel();
        
                txtNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
                txtPresentacion.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtTipoVenta.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecio.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtUnidades.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
            }
        }

Acción: Extrae los valores de la fila seleccionada y los asigna a los campos.

6. Limpiar Campos: Restaura los campos a su estado inicial.

        private void limpiarCampos() {
            txtNombre.setText("");
            txtPresentacion.setText("");
            txtTipoVenta.setText("");
            txtPrecio.setText("");
            txtUnidades.setText("");
        }

🗂️ Módulo: Gestión de Pacientes

![image](https://github.com/user-attachments/assets/91e8bdd5-7efc-4722-8b51-3a6eea95b828)

El módulo Pacientes en DashboardAdministrador facilita la gestión de información de pacientes en el sistema. Ofrece funcionalidades para añadir, buscar, modificar, eliminar y visualizar registros de pacientes.

⚙️ Funcionalidades Principales

1. Cargar Pacientes en la Tabla: Al iniciar la interfaz, la tabla se llena automáticamente con los datos de pacientes existentes en la base de datos.

        private void cargarPacientesEnTabla() {
            DefaultTableModel modeloTabla = pacienteController.cargarPacientesEnTabla();
            if (modeloTabla != null) {
                TablaPacientes5.setModel(modeloTabla);
            } else {
                JOptionPane.showMessageDialog(this, "Error al cargar los datos de pacientes.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
   
Acción: Llama al controlador PacienteController para recuperar y mostrar la lista de pacientes.

3. Añadir un Nuevo Paciente: Permite ingresar un nuevo paciente con detalles como nombre, apellido, CURP, fecha de nacimiento, sexo, correo, teléfono y dirección.

           private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {
            String nombre = txtNombre5.getText().trim();
            String apellido = txtApellido5.getText().trim();
            String curp = txtCurp5.getText().trim();
            Date fechaNacimiento = jDateNacimiento5.getDate();
            String sexo = buttonHombre5.isSelected() ? "Hombre" : "Mujer";
            String correo = txtCorreo5.getText().trim();
            String telefono = txtTelefono5.getText().trim();
            String direccion = txtDireccion5.getText().trim();
        
            // Validaciones
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") || !apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(null, "Nombre y apellido solo pueden contener letras.");
                return;
            }
            if (!curp.matches("^[A-Z0-9]{18}$")) {
                JOptionPane.showMessageDialog(this, "La CURP debe tener 18 caracteres alfanuméricos en mayúsculas.");
                return;
            }
            if (!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(this, "Correo inválido.");
                return;
            }
        
            java.sql.Date fechaNacimientoSQL = new java.sql.Date(fechaNacimiento.getTime());
        
            if (pacienteController.insertarPaciente(nombre, apellido, curp, fechaNacimientoSQL, sexo, correo, telefono, direccion)) {
                JOptionPane.showMessageDialog(this, "Paciente añadido correctamente.");
                cargarPacientesEnTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al añadir el paciente.");
            }
        }

Acción:
* Valida campos.
* Convierte fecha.
* Envía los datos al controlador PacienteController para su inserción.

3. Modificar un Paciente: Actualiza la información de correo, teléfono y dirección de un paciente.

        private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
            int filaSeleccionada = TablaPacientes5.getSelectedRow();
            if (filaSeleccionada >= 0) {
                String curp = txtCurp5.getText().trim();
                String correo = txtCorreo5.getText().trim();
                String telefono = txtTelefono5.getText().trim();
                String direccion = txtDireccion5.getText().trim();
        
                if (!telefono.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(this, "El teléfono debe tener exactamente 10 dígitos.");
                    return;
                }
                if (pacienteController.modificarPaciente(curp, correo, telefono, direccion)) {
                    JOptionPane.showMessageDialog(this, "Paciente modificado correctamente.");
                    cargarPacientesEnTabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al modificar el paciente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un paciente.");
            }
        }

Acción: 
* Valida datos actualizables.
* Llama al controlador PacienteController para realizar la actualización.
  
4. Eliminar un Paciente: Elimina un paciente seleccionado usando su CURP.

        private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
            int filaSeleccionada = TablaPacientes5.getSelectedRow();
            if (filaSeleccionada >= 0) {
                String curp = TablaPacientes5.getValueAt(filaSeleccionada, 2).toString();
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION && pacienteController.eliminarPaciente(curp)) {
                    JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.");
                    cargarPacientesEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el paciente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un paciente para eliminar.");
            }
        }

Acción: Solicita confirmación y procede con la eliminación.

5. Buscar Pacientes: Filtra pacientes por nombre, apellido, CURP o correo.

        private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
            String nombre = txtNombre5.getText().trim();
            String apellido = txtApellido5.getText().trim();
            String curp = txtCurp5.getText().trim();
            String correo = txtCorreo5.getText().trim();
        
            DefaultTableModel modeloTabla = pacienteController.buscarPacientes(nombre, apellido, curp, correo);
            if (modeloTabla != null && modeloTabla.getRowCount() > 0) {
                TablaPacientes5.setModel(modeloTabla);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron pacientes.");
            }
        }

Acción: Actualiza la tabla con los resultados de la búsqueda.

📋 Módulo: Historial de Citas

![image](https://github.com/user-attachments/assets/9f2c38b4-7aa5-42c9-aac2-a927cf468451)

El módulo HistorialCitas en DashboardAdministrador permite administrar, buscar, eliminar y mostrar el historial de citas de los pacientes. Este módulo está diseñado para proporcionar una vista completa del estado y los detalles de cada cita.

⚙️ Funcionalidades Principales

1. Cargar Historial de Citas: Carga el historial de citas desde la base de datos y lo presenta en una tabla.

        private void cargarHistorialCitas() {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaHistorialC.getModel();
            modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        
            try (Connection conn = ConexionDB.conectar()) {
                HistorialCitasController controlador = new HistorialCitasController();
                ArrayList<HashMap<String, String>> listaCitas = controlador.obtenerCitas(conn);
        
                for (HashMap<String, String> cita : listaCitas) {
                    modeloTabla.addRow(new Object[]{
                        cita.get("hora"),
                        cita.get("fecha"),
                        cita.get("estatus"),
                        cita.get("nombre"),
                        cita.get("apellido"),
                        cita.get("correo"),
                        cita.get("telefono"),
                        cita.get("curp")
                    });
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el historial de citas: " + e.getMessage());
            }
        }

Acción: Recupera las citas mediante HistorialCitasController y las despliega en la tabla.

2. Buscar Citas: Permite buscar citas en función de CURP, fecha, y hora.

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    String curp = txtCurpF.getText().trim();
    java.util.Date fechaSeleccionada = jDateChooser1.getDate();
    String horaTexto = txtHoraF.getText().trim();

    java.sql.Date sqlFecha = fechaSeleccionada != null ? new java.sql.Date(fechaSeleccionada.getTime()) : null;

    if (!horaTexto.isEmpty() && horaTexto.length() == 5) {
        horaTexto += ":00"; // Agregar segundos si falta
    }

    try {
        HistorialCitasController controlador = new HistorialCitasController();
        ArrayList<HashMap<String, String>> listaCitas = controlador.buscarCitas(curp, sqlFecha, horaTexto);

        DefaultTableModel modeloTabla = (DefaultTableModel) tablaHistorialC.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla

        for (HashMap<String, String> cita : listaCitas) {
            modeloTabla.addRow(new Object[]{
                cita.get("hora"),
                cita.get("fecha"),
                cita.get("estatus"),
                cita.get("nombre"),
                cita.get("apellido"),
                cita.get("correo"),
                cita.get("telefono"),
                cita.get("curp")
            });
        }

        if (listaCitas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron citas con los filtros proporcionados.");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar citas: " + ex.getMessage());
    }
}

Acción:
- Recoge datos de los filtros (CURP, fecha y hora).
- Llama a HistorialCitasController para realizar la búsqueda.
- Muestra los resultados en la tabla.
  
3. Eliminar Citas: Elimina una cita seleccionada basándose en su CURP, fecha, y hora.

        private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
            int filaSeleccionada = tablaHistorialC.getSelectedRow();
        
            if (filaSeleccionada >= 0) {
                String curp = tablaHistorialC.getValueAt(filaSeleccionada, 7).toString(); // CURP
                String fecha = tablaHistorialC.getValueAt(filaSeleccionada, 1).toString(); // Fecha
                String hora = tablaHistorialC.getValueAt(filaSeleccionada, 0).toString(); // Hora
        
                int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar la cita seleccionada?\nCURP: " + curp 
                    + "\nFecha: " + fecha + "\nHora: " + hora,
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        
                if (confirmacion == JOptionPane.YES_OPTION) {
                    try (Connection conn = ConexionDB.conectar()) {
                        HistorialCitasController controlador = new HistorialCitasController();
                        boolean exito = controlador.eliminarCita(curp, fecha, hora, conn);
        
                        if (exito) {
                            JOptionPane.showMessageDialog(this, "Cita eliminada correctamente.");
                            cargarHistorialCitas(); // Refrescar la tabla
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo eliminar la cita. Verifique los datos.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error al eliminar la cita: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una cita para eliminar.");
            }
        }

Acción:
* Identifica la fila seleccionada.
* Solicita confirmación del usuario.
* Llama al controlador para ejecutar la eliminación.
* Refresca la tabla.
  
4. Seleccionar y Mostrar Detalles: Selecciona una fila de la tabla y llena los campos del formulario con los datos.

        private void configurarEventoSeleccionTabla() {
            tablaHistorialC.getSelectionModel().addListSelectionListener(event -> {
                if (!event.getValueIsAdjusting()) { // Evitar múltiples eventos
                    int selectedRow = tablaHistorialC.getSelectedRow();
        
                    if (selectedRow != -1) {
                        String hora = tablaHistorialC.getValueAt(selectedRow, 0).toString();
                        String fecha = tablaHistorialC.getValueAt(selectedRow, 1).toString();
                        String estatus = tablaHistorialC.getValueAt(selectedRow, 2).toString();
                        String nombre = tablaHistorialC.getValueAt(selectedRow, 3).toString();
                        String apellido = tablaHistorialC.getValueAt(selectedRow, 4).toString();
                        String correo = tablaHistorialC.getValueAt(selectedRow, 5).toString();
                        String telefono = tablaHistorialC.getValueAt(selectedRow, 6).toString();
                        String curp = tablaHistorialC.getValueAt(selectedRow, 7).toString();
        
                        txtCurpF.setText(curp);
                        txtNombreF.setText(nombre);
                        txtApellidoF.setText(apellido);
                        txtHoraF.setText(hora);
                        txtEstatusF.setText(estatus);
                        txtCorreoF.setText(correo);
                        txtTelefonoF.setText(telefono);
        
                        try {
                            java.util.Date fechaSeleccionada = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                            jDateChooser1.setDate(fechaSeleccionada);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error al establecer la fecha: " + e.getMessage());
                        }
                    }
                }
            });
        }

Acción:
* Detecta la fila seleccionada en la tabla.
* Muestra los datos en los campos correspondientes.
  
5. Mostrar Todo: Restaura la tabla para mostrar todo el historial de citas.

        private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {
            cargarHistorialCitas();
        }

Acción: Llama al método cargarHistorialCitas para recargar todos los registros.

Librerias en el proyecto

![image](https://github.com/user-attachments/assets/bef15571-c811-4f5e-8897-e53d442c6b82)

Explicación del uso de cada librería en el proyecto:

1. Absolute Layout - AbsoluteLayout.jar
   
* Uso: Proporciona soporte para la disposición absoluta de componentes en interfaces gráficas.
* Detalles: Permite colocar componentes en posiciones exactas (x, y) con dimensiones fijas (width, height).Es útil cuando se requiere un control total de la ubicación de los componentes, aunque limita la adaptabilidad a distintos tamaños de pantalla.
  
2. postgresql-42.7.4.jar
  
* Uso: Es el controlador JDBC para conectarse a la base de datos PostgreSQL.
* Detalles:Permite realizar operaciones CRUD (Create, Read, Update, Delete) en una base de datos PostgreSQL. Proporciona clases como Connection, Statement, y ResultSet para manejar consultas SQL. Se utiliza en conjunto con ConexionDB en el proyecto.
  
3. jcalendar-1.4.jar
  
* Uso: Añade un componente gráfico de calendario a la interfaz de usuario.
Detalles: Proporciona un selector de fecha amigable, como el JDateChooser. Permite seleccionar fechas fácilmente en formularios, útil para campos como fecha de nacimiento o fecha de cita.

4. Componente.jar
  
* Uso: Librería personalizada (Componente Captchar de verificacion).
Detalles: Esta librería contiene un componente específico desarrollados para el proyecto. Especificamente se trata de un componente visto en clases anteriores.

5. javax.mail-1.6.2.jar
  
* Uso: Proporciona funcionalidades para enviar correos electrónicos.
* Detalles: Se usa para integrar servicios de correo SMTP. Permite enviar notificaciones automáticas por correo electrónico desde la aplicación, por ejemplo, confirmaciones de citas médicas.
  
6. activation-1.1.jar
   
* Uso: Se utiliza en conjunto con javax.mail para manejar tipos de datos MIME.
* Detalles: Permite adjuntar archivos o manejar tipos de contenido especiales en correos electrónicos. Facilita operaciones como envío de documentos PDF o imágenes en correos.
  
7. kernel-7.2.5.jar
   
* Uso: Parte de la librería iText.
* Detalles: iText se utiliza para crear, leer y manipular archivos PDF. El módulo kernel proporciona las funcionalidades centrales de manipulación de PDFs, como generación de reportes.
  
8. io-7.2.5.jar
   
* Uso: Otro módulo de la librería iText.
* Detalles: Facilita las operaciones de entrada/salida en la manipulación de archivos PDF. Complementa al módulo kernel para leer o escribir contenido en archivos PDF.
  
9. layout-7.2.5.jar
 
* Uso: Extiende funcionalidades de iText para gestionar el diseño de PDFs.
* Detalles: Proporciona herramientas para manejar la estructura y el formato del contenido PDF. Permite añadir elementos como tablas, párrafos y estilos personalizados.
  
10. commons-7.2.5.jar
* Uso: Parte de iText para funcionalidades comunes.
* Detalles: Proporciona herramientas comunes reutilizables en el manejo de PDFs, como utilidades matemáticas o configuraciones globales.
  
11. pdfa-7.2.5.jar
    
* Uso: Permite crear archivos PDF/A.
* Detalles: PDF/A es un formato estándar ISO para la archivación a largo plazo de documentos PDF. Se utiliza en el proyecto para generar documentos legales o históricos, como reportes de pacientes.
  
13. slf4j-api-1.7.36.jar
    
* Uso: Proporciona una interfaz para logs.
* Detalles: SLF4J (Simple Logging Facade for Java) permite abstraer la implementación de logs. Puede integrarse con frameworks como Log4j o java.util.logging para registrar eventos y errores.

Paquetes Controlador y Modelo 

En un proyecto basado en la arquitectura MVC (Modelo-Vista-Controlador), los paquetes Controlador y Modelo tienen roles específicos que permiten separar las responsabilidades del sistema para que sea modular, mantenible y escalable.

Paquete Controlador

Rol principal: Manejar la lógica de negocio y actuar como intermediario entre la Vista y el Modelo.

Responsabilidades:

- Gestionar las interacciones del usuario: Responder a las acciones realizadas en la interfaz gráfica.
- Llamar a los métodos del Modelo: Solicitar operaciones de datos (por ejemplo, guardar, eliminar o buscar información).
- Actualizar la Vista: Enviar los resultados obtenidos del Modelo para reflejar los cambios en la interfaz.
- Clases del paquete:

AgendarCitasController.java: Controla la lógica para programar citas en el sistema. Se comunica con el modelo AgendarCitasModel para manejar los datos de las citas.

CorreoUtils.java: Facilita el envío de correos electrónicos, como notificaciones o confirmaciones. Utiliza la librería javax.mail para conectarse a un servidor de correo.

HistorialCitasController.java: Maneja las operaciones relacionadas con el historial de citas. Comunica a la Vista el historial cargado desde HistorialCitasModel.

MedicamentoControlador.java: Controla la gestión de medicamentos: añadir, buscar, eliminar y actualizar datos. Interactúa con MedicamentosModel.

PacienteController.java: Gestiona las operaciones de los pacientes: registro, modificación, eliminación y búsqueda. Se comunica con PacienteModel.

UsuarioController.java: Controla la lógica de negocio relacionada con los usuarios. Facilita la autenticación, gestión de roles y administración de usuarios usando UsuarioModel.


Paquete Modelo

Rol principal: Encapsular la lógica de acceso a datos y las operaciones sobre la base de datos.

Responsabilidades:
* Conectar con la base de datos: Utilizar una conexión a la base de datos PostgreSQL (en este caso).
* Ejecutar consultas SQL: Realizar operaciones CRUD (Create, Read, Update, Delete).
* Proporcionar datos al Controlador: Devolver los resultados de las consultas para que el Controlador los utilice.
* Clases del paquete:

AgendarCitasModel.java: Define los métodos para insertar y consultar las citas programadas en la base de datos.

HistorialCitasModel.java: Se encarga de consultar y devolver el historial completo de citas. Permite filtrar por fecha, hora, o paciente.

MedicamentosModel.java: Gestiona las operaciones sobre los medicamentos, como insertar, actualizar o eliminar registros.

PacienteModel.java: Define los métodos de acceso a los datos de pacientes, como registrar un paciente o buscar información específica.

UsuarioModel.java: Realiza operaciones sobre los datos de los usuarios, como validar credenciales y administrar roles.

Importancia de esta separación

- Modularidad: Al separar el Modelo y el Controlador, las clases se vuelven más organizadas y fáciles de entender.
- Reutilización: Los métodos del Modelo pueden ser reutilizados por múltiples Controladores.
- Mantenibilidad: Si se requiere cambiar la lógica de acceso a datos (por ejemplo, cambiar de PostgreSQL a MySQL), solo se modifica el paquete Modelo.
- Pruebas unitarias: Es más fácil realizar pruebas unitarias en clases del Modelo y Controlador de forma independiente.




https://github.com/user-attachments/assets/98ca626c-bb89-4e06-aa4d-44242673b3ad

