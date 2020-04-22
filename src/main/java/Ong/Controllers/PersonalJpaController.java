/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controllers;

import Ong.Controllers.exceptions.IllegalOrphanException;
import Ong.Controllers.exceptions.NonexistentEntityException;
import Ong.Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Ong.Models.Miembros;
import Ong.Models.Personal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ivan
 */
public class PersonalJpaController implements Serializable {

    public PersonalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PersonalJpaController() {
    }
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Personal personal) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Miembros miembrosOrphanCheck = personal.getMiembros();
        if (miembrosOrphanCheck != null) {
            Personal oldPersonalOfMiembros = miembrosOrphanCheck.getPersonal();
            if (oldPersonalOfMiembros != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Miembros " + miembrosOrphanCheck + " already has an item of type Personal whose miembros column cannot be null. Please make another selection for the miembros field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Miembros miembros = personal.getMiembros();
            if (miembros != null) {
                miembros = em.getReference(miembros.getClass(), miembros.getIdMiembro());
                personal.setMiembros(miembros);
            }
            em.persist(personal);
            if (miembros != null) {
                miembros.setPersonal(personal);
                miembros = em.merge(miembros);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersonal(personal.getIdPersonal()) != null) {
                throw new PreexistingEntityException("Personal " + personal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Personal personal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Personal persistentPersonal = em.find(Personal.class, personal.getIdPersonal());
            Miembros miembrosOld = persistentPersonal.getMiembros();
            Miembros miembrosNew = personal.getMiembros();
            List<String> illegalOrphanMessages = null;
            if (miembrosNew != null && !miembrosNew.equals(miembrosOld)) {
                Personal oldPersonalOfMiembros = miembrosNew.getPersonal();
                if (oldPersonalOfMiembros != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Miembros " + miembrosNew + " already has an item of type Personal whose miembros column cannot be null. Please make another selection for the miembros field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (miembrosNew != null) {
                miembrosNew = em.getReference(miembrosNew.getClass(), miembrosNew.getIdMiembro());
                personal.setMiembros(miembrosNew);
            }
            personal = em.merge(personal);
            if (miembrosOld != null && !miembrosOld.equals(miembrosNew)) {
                miembrosOld.setPersonal(null);
                miembrosOld = em.merge(miembrosOld);
            }
            if (miembrosNew != null && !miembrosNew.equals(miembrosOld)) {
                miembrosNew.setPersonal(personal);
                miembrosNew = em.merge(miembrosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = personal.getIdPersonal();
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

    public void destroy(Integer id) throws NonexistentEntityException {
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
            Miembros miembros = personal.getMiembros();
            if (miembros != null) {
                miembros.setPersonal(null);
                miembros = em.merge(miembros);
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

    public Personal findPersonal(Integer id) {
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
