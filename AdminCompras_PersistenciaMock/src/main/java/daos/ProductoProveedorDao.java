/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.ProductoProveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoProveedorDao {
    
    private ProductoDao productoDao;
    private ProveedorDao proveedorDao;
    private List<ProductoProveedor> listaProductosProveedores;

    public ProductoProveedorDao() {
        this.listaProductosProveedores = new ArrayList();
        this.listaProductosProveedores.add(new ProductoProveedor(1L, 103.59, 11, productoDao.obtenerProductoPorId(1L), proveedorDao.obtenerProveedorPorId(1L)));
        this.listaProductosProveedores.add(new ProductoProveedor(2L, 79.69, 38, productoDao.obtenerProductoPorId(2L), proveedorDao.obtenerProveedorPorId(2L)));
        this.listaProductosProveedores.add(new ProductoProveedor(3L, 127.55, 43, productoDao.obtenerProductoPorId(3L), proveedorDao.obtenerProveedorPorId(3L)));
    }
    
    public List<ProductoProveedor> obtenerProductosProveedores() {
        return this.listaProductosProveedores;
    }
    
    public ProductoProveedor obtenerProductoProveedorPorId(Long id) {
        ProductoProveedor productoProveedor = null;
        
        for(ProductoProveedor p: this.listaProductosProveedores) {
            if (id == p.getId()) {
                productoProveedor = p;
            }
        }
        
        return productoProveedor;
    }
    
    public void agregarProductoProveedor(ProductoProveedor productoProveedor) {
        Long ultimoId = this.obtenerProductoProveedorPorId(Long.valueOf(String.valueOf(this.listaProductosProveedores.size()))).getId();
        productoProveedor.setId(ultimoId + 1);
        this.listaProductosProveedores.add(productoProveedor);
    }
    
    public void eliminarProductoProveedor(Long id) {
        for (int i = 0; i < this.listaProductosProveedores.size(); i++) {
            if (id == this.listaProductosProveedores.get(i).getId()) {
                this.listaProductosProveedores.remove(i);
                break;
            }
        }
    }
    
}
