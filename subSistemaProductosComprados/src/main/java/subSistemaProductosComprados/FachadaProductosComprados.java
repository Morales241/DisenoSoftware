/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaProductosComprados;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tacot
 */
public class FachadaProductosComprados implements IFachadaProductoComprado{

    ControladorProductosComprados ConsultaPC = ControladorProductosComprados.getInstance();

    public FachadaProductosComprados() {
    }
    
    @Override
    public boolean agregarCompraLista(ProductoCompradoDto proCompDto) {
        try {
            return ConsultaPC.agregarCompraLista(proCompDto);
        } catch (Exception ex) {
            Logger.getLogger(FachadaProductosComprados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ProductoCompradoDto> getListaProductosComprados() {
        return ConsultaPC.getListaProductosComprados();
    }

    @Override
    public void eliminarProductos(int index) {
        ConsultaPC.eliminarProducto(index);
    }

    @Override
    public void eliminarTodosLosProductos() {
        ConsultaPC.eliminarTodosLosProductos();
    }
    
}
