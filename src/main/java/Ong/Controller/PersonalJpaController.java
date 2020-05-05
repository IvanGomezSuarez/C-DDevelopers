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
import Ong.Models.Personal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class PersonalJpaController implements Serializable {

    public PersonalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Personal personal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Miembro miembro = personal.getMiembro();
            if (miembro != null) {
                miembro = em.getReference(miembro.getClass(), miembro.getIdMiembro());
                personal.setMiembro(miembro);
            }
            em.persist(personal);
            if (miembro != null) {
                Personal oldPersonalOfMiembro = miembro.getPersonal();
                if (oldPersonalOfMiembro != null) {
                    oldPersonalOfMiembro.setMiembro(null);
                    oldPersonalOfMiembro = em.merge(oldPersonalOfMiembro);
                }
                miembro.setPersonal(personal);
                miembro = em.merge(miembro);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Personal personal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Personal persistentPersonal = em.find(Personal.class, personal.getIdPersonal());
            Miembro miembroOld = persistentPersonal.getMiembro();
            Miembro miembroNew = personal.getMiembro();
            if (miembroNew != null) {
                miembroNew = em.getReference(miembroNew.getClass(), miembroNew.getIdMiembro());
                personal.setMiembro(miembroNew);
            }
            personal = em.merge(personal);
            if (miembroOld != null && !miembroOld.equals(miembroNew)) {
                miembroOld.setPersonal(null);
                miembroOld = em.merge(miembroOld);
            }
            if (miembroNew != null && !miembroNew.equals(miembroOld)) {
                Personal oldPersonalOfMiembro = miembroNew.getPersonal();
                if (oldPersonalOfMiembro != null) {
                    oldPersonalOfMiembro.setMiembro(null);
                    oldPersonalOfMiembro = em.merge(oldPersonalOfMiembro);
                }
                miembroNew.setPersonal(personal);
                miembroNew = em.merge(miembroNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = personal.getIdPersonal();
                if (findPersonal(id) == null) {
                    throw new NonexistentEntityException("The personal with id " + id + " no longer exists.");
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
            Personal personal;
            try {
                personal = em.getReference(Personal.class, id);
                personal.getIdPersonal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personal with id " + id + " no longer exists.", enfe);
            }
            Miembro miembro = personal.getMiembro();
            if (miembro != null) {
                miembro.setPersonal(null);
                miembro = em.merge(miembro);
            }
            em.remove(personal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Personal> findPersonalEntities() {
        return findPersonalEntities(true, -1, -1);
    }

    public List<Personal> findPersonalEntities(int maxResults, int firstResult) {
        return findPersonalEntities(false, maxResults, firstResult);
    }

    private List<Personal> findPersonalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Personal.class));
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

    public Personal findPersonal(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Personal.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Personal> rt = cq.from(Personal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
