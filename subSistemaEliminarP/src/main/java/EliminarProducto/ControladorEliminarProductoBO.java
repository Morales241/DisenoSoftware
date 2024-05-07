/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EliminarProducto;

import subSistemaProductosComprados.FachadaProductosComprados;
import subSistemaProductosComprados.IConsultarProductoCompradoBO;

/**
 *
 * @author tacot
 */
public class ControladorEliminarProductoBO {

    protected IConsultarProductoCompradoBO PC = new FachadaProductosComprados();
    
    public ControladorEliminarProductoBO() {
    }
    
    public void eliminarProducto(int index){
        PC.eliminarProductos(index);
    }
    
    public void eliminarTodosLosProductos(){
        PC.eliminarTodosLosProductos();
    }
}