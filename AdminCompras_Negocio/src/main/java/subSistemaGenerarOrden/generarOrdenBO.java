/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaGenerarOrden;

import Negocio.dto.ProductoCompradoDto;
import daos.OrdenCompraDao;
import entidades.OrdenCompra;
import entidades.Producto;
import entidades.ProductoComprado;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        
        OrdenCompraDao ocd = new OrdenCompraDao();
        
        List<ProductoComprado> listaProductos = new ArrayList<>();
        
        for (ProductoCompradoDto pcdto: prdsDto) {
            listaProductos.add(new ProductoComprado(new Producto(pcdto.getNombre(), pcdto.getCodigo()), new Proveedor(pcdto.getNombre()), pcdto.getCantidad(), pcdto.getPrecio()));
        }
        
        double total = 0;
        for (ProductoComprado p: listaProductos) {
            total += p.getCantidad() * p.getPrecio();
        }
        
        OrdenCompra oc = new OrdenCompra(total, new Date(), listaProductos);
        
        ocd.agregarOrdenCompra(oc);
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        List<ProComprado> productos = new ArrayList();
//
//        prdsDto.forEach(ProductoCompradoDto -> {
//
//            productos.add(new ProComprado(ProductoCompradoDto.getNombre(), ProductoCompradoDto.getCodigo(),
//                    ProductoCompradoDto.getProveedor(), ProductoCompradoDto.getCantidad(), ProductoCompradoDto.getPrecio()));
//        });
//
//        OrdenCompra oc = new OrdenCompra();
//        oc.setFechaExpedicion(Calendar.getInstance());
//        oc.setProductos(productos);
//        double total = 0;
//        for (ProComprado p : productos) {
//            total += p.getCantidad() * p.getPrecio();
//        }
//        oc.setTotal(total);
//        
//        for (ProComprado p : productos) {
//            p.setOrden(oc);
//        }
//        em.persist(oc);
//
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        
    }
}
