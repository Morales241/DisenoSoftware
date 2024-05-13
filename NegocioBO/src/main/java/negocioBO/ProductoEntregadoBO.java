/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.DaoproInventario;
import Entidades.proInventario;
import Negocio.dto.ProductoEntregadoDto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlon
 */
public class ProductoEntregadoBO implements IProductoEntregadoBO {
    
    DaoproInventario daoProductos = new DaoproInventario();

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
                    listaAux.add(new ProductoEntregadoDto(proEntregadoMock.getNombre(), proEntregadoMock.getCodigo(), proEntregadoMock.getCantidad()));
                }
            });
            
        } catch (Exception ex) {
            Logger.getLogger(ProductoEntregadoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAux;
    }

    @Override
    public DefaultTableModel obtenerProductosBuscados(String cadena) {
        List<proInventario> entidades;
        try {
            entidades = daoProductos.consultar();
        } catch (Exception ex) {
            entidades = null;
            Logger.getLogger(ProductoEntregadoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<ProductoEntregadoDto> dtos = new ArrayList<>();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Código");
        
        for(proInventario p: entidades) {
            if (p.getNombre().toLowerCase().contains(cadena.toLowerCase()) && p.getCantidad() > 0) {
                dtos.add(new ProductoEntregadoDto(p.getNombre(), p.getCodigo(), Integer.valueOf(p.getCantidad())));
            }
        }
        
        this.ordenarProductos(dtos);
        
        for(ProductoEntregadoDto p: dtos) {
            Object[] fila = {p.getNombre(), p.getCantidad(), p.getCodigo()};
            modeloTabla.addRow(fila);
        }
        
        return modeloTabla;
    }

    @Override
    public ProductoEntregadoDto obtenerProductoPorCodigo(String codigo) {
        List<proInventario> entidades;
        try {
            entidades = daoProductos.consultar();
        } catch (Exception ex) {
            entidades = null;
            Logger.getLogger(ProductoEntregadoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(proInventario p: entidades) {
            if (p.getCodigo().equals(codigo)) {
                return new ProductoEntregadoDto(p.getNombre(), p.getCodigo(), Integer.valueOf(p.getCantidad()));
            }
        }
        return null;
    }

    @Override
    public void ordenarProductos(List<ProductoEntregadoDto> listaProductos) {
        Comparator<ProductoEntregadoDto> comparadorCantidades = Comparator.comparingInt(ProductoEntregadoDto::getCantidad).reversed();
        listaProductos.sort(comparadorCantidades);
    }

    @Override
    public void desinventariarProducto(ProductoEntregadoDto producto) {
        proInventario entidad = new proInventario();
        entidad.setNombre(producto.getNombre());
        entidad.setCantidad(producto.getCantidad());
        entidad.setCodigo(producto.getCodigo());
        try {
            daoProductos.actualizar(entidad);
        } catch (Exception ex) {
            Logger.getLogger(ProductoEntregadoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
