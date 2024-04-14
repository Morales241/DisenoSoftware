/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.objetosNegocio;

import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import java.text.Format.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlon
 */
public class OrdenNegocio implements IOrdenNegocio {

    private JLabel tituloTablas = new JLabel();
    private JLabel tablitaSP = new JLabel();
    private JLabel tablePersonas = new JLabel();
    private consultarProductos consultasP = new consultarProductos();

    @Override
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra) {
        List<ProductoDto> listaProductos = new ArrayList<>();
        for (ProductoDto pdto : consultasP.obtenerProductos()) {
            if (pdto.getNombre().contains(palabra)) {
                listaProductos.add(pdto);
            }
        }
        return listaProductos;
    }


    @Override
    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla) {
        // Crear un modelo de tabla y establecerlo en el JTable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nombre","Codigo", "Proveedor", "Costo", "cantidad", "Total"});
        
        if (lista.isEmpty()) {
            System.out.println("No se encontraron productos");
        }else{
            for (ProductoCompradoDto p : lista) {
                model.addRow(new Object[]{p.getNombre(), p.getCodigo(), p.getProveedor(),p.getPrecio(), p.getCantidad(), p.getPrecio()*p.getCantidad()});
            }
        }
        
    }
}
