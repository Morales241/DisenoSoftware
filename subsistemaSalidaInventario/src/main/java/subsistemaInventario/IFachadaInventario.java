/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaInventario;

import dtos.ProductoDTO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlon
 */
public interface IFachadaInventario {
    
    public DefaultTableModel buscarProductos(String cadena);
    
    public ProductoDTO obtenerProductoPorCodigo(String codigo);
    
}
