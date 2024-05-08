/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaEntradaInventario;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 



/**
 *
 * @author 
 */
public class controladorEntradaInventario {
    
    public controladorEntradaInventario(){
        
    }
    
    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{ "Nombre", "Cantidad Esperada", "Cantidad Recibida"});
        
        if (lista.isEmpty()) {
            System.out.println("No se encontraron productos");
        } else {
            for (ProductoCompradoDto p : lista){
                int cantidad = cantidadRecibida();
                
                int resultado = p.getCantidad();
                
                if (p.getCantidad() >= cantidad) {
                    resultado = p.getCantidad() - cantidad;
                }
                
                model.addRow(new Object[]{p.getNombre(), p.getCantidad(), resultado});
            }
        }
        
    }
    
    public Integer cantidadRecibida(){
        
        Integer cant = new Random().nextInt(50)+1;
        
        int resultado = 0;
        
        if (cant == 35) {
            resultado = new Random().nextInt(3)+1;
        }
        return resultado;
    }
    
}
