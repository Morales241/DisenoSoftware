/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocioBO;

import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoEntregadoDto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlon
 */
public interface IProductoEntregadoBO {

    public void eliminarDeInventario(int index);

    public List<ProductoEntregadoDto> obtenerInventarioBajo();
    
    // SALIDA INVENTARIO
    
    public DefaultTableModel obtenerProductosBuscados(String cadena);
    
    public ProductoEntregadoDto obtenerProductoPorCodigo(String codigo);
    
    public void ordenarProductos(List<ProductoEntregadoDto> listaProductos);
    
    public void desinventariarProducto(ProductoEntregadoDto producto);

}
