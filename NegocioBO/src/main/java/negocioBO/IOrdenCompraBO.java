/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocioBO;

import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marlon
 */
public interface IOrdenCompraBO {

    public boolean verificarPresupuesto(Double cantidad);

    public void realizarOrden(List<ProductoCompradoDto> prdsDto);

    public List<OrdenCompraDto> consultarOrdenes();

    public boolean Pagar(OrdenCompraDto oc);

//    public static String generarFolio();

    public List<OrdenCompraDto> consultarOrdenesPeriodo(Date desde, Date hasta);

    public OrdenCompraDto buscarOrdenFolio(String folio);

    public List<OrdenCompraDto> consultarOrdenesPagadas();

    public boolean Reportar(OrdenCompraDto oc);

    public boolean Inventariar(OrdenCompraDto oc);
}
