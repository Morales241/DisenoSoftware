/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaInventario;

import Negocio.dto.ProductoEntregadoDto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocioBO.ProductoEntregadoBO;

/**
 *
 * @author tacot
 */
public class CtrlInventario {

    private ProductoEntregadoBO productoBO = new ProductoEntregadoBO();

    public DefaultTableModel obtenerProductosBuscados(String cadena) {
        return this.productoBO.obtenerProductosBuscados(cadena);
    }

    public ProductoEntregadoDto obtenerProductoPorCodigo(String codigo) {
        return this.productoBO.obtenerProductoPorCodigo(codigo);
    }

    private void ordenarProductos(List<ProductoEntregadoDto> listaProductos) {
        this.productoBO.ordenarProductos(listaProductos);
    }
}
