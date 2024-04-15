package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class consultarCoinsidenciasProductos implements IConsultarCoinsidenciasProductos {

    consultarProductos conP = new consultarProductos();

    public consultarCoinsidenciasProductos() {
    }

        @Override
        public List<ProductoDto> obtenerCoincidenciasProductos(String palabra) {

            List<ProductoDto> listaProductos = new ArrayList<>();
            for (ProductoDto pdto : conP.obtenerProductos()) {
                if (pdto.getNombre().contains(palabra)) {
                    listaProductos.add(pdto);
                }
            }
            return listaProductos;

//        List<ProductoDto> listaProductos = new ArrayList<>();
//        for (ProductoDto pdto : this.obtenerProductos()) {
//            if (pdto.getNombre().contains(palabra)) {
//                listaProductos.add(pdto);
//            }
//        }
//        return listaProductos;
        }


}
