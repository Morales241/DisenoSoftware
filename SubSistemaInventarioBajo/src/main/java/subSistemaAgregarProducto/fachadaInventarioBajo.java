package subSistemaAgregarProducto;

import Negocio.dto.ProductoEntregadoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class fachadaInventarioBajo implements IinventarioBajoBO{
    InventarioBajo inventario = new InventarioBajo();
    public fachadaInventarioBajo() {
    }

    @Override
    public List<ProductoEntregadoDto> obtenerProductosPorAgotarse() {
        return inventario.obtenerProductosPorAgotarse();
    }
    
}