/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Producto;

import Producto.ProComprado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    
    @OneToMany(mappedBy = "orden", cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    private List<ProComprado> productos;

    public OrdenCompra() {
        this.productos = new ArrayList<>();
    }

    public OrdenCompra(Double total, List<ProComprado> productos) {
        this.total = total;
        this.productos = productos;
    }
    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ProComprado> getProductos() {
        return productos;
    }

    public void setProductos(List<ProComprado> productos) {
        this.productos = productos;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
