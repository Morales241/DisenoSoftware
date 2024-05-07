/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import daos.ProductoProveedorDao;
import java.util.ArrayList;
import java.util.List;
import entidades.Proveedor;
import daos.ProveedorDao;
import entidades.ProductoProveedor;
import negocioBO.NegocioBO;

/**
 *
 * @author tacot
 */
public class ControladorConsultarProveedoresBO {
    protected NegocioBO negocio = new NegocioBO();
    
    public ControladorConsultarProveedoresBO() {
    }

    
    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto) {
        return negocio.obtenerProveedores(idProducto);
    }

}
