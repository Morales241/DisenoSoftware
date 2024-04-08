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
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getProductoProveedores() == null) {
            proveedor.setProductoProveedores(new ArrayList<pro_Pro>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<pro_Pro> attachedProductoProveedores = new ArrayList<pro_Pro>();
            for (pro_Pro productoProveedorespro_ProToAttach : proveedor.getProductoProveedores()) {
                productoProveedorespro_ProToAttach = em.getReference(productoProveedorespro_ProToAttach.getClass(), productoProveedorespro_ProToAttach.getId());
                attachedProductoProveedores.add(productoProveedorespro_ProToAttach);
            }
            proveedor.setProductoProveedores(attachedProductoProveedores);
            em.persist(proveedor);
            for (pro_Pro productoProveedorespro_Pro : proveedor.getProductoProveedores()) {
                Proveedor oldProveedorOfProductoProveedorespro_Pro = productoProveedorespro_Pro.getProveedor();
                productoProveedorespro_Pro.setProveedor(proveedor);
                productoProveedorespro_Pro = em.merge(productoProveedorespro_Pro);
                if (oldProveedorOfProductoProveedorespro_Pro != null) {
                    oldProveedorOfProductoProveedorespro_Pro.getProductoProveedores().remove(productoProveedorespro_Pro);
                    oldProveedorOfProductoProveedorespro_Pro = em.merge(oldProveedorOfProductoProveedorespro_Pro);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getId());
            List<pro_Pro> productoProveedoresOld = persistentProveedor.getProductoProveedores();
            List<pro_Pro> productoProveedoresNew = proveedor.getProductoProveedores();
            List<pro_Pro> attachedProductoProveedoresNew = new ArrayList<pro_Pro>();
            for (pro_Pro productoProveedoresNewpro_ProToAttach : productoProveedoresNew) {
                productoProveedoresNewpro_ProToAttach = em.getReference(productoProveedoresNewpro_ProToAttach.getClass(), productoProveedoresNewpro_ProToAttach.getId());
                attachedProductoProveedoresNew.add(productoProveedoresNewpro_ProToAttach);
            }
            productoProveedoresNew = attachedProductoProveedoresNew;
            proveedor.setProductoProveedores(productoProveedoresNew);
            proveedor = em.merge(proveedor);
            for (pro_Pro productoProveedoresOldpro_Pro : productoProveedoresOld) {
                if (!productoProveedoresNew.contains(productoProveedoresOldpro_Pro)) {
                    productoProveedoresOldpro_Pro.setProveedor(null);
                    productoProveedoresOldpro_Pro = em.merge(productoProveedoresOldpro_Pro);
                }
            }
            for (pro_Pro productoProveedoresNewpro_Pro : productoProveedoresNew) {
                if (!productoProveedoresOld.contains(productoProveedoresNewpro_Pro)) {
                    Proveedor oldProveedorOfProductoProveedoresNewpro_Pro = productoProveedoresNewpro_Pro.getProveedor();
                    productoProveedoresNewpro_Pro.setProveedor(proveedor);
                    productoProveedoresNewpro_Pro = em.merge(productoProveedoresNewpro_Pro);
                    if (oldProveedorOfProductoProveedoresNewpro_Pro != null && !oldProveedorOfProductoProveedoresNewpro_Pro.equals(proveedor)) {
                        oldProveedorOfProductoProveedoresNewpro_Pro.getProductoProveedores().remove(productoProveedoresNewpro_Pro);
                        oldProveedorOfProductoProveedoresNewpro_Pro = em.merge(oldProveedorOfProductoProveedoresNewpro_Pro);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = proveedor.getId();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<pro_Pro> productoProveedores = proveedor.getProductoProveedores();
            for (pro_Pro productoProveedorespro_Pro : productoProveedores) {
                productoProveedorespro_Pro.setProveedor(null);
                productoProveedorespro_Pro = em.merge(productoProveedorespro_Pro);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
