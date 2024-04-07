/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author tacot
 */
@Entity
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nombreCompleto", nullable = false)
    private String nombre;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "precioP", nullable = false)
    private String precioP;
    
    @Column(name = "stock", nullable = false)
    private int stock;
    
    @ManyToMany    
    @JoinTable(
        name = "producto_proveedor",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
    private List<Producto> productos;

    public Proveedor() {
        this.productos  = new ArrayList<>();
    }

    public Proveedor(String nombre, String telefono, String precioP, int stock, List<Producto> productos) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.precioP = precioP;
        this.stock = stock;
        this.productos = productos;
    }

    public Proveedor(String nombre, String telefono, String precioP, int stock) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.precioP = precioP;
        this.stock = stock;
        this.productos  = new ArrayList<>();
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrecioP() {
        return precioP;
    }

    public void setPrecioP(String precioP) {
        this.precioP = precioP;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    
}
