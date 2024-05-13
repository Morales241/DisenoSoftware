/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;

import Daos.DaoproComprado;
import Negocio.dto.ProductoEntregadoDto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marlon
 */
public class ProductoEntregadoBO implements IProductoEntregadoBO {
    
    DaoproComprado daoProductos = new DaoproComprado();

    @Override
    public void eliminarDeInventario(int index) {
        //        inventario.eliminarAInventario(index);
    }

    @Override
    public List<ProductoEntregadoDto> obtenerInventarioBajo() {
        List<ProductoEntregadoDto> listaAux = new ArrayList<>();
        try {
            daoProductos.consultar().forEach(proEntregadoMock -> {
                if (proEntregadoMock.getCantidad() < 3) {
                    listaAux.add(new ProductoEntregadoDto(proEntregadoMock.getNombre(), proEntregadoMock.getCodigo(), proEntregadoMock.getProveedor(),
                            proEntregadoMock.getCantidad(), proEntregadoMock.getPrecio()));
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(ProductoEntregadoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAux;
    }
    
}
