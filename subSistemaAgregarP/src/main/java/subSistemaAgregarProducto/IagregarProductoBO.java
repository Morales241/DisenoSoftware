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
public interface IagregarProductoBO {
    public void agregarCompraLista(ProductoCompradoDto proCompDto, int op);
    
//    public List<ProductoCompradoDto> getListaProductosComprados();
//    
//    public void setListaProductosComprados(List<ProductoCompradoDto> listaProductosComprados);
    
}
