/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class agregarProductoBO implements IagregarProductoBO {
    
    List<ProductoCompradoDto> listaProductosComprados;

    @Override
    public List<ProductoCompradoDto> agregarCompraLista(List<ProductoCompradoDto> prdsDto, ProductoCompradoDto proCompDto) {
        prdsDto.add(proCompDto);
        return prdsDto;
    }

    public List<ProductoCompradoDto> getListaProductosComprados() {
        return listaProductosComprados;
    }

    public void setListaProductosComprados(List<ProductoCompradoDto> listaProductosComprados) {
        this.listaProductosComprados = listaProductosComprados;
    }
    
}