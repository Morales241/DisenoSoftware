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
import java.util.Random;

/**
 *
 * @author tacot
 */
public class InventarioBajo  {

    public InventarioBajo() {
    }

    
    public List<ProductoCompradoDto> obtenerProductosPorAgotarse() {
        ProCompradoJpaController pcjc = new ProCompradoJpaController();

        List<ProComprado> listaProductosComprados = pcjc.findProCompradoEntities(); 
        
        List<ProductoCompradoDto> listaProductosPorAgotarse = new ArrayList<>();

        int anterior=0; 
        for (int i = 0; i < 5; i++) {
            int numeroAleatorio = new Random().nextInt((listaProductosComprados.size() - 1) + 1) + 1;
            if (numeroAleatorio != anterior) {
                //pc = producto comprado
                ProComprado pc = listaProductosComprados.get(numeroAleatorio);
                int cantidadA = new Random().nextInt((3 - 1) + 1) + 1; 
                
                listaProductosPorAgotarse.add(new ProductoCompradoDto(pc.getNombre(), pc.getCodigo(), pc.getProveedor(),cantidadA , pc.getPrecio()));
            }
        }

        return listaProductosPorAgotarse;
    }

}
