/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controller;

import Ong.Controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Ong.Models.Miembro;
import Ong.Models.Voluntario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class VoluntarioJpaController implements Serializable {

    public VoluntarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Voluntario voluntario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Miembro miembro = voluntario.getMiembro();
            if (miembro != null) {
                miembro = em.getReference(miembro.getClass(), miembro.getIdMiembro());
                voluntario.setMiembro(miembro);
            }
            em.persist(voluntario);
            if (miembro != null) {
                Voluntario oldVoluntarioOfMiembro = miembro.getVoluntario();
                if (oldVoluntarioOfMiembro != null) {
                    oldVoluntarioOfMiembro.setMiembro(null);
                    oldVoluntarioOfMiembro = em.merge(oldVoluntarioOfMiembro);
                }
                miembro.setVoluntario(voluntario);
                miembro = em.merge(miembro);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Voluntario voluntario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voluntario persistentVoluntario = em.find(Voluntario.class, voluntario.getIdVoluntario());
            Miembro miembroOld = persistentVoluntario.getMiembro();
            Miembro miembroNew = voluntario.getMiembro();
            if (miembroNew != null) {
                miembroNew = em.getReference(miembroNew.getClass(), miembroNew.getIdMiembro());
                voluntario.setMiembro(miembroNew);
            }
            voluntario = em.merge(voluntario);
            if (miembroOld != null && !miembroOld.equals(miembroNew)) {
                miembroOld.setVoluntario(null);
                miembroOld = em.merge(miembroOld);
            }
            if (miembroNew != null && !miembroNew.equals(miembroOld)) {
                Voluntario oldVoluntarioOfMiembro = miembroNew.getVoluntario();
                if (oldVoluntarioOfMiembro != null) {
                    oldVoluntarioOfMiembro.setMiembro(null);
                    oldVoluntarioOfMiembro = em.merge(oldVoluntarioOfMiembro);
                }
                miembroNew.setVoluntario(voluntario);
                miembroNew = em.merge(miembroNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = voluntario.getIdVoluntario();
                if (findVoluntario(id) == null) {
                    throw new NonexistentEntityException("The voluntario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voluntario voluntario;
            try {
                voluntario = em.getReference(Voluntario.class, id);
                voluntario.getIdVoluntario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The voluntario with id " + id + " no longer exists.", enfe);
            }
            Miembro miembro = voluntario.getMiembro();
            if (miembro != null) {
                miembro.setVoluntario(null);
                miembro = em.merge(miembro);
            }
            em.remove(voluntario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Voluntario> findVoluntarioEntities() {
        return findVoluntarioEntities(true, -1, -1);
    }

    public List<Voluntario> findVoluntarioEntities(int maxResults, int firstResult) {
        return findVoluntarioEntities(false, maxResults, firstResult);
    }

    private List<Voluntario> findVoluntarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Voluntario.class));
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

    public Voluntario findVoluntario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Voluntario.class, id);
        } finally {
            em.close();
        }
    }

    public int getVoluntarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Voluntario> rt = cq.from(Voluntario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
