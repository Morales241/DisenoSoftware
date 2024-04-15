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
    
    private Long id;
    
    private String nombre;

    private String codigo;
    
    private String proveedor;

    private Integer cantidad;
    
    private Double precio;

    private OrdenCompraDto orden;
    
    public ProductoCompradoDto( String nombre, String codigo, String proveedor, Integer cantidad, Double precio) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ProductoCompradoDto(Long id) {
        this.id = id;
    }

    public ProductoCompradoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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

    public OrdenCompraDto getOrden() {
        return orden;
    }

    public void setOrden(OrdenCompraDto orden) {
        this.orden = orden;
    }

    
}
