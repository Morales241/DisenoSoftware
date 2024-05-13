/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoEntregadoDto;
import java.util.List;
import negocioBO.IProductoEntregadoBO;
import negocioBO.ProductoEntregadoBO;

/**
 *
 * @author tacot
 */
public class ControladorInventarioBajo {

    public ControladorInventarioBajo() {
    }

    protected IProductoEntregadoBO inventario = new ProductoEntregadoBO();

    public List<ProductoEntregadoDto> obtenerProductosPorAgotarse() {
//        ProCompradoJpaController pcjc = new ProCompradoJpaController();
//
//        List<ProComprado> listaProductosComprados = pcjc.findProCompradoEntities(); 

        
        List<ProductoEntregadoDto> Inventario = inventario.obtenerInventarioBajo();
        

        return Inventario;
    }

}
