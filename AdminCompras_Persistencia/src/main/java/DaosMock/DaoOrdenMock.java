/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaosMock;

import EntidadesMock.ordenMock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesusmr
 */
public class DaoOrdenMock {

    private final List<ordenMock> listaOrdenes;

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

    public void agregarOrden(ordenMock orden) {
        this.listaOrdenes.add(orden);
    }

    public void eliminarOrden(ordenMock orden) {
        this.listaOrdenes.remove(orden);
    }

    public List<ordenMock> consultarOrden() {
        return this.listaOrdenes;
    }
}
