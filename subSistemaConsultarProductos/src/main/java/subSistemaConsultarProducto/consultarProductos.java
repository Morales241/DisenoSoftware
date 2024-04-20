package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import daos.ProductoDao;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import negocioBO.NegocioBO;

/**
 *
 * @author tacot
 */
public class consultarProductos {

    NegocioBO negocio = new NegocioBO();

    public consultarProductos() {
    }

    
    public List<ProductoDto> obtenerProductos() {
        return negocio.obtenerProductos();
    }

}
