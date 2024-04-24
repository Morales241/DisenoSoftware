/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaosMock;

import EntidadesMock.proCompradoMock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesusmr
 */
public class DaoproComMock {
    private static DaoproComMock instance;
    private final List<proCompradoMock> listaProductosComprados;

    public DaoproComMock() {
        this.listaProductosComprados = new ArrayList<>();
    }
    
    public static DaoproComMock getInstance(){
        if (instance == null) {
            return instance = new DaoproComMock();
        }
        
        return instance;
    }
    
    public void agregarProductoALista(proCompradoMock producto){
        this.listaProductosComprados.add(producto);
    }
    
    public void eliminarProductoDeLista(int index){
        this.listaProductosComprados.remove(listaProductosComprados.get(index));
    }
    
    public List<proCompradoMock>  ConsultarListaProductos(){
        return listaProductosComprados;
    }
}
