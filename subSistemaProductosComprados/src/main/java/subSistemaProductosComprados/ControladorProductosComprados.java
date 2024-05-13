package subSistemaProductosComprados;

import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;
import negocioBO.IProductoCompradoBO;
import negocioBO.IProductoProveedorBO;
import negocioBO.ProductoCompradoBO;
import negocioBO.ProductoProveedorBO;

public class ControladorProductosComprados  {

    protected IProductoCompradoBO negocio = new ProductoCompradoBO();
    
    protected IProductoProveedorBO negocioProveedor = new ProductoProveedorBO();
    protected static ControladorProductosComprados instance;
    protected List<ProductoCompradoDto> listaProductosAComprados;

    private ControladorProductosComprados() {
        listaProductosAComprados = new ArrayList<>();
    }

    public static ControladorProductosComprados getInstance() {
        if (instance == null) {
            instance = new ControladorProductosComprados();
        }
        return instance;
    }

    public boolean agregarCompraLista(ProductoCompradoDto proCompDto)throws Exception {
        if (proCompDto == null) {
            throw new Exception("No se selecciono Producto");
        }
        if (proCompDto.getCodigo()==null) {
            proCompDto = negocioProveedor.obtenerProductoProveedor(proCompDto.getNombre(), proCompDto.getProveedor());
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

    
    public void eliminarProducto(int index){
        listaProductosAComprados.remove(listaProductosAComprados.get(index));
    }
    
    public void eliminarTodosLosProductos(){
        listaProductosAComprados = new ArrayList<>();
    }

    public List<ProductoCompradoDto> getListaProductosComprados() {
        return listaProductosAComprados;
    }
}
