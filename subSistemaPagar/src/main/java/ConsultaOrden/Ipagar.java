/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ConsultaOrden;

import EntidadesMock.proCompradoMock;
import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoEntregadoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface Ipagar {

    public List<ProductoEntregadoDto> inventarioBajo();

    public void pagarOrden(OrdenCompraDto oc) throws Exception;
    
    public List<OrdenCompraDto> consultarOrdenes();
}
