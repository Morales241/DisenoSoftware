/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.dto;

/**
 *
 * @author marlon
 */
public class OrdenCompra {
    
    private Double total;

    public OrdenCompra() {
    }

    public OrdenCompra(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
