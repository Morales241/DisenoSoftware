package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;
import negocioBO.NegocioBO;

public class ConsultarProductoCompradoBO implements IConsultarProductoCompradoBO {

    NegocioBO negocio = new NegocioBO();
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
        if (proCompDto.getCodigo()==null) {
            proCompDto = negocio.obtenerProductoProveedor(proCompDto.getNombre(), proCompDto.getProveedor());
            proCompDto.setCantidad(1);
        }
        for (ProductoCompradoDto p : listaProductosAComprados) {
            if (p.getNombre().equals(proCompDto.getNombre()) && p.getProveedor().equals(proCompDto.getProveedor())) {
                p.setCantidad(p.getCantidad() + proCompDto.getCantidad());
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
