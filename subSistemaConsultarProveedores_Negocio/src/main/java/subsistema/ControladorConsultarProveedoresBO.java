/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoProveedorDto;
import java.util.List;
import negocioBO.IProductoProveedorBO;
import negocioBO.ProductoProveedorBO;

/**
 *
 * @author tacot
 */
public class ControladorConsultarProveedoresBO {
    protected IProductoProveedorBO negocio = new ProductoProveedorBO();
    
    public ControladorConsultarProveedoresBO() {
    }

    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto) {
        return negocio.obtenerProveedores(idProducto);
    }

}
