/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaInventario;

import Negocio.dto.ProductoEntregadoDto;
import dtos.ProductoDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocioBO.ProductoEntregadoBO;


/**
 *
 * @author marlon
 */
public class CtrlInventario {

    private ProductoEntregadoBO productoBO;

    public CtrlInventario() {
        productoBO = new ProductoEntregadoBO();
    }

    public DefaultTableModel obtenerProductosBuscados(String cadena) {
        return productoBO.obtenerProductosBuscados(cadena);
    }

    public ProductoEntregadoDto obtenerProductoPorCodigo(String codigo) {
        return productoBO.obtenerProductoPorCodigo(codigo);
    }

    private void ordenarProductos(List<ProductoEntregadoDto> listaProductos) {
        productoBO.ordenarProductos(listaProductos);
    }

}
