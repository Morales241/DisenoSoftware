/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoresDAO;

import Entidades.ProductoComprado;
import controladoresDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author tacot
 */
public class ProductoCompradoJpaController implements Serializable {

    public ProductoCompradoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductoComprado productoComprado) {
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

    public void edit(ProductoComprado productoComprado) throws NonexistentEntityException, Exception {
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
                    throw new NonexistentEntityException("El producto comprado con el id: " + id + " no existe.");
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
            ProductoComprado productoComprado;
            try {
                productoComprado = em.getReference(ProductoComprado.class, id);
                productoComprado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El producto comprado con el id: " + id + " no existe.", enfe);
            }
            em.remove(productoComprado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductoComprado> findProductoCompradoEntities() {
        return findProductoCompradoEntities(true, -1, -1);
    }

    public List<ProductoComprado> findProductoCompradoEntities(int maxResults, int firstResult) {
        return findProductoCompradoEntities(false, maxResults, firstResult);
    }

    private List<ProductoComprado> findProductoCompradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductoComprado.class));
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

    public ProductoComprado findProductoComprado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoComprado.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCompradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductoComprado> rt = cq.from(ProductoComprado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
