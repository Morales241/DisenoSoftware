/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoProveedorDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class fachadaConsultarProveedores implements IFachadaConsultarProveedores{
    ControladorConsultarProveedoresBO consulta = new ControladorConsultarProveedoresBO();
    public fachadaConsultarProveedores() {
    }

    @Override
    public List<ProductoProveedorDto> obtenerProveedores(Long id) {
        return consulta.obtenerProveedores(id);
    }
    
}
