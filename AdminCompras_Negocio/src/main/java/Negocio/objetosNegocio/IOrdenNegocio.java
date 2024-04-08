/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.objetosNegocio;

import Entidades.ProComprado;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.pro_Pro;
import java.util.List;

/**
 *
 * @author marlon
 */
public interface IOrdenNegocio {
    
    void obtenerOrden();
    void realizarOrden(List<ProComprado> listaProductos);
    List<Producto> obtenerProductos();
    public Producto obtenerProducto(Long id);
    public Proveedor obtenerProveedor(Long id);
    public pro_Pro obtenerProPro(Long id);
    
}
