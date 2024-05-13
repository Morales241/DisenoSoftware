/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaSalidaInventario;

import Negocio.dto.ProductoEntregadoDto;
import dtos.ProductoDTO;
import negocioBO.ProductoEntregadoBO;

/**
 *
 * @author marlon
 */
public class CtrlSalidaInventario {
    
    private ProductoEntregadoBO productoBO;

    public CtrlSalidaInventario() {
        productoBO = new ProductoEntregadoBO();
    }

    public void desinventariarProducto(ProductoEntregadoDto producto) {
        productoBO.desinventariarProducto(producto);
    }
    
}