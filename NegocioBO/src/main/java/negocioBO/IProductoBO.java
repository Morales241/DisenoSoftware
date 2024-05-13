/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocioBO;

import Negocio.dto.ProductoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IProductoBO {
    
    public List<ProductoDto> obtenerProductos();
}
