/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import subSistemaProductosComprados.IConsultarProductoCompradoBO;
import Negocio.dto.ProductoCompradoDto;
import subSistemaProductosComprados.FachadaProductosComprados;

/**
 *
 * @author tacot
 */
public class ControladorAgregarProductoBO  {

    public ControladorAgregarProductoBO() {
    }
    
    protected IConsultarProductoCompradoBO PC = new FachadaProductosComprados();
    

    public void agregarCompraLista(ProductoCompradoDto proCompDto) {
        PC.agregarCompraLista(proCompDto);
        
    }

    
}