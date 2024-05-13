/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import subSistemaProductosComprados.FachadaProductosComprados;
import subSistemaProductosComprados.IFachadaProductoComprado;

/**
 *
 * @author tacot
 */
public class ControladorAgregarProductoBO  {

    public ControladorAgregarProductoBO() {
    }
    
    protected IFachadaProductoComprado PC = new FachadaProductosComprados();
    

    public void agregarCompraLista(ProductoCompradoDto proCompDto) {
        PC.agregarCompraLista(proCompDto);
        
    }

    
}