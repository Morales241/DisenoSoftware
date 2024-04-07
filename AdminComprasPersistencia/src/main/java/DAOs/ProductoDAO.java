/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.exceptions.NonexistentEntityException;
import Entidades.Producto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.pProveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tacot
 */
public class ProductoDAO implements Serializable {

    public ProductoDAO() {
        this.emf = Persistence.createEntityManagerFactory("ConcexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getProductoProveedores() == null) {
            producto.setProductoProveedores(new ArrayList<pProveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<pProveedor> attachedProductoProveedores = new ArrayList<pProveedor>();
            for (pProveedor productoProveedoresproducto_ProveedorToAttach : producto.getProductoProveedores()) {
                productoProveedoresproducto_ProveedorToAttach = em.getReference(productoProveedoresproducto_ProveedorToAttach.getClass(), productoProveedoresproducto_ProveedorToAttach.getId());
                attachedProductoProveedores.add(productoProveedoresproducto_ProveedorToAttach);
            }
            producto.setProductoProveedores(attachedProductoProveedores);
            em.persist(producto);
            for (pProveedor productoProveedoresproducto_Proveedor : producto.getProductoProveedores()) {
                Producto oldProductoOfProductoProveedoresproducto_Proveedor = productoProveedoresproducto_Proveedor.getProducto();
                productoProveedoresproducto_Proveedor.setProducto(producto);
                productoProveedoresproducto_Proveedor = em.merge(productoProveedoresproducto_Proveedor);
                if (oldProductoOfProductoProveedoresproducto_Proveedor != null) {
                    oldProductoOfProductoProveedoresproducto_Proveedor.getProductoProveedores().remove(productoProveedoresproducto_Proveedor);
                    oldProductoOfProductoProveedoresproducto_Proveedor = em.merge(oldProductoOfProductoProveedoresproducto_Proveedor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getId());
            List<pProveedor> productoProveedoresOld = persistentProducto.getProductoProveedores();
            List<pProveedor> productoProveedoresNew = producto.getProductoProveedores();
            List<pProveedor> attachedProductoProveedoresNew = new ArrayList<pProveedor>();
            for (pProveedor productoProveedoresNewproducto_ProveedorToAttach : productoProveedoresNew) {
                productoProveedoresNewproducto_ProveedorToAttach = em.getReference(productoProveedoresNewproducto_ProveedorToAttach.getClass(), productoProveedoresNewproducto_ProveedorToAttach.getId());
                attachedProductoProveedoresNew.add(productoProveedoresNewproducto_ProveedorToAttach);
            }
            productoProveedoresNew = attachedProductoProveedoresNew;
            producto.setProductoProveedores(productoProveedoresNew);
            producto = em.merge(producto);
            for (pProveedor productoProveedoresOldproducto_Proveedor : productoProveedoresOld) {
                if (!productoProveedoresNew.contains(productoProveedoresOldproducto_Proveedor)) {
                    productoProveedoresOldproducto_Proveedor.setProducto(null);
                    productoProveedoresOldproducto_Proveedor = em.merge(productoProveedoresOldproducto_Proveedor);
                }
            }
            for (pProveedor productoProveedoresNewproducto_Proveedor : productoProveedoresNew) {
                if (!productoProveedoresOld.contains(productoProveedoresNewproducto_Proveedor)) {
                    Producto oldProductoOfProductoProveedoresNewproducto_Proveedor = productoProveedoresNewproducto_Proveedor.getProducto();
                    productoProveedoresNewproducto_Proveedor.setProducto(producto);
                    productoProveedoresNewproducto_Proveedor = em.merge(productoProveedoresNewproducto_Proveedor);
                    if (oldProductoOfProductoProveedoresNewproducto_Proveedor != null && !oldProductoOfProductoProveedoresNewproducto_Proveedor.equals(producto)) {
                        oldProductoOfProductoProveedoresNewproducto_Proveedor.getProductoProveedores().remove(productoProveedoresNewproducto_Proveedor);
                        oldProductoOfProductoProveedoresNewproducto_Proveedor = em.merge(oldProductoOfProductoProveedoresNewproducto_Proveedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getId();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<pProveedor> productoProveedores = producto.getProductoProveedores();
            for (pProveedor productoProveedoresproducto_Proveedor : productoProveedores) {
                productoProveedoresproducto_Proveedor.setProducto(null);
                productoProveedoresproducto_Proveedor = em.merge(productoProveedoresproducto_Proveedor);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Producto findProducto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
