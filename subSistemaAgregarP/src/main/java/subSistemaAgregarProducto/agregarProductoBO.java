/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class agregarProductoBO implements IagregarProductoBO {
    
    List<ProductoCompradoDto> listaProductosComprados = new ArrayList<>();

    @Override
    public List<ProductoCompradoDto> agregarCompraLista(ProductoCompradoDto proCompDto) {
        listaProductosComprados.add(proCompDto);
        return listaProductosComprados;
    }

//    @Override
//    public List<ProductoCompradoDto> getListaProductosComprados() {
//        return listaProductosComprados;
//    }
//
//    @Override
//    public void setListaProductosComprados(List<ProductoCompradoDto> listaProductosComprados) {
//        this.listaProductosComprados = listaProductosComprados;
//    }
    
}