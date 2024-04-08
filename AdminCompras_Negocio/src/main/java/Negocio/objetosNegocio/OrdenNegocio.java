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
            productosDto.add(new ProductoDto(p.getId(),p.getNombre(), p.getCodigo()));
        }
        return productosDto;
    }

    @Override
    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto) {
        pro_ProJpaController ppjc = new pro_ProJpaController();
        
        List<pro_Pro> pplist = ppjc.findpro_ProEntities();
        
        List<pro_Pro> provlist = new ArrayList<>();

        for (pro_Pro pp : pplist) {
            if (pp.getProducto().getId() == idProducto) {
                provlist.add(pp);
            }
        }

        List<ProductoProveedorDto> provlistdto = new ArrayList<>();

        for (pro_Pro p : provlist) {
            provlistdto.add(new ProductoProveedorDto(p.getPrecioP(), p.getStock(),
                    new ProductoDto(p.getProducto().getId(), p.getProducto().getNombre(),  p.getProducto().getCodigo()), 
                    new ProveedorDto(p.getProveedor().getId(), p.getProveedor().getNombre(),p.getProveedor().getTelefono())));
        }

        return provlistdto;
    }

    @Override
    public ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor) {
        pro_ProJpaController ppjc = new pro_ProJpaController();
        List<pro_Pro> pplist = ppjc.findpro_ProEntities();

        for (pro_Pro pp : pplist) {
            if (idProducto == pp.getProducto().getId() && idProveedor == pp.getProveedor().getId()) {
                return new ProductoProveedorDto(pp.getPrecioP(), pp.getStock(), new ProductoDto(pp.getProducto().getId(), pp.getProducto().getNombre(), pp.getProducto().getCodigo()), new ProveedorDto(pp.getProveedor().getNombre(), pp.getProveedor().getTelefono()));
            }
        }

        return null;
    }

    @Override
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra) {
        List<ProductoDto> listaProductos = new ArrayList<>();
        for (ProductoDto pdto : this.obtenerProductos()) {
            if (pdto.getNombre().contains(palabra)) {
                listaProductos.add(pdto);
            }
        }
        return listaProductos;
    }


}