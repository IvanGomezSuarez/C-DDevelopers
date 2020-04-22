/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controllers;

import Ong.Controllers.exceptions.NonexistentEntityException;
import Ong.Controllers.exceptions.PreexistingEntityException;
import Ong.Models.Direccionesusuarios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Ong.Models.Miembros;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ivan
 */
public class DireccionesusuariosJpaController implements Serializable {

    public DireccionesusuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DireccionesusuariosJpaController() {
    }

    public void create(Direccionesusuarios direccionesusuarios) throws PreexistingEntityException, Exception {
        if (direccionesusuarios.getMiembrosCollection() == null) {
            direccionesusuarios.setMiembrosCollection(new ArrayList<Miembros>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Miembros> attachedMiembrosCollection = new ArrayList<Miembros>();
            for (Miembros miembrosCollectionMiembrosToAttach : direccionesusuarios.getMiembrosCollection()) {
                miembrosCollectionMiembrosToAttach = em.getReference(miembrosCollectionMiembrosToAttach.getClass(), miembrosCollectionMiembrosToAttach.getIdMiembro());
                attachedMiembrosCollection.add(miembrosCollectionMiembrosToAttach);
            }
            direccionesusuarios.setMiembrosCollection(attachedMiembrosCollection);
            em.persist(direccionesusuarios);
            for (Miembros miembrosCollectionMiembros : direccionesusuarios.getMiembrosCollection()) {
                Direccionesusuarios oldDireccionOfMiembrosCollectionMiembros = miembrosCollectionMiembros.getDireccion();
                miembrosCollectionMiembros.setDireccion(direccionesusuarios);
                miembrosCollectionMiembros = em.merge(miembrosCollectionMiembros);
                if (oldDireccionOfMiembrosCollectionMiembros != null) {
                    oldDireccionOfMiembrosCollectionMiembros.getMiembrosCollection().remove(miembrosCollectionMiembros);
                    oldDireccionOfMiembrosCollectionMiembros = em.merge(oldDireccionOfMiembrosCollectionMiembros);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDireccionesusuarios(direccionesusuarios.getIdDireccion()) != null) {
                throw new PreexistingEntityException("Direccionesusuarios " + direccionesusuarios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Direccionesusuarios direccionesusuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Direccionesusuarios persistentDireccionesusuarios = em.find(Direccionesusuarios.class, direccionesusuarios.getIdDireccion());
            Collection<Miembros> miembrosCollectionOld = persistentDireccionesusuarios.getMiembrosCollection();
            Collection<Miembros> miembrosCollectionNew = direccionesusuarios.getMiembrosCollection();
            Collection<Miembros> attachedMiembrosCollectionNew = new ArrayList<Miembros>();
            for (Miembros miembrosCollectionNewMiembrosToAttach : miembrosCollectionNew) {
                miembrosCollectionNewMiembrosToAttach = em.getReference(miembrosCollectionNewMiembrosToAttach.getClass(), miembrosCollectionNewMiembrosToAttach.getIdMiembro());
                attachedMiembrosCollectionNew.add(miembrosCollectionNewMiembrosToAttach);
            }
            miembrosCollectionNew = attachedMiembrosCollectionNew;
            direccionesusuarios.setMiembrosCollection(miembrosCollectionNew);
            direccionesusuarios = em.merge(direccionesusuarios);
            for (Miembros miembrosCollectionOldMiembros : miembrosCollectionOld) {
                if (!miembrosCollectionNew.contains(miembrosCollectionOldMiembros)) {
                    miembrosCollectionOldMiembros.setDireccion(null);
                    miembrosCollectionOldMiembros = em.merge(miembrosCollectionOldMiembros);
                }
            }
            for (Miembros miembrosCollectionNewMiembros : miembrosCollectionNew) {
                if (!miembrosCollectionOld.contains(miembrosCollectionNewMiembros)) {
                    Direccionesusuarios oldDireccionOfMiembrosCollectionNewMiembros = miembrosCollectionNewMiembros.getDireccion();
                    miembrosCollectionNewMiembros.setDireccion(direccionesusuarios);
                    miembrosCollectionNewMiembros = em.merge(miembrosCollectionNewMiembros);
                    if (oldDireccionOfMiembrosCollectionNewMiembros != null && !oldDireccionOfMiembrosCollectionNewMiembros.equals(direccionesusuarios)) {
                        oldDireccionOfMiembrosCollectionNewMiembros.getMiembrosCollection().remove(miembrosCollectionNewMiembros);
                        oldDireccionOfMiembrosCollectionNewMiembros = em.merge(oldDireccionOfMiembrosCollectionNewMiembros);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = direccionesusuarios.getIdDireccion();
                if (findDireccionesusuarios(id) == null) {
                    throw new NonexistentEntityException("The direccionesusuarios with id " + id + " no longer exists.");
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
            Direccionesusuarios direccionesusuarios;
            try {
                direccionesusuarios = em.getReference(Direccionesusuarios.class, id);
                direccionesusuarios.getIdDireccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The direccionesusuarios with id " + id + " no longer exists.", enfe);
            }
            Collection<Miembros> miembrosCollection = direccionesusuarios.getMiembrosCollection();
            for (Miembros miembrosCollectionMiembros : miembrosCollection) {
                miembrosCollectionMiembros.setDireccion(null);
                miembrosCollectionMiembros = em.merge(miembrosCollectionMiembros);
            }
            em.remove(direccionesusuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Direccionesusuarios> findDireccionesusuariosEntities() {
        return findDireccionesusuariosEntities(true, -1, -1);
    }

    public List<Direccionesusuarios> findDireccionesusuariosEntities(int maxResults, int firstResult) {
        return findDireccionesusuariosEntities(false, maxResults, firstResult);
    }

    private List<Direccionesusuarios> findDireccionesusuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Direccionesusuarios.class));
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

    public Direccionesusuarios findDireccionesusuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Direccionesusuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getDireccionesusuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Direccionesusuarios> rt = cq.from(Direccionesusuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
