/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;
import negocioBO.NegocioBO;

/**
 *
 * @author tacot
 */
public class ControladorGenerarOrdenBO  {

    protected NegocioBO negocio = new NegocioBO();

    public ControladorGenerarOrdenBO() {
    }

    public void realizarOrden(List<ProductoCompradoDto> prdsDto) throws Exception {
        List<ProductoCompradoDto> listaSinDuplicados = new ArrayList<>();
        for (ProductoCompradoDto producto : prdsDto) {
            int index = listaSinDuplicados.indexOf(producto);
            if (index != -1) {
                listaSinDuplicados.get(index).setCantidad(listaSinDuplicados.get(index).getCantidad() + producto.getCantidad());
            } else {
                listaSinDuplicados.add(producto);
            }
        }
        
        negocio.realizarOrden(prdsDto);
    }
}
