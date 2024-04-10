/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author marlon
 */
public class OrdenCompra {
    
    private Long id;
    private Double total;
    private Date fechaExpecicion;
    private List<ProductoComprado> productosComprados;

    public OrdenCompra() {
    }
    
    public OrdenCompra(Double total, Date fechaExpecicion, List<ProductoComprado> productosComprados) {
        this.total = total;
        this.fechaExpecicion = fechaExpecicion;
        this.productosComprados = productosComprados;
    }

    public OrdenCompra(Long id, Double total, Date fechaExpecicion, List<ProductoComprado> productosComprados) {
        this.id = id;
        this.total = total;
        this.fechaExpecicion = fechaExpecicion;
        this.productosComprados = productosComprados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFechaExpecicion() {
        return fechaExpecicion;
    }

    public void setFechaExpecicion(Date fechaExpecicion) {
        this.fechaExpecicion = fechaExpecicion;
    }

    public List<ProductoComprado> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(List<ProductoComprado> productosComprados) {
        this.productosComprados = productosComprados;
    }
    
}
