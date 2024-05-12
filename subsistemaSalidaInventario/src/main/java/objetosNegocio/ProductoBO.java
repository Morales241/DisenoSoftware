/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import dtos.ProductoDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import persistenciaMock.daos.ProductoDAO;
import persistenciaMock.entidades.Producto;

/**
 *
 * @author marlon
 */
public class ProductoBO {
    
    private ProductoDAO productoDAO;

    public ProductoBO() {
        this.productoDAO = ProductoDAO.obtenerInstancia();
    }
    
    public void desinventariarProducto(ProductoDTO producto) {
        Producto entidad = new Producto();
        entidad.setId(this.obtenerIdProducto(producto.getCodigo()));
        entidad.setNombre(producto.getNombre());
        entidad.setCantidad(producto.getCantidad());
        entidad.setCodigo(producto.getCodigo());
        productoDAO.actualizarProducto(entidad);
    }
    
    public Long obtenerIdProducto(String codigo) {
        List<Producto> entidades = productoDAO.obtenerProductos();
        
        for(Producto p: entidades) {
            if (codigo.equals(p.getCodigo())) {
                return p.getId();
            }
        }
        
        return -1L;
    }
    
    public DefaultTableModel obtenerProductosBuscados(String cadena) {
        List<Producto> entidades = productoDAO.obtenerProductos();
        List<ProductoDTO> dtos = new ArrayList<>();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Código");
        
        for(Producto p: entidades) {
            if (p.getNombre().toLowerCase().contains(cadena.toLowerCase()) && p.getCantidad() > 0) {
                dtos.add(new ProductoDTO(p.getNombre(), p.getCantidad(), p.getCodigo()));
            }
        }
        
        this.ordenarProductos(dtos);
        
        for(ProductoDTO p: dtos) {
            Object[] fila = {p.getNombre(), p.getCantidad(), p.getCodigo()};
            modeloTabla.addRow(fila);
        }
        
        return modeloTabla;
    }

   public ProductoDTO obtenerProductoPorCodigo(String codigo) {
        List<Producto> entidades = productoDAO.obtenerProductos();
        for(Producto p: entidades) {
            if (p.getCodigo().equals(codigo)) {
                return new ProductoDTO(p.getNombre(), p.getCantidad(), p.getCodigo());
            }
        }
        return null;
    }
    
    public void ordenarProductos(List<ProductoDTO> listaProductos) {
        Comparator<ProductoDTO> comparadorCantidades = Comparator.comparingInt(ProductoDTO::getCantidad).reversed();
        listaProductos.sort(comparadorCantidades);
    }
    
}
