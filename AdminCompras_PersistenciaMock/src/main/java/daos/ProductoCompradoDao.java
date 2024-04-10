/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.ProductoComprado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoCompradoDao {
    
    private ProductoDao productoDao;
    private ProveedorDao proveedorDao;
    private List<ProductoComprado> listaProductosComprados;

    public ProductoCompradoDao() {
        productoDao = new ProductoDao();
        proveedorDao = new ProveedorDao();
        this.listaProductosComprados = new ArrayList<>();
    }
    
    public List<ProductoComprado> obtenerProductosComprados() {
        return this.listaProductosComprados;
    }
    
    public ProductoComprado obtenerProductoCompradoPorId(Long id) {
        ProductoComprado productoComprado = null;
        
        for(ProductoComprado p: this.listaProductosComprados) {
            if (id == p.getId()) {
                productoComprado = p;            }
        }
        
        return productoComprado;
    }
    
    public void agregarProductoComprado(ProductoComprado productoComprado) {
        Long ultimoId = this.obtenerProductoCompradoPorId(Long.valueOf(String.valueOf(this.listaProductosComprados.size()))).getId();
        productoComprado.setId(ultimoId + 1);
        this.listaProductosComprados.add(productoComprado);
    }
    
    public void eliminarProductoComprado(Long id) {
        for (int i = 0; i < this.listaProductosComprados.size(); i++) {
            if (id == this.listaProductosComprados.get(i).getId()) {
                this.listaProductosComprados.remove(i);
                break;
            }
        }
    }
    
}
