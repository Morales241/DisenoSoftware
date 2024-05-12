/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import daos.ProductoProveedorDao;
import entidades.ProductoProveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoProveedorBO implements IProductoProveedorBO {
    
    ProductoProveedorDao ProductoProveedorDao = new ProductoProveedorDao();

    @Override
    public ProductoCompradoDto obtenerProductoProveedor(String nombre, String pro) {
        List<ProductoProveedor> listaProductoProveedores = ProductoProveedorDao.obtenerProductosProveedores();

        for (ProductoProveedor pp : listaProductoProveedores) {
            if (pp.getProducto().getNombre().equals(nombre) && pp.getProveedor().getNombre().equals(pro)) {
                ProductoCompradoDto pc = new ProductoCompradoDto(pp.getProducto().getNombre(), pp.getProducto().getCodigo(),
                        pp.getProveedor().getNombre(), 0, pp.getPrecio());
                return pc;
            }
        }
        return null;
    }

    @Override
    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto) {
        List<ProductoProveedor> listaProductoProveedores = ProductoProveedorDao.obtenerProductosProveedores();

        List<ProductoProveedor> listaAux = new ArrayList<>();

        List<ProductoProveedorDto> listaProductoProveedoresDto = new ArrayList<>();

        for (ProductoProveedor pp : listaProductoProveedores) {
            if (pp.getProducto().getId() == idProducto) {
                listaAux.add(pp);
            }
        }

        for (ProductoProveedor p : listaAux) {
            listaProductoProveedoresDto.add(new ProductoProveedorDto(p.getPrecio(), p.getStock(),
                    new ProductoDto(p.getProducto().getId(), p.getProducto().getNombre(), p.getProducto().getCodigo()),
                    new ProveedorDto(p.getProveedor().getId(), p.getProveedor().getNombre(), p.getProveedor().getTelefono())));
        }

        return listaProductoProveedoresDto;
    }
    
}
