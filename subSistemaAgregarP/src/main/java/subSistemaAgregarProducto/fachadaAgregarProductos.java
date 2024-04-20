/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;

/**
 *
 * @author tacot
 */
public class fachadaAgregarProductos implements IagregarProductoBO{
    agregarProductoBO agregar = new agregarProductoBO();
    public fachadaAgregarProductos() {
    }

    @Override
    public void agregarCompraLista(ProductoCompradoDto proCompDto) {
        agregar.agregarCompraLista(proCompDto);
    }    
}
