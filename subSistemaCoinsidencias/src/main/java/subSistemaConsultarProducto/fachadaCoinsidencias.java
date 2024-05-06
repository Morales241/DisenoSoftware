/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaConsultarProducto;

import Negocio.dto.ProductoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class fachadaCoinsidencias implements IFachadaCoinsidencias{
    
    ControladorCoinsidencias coin = new ControladorCoinsidencias();
    public fachadaCoinsidencias() {
    }

    @Override
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra) {
        return coin.obtenerCoincidenciasProductos(palabra);
    }
    
}
