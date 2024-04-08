/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.objetosNegocio;

import Producto.OrdenCompra;
import Producto.ProComprado;
import Producto.Producto;
import Producto.ProductoJpaController;
import Producto.Proveedor;
import Producto.ProveedorJpaController;
import Producto.pro_Pro;
import Producto.pro_ProJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marlon
 */
public class OrdenNegocio implements IOrdenNegocio {

    @Override
    public void obtenerOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void realizarOrden(List<ProComprado> listaProductos) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        OrdenCompra oc = new OrdenCompra();
        oc.setProductos(listaProductos);
        double total = 0;
        for(ProComprado p: listaProductos) {
            total += p.getCantidad() * p.getPrecio();
        }
        oc.setTotal(total);
        for (ProComprado p: listaProductos) {
            p.setOrden(oc);
        }
        em.persist(oc);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    @Override
    public List<Producto> obtenerProductos() {
        ProductoJpaController pjc = new ProductoJpaController();
        return pjc.findProductoEntities();
    }
    
    public Producto obtenerProducto(Long id) {
        ProductoJpaController pjc = new ProductoJpaController();
        return pjc.findProducto(id);
    }
    
    public Proveedor obtenerProveedor(Long id) {
        ProveedorJpaController pjc = new ProveedorJpaController();
        return pjc.findProveedor(id);
    }
    
    public pro_Pro obtenerProPro(Long id) {
        pro_ProJpaController ppjc = new pro_ProJpaController();
        return ppjc.findpro_Pro(id);
    }
    
}
