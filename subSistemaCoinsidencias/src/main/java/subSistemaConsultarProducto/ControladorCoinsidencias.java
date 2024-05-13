package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import java.util.ArrayList;
import java.util.List;
import negocioBO.IProductoBO;
import negocioBO.ProductoBO;

/**
 *
 * @author tacot
 */
public class ControladorCoinsidencias {

    protected IProductoBO conP = new ProductoBO();

    public ControladorCoinsidencias() {
    }

        public List<ProductoDto> obtenerCoincidenciasProductos(String palabra) {

            List<ProductoDto> listaProductos = new ArrayList<>();
            for (ProductoDto pdto : conP.obtenerProductos()) {
                if (pdto.getNombre().toLowerCase().contains(palabra.toLowerCase())) {
                    listaProductos.add(pdto);
                }
            }
            return listaProductos;
        }


}
