package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import java.util.ArrayList;
import java.util.List;
import negocioBO.NegocioBO;

/**
 *
 * @author tacot
 */
public class ControladorCoinsidencias {

    protected NegocioBO conP = new NegocioBO();

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

//        List<ProductoDto> listaProductos = new ArrayList<>();
//        for (ProductoDto pdto : this.obtenerProductos()) {
//            if (pdto.getNombre().contains(palabra)) {
//                listaProductos.add(pdto);
//            }
//        }
//        return listaProductos;
        }


}
