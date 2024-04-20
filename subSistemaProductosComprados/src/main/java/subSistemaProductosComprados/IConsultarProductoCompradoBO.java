/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subSistemaProductosComprados;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IConsultarProductoCompradoBO {
    public boolean agregarCompraLista(ProductoCompradoDto proCompDto);
    
    public List<ProductoCompradoDto> getListaProductosComprados();
    
}
