/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controllers;

import Ong.Controllers.exceptions.IllegalOrphanException;
import Ong.Controllers.exceptions.NonexistentEntityException;
import Ong.Controllers.exceptions.PreexistingEntityException;
import Ong.Models.Colaborador;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Ong.Models.Miembros;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ivan
 */
public class ColaboradorJpaController implements Serializable {

    public ColaboradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ColaboradorJpaController() {
    }
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Colaborador colaborador) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Miembros miembrosOrphanCheck = colaborador.getMiembros();
        if (miembrosOrphanCheck != null) {
            Colaborador oldColaboradorOfMiembros = miembrosOrphanCheck.getColaborador();
            if (oldColaboradorOfMiembros != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Miembros " + miembrosOrphanCheck + " already has an item of type Colaborador whose miembros column cannot be null. Please make another selection for the miembros field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Miembros miembros = colaborador.getMiembros();
            if (miembros != null) {
                miembros = em.getReference(miembros.getClass(), miembros.getIdMiembro());
                colaborador.setMiembros(miembros);
            }
            em.persist(colaborador);
            if (miembros != null) {
                miembros.setColaborador(colaborador);
                miembros = em.merge(miembros);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findColaborador(colaborador.getIdColaborador()) != null) {
                throw new PreexistingEntityException("Colaborador " + colaborador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Colaborador colaborador) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Colaborador persistentColaborador = em.find(Colaborador.class, colaborador.getIdColaborador());
            Miembros miembrosOld = persistentColaborador.getMiembros();
            Miembros miembrosNew = colaborador.getMiembros();
            List<String> illegalOrphanMessages = null;
            if (miembrosNew != null && !miembrosNew.equals(miembrosOld)) {
                Colaborador oldColaboradorOfMiembros = miembrosNew.getColaborador();
                if (oldColaboradorOfMiembros != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Miembros " + miembrosNew + " already has an item of type Colaborador whose miembros column cannot be null. Please make another selection for the miembros field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (miembrosNew != null) {
                miembrosNew = em.getReference(miembrosNew.getClass(), miembrosNew.getIdMiembro());
                colaborador.setMiembros(miembrosNew);
            }
            colaborador = em.merge(colaborador);
            if (miembrosOld != null && !miembrosOld.equals(miembrosNew)) {
                miembrosOld.setColaborador(null);
                miembrosOld = em.merge(miembrosOld);
            }
            if (miembrosNew != null && !miembrosNew.equals(miembrosOld)) {
                miembrosNew.setColaborador(colaborador);
                miembrosNew = em.merge(miembrosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = colaborador.getIdColaborador();
                if (findColaborador(id) == null) {
                    throw new NonexistentEntityException("The colaborador with id " + id + " no longer exists.");
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
            Colaborador colaborador;
            try {
                colaborador = em.getReference(Colaborador.class, id);
                colaborador.getIdColaborador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The colaborador with id " + id + " no longer exists.", enfe);
            }
            Miembros miembros = colaborador.getMiembros();
            if (miembros != null) {
                miembros.setColaborador(null);
                miembros = em.merge(miembros);
            }
            em.remove(colaborador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Colaborador> findColaboradorEntities() {
        return findColaboradorEntities(true, -1, -1);
    }

    public List<Colaborador> findColaboradorEntities(int maxResults, int firstResult) {
        return findColaboradorEntities(false, maxResults, firstResult);
    }

    private List<Colaborador> findColaboradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Colaborador.class));
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

    public Colaborador findColaborador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Colaborador.class, id);
        } finally {
            em.close();
        }
    }

    public int getColaboradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Colaborador> rt = cq.from(Colaborador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
