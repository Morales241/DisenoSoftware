package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;

public class ConsultarProductoCompradoBO implements IConsultarProductoCompradoBO {

    private static ConsultarProductoCompradoBO instance;
    private final List<ProductoCompradoDto> listaProductosAComprados;

    public ConsultarProductoCompradoBO() {
        listaProductosAComprados = new ArrayList<>();
    }

    public static ConsultarProductoCompradoBO getInstance() {
        if (instance == null) {
            instance = new ConsultarProductoCompradoBO();
        }
        return instance;
    }

    @Override
    public boolean agregarCompraLista(ProductoCompradoDto proCompDto) {
        for (ProductoCompradoDto p : listaProductosAComprados) {
            if (p.getNombre().equals(proCompDto.getNombre()) && p.getProveedor().equals(proCompDto.getProveedor())) {
                p.setCantidad(p.getCantidad()+proCompDto.getCantidad());
                return true;
            }
        }
        
        listaProductosAComprados.add(proCompDto);
        return false;
    }

    @Override
    public List<ProductoCompradoDto> getListaProductosComprados() {
        return listaProductosAComprados;
    }
}
