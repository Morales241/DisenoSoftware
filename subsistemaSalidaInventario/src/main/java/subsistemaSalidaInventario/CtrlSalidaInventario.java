/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaSalidaInventario;

import dtos.ProductoDTO;
import objetosNegocio.ProductoBO;

/**
 *
 * @author marlon
 */
public class CtrlSalidaInventario {
    
    private ProductoBO productoBO;

    public CtrlSalidaInventario() {
        productoBO = new ProductoBO();
    }

    public void desinventariarProducto(ProductoDTO producto) {
        productoBO.desinventariarProducto(producto);
    }
    
    private Long obtenerIdProducto(String codigo) {
        return productoBO.obtenerIdProducto(codigo);
    }
    
}
