/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.objetosNegocio;

import Entidades.ProComprado;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import java.util.List;

/**
 *
 * @author marlon
 */
public interface IOrdenNegocio {
    
    void realizarOrden(List<ProComprado> listaProductos);
    
    List<ProductoDto> obtenerProductos();

    List<ProveedorDto> obtenerProveedores(Long codigoProducto);
    
    ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor);
    
}
