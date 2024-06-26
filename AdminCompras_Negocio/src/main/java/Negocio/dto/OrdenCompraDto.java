/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marlon
 */
public class OrdenCompraDto {
    
    private Double total;
    
    private boolean estado;
    
    private String folio;
    
    private Date fechaExpedicion;

    private List<ProductoCompradoDto> productos;
    
    public OrdenCompraDto() {
    }

    public OrdenCompraDto(Double total, boolean estado, String folio, Date fechaExpedicion, List<ProductoCompradoDto> productos) {
        this.total = total;
        this.estado = estado;
        this.folio = folio;
        this.fechaExpedicion = fechaExpedicion;
        this.productos = productos;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }


    public List<ProductoCompradoDto> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoCompradoDto> productos) {
        this.productos = productos;
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

    @Override
    public String toString() {
        return "OrdenCompraDto{" + "fechaExpedicion=" + fechaExpedicion.getTime() + '}';
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
}
