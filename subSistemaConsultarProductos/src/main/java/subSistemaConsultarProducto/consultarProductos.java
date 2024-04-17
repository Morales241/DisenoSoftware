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
public class consultarProductos implements IConsultarProducto {

    NegocioBO negocio = new NegocioBO();

    public consultarProductos() {
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        return negocio.obtenerProductos();
    }

}
