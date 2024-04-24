/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class FachadaPagar implements Ipagar {

    subSistemaPagoBO subSistema = new subSistemaPagoBO();

    @Override
    public List<ProductoEntregadoDto> inventarioBajo() {
        return subSistema.inventarioBajo();
    }

    @Override
    public void pagarOrden(OrdenCompraDto oc) throws Exception {
        subSistema.pagarOrden(oc);
    }

    @Override
    public List<OrdenCompraDto> consultarOrdenes() {
        return subSistema.consultarOrdenes();
    }

}
