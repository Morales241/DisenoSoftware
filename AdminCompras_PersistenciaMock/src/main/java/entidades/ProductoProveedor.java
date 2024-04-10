/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author marlon
 */
public class ProductoProveedor {
    
    private Long id;
    private double precio;
    private int stock;
    private Producto producto;
    private Proveedor proveedor;

    public ProductoProveedor() {
    }

    public ProductoProveedor(Long id, double precio, int stock, Producto producto, Proveedor proveedor) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
        
}
