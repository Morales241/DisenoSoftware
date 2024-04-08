/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Producto.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author tacot
 */
public class pro_ProJpaController implements Serializable {

    public pro_ProJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(pro_Pro pro_Pro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = pro_Pro.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getId());
                pro_Pro.setProducto(producto);
            }
            Proveedor proveedor = pro_Pro.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getId());
                pro_Pro.setProveedor(proveedor);
            }
            em.persist(pro_Pro);
            if (producto != null) {
                producto.getProductoProveedores().add(pro_Pro);
                producto = em.merge(producto);
            }
            if (proveedor != null) {
                proveedor.getProductoProveedores().add(pro_Pro);
                proveedor = em.merge(proveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(pro_Pro pro_Pro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pro_Pro persistentpro_Pro = em.find(pro_Pro.class, pro_Pro.getId());
            Producto productoOld = persistentpro_Pro.getProducto();
            Producto productoNew = pro_Pro.getProducto();
            Proveedor proveedorOld = persistentpro_Pro.getProveedor();
            Proveedor proveedorNew = pro_Pro.getProveedor();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getId());
                pro_Pro.setProducto(productoNew);
            }
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getId());
                pro_Pro.setProveedor(proveedorNew);
            }
            pro_Pro = em.merge(pro_Pro);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getProductoProveedores().remove(pro_Pro);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getProductoProveedores().add(pro_Pro);
                productoNew = em.merge(productoNew);
            }
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getProductoProveedores().remove(pro_Pro);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getProductoProveedores().add(pro_Pro);
                proveedorNew = em.merge(proveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pro_Pro.getId();
                if (findpro_Pro(id) == null) {
                    throw new NonexistentEntityException("The pro_Pro with id " + id + " no longer exists.");
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
            pro_Pro pro_Pro;
            try {
                pro_Pro = em.getReference(pro_Pro.class, id);
                pro_Pro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pro_Pro with id " + id + " no longer exists.", enfe);
            }
            Producto producto = pro_Pro.getProducto();
            if (producto != null) {
                producto.getProductoProveedores().remove(pro_Pro);
                producto = em.merge(producto);
            }
            Proveedor proveedor = pro_Pro.getProveedor();
            if (proveedor != null) {
                proveedor.getProductoProveedores().remove(pro_Pro);
                proveedor = em.merge(proveedor);
            }
            em.remove(pro_Pro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<pro_Pro> findpro_ProEntities() {
        return findpro_ProEntities(true, -1, -1);
    }

    public List<pro_Pro> findpro_ProEntities(int maxResults, int firstResult) {
        return findpro_ProEntities(false, maxResults, firstResult);
    }

    private List<pro_Pro> findpro_ProEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(pro_Pro.class));
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

    public pro_Pro findpro_Pro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(pro_Pro.class, id);
        } finally {
            em.close();
        }
    }

    public int getpro_ProCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<pro_Pro> rt = cq.from(pro_Pro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
