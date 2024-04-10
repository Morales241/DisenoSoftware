/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subSistemaConsultarProveedores;

import Negocio.dto.ProductoProveedorDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IConsultarProveedores {
    List<ProductoProveedorDto> obtenerProveedores(Long codigoProducto);
    
    ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor);
}
