/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Negocio.dto.ProductoEntregadoDto;
import java.util.List;
import negocioBO.NegocioBO;

/**
 *
 * @author tacot
 */
public class ControladorInventarioBajo {

    public ControladorInventarioBajo() {
    }

    protected NegocioBO inventario = new NegocioBO();

    public List<ProductoEntregadoDto> obtenerProductosPorAgotarse() {
//        ProCompradoJpaController pcjc = new ProCompradoJpaController();
//
//        List<ProComprado> listaProductosComprados = pcjc.findProCompradoEntities(); 

        
        List<ProductoEntregadoDto> Inventario = inventario.obtenerInventarioBajo();
        

        return Inventario;
    }

}
