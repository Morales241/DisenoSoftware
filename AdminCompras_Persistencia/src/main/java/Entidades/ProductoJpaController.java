/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Producto.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tacot
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getProductoProveedores() == null) {
            producto.setProductoProveedores(new ArrayList<pro_Pro>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<pro_Pro> attachedProductoProveedores = new ArrayList<pro_Pro>();
            for (pro_Pro productoProveedorespro_ProToAttach : producto.getProductoProveedores()) {
                productoProveedorespro_ProToAttach = em.getReference(productoProveedorespro_ProToAttach.getClass(), productoProveedorespro_ProToAttach.getId());
                attachedProductoProveedores.add(productoProveedorespro_ProToAttach);
            }
            producto.setProductoProveedores(attachedProductoProveedores);
            em.persist(producto);
            for (pro_Pro productoProveedorespro_Pro : producto.getProductoProveedores()) {
                Producto oldProductoOfProductoProveedorespro_Pro = productoProveedorespro_Pro.getProducto();
                productoProveedorespro_Pro.setProducto(producto);
                productoProveedorespro_Pro = em.merge(productoProveedorespro_Pro);
                if (oldProductoOfProductoProveedorespro_Pro != null) {
                    oldProductoOfProductoProveedorespro_Pro.getProductoProveedores().remove(productoProveedorespro_Pro);
                    oldProductoOfProductoProveedorespro_Pro = em.merge(oldProductoOfProductoProveedorespro_Pro);
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
            List<pro_Pro> productoProveedoresOld = persistentProducto.getProductoProveedores();
            List<pro_Pro> productoProveedoresNew = producto.getProductoProveedores();
            List<pro_Pro> attachedProductoProveedoresNew = new ArrayList<pro_Pro>();
            for (pro_Pro productoProveedoresNewpro_ProToAttach : productoProveedoresNew) {
                productoProveedoresNewpro_ProToAttach = em.getReference(productoProveedoresNewpro_ProToAttach.getClass(), productoProveedoresNewpro_ProToAttach.getId());
                attachedProductoProveedoresNew.add(productoProveedoresNewpro_ProToAttach);
            }
            productoProveedoresNew = attachedProductoProveedoresNew;
            producto.setProductoProveedores(productoProveedoresNew);
            producto = em.merge(producto);
            for (pro_Pro productoProveedoresOldpro_Pro : productoProveedoresOld) {
                if (!productoProveedoresNew.contains(productoProveedoresOldpro_Pro)) {
                    productoProveedoresOldpro_Pro.setProducto(null);
                    productoProveedoresOldpro_Pro = em.merge(productoProveedoresOldpro_Pro);
                }
            }
            for (pro_Pro productoProveedoresNewpro_Pro : productoProveedoresNew) {
                if (!productoProveedoresOld.contains(productoProveedoresNewpro_Pro)) {
                    Producto oldProductoOfProductoProveedoresNewpro_Pro = productoProveedoresNewpro_Pro.getProducto();
                    productoProveedoresNewpro_Pro.setProducto(producto);
                    productoProveedoresNewpro_Pro = em.merge(productoProveedoresNewpro_Pro);
                    if (oldProductoOfProductoProveedoresNewpro_Pro != null && !oldProductoOfProductoProveedoresNewpro_Pro.equals(producto)) {
                        oldProductoOfProductoProveedoresNewpro_Pro.getProductoProveedores().remove(productoProveedoresNewpro_Pro);
                        oldProductoOfProductoProveedoresNewpro_Pro = em.merge(oldProductoOfProductoProveedoresNewpro_Pro);
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
            List<pro_Pro> productoProveedores = producto.getProductoProveedores();
            for (pro_Pro productoProveedorespro_Pro : productoProveedores) {
                productoProveedorespro_Pro.setProducto(null);
                productoProveedorespro_Pro = em.merge(productoProveedorespro_Pro);
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
