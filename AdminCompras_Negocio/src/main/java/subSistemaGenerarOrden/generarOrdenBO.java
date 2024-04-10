/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaGenerarOrden;

import Entidades.OrdenCompra;
import Entidades.ProComprado;
import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tacot
 */
public class generarOrdenBO implements IGenerarOrden{
    
    @Override
    public void realizarOrden(List<ProductoCompradoDto> prdsDto)  {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<ProComprado> productos = new ArrayList();

        prdsDto.forEach(ProductoCompradoDto -> {

            productos.add(new ProComprado(ProductoCompradoDto.getNombre(), ProductoCompradoDto.getCodigo(),
                    ProductoCompradoDto.getProveedor(), ProductoCompradoDto.getCantidad(), ProductoCompradoDto.getPrecio()));
        });

        OrdenCompra oc = new OrdenCompra();
        oc.setFechaExpedicion(Calendar.getInstance());
        oc.setProductos(productos);
        double total = 0;
        for (ProComprado p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }
        oc.setTotal(total);
        
        for (ProComprado p : productos) {
            p.setOrden(oc);
        }
        em.persist(oc);

        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
