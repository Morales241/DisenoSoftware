/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocioBO;

import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoProveedorDto;
import java.util.List;

/**
 *
 * @author marlon
 */
public interface IProductoProveedorBO {

    public ProductoCompradoDto obtenerProductoProveedor(String nombre, String pro);

    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto);

}
