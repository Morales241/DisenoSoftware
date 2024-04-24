/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaosMock;

import EntidadesMock.proEntregadoMock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class DaoproEntregadoMock {

    private static DaoproEntregadoMock instance;
    private final List<proEntregadoMock> listaInventario;

    public DaoproEntregadoMock() {
        this.listaInventario = new ArrayList<>();
    }

    public static DaoproEntregadoMock getinstance(){
        if (instance == null) {
            return instance = new DaoproEntregadoMock();
        }
        
        return instance;

    }
    
    public boolean agregarAInventario(proEntregadoMock producto) {
        for (proEntregadoMock p : listaInventario) {
            if (p.getNombre().equals(producto.getNombre()) && p.getProveedor().equals(producto.getProveedor())) {
                p.setCantidad(p.getCantidad() + producto.getCantidad());
                return true;
            }
        }

        this.listaInventario.add(producto);
        return false;
    }

    public void eliminarAInventario(int index) {
        this.listaInventario.remove(listaInventario.get(index));
    }

    public List<proEntregadoMock> consultarInventario() {
        return this.listaInventario;
    }
}
