/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaosMock;

import EntidadesMock.ordenMock;
import EntidadesMock.proCompradoMock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesusmr
 */
public class DaoOrdenMock {

    private List<ordenMock> listaOrdenes;

    private static DaoOrdenMock instance;

    public DaoOrdenMock() {
        this.listaOrdenes = new ArrayList<>();
    }

    public static DaoOrdenMock getInstance() {
        if (instance == null) {
            return instance = new DaoOrdenMock();
        }

        return instance;

    }

    public List<ordenMock> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(List<ordenMock> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public void agregarOrden(ordenMock orden) {
        this.listaOrdenes.add(orden);
    }

    public void eliminarOrden(ordenMock orden) {
        this.listaOrdenes.remove(orden);
    }

    public List<ordenMock> consultarOrden() {
        return this.listaOrdenes;
    }

    public List<proCompradoMock> consultarProductosOrden(int index) {
        return this.listaOrdenes.get(index).getProductos();
    }

    public void borrarOrden() {
        this.listaOrdenes = new ArrayList<>();
    }

    public void pagado(String folio) {
        for (ordenMock Orden : listaOrdenes) {
            if (Orden.getFolio().equals(folio)) {
                Orden.setEstado(true);
            }
        }
    }

}
