package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;

public class ConsultarProductoCompradoBO implements IConsultarProductoCompradoBO {

    private static ConsultarProductoCompradoBO instance;
    private List<ProductoCompradoDto> listaProductosComprados;

    public ConsultarProductoCompradoBO() {
        listaProductosComprados = new ArrayList<>();
    }

    public static ConsultarProductoCompradoBO getInstance() {
        if (instance == null) {
            instance = new ConsultarProductoCompradoBO();
        }
        return instance;
    }

    @Override
    public void agregarCompraLista(ProductoCompradoDto proCompDto, int op) {
        if (op == 1) {
            listaProductosComprados.add(proCompDto);
        } else {
            listaProductosComprados.forEach(ProductoCompradoDto -> {
                if (ProductoCompradoDto.getNombre().equals(proCompDto.getNombre())) {
                    ProductoCompradoDto.setCantidad(3 + ProductoCompradoDto.getCantidad());
                }
            });
        }
    }

    @Override
    public List<ProductoCompradoDto> getListaProductosComprados() {
        return listaProductosComprados;
    }
}
