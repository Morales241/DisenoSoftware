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

    public ConsultarProductoCompradoBO() {
        
    }

    @Override
    public void agregarCompraLista(ProductoCompradoDto proCompDto, int op) {
        
        
        if (op == 1) {
            listaProductosComprados.add(proCompDto);
        }else{
            listaProductosComprados.forEach(ProductoCompradoDto ->{
                if (ProductoCompradoDto.getNombre().equals(proCompDto.getNombre())) {
                    ProductoCompradoDto.setCantidad(3+ProductoCompradoDto.getCantidad());
                    
                }
            });
            
        }
    }

    @Override
    public List<ProductoCompradoDto> getListaProductosComprados() {
        return listaProductosComprados;
    }

}
