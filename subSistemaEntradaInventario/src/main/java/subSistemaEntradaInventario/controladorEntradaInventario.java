/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaEntradaInventario;

import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocioBO.IOrdenCompraBO;
import negocioBO.OrdenCompraBO;

/**
 *
 * @author
 */
public class controladorEntradaInventario {

    protected IOrdenCompraBO negocio;

    public controladorEntradaInventario() {
        this.negocio = new OrdenCompraBO();
    }

    public void llenarTablaProductos(List<ProductoCompradoDto> lista, JTable tabla) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nombre", "Cantidad Esperada", "Cantidad Recibida"});

        if (lista.isEmpty()) {
            System.out.println("No se encontraron productos");
        } else {
            for (ProductoCompradoDto p : lista) {
                int cantidad = cantidadRecibida();

                int resultado = p.getCantidad();

                if (p.getCantidad() >= cantidad) {
                    resultado = p.getCantidad() - cantidad;
                }

                model.addRow(new Object[]{p.getNombre(), p.getCantidad(), resultado});
            }
        }
        tabla.setModel(model);
    }

    public void llenarTablaOrdenes(JTable tabla) throws Exception {

        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(new String[]{"Folio", "Fecha Entrega"});

        List<OrdenCompraDto> listaAux = negocio.consultarOrdenesPagadas();

        if (listaAux.isEmpty()) {
            throw new Exception("No se encontraron órdenes");
        } else {
            for (OrdenCompraDto p : listaAux) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            String fecha = formato.format(p.getFechaExpedicion());
                
                model.addRow(new Object[]{p.getFolio(), fecha});
            }
        }
        tabla.setModel(model);
    }

    public void llenarTablaFiltrada(JTable tabla, Date desde, Date hasta) {

        List<OrdenCompraDto> listaAux = new ArrayList<>();

        listaAux = negocio.consultarOrdenesPeriodo(desde, hasta);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Folio", "Fecha Entrega"});

        if (listaAux.isEmpty()) {
            System.out.println("No se encontraron órdenes");
        } else {
            for (OrdenCompraDto p : listaAux) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            String fecha = formato.format(p.getFechaExpedicion());
                
                model.addRow(new Object[]{p.getFolio(), fecha});
            }
        }
        tabla.setModel(model);
    }

    public OrdenCompraDto ordenPorFolio(String folio) {

        return negocio.buscarOrdenFolio(folio);

    }

    public Integer cantidadRecibida() {

        Integer cant = new Random().nextInt(50) + 1;

        int resultado = 0;

        if (cant == 35) {
            resultado = new Random().nextInt(3) + 1;
        }
        return resultado;
    }
    
    public void Reportar(OrdenCompraDto oc){
        negocio.Reportar(oc);
    }
    
    public void Inventariar(OrdenCompraDto oc){
        negocio.Inventariar(oc);
    }

}
