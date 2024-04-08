/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Entidades.exceptions.NonexistentEntityException;
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
public class FinanzasJpaController implements Serializable {

    public FinanzasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    
    public FinanzasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Finanzas finanzas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(finanzas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Finanzas finanzas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            finanzas = em.merge(finanzas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = finanzas.getId();
                if (findFinanzas(id) == null) {
                    throw new NonexistentEntityException("The finanzas with id " + id + " no longer exists.");
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
            Finanzas finanzas;
            try {
                finanzas = em.getReference(Finanzas.class, id);
                finanzas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The finanzas with id " + id + " no longer exists.", enfe);
            }
            em.remove(finanzas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Finanzas> findFinanzasEntities() {
        return findFinanzasEntities(true, -1, -1);
    }

    public List<Finanzas> findFinanzasEntities(int maxResults, int firstResult) {
        return findFinanzasEntities(false, maxResults, firstResult);
    }

    private List<Finanzas> findFinanzasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Finanzas.class));
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

    public Finanzas findFinanzas(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Finanzas.class, id);
        } finally {
            em.close();
        }
    }

    public int getFinanzasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Finanzas> rt = cq.from(Finanzas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
