/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.dto;

/**
 *
 * @author marlon
 */
public class ProductoProveedorDto {
    
    private Double precioP;
    private int stock;
    private ProductoDto producto;
    private ProveedorDto proveedor;

    public ProductoProveedorDto() {
    }

    public ProductoProveedorDto(Double precioP, int stock, ProductoDto producto, ProveedorDto proveedor) {
        this.precioP = precioP;
        this.stock = stock;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public Double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(Double precioP) {
        this.precioP = precioP;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }

    public ProveedorDto getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDto proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return proveedor.getNombre() +", P/u"+ precioP;
    }
    
    
}
