/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class fachadaConsultarProducto implements IFachadaConsultarProducto {
    ControladorConsultarProductos consulta = new ControladorConsultarProductos();
    public fachadaConsultarProducto() {
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        return consulta.obtenerProductos();
    }
    
}
