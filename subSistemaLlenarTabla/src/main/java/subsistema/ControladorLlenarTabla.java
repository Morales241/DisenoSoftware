/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsistema;

import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoEntregadoDto;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marlon
 */
public class ControladorLlenarTabla  {

    public ControladorLlenarTabla() {
    }

    
    public void llenarTablaInventario(List<ProductoEntregadoDto> lista, JTable tabla) {
        // Crear un modelo de tabla y establecerlo en el JTable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nombre", "Codigo", "cantidad"});

        if (lista.isEmpty()) {
            System.out.println("No se encontraron productos en el inventario");
        } else {
            for (ProductoEntregadoDto p : lista) {
                model.addRow(new Object[]{p.getNombre(), p.getCodigo(), p.getCantidad()});
            }
        }
        tabla.setModel(model);
    }
    
    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla) {
        // Crear un modelo de tabla y establecerlo en el JTable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nombre", "Codigo", "P/U", "cantidad", "total"});

        if (lista.isEmpty()) {
            System.out.println("No se encontraron productos");
        } else {
            for (ProductoCompradoDto p : lista) {
                model.addRow(new Object[]{p.getNombre(), p.getCodigo(),p.getPrecio(), p.getCantidad(), p.getCantidad()*p.getPrecio()});
            }
        }
        tabla.setModel(model);
    }
}
