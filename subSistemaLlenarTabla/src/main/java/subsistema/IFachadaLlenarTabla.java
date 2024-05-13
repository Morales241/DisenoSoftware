/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsistema;

import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoEntregadoDto;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Marlon
 */
public interface IFachadaLlenarTabla {
    
    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla);
    
    public void llenarTablaInventario(List<ProductoEntregadoDto> lista, JTable tabla);
    
}
