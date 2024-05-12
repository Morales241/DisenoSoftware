/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocioBO;

import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoEntregadoDto;
import java.util.List;

/**
 *
 * @author marlon
 */
public interface IProductoEntregadoBO {

    public List<ProductoDto> obtenerProductos();

    public void eliminarDeInventario(int index);

    public List<ProductoEntregadoDto> obtenerInventarioBajo();

}
