/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Producto;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author tacot
 */
@Entity
public class ProComprado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "codigo", nullable = false)
    private String codigo;
    
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "proveedor_id", referencedColumnName = "id")
    private Proveedor proveedor;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @ManyToOne
    private OrdenCompra orden;

    public ProComprado() {
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ProComprado(String nombre, String codigo, Proveedor proveedor, Integer cantidad, Double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenCompra getOrden() {
        return orden;
    }

    public void setOrden(OrdenCompra orden) {
        this.orden = orden;
    }
    
}
