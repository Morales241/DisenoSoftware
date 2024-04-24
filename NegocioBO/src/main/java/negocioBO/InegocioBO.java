/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocioBO;

import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoEntregadoDto;
import Negocio.dto.ProductoProveedorDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface InegocioBO {

    public List<ProductoDto> obtenerProductos();

    List<ProductoProveedorDto> obtenerProveedores(Long codigoProducto);

    public ProductoCompradoDto obtenerProductoProveedor(String nombre, String pro);

    void realizarOrden(List<ProductoCompradoDto> prdsDto);

    boolean verificarPresupuesto(Double cantidad);

    public List<OrdenCompraDto> consultarOrdenes();

    public List<ProductoCompradoDto>  obetenerProductosOrden(int index);

    public boolean agregarAInventario(OrdenCompraDto oc);

    public void eliminarDeInventario(int index);
    
    public List<ProductoEntregadoDto> obtenerInventarioBajo();
}
