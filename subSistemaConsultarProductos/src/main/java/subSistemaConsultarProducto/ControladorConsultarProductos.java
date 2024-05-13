package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import java.util.List;
import negocioBO.IProductoBO;
import negocioBO.ProductoBO;

/**
 *
 * @author tacot
 */
public class ControladorConsultarProductos {

    protected IProductoBO negocio = new ProductoBO();

    public ControladorConsultarProductos() {
    }
    
    public List<ProductoDto> obtenerProductos() {
        return negocio.obtenerProductos();
    }

}
