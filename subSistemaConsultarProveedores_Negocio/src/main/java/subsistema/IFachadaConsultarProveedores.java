/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoProveedorDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IFachadaConsultarProveedores {
    List<ProductoProveedorDto> obtenerProveedores(Long codigoProducto);
    
}
