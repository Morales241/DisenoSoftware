/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.DaoproComprado;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoEntregadoDto;
import daos.ProductoDao;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marlon
 */
public class ProductoEntregadoBO implements IProductoEntregadoBO {
    
    DaoproComprado daoProductos = new DaoproComprado();

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

    @Override
    public void eliminarDeInventario(int index) {
        //        inventario.eliminarAInventario(index);
    }

    @Override
    public List<ProductoEntregadoDto> obtenerInventarioBajo() {
        List<ProductoEntregadoDto> listaAux = new ArrayList<>();
        try {
            daoProductos.consultar().forEach(proEntregadoMock -> {
                if (proEntregadoMock.getCantidad() < 3) {
                    listaAux.add(new ProductoEntregadoDto(proEntregadoMock.getNombre(), proEntregadoMock.getCodigo(), proEntregadoMock.getProveedor(),
                            proEntregadoMock.getCantidad(), proEntregadoMock.getPrecio()));
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(NegocioBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAux;
    }
    
}
