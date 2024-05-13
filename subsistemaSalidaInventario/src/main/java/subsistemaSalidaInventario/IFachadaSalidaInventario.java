/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaSalidaInventario;

import Negocio.dto.ProductoEntregadoDto;

/**
 *
 * @author marlon
 */
public interface IFachadaSalidaInventario {
    
    public void desinventariarProducto(ProductoEntregadoDto producto);
    
}
