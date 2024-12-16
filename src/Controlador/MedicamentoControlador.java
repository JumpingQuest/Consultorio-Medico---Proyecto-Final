/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MedicamentosModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rober
 */
public class MedicamentoControlador {
    
    private final MedicamentosModel modeloMedicamentos;

    public MedicamentoControlador() {
        this.modeloMedicamentos = new MedicamentosModel();
    }

    public boolean insertarMedicamento(String nombre, String presentacion, String tipoVenta, double precio, int unidades) {
        return modeloMedicamentos.insertarMedicamento(nombre, presentacion, tipoVenta, precio, unidades);
    }

    public boolean eliminarMedicamento(String nombre) {
        return modeloMedicamentos.eliminarMedicamento(nombre);
    }

    public List<String[]> buscarMedicamentos(String nombre, String presentacion, String tipoVenta) {
        return modeloMedicamentos.buscarMedicamentos(nombre, presentacion, tipoVenta);
    }

    public void cargarMedicamentosEnTabla(DefaultTableModel modeloTabla) {
        modeloMedicamentos.cargarMedicamentosEnTabla(modeloTabla);
    }
}
