/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ConexionPostgreSQL.ConexionDB;
import Modelo.AgendarCitasModel;
import com.toedter.calendar.JCalendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTextArea;
/**
 *
 * @author rober
 */
public class AgendarCitasController {
     private final AgendarCitasModel historialCitasDAO;

    public AgendarCitasController() {
        this.historialCitasDAO = new AgendarCitasModel();
    }

public void confirmarCita(String curp, String horaTexto, String fechaTexto, JTextArea jtxtAreaCitas, JCalendar jCalendarCitas) {
    try (Connection conn = ConexionDB.conectar()) {
        // Validar datos
        if (curp.isEmpty() || horaTexto.isEmpty() || fechaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
            return;
        }

        // Validar y convertir hora al formato requerido
        Time hora;
        try {
            hora = Time.valueOf(horaTexto); // Convierte a Time (HH:mm:ss)
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "La hora debe estar en el formato HH:mm:ss.");
            return;
        }

        // Validar y convertir fecha al formato requerido
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date fecha;
        try {
            java.util.Date parsedDate = dateFormat.parse(fechaTexto);
            fecha = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "La fecha debe estar en el formato YYYY-MM-DD.");
            return;
        }

        // Verificar si la hora y fecha ya están ocupadas
        if (historialCitasDAO.verificarCitaExistente(hora, fecha, conn)) {
            JOptionPane.showMessageDialog(null, "El horario está agendado.");
            return;
        }

        // Llamar al modelo para registrar la cita
        boolean exito = historialCitasDAO.registrarCita(curp, hora, fecha, conn);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Cita registrada con éxito.");

            // Refrescar las citas en tiempo real
            refrescarCitas(jCalendarCitas, jtxtAreaCitas);
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al registrar la cita: " + ex.getMessage());
    }
}


 public void cancelarCita(String curp, String horaTexto, String fechaTexto) {
    try (Connection conn = ConexionDB.conectar()) {
        // Validar y convertir hora
        Time hora = Time.valueOf(horaTexto); // Hora en formato HH:mm:ss

        // Validar y convertir fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = new java.sql.Date(dateFormat.parse(fechaTexto).getTime());

        // Verificar si la cita ya fue cancelada
        if (historialCitasDAO.verificarCitaCancelada(curp, hora, fecha, conn)) {
            JOptionPane.showMessageDialog(null, "La cita ya fue cancelada previamente. No puede re-agendar.");
            return;
        }

        // Cancelar la cita
        boolean exito = historialCitasDAO.cancelarCita(curp, hora, fecha, conn);
        if (exito) {
            JOptionPane.showMessageDialog(null, "La cita ha sido cancelada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cancelar la cita. Verifica los datos.");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al cancelar la cita: " + ex.getMessage());
    }
}

 
 private void refrescarCitas(JCalendar jCalendarCitas, JTextArea jtxtAreaCitas) {
    try (Connection conn = ConexionDB.conectar()) {
        // Obtener la fecha seleccionada del JCalendar
        java.util.Date fechaSeleccionada = jCalendarCitas.getDate();
        java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());

        // Obtener las citas de la base de datos
        AgendarCitasModel modelo = new AgendarCitasModel();
        ArrayList<String> citas = modelo.obtenerCitasPorFecha(fechaSQL, conn);

        // Limpiar el JTextArea y mostrar las citas actualizadas
        jtxtAreaCitas.setText("");
        if (citas.isEmpty()) {
            jtxtAreaCitas.setText("No hay citas agendadas para este día.");
        } else {
            for (String cita : citas) {
                jtxtAreaCitas.append(cita + "\n");
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al refrescar las citas: " + ex.getMessage());
    }
}


}
