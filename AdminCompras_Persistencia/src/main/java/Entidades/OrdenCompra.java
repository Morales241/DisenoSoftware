/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tacot
 */
@Entity
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total", nullable = false)
    private Double total;
    
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    
    @OneToMany(mappedBy = "orden", cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    private List<ProComprado> productos;

    public OrdenCompra() {
    }

    public OrdenCompra(Long id, Double total, Date fechaExpedicion, List<ProComprado> productos) {
        this.id = id;
        this.total = total;
        this.fechaExpedicion = fechaExpedicion;
        this.productos = productos;
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

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public List<ProComprado> getProductos() {
        return productos;
    }

    public void setProductos(List<ProComprado> productos) {
        this.productos = productos;
    }
    
}
