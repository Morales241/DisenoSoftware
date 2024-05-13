/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaInventario;

import Negocio.dto.ProductoEntregadoDto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlon
 */
public class FachadaInventario implements IFachadaInventario {
    
    private CtrlInventario ctrlInventario;

    public FachadaInventario() {
        ctrlInventario = new CtrlInventario();
    }
    
    @Override
    public DefaultTableModel buscarProductos(String cadena) {
        return ctrlInventario.obtenerProductosBuscados(cadena);
    }

    @Override
    public ProductoEntregadoDto obtenerProductoPorCodigo(String codigo) {
        return ctrlInventario.obtenerProductoPorCodigo(codigo);
    }
    
}
