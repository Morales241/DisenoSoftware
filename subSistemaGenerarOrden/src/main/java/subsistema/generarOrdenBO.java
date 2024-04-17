/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Daos.OrdenCompraJpaController;
import Entidades.OrdenCompra;
import Negocio.dto.ProductoCompradoDto;
import Entidades.ProComprado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocioBO.NegocioBO;

/**
 *
 * @author tacot
 */
public class generarOrdenBO implements IGenerarOrden {

    NegocioBO negocio = new NegocioBO();

    public generarOrdenBO() {
    }

    @Override
    public void realizarOrden(List<ProductoCompradoDto> prdsDto) throws Exception {
        List<ProductoCompradoDto> listaSinDuplicados = new ArrayList<>();
        for (ProductoCompradoDto producto : prdsDto) {
            int index = listaSinDuplicados.indexOf(producto);
            if (index != -1) {
                listaSinDuplicados.get(index).setCantidad(listaSinDuplicados.get(index).getCantidad() + producto.getCantidad());
            } else {
                listaSinDuplicados.add(producto);
            }
        }
        
        negocio.realizarOrden(prdsDto);
    }
}
