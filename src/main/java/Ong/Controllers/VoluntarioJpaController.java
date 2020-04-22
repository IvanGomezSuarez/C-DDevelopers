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
import Ong.Models.Voluntario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ivan
 */
public class VoluntarioJpaController implements Serializable {

    public VoluntarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public VoluntarioJpaController() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Voluntario voluntario) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Miembros miembrosOrphanCheck = voluntario.getMiembros();
        if (miembrosOrphanCheck != null) {
            Voluntario oldVoluntarioOfMiembros = miembrosOrphanCheck.getVoluntario();
            if (oldVoluntarioOfMiembros != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Miembros " + miembrosOrphanCheck + " already has an item of type Voluntario whose miembros column cannot be null. Please make another selection for the miembros field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Miembros miembros = voluntario.getMiembros();
            if (miembros != null) {
                miembros = em.getReference(miembros.getClass(), miembros.getIdMiembro());
                voluntario.setMiembros(miembros);
            }
            em.persist(voluntario);
            if (miembros != null) {
                miembros.setVoluntario(voluntario);
                miembros = em.merge(miembros);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVoluntario(voluntario.getIdVoluntario()) != null) {
                throw new PreexistingEntityException("Voluntario " + voluntario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Voluntario voluntario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voluntario persistentVoluntario = em.find(Voluntario.class, voluntario.getIdVoluntario());
            Miembros miembrosOld = persistentVoluntario.getMiembros();
            Miembros miembrosNew = voluntario.getMiembros();
            List<String> illegalOrphanMessages = null;
            if (miembrosNew != null && !miembrosNew.equals(miembrosOld)) {
                Voluntario oldVoluntarioOfMiembros = miembrosNew.getVoluntario();
                if (oldVoluntarioOfMiembros != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Miembros " + miembrosNew + " already has an item of type Voluntario whose miembros column cannot be null. Please make another selection for the miembros field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (miembrosNew != null) {
                miembrosNew = em.getReference(miembrosNew.getClass(), miembrosNew.getIdMiembro());
                voluntario.setMiembros(miembrosNew);
            }
            voluntario = em.merge(voluntario);
            if (miembrosOld != null && !miembrosOld.equals(miembrosNew)) {
                miembrosOld.setVoluntario(null);
                miembrosOld = em.merge(miembrosOld);
            }
            if (miembrosNew != null && !miembrosNew.equals(miembrosOld)) {
                miembrosNew.setVoluntario(voluntario);
                miembrosNew = em.merge(miembrosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = voluntario.getIdVoluntario();
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

    public void destroy(Integer id) throws NonexistentEntityException {
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
            Miembros miembros = voluntario.getMiembros();
            if (miembros != null) {
                miembros.setVoluntario(null);
                miembros = em.merge(miembros);
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

    public Voluntario findVoluntario(Integer id) {
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
