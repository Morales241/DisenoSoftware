/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.pProveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tacot
 */
public class pProveedorDAO implements Serializable {

    public pProveedorDAO() {
        this.emf = Persistence.createEntityManagerFactory("ConcexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(pProveedor producto_Proveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = producto_Proveedor.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getId());
                producto_Proveedor.setProducto(producto);
            }
            Proveedor proveedor = producto_Proveedor.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getId());
                producto_Proveedor.setProveedor(proveedor);
            }
            em.persist(producto_Proveedor);
            if (producto != null) {
                producto.getProductoProveedores().add(producto_Proveedor);
                producto = em.merge(producto);
            }
            if (proveedor != null) {
                proveedor.getProductoProveedores().add(producto_Proveedor);
                proveedor = em.merge(proveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(pProveedor producto_Proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pProveedor persistentproducto_Proveedor = em.find(pProveedor.class, producto_Proveedor.getId());
            Producto productoOld = persistentproducto_Proveedor.getProducto();
            Producto productoNew = producto_Proveedor.getProducto();
            Proveedor proveedorOld = persistentproducto_Proveedor.getProveedor();
            Proveedor proveedorNew = producto_Proveedor.getProveedor();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getId());
                producto_Proveedor.setProducto(productoNew);
            }
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getId());
                producto_Proveedor.setProveedor(proveedorNew);
            }
            producto_Proveedor = em.merge(producto_Proveedor);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getProductoProveedores().remove(producto_Proveedor);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getProductoProveedores().add(producto_Proveedor);
                productoNew = em.merge(productoNew);
            }
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getProductoProveedores().remove(producto_Proveedor);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getProductoProveedores().add(producto_Proveedor);
                proveedorNew = em.merge(proveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto_Proveedor.getId();
                if (findproducto_Proveedor(id) == null) {
                    throw new NonexistentEntityException("The producto_Proveedor with id " + id + " no longer exists.");
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
            pProveedor producto_Proveedor;
            try {
                producto_Proveedor = em.getReference(pProveedor.class, id);
                producto_Proveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto_Proveedor with id " + id + " no longer exists.", enfe);
            }
            Producto producto = producto_Proveedor.getProducto();
            if (producto != null) {
                producto.getProductoProveedores().remove(producto_Proveedor);
                producto = em.merge(producto);
            }
            Proveedor proveedor = producto_Proveedor.getProveedor();
            if (proveedor != null) {
                proveedor.getProductoProveedores().remove(producto_Proveedor);
                proveedor = em.merge(proveedor);
            }
            em.remove(producto_Proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<pProveedor> findproducto_ProveedorEntities() {
        return findproducto_ProveedorEntities(true, -1, -1);
    }

    public List<pProveedor> findproducto_ProveedorEntities(int maxResults, int firstResult) {
        return findproducto_ProveedorEntities(false, maxResults, firstResult);
    }

    private List<pProveedor> findproducto_ProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(pProveedor.class));
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

    public pProveedor findproducto_Proveedor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(pProveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getproducto_ProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<pProveedor> rt = cq.from(pProveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
