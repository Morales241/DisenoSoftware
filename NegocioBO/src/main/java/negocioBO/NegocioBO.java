/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.OrdenCompraJpaController;
import DaosMock.DaoOrdenMock;
import DaosMock.DaoproComMock;
import Entidades.OrdenCompra;
import Entidades.ProComprado;
import EntidadesMock.ordenMock;
import EntidadesMock.proCompradoMock;
import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import daos.ProductoDao;
import daos.ProductoProveedorDao;
import entidad.Presupuesto;
import entidades.Producto;
import entidades.ProductoProveedor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author tacot
 */
public class NegocioBO implements InegocioBO {
    ProductoProveedorDao ProductoProveedorDao = new ProductoProveedorDao();
    
    public NegocioBO() {
    }

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

    @Override
    public void realizarOrden(List<ProductoCompradoDto> prdsDto) {
//        OrdenCompraJpaController OrdenDAO = new OrdenCompraJpaController();
//        
//        List<ProComprado> productos = new ArrayList<>();
//
//        prdsDto.forEach(ProductoCompradoDto -> {
//
//            productos.add(new ProComprado(ProductoCompradoDto.getNombre(), ProductoCompradoDto.getCodigo(),
//                    ProductoCompradoDto.getProveedor(), ProductoCompradoDto.getCantidad(), ProductoCompradoDto.getPrecio()));
//        });
//
//        OrdenCompra oc = new OrdenCompra();
//        oc.setFechaExpedicion(Calendar.getInstance());
//        oc.setProductos(productos);
//        double total = 0;
//        for (ProComprado p : productos) {
//            total += p.getCantidad() * p.getPrecio();
//        }
//
//        oc.setTotal(total);
//        
//        OrdenDAO.create(oc);

            DaoOrdenMock ordenDao = DaoOrdenMock.getInstance();
            
            List<proCompradoMock> productos = new ArrayList<>();
            
            prdsDto.forEach(ProductoCompradoDto -> {           
            productos.add(new proCompradoMock(ProductoCompradoDto.getNombre(), ProductoCompradoDto.getCodigo(),
                    ProductoCompradoDto.getProveedor(), ProductoCompradoDto.getCantidad(), ProductoCompradoDto.getPrecio()));
        });
            
            ordenMock oc = new ordenMock();
        oc.setFechaExpedicion(Calendar.getInstance());
        oc.setProductos(productos);
        double total = 0;
        for (proCompradoMock p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }
        
        oc.setTotal(total);
        
        ordenDao.agregarOrden(oc);
    }

    @Override
    public boolean verificarPresupuesto(Double cantidad) {
        Presupuesto pp = new Presupuesto();
        
        return cantidad <= pp.getFondoMonetario();
    }

    @Override
    public ProductoCompradoDto obtenerProductoProveedor(String nombre,String pro){
        
        List<ProductoProveedor> listaProductoProveedores = ProductoProveedorDao.obtenerProductosProveedores();
        
        for (ProductoProveedor pp : listaProductoProveedores) {
            if (pp.getProducto().getNombre().equals(nombre) && pp.getProveedor().getNombre().equals(pro)) {
                ProductoCompradoDto pc = new ProductoCompradoDto(pp.getProducto().getNombre(),pp.getProducto().getCodigo(), 
                        pp.getProveedor().getNombre(), 0, pp.getPrecio());
                return pc;
            }
        }
        return null;
    }

    @Override
    public OrdenCompraDto consultarOrdenes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarAInventario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarDeInventario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
