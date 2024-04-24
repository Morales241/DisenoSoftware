/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultaOrden;

import DaosMock.DaoOrdenMock;
import EntidadesMock.ordenMock;
import EntidadesMock.proCompradoMock;
import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoEntregadoDto;
import entidad.fachadaPresupuesto;
import java.util.List;
import negocioBO.NegocioBO;

/**
 *
 * @author tacot
 */
public class subSistemaPagoBO {

    NegocioBO negocio = new NegocioBO();
    fachadaPresupuesto presupuesto = new fachadaPresupuesto();

    public List<ProductoEntregadoDto> inventarioBajo() {
        return negocio.obtenerInventarioBajo();
    }

    public void pagarOrden(OrdenCompraDto oc) throws Exception {
        if (oc.getTotal() <= presupuesto.trarerPresupuesto()) {

            negocio.agregarAInventario(oc.getProductos());

        } else {
            throw new Exception("No cuentamos con el dinero suficiente");
        }
    }

    public List<OrdenCompraDto> consultarOrdenes() {
        return negocio.consultarOrdenes();
    }

}
