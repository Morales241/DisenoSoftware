package subSistemaAgregarProducto;

import Negocio.dto.ProductoEntregadoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class fachadaInventarioBajo implements IFachadaInventarioBajo{
    ControladorInventarioBajo inventario = new ControladorInventarioBajo();
    public fachadaInventarioBajo() {
    }

    @Override
    public List<ProductoEntregadoDto> obtenerProductosPorAgotarse() {
        return inventario.obtenerProductosPorAgotarse();
    }
    
}