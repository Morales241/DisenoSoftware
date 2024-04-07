/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.dto;

/**
 *
 * @author marlon
 */
public class ProductoCompradoDto {
    
    private ProductoDto productoDto;
    private ProveedorDto proveedorDto;
    private Integer cantidad;
    private Double precio;

    public ProductoCompradoDto() {
    }

    public ProductoCompradoDto(ProductoDto productoDto, ProveedorDto proveedorDto, Integer cantidad, Double precio) {
        this.productoDto = productoDto;
        this.proveedorDto = proveedorDto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ProductoDto getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(ProductoDto productoDto) {
        this.productoDto = productoDto;
    }

    public ProveedorDto getProveedorDto() {
        return proveedorDto;
    }

    public void setProveedorDto(ProveedorDto proveedorDto) {
        this.proveedorDto = proveedorDto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
