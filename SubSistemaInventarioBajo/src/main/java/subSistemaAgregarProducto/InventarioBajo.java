/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaAgregarProducto;

import Daos.ProCompradoJpaController;
import Entidades.ProComprado;
import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class InventarioBajo implements IinventarioBajoBO {

    public InventarioBajo() {
    }

    @Override
    public List<ProductoCompradoDto> obtenerProductosPorAgotarse() {
        ProCompradoJpaController pcjc = new ProCompradoJpaController();

        List<ProComprado> listaProductosComprados = pcjc.findProCompradoEntities();

        List<ProductoCompradoDto> listaProductosPorAgotarse = new ArrayList<>();

        for (ProComprado pc : listaProductosComprados) {
            if (pc.getCantidad() < 3) {
                listaProductosPorAgotarse.add(new ProductoCompradoDto(pc.getNombre(), pc.getCodigo(), pc.getProveedor(), pc.getCantidad(), pc.getPrecio()));
            }
        }

        return listaProductosPorAgotarse;
    }

}
