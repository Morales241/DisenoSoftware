/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaInventario;

import Negocio.dto.ProductoEntregadoDto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tacot
 */
public class FachadaInventario implements IFachadaInventario {

    private final CtrlInventario ctrlInventario = new CtrlInventario();

    @Override
    public DefaultTableModel buscarProductos(String cadena) {
        return this.ctrlInventario.obtenerProductosBuscados(cadena);
    }

    @Override
    public ProductoEntregadoDto obtenerProductoPorCodigo(String codigo) {
        return this.ctrlInventario.obtenerProductoPorCodigo(codigo);
    }
}
