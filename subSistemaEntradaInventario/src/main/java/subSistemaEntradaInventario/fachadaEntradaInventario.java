/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaEntradaInventario;

import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author 
 */
public class fachadaEntradaInventario implements IFachadaEntradaInventario{

    controladorEntradaInventario controlador = new controladorEntradaInventario();
    
    @Override
    public void llenarTablaProductos(List<ProductoCompradoDto> lista, JTable tabla) {

        controlador.llenarTablaProductos(lista, tabla);
        System.out.println("Pasó por fachada subsistemaEntradaInventario por el método llenarTablaProductos");

    }

    @Override
    public void llenarTablaOrdenes(JTable tabla) {

        try {
            controlador.llenarTablaOrdenes(tabla);
//            System.out.println("Pasó por fachada subsistemaEntradaInventario por el método llenarTablaOrdenes");
        } catch (Exception ex) {
            Logger.getLogger(fachadaEntradaInventario.class.getName()).log(Level.SEVERE, "No se encontraron Ordenes");
        }
        
    }

    @Override
    public void llenarTablaFiltrada(JTable tabla, Date desde, Date hasta) {

        controlador.llenarTablaFiltrada(tabla, desde, hasta);
        System.out.println("Pasó por fachada subsistemaEntradaInventario por el método llenarTablaFiltrada");

    }

    @Override
    public OrdenCompraDto ordenPorFolio(String folio) {
        
        System.out.println("Va a pasar por fachada subsistemaEntradaInventario por el método ordenPorFolio");
        return controlador.ordenPorFolio(folio);
    }
    
    
    public void Reportar(OrdenCompraDto oc){
        controlador.Reportar(oc);
    }
    
    public void Inventariar(OrdenCompraDto oc){
        controlador.Inventariar(oc);
    }
}
