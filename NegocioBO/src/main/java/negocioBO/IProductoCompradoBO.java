/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocioBO;

import Entidades.ordenCompra;
import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author marlon
 */
public interface IProductoCompradoBO {
    
    public List<ProductoCompradoDto> obtenerProductosOrden(ordenCompra oc) throws Exception;
    
}
