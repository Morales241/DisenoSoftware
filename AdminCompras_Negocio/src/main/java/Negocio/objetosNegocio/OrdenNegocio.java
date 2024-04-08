/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.objetosNegocio;

import Entidades.OrdenCompra;
import Entidades.ProComprado;
import Entidades.Producto;
import Entidades.ProductoJpaController;
import Entidades.Proveedor;
import Entidades.ProveedorJpaController;
import Entidades.pro_Pro;
import Entidades.pro_ProJpaController;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import java.util.ArrayList;
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
    public void realizarOrden(List<ProComprado> listaProductos) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        OrdenCompra oc = new OrdenCompra();
        oc.setProductos(listaProductos);
        double total = 0;
        for (ProComprado p : listaProductos) {
            total += p.getCantidad() * p.getPrecio();
        }
        oc.setTotal(total);
        for (ProComprado p : listaProductos) {
            p.setOrden(oc);
        }
        em.persist(oc);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        ProductoJpaController pjc = new ProductoJpaController();
        List<Producto> productos = pjc.findProductoEntities();
        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto p : productos) {
            productosDto.add(new ProductoDto(p.getNombre()));
        }
        return productosDto;
    }

    @Override
    public List<ProveedorDto> obtenerProveedores(Long idProducto) {
        pro_ProJpaController ppjc = new pro_ProJpaController();
        List<pro_Pro> pplist = ppjc.findpro_ProEntities();
        List<Proveedor> provlist = new ArrayList<>();

        for (pro_Pro pp : pplist) {
            if (pp.getProducto().getId() == idProducto) {
                provlist.add(pp.getProveedor());
            }
        }

        List<ProveedorDto> provlistdto = new ArrayList<>();

        for (Proveedor p : provlist) {
            provlistdto.add(new ProveedorDto(p.getNombre(), p.getTelefono()));
        }

        return provlistdto;
    }

    @Override
    public ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor) {
        pro_ProJpaController ppjc = new pro_ProJpaController();
        List<pro_Pro> pplist = ppjc.findpro_ProEntities();
        
        for (pro_Pro pp: pplist) {
            if (idProducto == pp.getProducto().getId() && idProveedor == pp.getProveedor().getId()) {
                return new ProductoProveedorDto(pp.getPrecioP(), pp.getStock(), new ProductoDto(pp.getProducto().getNombre()), new ProveedorDto(pp.getProveedor().getNombre(), pp.getProveedor().getTelefono()));
            }
        }
        
        return null;
    }

}
