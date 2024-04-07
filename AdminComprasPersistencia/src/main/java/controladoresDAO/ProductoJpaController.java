/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoresDAO;

import Entidades.Producto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Proveedor;
import controladoresDAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author tacot
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getProveedores() == null) {
            producto.setProveedores(new ArrayList<Proveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proveedor> attachedProveedores = new ArrayList<Proveedor>();
            for (Proveedor proveedoresProveedorToAttach : producto.getProveedores()) {
                proveedoresProveedorToAttach = em.getReference(proveedoresProveedorToAttach.getClass(), proveedoresProveedorToAttach.getId());
                attachedProveedores.add(proveedoresProveedorToAttach);
            }
            producto.setProveedores(attachedProveedores);
            em.persist(producto);
            for (Proveedor proveedoresProveedor : producto.getProveedores()) {
                proveedoresProveedor.getProductos().add(producto);
                proveedoresProveedor = em.merge(proveedoresProveedor);
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
            List<Proveedor> proveedoresOld = persistentProducto.getProveedores();
            List<Proveedor> proveedoresNew = producto.getProveedores();
            List<Proveedor> attachedProveedoresNew = new ArrayList<Proveedor>();
            for (Proveedor proveedoresNewProveedorToAttach : proveedoresNew) {
                proveedoresNewProveedorToAttach = em.getReference(proveedoresNewProveedorToAttach.getClass(), proveedoresNewProveedorToAttach.getId());
                attachedProveedoresNew.add(proveedoresNewProveedorToAttach);
            }
            proveedoresNew = attachedProveedoresNew;
            producto.setProveedores(proveedoresNew);
            producto = em.merge(producto);
            for (Proveedor proveedoresOldProveedor : proveedoresOld) {
                if (!proveedoresNew.contains(proveedoresOldProveedor)) {
                    proveedoresOldProveedor.getProductos().remove(producto);
                    proveedoresOldProveedor = em.merge(proveedoresOldProveedor);
                }
            }
            for (Proveedor proveedoresNewProveedor : proveedoresNew) {
                if (!proveedoresOld.contains(proveedoresNewProveedor)) {
                    proveedoresNewProveedor.getProductos().add(producto);
                    proveedoresNewProveedor = em.merge(proveedoresNewProveedor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getId();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("El producto con el id: " + id + " no existe.");
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
                throw new NonexistentEntityException("El producto con el id: " + id + " no existe.", enfe);
            }
            List<Proveedor> proveedores = producto.getProveedores();
            for (Proveedor proveedoresProveedor : proveedores) {
                proveedoresProveedor.getProductos().remove(producto);
                proveedoresProveedor = em.merge(proveedoresProveedor);
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
