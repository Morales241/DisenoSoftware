package subSistemaInventario;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface Iinventario {
    
    List<ProductoCompradoDto> obtenerProductosPorAgotarse();
}
