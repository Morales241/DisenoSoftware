/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class fachadaInventarioBajo implements IinventarioBajoBO{
    InventarioBajo inventario = new InventarioBajo();
    public fachadaInventarioBajo() {
    }

    @Override
    public List<ProductoCompradoDto> obtenerProductosPorAgotarse() {
        return inventario.obtenerProductosPorAgotarse();
    }
    
}
