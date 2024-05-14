/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cotizaciones;

import Negocio.dto.ProductoProveedorDto;
import java.util.ArrayList;
import java.util.List;
import negocioBO.IProductoProveedorBO;
import negocioBO.ProductoProveedorBO;

/**
 *
 * @author tacot
 */
public class controladorCotizaciones {

    IProductoProveedorBO proveedorBO = new ProductoProveedorBO();
    
    public controladorCotizaciones() {
    }
    
    
    public ProductoProveedorDto mejorProveedor(Long id){
        List<ProductoProveedorDto> proveedores = new ArrayList<>();
        
        for (ProductoProveedorDto p : proveedorBO.obtenerProveedores(id)) {
                proveedores.add(p);
            }
        
        ProductoProveedorDto mejorPro = proveedores.get(0);
        for (int i = 1; i < proveedores.size(); i++) {
            if (proveedores.get(i).getPrecioP() < mejorPro.getPrecioP()) {
                mejorPro = proveedores.get(i);
            }
        }
        return mejorPro;
    }
}
