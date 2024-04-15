/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsistema;

import dto.ProductoCompradoDto;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marlon
 */
public class LlenarTabla implements ILlenarTabla {

    @Override
    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla) {
        // Crear un modelo de tabla y establecerlo en el JTable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nombre","Codigo", "Proveedor", "Costo", "cantidad", "Total"});
        
        if (lista.isEmpty()) {
            System.out.println("No se encontraron productos");
        }else{
            for (ProductoCompradoDto p : lista) {
                model.addRow(new Object[]{p.getNombre(), p.getCodigo(), p.getProveedor(),p.getPrecio(), p.getCantidad(), p.getPrecio()*p.getCantidad()});
            }
        }
    }
}
