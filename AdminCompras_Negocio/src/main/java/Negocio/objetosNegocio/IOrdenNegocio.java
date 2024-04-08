/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.objetosNegocio;

import Entidades.ProComprado;
import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import java.util.List;

/**
 *
 * @author marlon
 */
public interface IOrdenNegocio {
    
    void realizarOrden(List<ProductoCompradoDto> prdsDto);
    
    List<ProductoDto> obtenerProductos();

    List<ProductoProveedorDto> obtenerProveedores(Long codigoProducto);
    
    ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor);
    
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra);
    
    boolean validarCantidad(String cantidad);
    
    boolean verificarPresupuesto(Double cantidad);
    
    List<ProductoCompradoDto> obtenerProductosPorAgotarse();
    
    public void insercion();
}
