/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IConsultarProducto {
    
    List<ProductoDto> obtenerProductos();
    
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra);
}
