/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controller;

import Ong.Controller.exceptions.NonexistentEntityException;
import Ong.Models.DireccionesUsuario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Ong.Models.Miembro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class DireccionesUsuarioJpaController implements Serializable {

    public DireccionesUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DireccionesUsuario direccionesUsuario) {
        EntityManager em = null;
        try {
        	emf = Persistence.createEntityManagerFactory("persistencia2");
            //em = getEntityManager();
            em=emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(direccionesUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DireccionesUsuario direccionesUsuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DireccionesUsuario persistentDireccionesUsuario = em.find(DireccionesUsuario.class, direccionesUsuario.getIdDireccion());
            List<Miembro> miembrosOld = persistentDireccionesUsuario.getMiembros();
            List<Miembro> miembrosNew = direccionesUsuario.getMiembros();
            List<Miembro> attachedMiembrosNew = new ArrayList<Miembro>();
            for (Miembro miembrosNewMiembroToAttach : miembrosNew) {
                miembrosNewMiembroToAttach = em.getReference(miembrosNewMiembroToAttach.getClass(), miembrosNewMiembroToAttach.getIdMiembro());
                attachedMiembrosNew.add(miembrosNewMiembroToAttach);
            }
            miembrosNew = attachedMiembrosNew;
            direccionesUsuario.setMiembros(miembrosNew);
            direccionesUsuario = em.merge(direccionesUsuario);
            for (Miembro miembrosOldMiembro : miembrosOld) {
                if (!miembrosNew.contains(miembrosOldMiembro)) {
                    miembrosOldMiembro.setDireccionesUsuario(null);
                    miembrosOldMiembro = em.merge(miembrosOldMiembro);
                }
            }
            for (Miembro miembrosNewMiembro : miembrosNew) {
                if (!miembrosOld.contains(miembrosNewMiembro)) {
                    DireccionesUsuario oldDireccionesUsuarioOfMiembrosNewMiembro = miembrosNewMiembro.getDireccionesUsuario();
                    miembrosNewMiembro.setDireccionesUsuario(direccionesUsuario);
                    miembrosNewMiembro = em.merge(miembrosNewMiembro);
                    if (oldDireccionesUsuarioOfMiembrosNewMiembro != null && !oldDireccionesUsuarioOfMiembrosNewMiembro.equals(direccionesUsuario)) {
                        oldDireccionesUsuarioOfMiembrosNewMiembro.getMiembros().remove(miembrosNewMiembro);
                        oldDireccionesUsuarioOfMiembrosNewMiembro = em.merge(oldDireccionesUsuarioOfMiembrosNewMiembro);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = direccionesUsuario.getIdDireccion();
                if (findDireccionesUsuario(id) == null) {
                    throw new NonexistentEntityException("The direccionesUsuario with id " + id + " no longer exists.");
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
            DireccionesUsuario direccionesUsuario;
            try {
                direccionesUsuario = em.getReference(DireccionesUsuario.class, id);
                direccionesUsuario.getIdDireccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The direccionesUsuario with id " + id + " no longer exists.", enfe);
            }
            List<Miembro> miembros = direccionesUsuario.getMiembros();
            for (Miembro miembrosMiembro : miembros) {
                miembrosMiembro.setDireccionesUsuario(null);
                miembrosMiembro = em.merge(miembrosMiembro);
            }
            em.remove(direccionesUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DireccionesUsuario> findDireccionesUsuarioEntities() {
        return findDireccionesUsuarioEntities(true, -1, -1);
    }

    public List<DireccionesUsuario> findDireccionesUsuarioEntities(int maxResults, int firstResult) {
        return findDireccionesUsuarioEntities(false, maxResults, firstResult);
    }

    private List<DireccionesUsuario> findDireccionesUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DireccionesUsuario.class));
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

    public DireccionesUsuario findDireccionesUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DireccionesUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getDireccionesUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DireccionesUsuario> rt = cq.from(DireccionesUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
