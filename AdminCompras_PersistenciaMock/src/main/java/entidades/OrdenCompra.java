/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author marlon
 */
public class OrdenCompra {
    
    private Long id;
    private Double total;
    private Date fechaExpecicion;

    public OrdenCompra() {
    }

    public OrdenCompra(Long id, Double total, Date fechaExpecicion) {
        this.id = id;
        this.total = total;
        this.fechaExpecicion = fechaExpecicion;
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
    
}
