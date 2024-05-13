/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultaOrden;

import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoEntregadoDto;
import entidad.fachadaPresupuesto;
import java.util.List;
import negocioBO.IOrdenCompraBO;
import negocioBO.IProductoEntregadoBO;
import negocioBO.InegocioBO;
import negocioBO.OrdenCompraBO;
import negocioBO.ProductoEntregadoBO;

/**
 *
 * @author tacot
 */
public class ControladorPagar {

    protected IProductoEntregadoBO negocio = new ProductoEntregadoBO();
    
    protected IOrdenCompraBO negocioPagar = new OrdenCompraBO();
    
    protected fachadaPresupuesto presupuesto = fachadaPresupuesto.getInstance();

    List<ProductoEntregadoDto> inventarioBajo() {
        return negocio.obtenerInventarioBajo();
    }

    public void pagarOrden(OrdenCompraDto oc) throws Exception {
        if (oc.getTotal() <= presupuesto.trarerPresupuesto()) {
            
            negocioPagar.Pagar(oc);

        } else {
            throw new Exception("No contamos con el dinero suficiente");
        }
    }

    public List<OrdenCompraDto> consultarOrdenes() {
        return negocioPagar.consultarOrdenes();
    }

}
