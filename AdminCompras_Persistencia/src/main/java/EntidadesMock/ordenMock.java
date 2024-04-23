/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesMock;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author tacot
 */
public class ordenMock {

    private Double total;

    private Calendar fechaExpedicion;

    private List<proCompradoMock> productos;

    public ordenMock() {
    }

    public ordenMock(Double total, Calendar fechaExpedicion, List<proCompradoMock> productos) {
        this.total = total;
        this.fechaExpedicion = fechaExpedicion;
        this.productos = productos;
    }

    public List<proCompradoMock> getProductos() {
        return productos;
    }

    public void setProductos(List<proCompradoMock> productos) {
        this.productos = productos;
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
}
