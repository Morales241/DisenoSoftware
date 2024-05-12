/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subSistemaEntradaInventario;

import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author 
 */
public interface IFachadaEntradaInventario {

    public void llenarTablaProductos(List<ProductoCompradoDto> lista, JTable tabla);
    
    public void llenarTablaOrdenes(JTable tabla);
    
    public void llenarTablaFiltrada(JTable tabla, Date desde, Date hasta);
   
    public OrdenCompraDto ordenPorFolio(String folio);
    
    public void Reportar(OrdenCompraDto oc);
    
    public void Inventariar(OrdenCompraDto oc);
}
