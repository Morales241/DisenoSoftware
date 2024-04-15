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
public class ConsultarProductoCompradoBO implements IConsultarProductoCompradoBO {

    List<ProductoCompradoDto> listaProductosComprados = new ArrayList<>();

    @Override
    public void agregarCompraLista(ProductoCompradoDto proCompDto) {
        listaProductosComprados.add(proCompDto);
    }

    @Override
    public List<ProductoCompradoDto> getListaProductosComprados() {
        return listaProductosComprados;
    }

}
