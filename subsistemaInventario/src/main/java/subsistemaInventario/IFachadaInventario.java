/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaInventario;

import Negocio.dto.ProductoEntregadoDto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tacot
 */
public interface IFachadaInventario {
   public DefaultTableModel buscarProductos(String var1);

   public ProductoEntregadoDto obtenerProductoPorCodigo(String var1);
}