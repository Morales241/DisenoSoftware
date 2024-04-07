/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.exceptions.NonexistentEntityException;
import Entidades.Proveedor;
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
public class ProveedorDAO implements Serializable {

    public ProveedorDAO() {
        this.emf = Persistence.createEntityManagerFactory("ConcexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getProductoProveedores() == null) {
            proveedor.setProductoProveedores(new ArrayList<pProveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<pProveedor> attachedProductoProveedores = new ArrayList<pProveedor>();
            for (pProveedor productoProveedoresproducto_ProveedorToAttach : proveedor.getProductoProveedores()) {
                productoProveedoresproducto_ProveedorToAttach = em.getReference(productoProveedoresproducto_ProveedorToAttach.getClass(), productoProveedoresproducto_ProveedorToAttach.getId());
                attachedProductoProveedores.add(productoProveedoresproducto_ProveedorToAttach);
            }
            proveedor.setProductoProveedores(attachedProductoProveedores);
            em.persist(proveedor);
            for (pProveedor productoProveedoresproducto_Proveedor : proveedor.getProductoProveedores()) {
                Proveedor oldProveedorOfProductoProveedoresproducto_Proveedor = productoProveedoresproducto_Proveedor.getProveedor();
                productoProveedoresproducto_Proveedor.setProveedor(proveedor);
                productoProveedoresproducto_Proveedor = em.merge(productoProveedoresproducto_Proveedor);
                if (oldProveedorOfProductoProveedoresproducto_Proveedor != null) {
                    oldProveedorOfProductoProveedoresproducto_Proveedor.getProductoProveedores().remove(productoProveedoresproducto_Proveedor);
                    oldProveedorOfProductoProveedoresproducto_Proveedor = em.merge(oldProveedorOfProductoProveedoresproducto_Proveedor);
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
            List<pProveedor> productoProveedoresOld = persistentProveedor.getProductoProveedores();
            List<pProveedor> productoProveedoresNew = proveedor.getProductoProveedores();
            List<pProveedor> attachedProductoProveedoresNew = new ArrayList<pProveedor>();
            for (pProveedor productoProveedoresNewproducto_ProveedorToAttach : productoProveedoresNew) {
                productoProveedoresNewproducto_ProveedorToAttach = em.getReference(productoProveedoresNewproducto_ProveedorToAttach.getClass(), productoProveedoresNewproducto_ProveedorToAttach.getId());
                attachedProductoProveedoresNew.add(productoProveedoresNewproducto_ProveedorToAttach);
            }
            productoProveedoresNew = attachedProductoProveedoresNew;
            proveedor.setProductoProveedores(productoProveedoresNew);
            proveedor = em.merge(proveedor);
            for (pProveedor productoProveedoresOldproducto_Proveedor : productoProveedoresOld) {
                if (!productoProveedoresNew.contains(productoProveedoresOldproducto_Proveedor)) {
                    productoProveedoresOldproducto_Proveedor.setProveedor(null);
                    productoProveedoresOldproducto_Proveedor = em.merge(productoProveedoresOldproducto_Proveedor);
                }
            }
            for (pProveedor productoProveedoresNewproducto_Proveedor : productoProveedoresNew) {
                if (!productoProveedoresOld.contains(productoProveedoresNewproducto_Proveedor)) {
                    Proveedor oldProveedorOfProductoProveedoresNewproducto_Proveedor = productoProveedoresNewproducto_Proveedor.getProveedor();
                    productoProveedoresNewproducto_Proveedor.setProveedor(proveedor);
                    productoProveedoresNewproducto_Proveedor = em.merge(productoProveedoresNewproducto_Proveedor);
                    if (oldProveedorOfProductoProveedoresNewproducto_Proveedor != null && !oldProveedorOfProductoProveedoresNewproducto_Proveedor.equals(proveedor)) {
                        oldProveedorOfProductoProveedoresNewproducto_Proveedor.getProductoProveedores().remove(productoProveedoresNewproducto_Proveedor);
                        oldProveedorOfProductoProveedoresNewproducto_Proveedor = em.merge(oldProveedorOfProductoProveedoresNewproducto_Proveedor);
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
            List<pProveedor> productoProveedores = proveedor.getProductoProveedores();
            for (pProveedor productoProveedoresproducto_Proveedor : productoProveedores) {
                productoProveedoresproducto_Proveedor.setProveedor(null);
                productoProveedoresproducto_Proveedor = em.merge(productoProveedoresproducto_Proveedor);
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
