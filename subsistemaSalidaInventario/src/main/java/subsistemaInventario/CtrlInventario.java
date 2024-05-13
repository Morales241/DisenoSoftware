/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaInventario;

import dtos.ProductoDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.ProductoBO;

/**
 *
 * @author marlon
 */
public class CtrlInventario {

    private ProductoBO productoBO;

    public CtrlInventario() {
        productoBO = new ProductoBO();
    }

    public DefaultTableModel obtenerProductosBuscados(String cadena) {
        return productoBO.obtenerProductosBuscados(cadena);
    }

    public ProductoDTO obtenerProductoPorCodigo(String codigo) {
        return productoBO.obtenerProductoPorCodigo(codigo);
    }

    private void ordenarProductos(List<ProductoDTO> listaProductos) {
        productoBO.ordenarProductos(listaProductos);
    }

}
