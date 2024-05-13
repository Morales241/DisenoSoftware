/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.DaoOrdenCompra;
import Entidades.ordenCompra;
import Entidades.proComprado;
import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import entidad.IFachadaPresupuesto;
import entidad.fachadaPresupuesto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocioBO.IOrdenCompraBO;

/**
 *
 * @author marlon
 */
public class OrdenCompraBO implements IOrdenCompraBO {
    
    DaoOrdenCompra ordenDao = new DaoOrdenCompra();
    
    public static String generarFolio() {
        Random rand = new Random();
        int num = rand.nextInt(9000000) + 1000000;
        return String.valueOf(num);
    }

    @Override
    public boolean verificarPresupuesto(Double cantidad) {
        IFachadaPresupuesto pp = fachadaPresupuesto.getInstance();

        return cantidad <= pp.trarerPresupuesto();
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
            Logger.getLogger(OrdenCompraBO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(OrdenCompraBO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrdenCompraBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        return true;
    }

    @Override
    public List<OrdenCompraDto> consultarOrdenesPeriodo(Date desde, Date hasta) {
        List<OrdenCompraDto> listaAux = consultarOrdenesPagadas();

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
        List<OrdenCompraDto> listaAux = consultarOrdenesPagadas();

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
            Logger.getLogger(OrdenCompraBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaOrdenes;
    }

    @Override
    public boolean Reportar(OrdenCompraDto oc) {
        List<ProductoCompradoDto> prdsDto = oc.getProductos();

        List<proComprado> listaAux = new ArrayList<>();

        prdsDto.forEach(proCompradoDto -> {

            listaAux.add(new proComprado(proCompradoDto.getNombre(), 
                    proCompradoDto.getCodigo(), proCompradoDto.getProveedor(), 
                    proCompradoDto.getCantidad(), proCompradoDto.getPrecio()));
        });

        ordenCompra ordenAux = new ordenCompra(oc.getTotal(), oc.getFechaExpedicion(), oc.getFolio(), listaAux, "Reportado");
        
        try {
            ordenDao.actualizar(ordenAux);
        } catch (Exception ex) {
            Logger.getLogger(OrdenCompraBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean Inventariar(OrdenCompraDto oc) {
        List<ProductoCompradoDto> prdsDto = oc.getProductos();

        List<proComprado> listaAux = new ArrayList<>();

        prdsDto.forEach(proCompradoDto -> {

            listaAux.add(new proComprado(proCompradoDto.getNombre(), 
                    proCompradoDto.getCodigo(), proCompradoDto.getProveedor(), 
                    proCompradoDto.getCantidad(), proCompradoDto.getPrecio()));
        });

        ordenCompra ordenAux = new ordenCompra(oc.getTotal(), oc.getFechaExpedicion(), oc.getFolio(), listaAux, "Inventariado");
        
        try {
            ordenDao.actualizar(ordenAux);
        } catch (Exception ex) {
            Logger.getLogger(OrdenCompraBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        return true;
    }
    
}
