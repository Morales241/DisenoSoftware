
package Negocio.objetosNegocio;

import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author marlon
 */
public interface IOrdenNegocio {
   
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra);
    
    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla);
    
    //subsistema de insercion
//    public void insercion();
}
