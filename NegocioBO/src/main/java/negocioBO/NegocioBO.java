/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.OrdenCompraJpaController;
import DaosMock.DaoOrdenMock;
import DaosMock.DaoproComMock;
import DaosMock.DaoproEntregadoMock;
import Entidades.OrdenCompra;
import Entidades.ProComprado;
import EntidadesMock.ordenMock;
import EntidadesMock.proCompradoMock;
import EntidadesMock.proEntregadoMock;
import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoEntregadoDto;
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

    DaoOrdenMock ordenDao = DaoOrdenMock.getInstance();
    
    DaoproEntregadoMock inventario = DaoproEntregadoMock.getinstance();
    

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
    public List<OrdenCompraDto> consultarOrdenes() {
        List<OrdenCompraDto> listaOrdenes = new ArrayList<>();

        ordenDao.consultarOrden().forEach(ordenMock -> {

            List<ProductoCompradoDto> listaAux = new ArrayList<>();

            ordenMock.getProductos().forEach(proCompradoMock -> {

                listaAux.add(new ProductoCompradoDto(proCompradoMock.getNombre(), proCompradoMock.getCodigo(), proCompradoMock.getProveedor(),
                        proCompradoMock.getCantidad(), proCompradoMock.getPrecio()));
            });

            listaOrdenes.add(new OrdenCompraDto(ordenMock.getTotal(), ordenMock.getFechaExpedicion(), listaAux));
        });

        return listaOrdenes;
    }

    @Override
    public void agregarAInventario(List<ProductoCompradoDto> prdsDto) {
        prdsDto.forEach(ProductoCompradoDto->{
        inventario.agregarAInventario(new proEntregadoMock(ProductoCompradoDto.getNombre(), 
                ProductoCompradoDto.getCodigo(), ProductoCompradoDto.getProveedor(),
                ProductoCompradoDto.getCantidad(), ProductoCompradoDto.getPrecio()));
    
        });
        
    }

    @Override
    public void eliminarDeInventario(int index) {
        
        inventario.eliminarAInventario(index);
    }

    
    @Override
    public List<ProductoCompradoDto> obetenerProductosOrden(int index) {
        List<ProductoCompradoDto> listaAux = new ArrayList<>();
        ordenDao.consultarProductosOrden(index).forEach(proCompradoMocko -> {
            listaAux.add(new ProductoCompradoDto(proCompradoMocko.getNombre(), proCompradoMocko.getCodigo(), proCompradoMocko.getProveedor(),
                    proCompradoMocko.getCantidad(), proCompradoMocko.getPrecio()));
        });
        return listaAux;
    }

    @Override
    public List<ProductoEntregadoDto> obtenerInventarioBajo() {
        List<ProductoEntregadoDto> listaAux = new ArrayList<>();
        inventario.consultarInventario().forEach(proEntregadoMock->{
            if (proEntregadoMock.getCantidad()<3) {
                listaAux.add(new ProductoEntregadoDto(proEntregadoMock.getNombre(), proEntregadoMock.getCodigo(), proEntregadoMock.getProveedor(),
                    proEntregadoMock.getCantidad(), proEntregadoMock.getPrecio()));
            }
        });
        
        return listaAux;
    }
}
