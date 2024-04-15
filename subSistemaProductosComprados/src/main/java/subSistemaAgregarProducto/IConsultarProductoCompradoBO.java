/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IConsultarProductoCompradoBO {
    public void agregarCompraLista(ProductoCompradoDto proCompDto);
    
    public List<ProductoCompradoDto> getListaProductosComprados();
    
}
