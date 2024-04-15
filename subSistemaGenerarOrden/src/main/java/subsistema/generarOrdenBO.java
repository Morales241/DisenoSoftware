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
import subSistemaFinanzas.Finanzas;
import subSistemaFinanzas.IFinanzas;

/**
 *
 * @author tacot
 */
public class generarOrdenBO implements IGenerarOrden {

    IFinanzas f = new Finanzas();

    public generarOrdenBO() {
    }

    @Override
    public void realizarOrden(List<ProductoCompradoDto> prdsDto) throws Exception{

//        OrdenCompraJpaController ocd = new OrdenCompraJpaController();
//        
//        List<ProductoComprado> listaProductos = new ArrayList<>();
//        // NUEVA LÍNEA
//        List<ProComprado> listaProductosPersistir = new ArrayList<>();
//        
//        for (ProductoCompradoDto pcdto: prdsDto) {
//            listaProductos.add(new ProductoComprado(new Producto(pcdto.getNombre(), pcdto.getCodigo()), new Proveedor(pcdto.getNombre()), pcdto.getCantidad(), pcdto.getPrecio()));
//        }
//        
//        double total = 0;
//        for (ProductoComprado p: listaProductos) {
//            total += p.getCantidad() * p.getPrecio();
//            // NUEVA LÍNEA
//            listaProductosPersistir.add(new ProComprado(p.getProducto().getNombre(), p.getProducto().getCodigo(), p.getProveedor().getNombre(), p.getCantidad(), p.getPrecio()));
//        }
//        
//        // MODIFICACIÓN LÍNEA
//        OrdenCompra oc = new OrdenCompra(total, Calendar.getInstance(), listaProductosPersistir);
//        
//        ocd.create(oc);
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
        if (!f.verificarPresupuesto(total)) {

            throw new Exception("No se cuenta con el presupuesto suficiente");

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
