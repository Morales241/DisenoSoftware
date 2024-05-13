/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Negocio.dto.ProductoDto;
import daos.ProductoDao;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class ProductoBO implements IProductoBO{

    @Override
    public List<ProductoDto> obtenerProductos() {
        ProductoDao productoDao = new ProductoDao();

        List<Producto> listaProductos = productoDao.obtenerProductos();
        List<ProductoDto> listaProductosDto = new ArrayList<>();
        for (Producto p : listaProductos) {
            listaProductosDto.add(new ProductoDto(p.getId(), p.getNombre(), p.getCodigo()));
        }
        return listaProductosDto;
    }
}
