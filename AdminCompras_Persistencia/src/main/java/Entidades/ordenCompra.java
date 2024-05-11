/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Calendar;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author jesusmr
 */
public class ordenCompra {

    private ObjectId id;
    private Double total;
    private Calendar fechaExpedicion;
    private List<proComprado> productos;
    private String estado;

    public ordenCompra() {
    }

    public ordenCompra(Double total, Calendar fechaExpedicion, List<proComprado> productos, String estado) {
        this.total = total;
        this.fechaExpedicion = fechaExpedicion;
        this.productos = productos;
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public List<proComprado> getProductos() {
        return productos;
    }

    public void setProductos(List<proComprado> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
