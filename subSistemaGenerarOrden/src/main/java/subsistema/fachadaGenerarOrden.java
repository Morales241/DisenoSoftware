/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class fachadaGenerarOrden implements IGenerarOrden{
    generarOrdenBO GenerarOrden = new generarOrdenBO();
    public fachadaGenerarOrden() {
    }

    @Override
    public void realizarOrden(List<ProductoCompradoDto> prdsDto) throws Exception {
        GenerarOrden.realizarOrden(prdsDto);
    }
    
}
