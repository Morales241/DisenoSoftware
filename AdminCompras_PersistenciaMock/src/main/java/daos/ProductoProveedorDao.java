/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.ProductoProveedor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoProveedorDao {

    private ProductoDao productoDao = new ProductoDao();
    private ProveedorDao proveedorDao = new ProveedorDao();
    
    private List<ProductoProveedor> listaProductosProveedores = Arrays.asList(new ProductoProveedor(1L, 103.59, 11, productoDao.obtenerProductoPorId(1L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(2L, 79.69, 38, productoDao.obtenerProductoPorId(2L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(3L, 127.55, 43, productoDao.obtenerProductoPorId(3L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(4L, 241.23, 43, productoDao.obtenerProductoPorId(4L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(5L, 632.37, 43, productoDao.obtenerProductoPorId(5L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(6L, 731.23, 43, productoDao.obtenerProductoPorId(6L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(7L, 237.33, 43, productoDao.obtenerProductoPorId(7L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(8L, 237.88, 43, productoDao.obtenerProductoPorId(8L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(9L, 963.11, 43, productoDao.obtenerProductoPorId(9L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(10L, 993.21, 43, productoDao.obtenerProductoPorId(10L), proveedorDao.obtenerProveedorPorId(1L)),
            new ProductoProveedor(11L, 993.21, 43, productoDao.obtenerProductoPorId(11L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(12L, 993.21, 43, productoDao.obtenerProductoPorId(12L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(13L, 993.21, 43, productoDao.obtenerProductoPorId(13L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(14L, 993.21, 43, productoDao.obtenerProductoPorId(14L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(15L, 993.21, 43, productoDao.obtenerProductoPorId(15L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(16L, 993.21, 43, productoDao.obtenerProductoPorId(16L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(17L, 993.21, 43, productoDao.obtenerProductoPorId(17L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(18L, 993.21, 43, productoDao.obtenerProductoPorId(18L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(19L, 993.21, 43, productoDao.obtenerProductoPorId(19L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(20L, 993.21, 43, productoDao.obtenerProductoPorId(20L), proveedorDao.obtenerProveedorPorId(2L)),
            new ProductoProveedor(21L, 235.33, 11, productoDao.obtenerProductoPorId(1L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(22L, 79.69, 38, productoDao.obtenerProductoPorId(2L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(23L, 64.23, 43, productoDao.obtenerProductoPorId(3L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(24L, 885.44, 43, productoDao.obtenerProductoPorId(4L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(25L, 12.4, 43, productoDao.obtenerProductoPorId(5L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(26L, 532.2, 43, productoDao.obtenerProductoPorId(6L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(27L, 22.45, 43, productoDao.obtenerProductoPorId(7L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(28L, 632.21, 43, productoDao.obtenerProductoPorId(8L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(29L, 75.24, 43, productoDao.obtenerProductoPorId(9L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(30L, 642.86, 43, productoDao.obtenerProductoPorId(10L), proveedorDao.obtenerProveedorPorId(3L)),
            new ProductoProveedor(31L, 11.24, 43, productoDao.obtenerProductoPorId(11L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(32L, 56.78, 43, productoDao.obtenerProductoPorId(12L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(33L, 33.62, 43, productoDao.obtenerProductoPorId(13L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(34L, 531.22, 43, productoDao.obtenerProductoPorId(14L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(35L, 34.23, 43, productoDao.obtenerProductoPorId(15L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(36L, 553.12, 43, productoDao.obtenerProductoPorId(16L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(37L, 353.21, 43, productoDao.obtenerProductoPorId(17L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(38L, 764.23, 43, productoDao.obtenerProductoPorId(18L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(39L, 64.22, 43, productoDao.obtenerProductoPorId(19L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(40L, 64.43, 43, productoDao.obtenerProductoPorId(20L), proveedorDao.obtenerProveedorPorId(4L)),
            new ProductoProveedor(41L, 543.11, 11, productoDao.obtenerProductoPorId(1L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(42L, 64.23, 38, productoDao.obtenerProductoPorId(2L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(43L, 875.12, 43, productoDao.obtenerProductoPorId(3L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(44L, 546.11, 43, productoDao.obtenerProductoPorId(4L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(45L, 468.98, 43, productoDao.obtenerProductoPorId(5L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(46L, 334.53, 43, productoDao.obtenerProductoPorId(6L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(47L, 87.12, 43, productoDao.obtenerProductoPorId(7L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(48L, 67.34, 43, productoDao.obtenerProductoPorId(8L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(49L, 123.87, 43, productoDao.obtenerProductoPorId(9L), proveedorDao.obtenerProveedorPorId(5L)),
            new ProductoProveedor(50L, 114.12, 43, productoDao.obtenerProductoPorId(10L), proveedorDao.obtenerProveedorPorId(5L))
    );

    public ProductoProveedorDao() {

    }

    public List<ProductoProveedor> obtenerProductosProveedores() {
        return this.listaProductosProveedores;
    }

    public ProductoProveedor obtenerProductoProveedorPorId(Long id) {
        ProductoProveedor productoProveedor = null;

        for (ProductoProveedor p : this.listaProductosProveedores) {
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
