/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaConsultarProducto;

import Entidades.Producto;
import Entidades.ProductoJpaController;
import Negocio.dto.ProductoDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class consultarProductos implements IConsultarProducto{

    @Override
    public List<ProductoDto> obtenerProductos() {
        ProductoJpaController pjc = new ProductoJpaController();
        List<Producto> productos = pjc.findProductoEntities();
        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto p : productos) {
            productosDto.add(new ProductoDto(p.getId(), p.getNombre(), p.getCodigo()));
        }
        return productosDto;
    }
    
    @Override
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra) {
        List<ProductoDto> listaProductos = new ArrayList<>();
        for (ProductoDto pdto : this.obtenerProductos()) {
            if (pdto.getNombre().contains(palabra)) {
                listaProductos.add(pdto);
            }
        }
        return listaProductos;
    }

    
}
