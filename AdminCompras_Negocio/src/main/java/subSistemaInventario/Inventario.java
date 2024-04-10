/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaInventario;

import Negocio.dto.ProductoCompradoDto;
import daos.ProductoCompradoDao;
import entidades.ProductoComprado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class Inventario implements Iinventario{

    @Override
    public List<ProductoCompradoDto> obtenerProductosPorAgotarse() {
        ProductoCompradoDao pcd = new ProductoCompradoDao();
        List<ProductoComprado> listaProductosComprados = pcd.obtenerProductosComprados();
        List<ProductoCompradoDto> listaProductosPorAgotarse = new ArrayList<>();
        for(ProductoComprado pc: listaProductosComprados) {
            if (pc.getCantidad() < 3) {
                listaProductosPorAgotarse.add(new ProductoCompradoDto(pc.getProducto().getNombre(), pc.getProducto().getCodigo(), pc.getProveedor().getNombre(), pc.getCantidad(), pc.getPrecio()));
            }
        }
        return listaProductosPorAgotarse;
//        ProCompradoJpaController pcjc = new ProCompradoJpaController();
//        
//        List<ProComprado> listaProductosComprados = pcjc.findProCompradoEntities();
//              
//        List<ProductoCompradoDto> listaProductosPorAgotarse = new ArrayList<>();
//        
//        for(ProComprado pc: listaProductosComprados) {
//            if (pc.getCantidad() < 3) {
//                listaProductosPorAgotarse.add(new ProductoCompradoDto(pc.getNombre(), pc.getCodigo(), pc.getProveedor(), pc.getCantidad(), pc.getPrecio()));
//            }
//        }
//        
//        return listaProductosPorAgotarse;
    }
}
