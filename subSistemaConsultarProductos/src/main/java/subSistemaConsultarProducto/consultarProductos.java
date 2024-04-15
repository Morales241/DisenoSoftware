package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import daos.ProductoDao;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class consultarProductos implements IConsultarProducto {

    public consultarProductos() {
    }

    @Override
        public List<ProductoDto> obtenerProductos() {

            ProductoDao productoDao = new ProductoDao();
            List<Producto> listaProductos = productoDao.obtenerProductos();
            List<ProductoDto> listaProductosDto = new ArrayList<>();
            for (Producto p : listaProductos) {
                listaProductosDto.add(new ProductoDto(p.getId(), p.getNombre(), p.getCodigo()));
            }
            return listaProductosDto;
        }
//        ProductoJpaController pjc = new ProductoJpaController();
//        List<Producto> productos = pjc.findProductoEntities();
//        List<ProductoDto> productosDto = new ArrayList<>();
//        for (Producto p : productos) {
//            productosDto.add(new ProductoDto(p.getId(), p.getNombre(), p.getCodigo()));
//        }
//        return productosDto;
//        }

}
