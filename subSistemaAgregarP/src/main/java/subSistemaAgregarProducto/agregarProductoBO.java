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
public class agregarProductoBO implements IagregarProductoBO {

    public agregarProductoBO() {
    }
    
    IConsultarProductoCompradoBO PC = ConsultarProductoCompradoBO.getInstance();
    

    @Override
    public void agregarCompraLista(ProductoCompradoDto proCompDto) {
        PC.agregarCompraLista(proCompDto);
        
    }

    
}