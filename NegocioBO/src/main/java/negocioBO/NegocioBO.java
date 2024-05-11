/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.DaoOrdenCompra;
import Daos.DaoproComprado;
import Entidades.ordenCompra;
import Entidades.proComprado;
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
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tacot
 */
public class NegocioBO implements InegocioBO {

    ProductoProveedorDao ProductoProveedorDao = new ProductoProveedorDao();

    DaoOrdenCompra ordenDao = new DaoOrdenCompra();

    proComprado inventario = new proComprado();
    
    DaoproComprado daoProductos = new DaoproComprado();

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

        List<proComprado> productos = new ArrayList<>();

        prdsDto.forEach(ProductoCompradoDto -> {
            productos.add(new proComprado(ProductoCompradoDto.getNombre(), ProductoCompradoDto.getCodigo(),
                    ProductoCompradoDto.getProveedor(), ProductoCompradoDto.getCantidad(), ProductoCompradoDto.getPrecio()));
        });

        ordenCompra oc = new ordenCompra();
        oc.setFechaExpedicion(new Date());
        oc.setProductos(productos);
        oc.setEstado("NoPagado");
        oc.setFolio(generarFolio());
        double total = 0;
        for (proComprado p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }

        oc.setTotal(total);

        try {
            ordenDao.guardar(oc);
        } catch (Exception ex) {
            Logger.getLogger(NegocioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean verificarPresupuesto(Double cantidad) {
        Presupuesto pp = Presupuesto.getInstance();

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

        try {
            ordenDao.consultar().forEach(ordenCompra -> {

                if (ordenCompra.getEstado().equals("NoPagado")) {
                    List<ProductoCompradoDto> listaAux = new ArrayList<>();

                    ordenCompra.getProductos().forEach(proCompradoMock -> {

                        listaAux.add(new ProductoCompradoDto(proCompradoMock.getNombre(), proCompradoMock.getCodigo(), proCompradoMock.getProveedor(),
                                proCompradoMock.getCantidad(), proCompradoMock.getPrecio()));
                    });

                    listaOrdenes.add(new OrdenCompraDto(ordenCompra.getTotal(), false, ordenCompra.getFolio(), ordenCompra.getFechaExpedicion(), listaAux));

                }

            });
        } catch (Exception ex) {
            Logger.getLogger(NegocioBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaOrdenes;
    }

    @Override
    public boolean Pagar(OrdenCompraDto oc) {

        List<ProductoCompradoDto> prdsDto = oc.getProductos();

        List<proComprado> listaAux = new ArrayList<>();

        prdsDto.forEach(proCompradoDto -> {

            listaAux.add(new proComprado(proCompradoDto.getNombre(), 
                    proCompradoDto.getCodigo(), proCompradoDto.getProveedor(), 
                    proCompradoDto.getCantidad(), proCompradoDto.getPrecio()));
        });

        ordenCompra ordenAux = new ordenCompra(oc.getTotal(), oc.getFechaExpedicion(), oc.getFolio(), listaAux, "Pagado");

        try {
            ordenDao.actualizar(ordenAux);
        } catch (Exception ex) {
            Logger.getLogger(NegocioBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        return true;
    }

    @Override
    public void eliminarDeInventario(int index) {

//        inventario.eliminarAInventario(index);
    }

    @Override
    public List<ProductoCompradoDto> obtenerProductosOrden(ordenCompra oc) throws Exception {
        List<ProductoCompradoDto> listaAux = new ArrayList<>();
        ordenDao.buscarPorID(oc).getProductos().forEach(proCompradoMocko -> {
            listaAux.add(new ProductoCompradoDto(proCompradoMocko.getNombre(), proCompradoMocko.getCodigo(), proCompradoMocko.getProveedor(),
                    proCompradoMocko.getCantidad(), proCompradoMocko.getPrecio()));
        });
        return listaAux;
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

    public static String generarFolio() {
        Random rand = new Random();
        int num = rand.nextInt(9000000) + 1000000;
        return String.valueOf(num);
    }

    @Override
    public List<OrdenCompraDto> consultarOrdenesPeriodo(Date desde, Date hasta) {

        List<OrdenCompraDto> listaAux = consultarOrdenes();

        List<OrdenCompraDto> ordenesFiltradas = new ArrayList<>();

        listaAux.forEach(OrdenCompraDto -> {

            if (OrdenCompraDto.getFechaExpedicion().after(desde)
                    && OrdenCompraDto.getFechaExpedicion().before(hasta)) {
                ordenesFiltradas.add(OrdenCompraDto);
            }
        });

        return ordenesFiltradas;
    }

    @Override
    public OrdenCompraDto buscarOrdenFolio(String folio) {

        List<OrdenCompraDto> listaAux = consultarOrdenes();

        for (OrdenCompraDto o : listaAux) {
            if (o.getFolio().equals(folio)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<OrdenCompraDto> consultarOrdenesPagadas() {
        List<OrdenCompraDto> listaOrdenes = new ArrayList<>();

        try {
            ordenDao.consultar().forEach(ordenCompra -> {

                if (ordenCompra.getEstado().equals("Pagado")) {
                    List<ProductoCompradoDto> listaAux = new ArrayList<>();

                    ordenCompra.getProductos().forEach(proCompradoMock -> {

                        listaAux.add(new ProductoCompradoDto(proCompradoMock.getNombre(), proCompradoMock.getCodigo(), proCompradoMock.getProveedor(),
                                proCompradoMock.getCantidad(), proCompradoMock.getPrecio()));
                    });

                    listaOrdenes.add(new OrdenCompraDto(ordenCompra.getTotal(), false, ordenCompra.getFolio(), ordenCompra.getFechaExpedicion(), listaAux));

                }

            });
        } catch (Exception ex) {
            Logger.getLogger(NegocioBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaOrdenes;
    }
}
