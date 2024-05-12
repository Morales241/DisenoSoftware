/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaSalidaInventario;

import dtos.ProductoDTO;

/**
 *
 * @author marlon
 */
public class FachadaSalidaInventario implements IFachadaSalidaInventario {

    private CtrlSalidaInventario ctrlSalidaInventario;

    public FachadaSalidaInventario() {
        ctrlSalidaInventario = new CtrlSalidaInventario();
    }

    @Override
    public void desinventariarProducto(ProductoDTO producto) {
        ctrlSalidaInventario.desinventariarProducto(producto);
    }
    
}
