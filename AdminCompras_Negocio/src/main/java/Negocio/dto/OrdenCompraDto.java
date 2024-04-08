/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.dto;

import java.util.Date;

/**
 *
 * @author marlon
 */
public class OrdenCompraDto {
    
    private Double total;
    private Date fechaExpedicion;

    public OrdenCompraDto() {
    }

    public OrdenCompraDto(Double total, Date fechaExpedicion) {
        this.total = total;
        this.fechaExpedicion = fechaExpedicion;
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
    
}
