/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.DaoOrdenCompra;
import Entidades.ordenCompra;
import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoCompradoBO implements IProductoCompradoBO {
    
    DaoOrdenCompra ordenDao = new DaoOrdenCompra();

    @Override
    public List<ProductoCompradoDto> obtenerProductosOrden(ordenCompra oc) throws Exception {
        List<ProductoCompradoDto> listaAux = new ArrayList<>();
        ordenDao.buscarPorID(oc).getProductos().forEach(proCompradoMocko -> {
            listaAux.add(new ProductoCompradoDto(proCompradoMocko.getNombre(), proCompradoMocko.getCodigo(), proCompradoMocko.getProveedor(),
                    proCompradoMocko.getCantidad(), proCompradoMocko.getPrecio()));
        });
        return listaAux;
    }
    
}
