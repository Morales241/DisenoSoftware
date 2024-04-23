/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaProductosComprados;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class FachadaProductosComprados implements IConsultarProductoCompradoBO{

    ConsultarProductoCompradoBO ConsultaPC = ConsultarProductoCompradoBO.getInstance();

    public FachadaProductosComprados() {
    }
    
    @Override
    public boolean agregarCompraLista(ProductoCompradoDto proCompDto) {
        return ConsultaPC.agregarCompraLista(proCompDto);
        
    }

    @Override
    public List<ProductoCompradoDto> getListaProductosComprados() {
        return ConsultaPC.getListaProductosComprados();
    }

    @Override
    public void eliminarProductos(int index) {
        ConsultaPC.eliminarProducto(index);
    }
    
}
