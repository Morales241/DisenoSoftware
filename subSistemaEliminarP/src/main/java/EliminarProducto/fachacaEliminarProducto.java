/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EliminarProducto;

import Negocio.dto.ProductoCompradoDto;

/**
 *
 * @author tacot
 */
public class fachacaEliminarProducto implements IfachadaEliminarP{
    EliminarProductoBO EP = new EliminarProductoBO();

    public fachacaEliminarProducto() {
    }
    
    @Override
    public void eliminarProducto(int index) {
        EP.eliminarProducto(index);
    }
    
}