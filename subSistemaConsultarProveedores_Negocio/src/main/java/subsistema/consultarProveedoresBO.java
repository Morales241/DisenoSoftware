/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import daos.ProductoProveedorDao;
import java.util.ArrayList;
import java.util.List;
import entidades.Proveedor;
import daos.ProveedorDao;
import entidades.ProductoProveedor;

/**
 *
 * @author tacot
 */
public class consultarProveedoresBO implements IConsultarProveedores {

    public consultarProveedoresBO() {
    }

    @Override
    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto) {

        ProductoProveedorDao ProductoProveedorDao = new ProductoProveedorDao();

        List<ProductoProveedor> listaProductoProveedores = ProductoProveedorDao.obtenerProductosProveedores();

        List<ProductoProveedorDto> listaProductoProveedoresDto = new ArrayList<>();

        for (ProductoProveedor pp : listaProductoProveedores) {
            if (pp.getProducto().getId() == idProducto) {
                listaProductoProveedores.add(pp);
            }
        }

        for (ProductoProveedor p : listaProductoProveedores) {
            listaProductoProveedoresDto.add(new ProductoProveedorDto(p.getPrecio(), p.getStock(),
                    new ProductoDto(p.getProducto().getId(), p.getProducto().getNombre(), p.getProducto().getCodigo()),
                    new ProveedorDto(p.getProveedor().getId(), p.getProveedor().getNombre(), p.getProveedor().getTelefono())));
        }

        return listaProductoProveedoresDto;

//        pro_ProJpaController ppjc = new pro_ProJpaController();
//
//        List<pro_Pro> pplist = ppjc.findpro_ProEntities();
//
//        List<pro_Pro> provlist = new ArrayList<>();
//
//        for (pro_Pro pp : pplist) {
//            if (pp.getProducto().getId() == idProducto) {
//                provlist.add(pp);
//            }
//        }
//
//        List<ProductoProveedorDto> provlistdto = new ArrayList<>();
//
//        for (pro_Pro p : provlist) {
//            provlistdto.add(new ProductoProveedorDto(p.getPrecioP(), p.getStock(),
//                    new ProductoDto(p.getProducto().getId(), p.getProducto().getNombre(), p.getProducto().getCodigo()),
//                    new ProveedorDto(p.getProveedor().getId(), p.getProveedor().getNombre(), p.getProveedor().getTelefono())));
//        }
//
//        return provlistdto;
    }

    @Override
    public ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor) {

        ProductoProveedorDao ProductoProveedorDao = new ProductoProveedorDao();

        List<ProductoProveedor> listaProductoProveedores = ProductoProveedorDao.obtenerProductosProveedores();

        for (ProductoProveedor p : listaProductoProveedores) {
            if (idProducto == p.getProducto().getId() && idProveedor == p.getProveedor().getId()) {
                return new ProductoProveedorDto(p.getPrecio(), p.getStock(),
                        new ProductoDto(p.getProducto().getId(), p.getProducto().getNombre(), p.getProducto().getCodigo()),
                        new ProveedorDto(p.getProveedor().getId(), p.getProveedor().getNombre(), p.getProveedor().getTelefono()));
            }
        }
        return null;

//        pro_ProJpaController ppjc = new pro_ProJpaController();
//        List<pro_Pro> pplist = ppjc.findpro_ProEntities();
//
//        for (pro_Pro pp : pplist) {
//            if (idProducto == pp.getProducto().getId() && idProveedor == pp.getProveedor().getId()) {
//                return new ProductoProveedorDto(pp.getPrecioP(), pp.getStock(), 
//              new ProductoDto(pp.getProducto().getId(), pp.getProducto().getNombre(), pp.getProducto().getCodigo()),
//          new ProveedorDto(pp.getProveedor().getNombre(), pp.getProveedor().getTelefono()));
//            }
//        }
//
//        return null;
//        }
    }

}
