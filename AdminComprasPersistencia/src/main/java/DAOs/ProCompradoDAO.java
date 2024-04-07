/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.exceptions.NonexistentEntityException;
import Entidades.ProComprado;
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
public class ProCompradoDAO implements Serializable {

    public ProCompradoDAO() {
        this.emf = Persistence.createEntityManagerFactory("ConcexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProComprado productoComprado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoComprado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProComprado productoComprado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoComprado = em.merge(productoComprado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = productoComprado.getId();
                if (findProductoComprado(id) == null) {
                    throw new NonexistentEntityException("The productoComprado with id " + id + " no longer exists.");
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
            ProComprado productoComprado;
            try {
                productoComprado = em.getReference(ProComprado.class, id);
                productoComprado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoComprado with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoComprado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProComprado> findProductoCompradoEntities() {
        return findProductoCompradoEntities(true, -1, -1);
    }

    public List<ProComprado> findProductoCompradoEntities(int maxResults, int firstResult) {
        return findProductoCompradoEntities(false, maxResults, firstResult);
    }

    private List<ProComprado> findProductoCompradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProComprado.class));
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

    public ProComprado findProductoComprado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProComprado.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCompradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProComprado> rt = cq.from(ProComprado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
