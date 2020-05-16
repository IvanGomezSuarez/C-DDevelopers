/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import DAO.hibernate.interfaces.IMiembrosDao;
import Ong.Controller.exceptions.NonexistentEntityException;
import Ong.Models.Colaborador;
import Ong.Models.DireccionesUsuario;
import Ong.Models.Miembro;
import Ong.Models.Personal;
import Ong.Models.Voluntario;

public class MiembroJpaController implements Serializable {
	
	 public MiembroJpaController(EntityManagerFactory emf) {
	        this.emf = emf;
	    }
	    private EntityManagerFactory emf = null;

	    public EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }
    public void create(Miembro miembro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Colaborador colaborador = miembro.getColaborador();
            if (colaborador != null) {
                colaborador = em.getReference(colaborador.getClass(), colaborador.getIdColaborador());
                miembro.setColaborador(colaborador);
            }
            DireccionesUsuario direccionesUsuario = miembro.getDireccionesUsuario();
            if (direccionesUsuario != null) {
                direccionesUsuario = em.getReference(direccionesUsuario.getClass(), direccionesUsuario.getIdDireccion());            	
                miembro.setDireccionesUsuario(direccionesUsuario);
                //direccionesUsuario = em.getReference(direccionesUsuario.getClass(), miembro.getIdMiembro());
            	//miembro.setDireccionesUsuario(miembro.getDireccionesUsuario());
            }
            Personal personal = miembro.getPersonal();
            if (personal != null) {
                personal = em.getReference(personal.getClass(), personal.getIdPersonal());
                miembro.setPersonal(personal);
            	//miembro.setPersonal(miembro.getPersonal());
            }
            Voluntario voluntario = miembro.getVoluntario();
            if (voluntario != null) {
                voluntario = em.getReference(voluntario.getClass(), voluntario.getIdVoluntario());
                miembro.setVoluntario(voluntario);
            }
            
            em.persist(miembro);
            
            if (colaborador != null) {
                Miembro oldMiembroOfColaborador = colaborador.getMiembro();
                if (oldMiembroOfColaborador != null) {
                    oldMiembroOfColaborador.setColaborador(null);
                    oldMiembroOfColaborador = em.merge(oldMiembroOfColaborador);
                }
                colaborador.setMiembro(miembro);
                colaborador = em.merge(colaborador);
            }
            if (direccionesUsuario != null) {
                direccionesUsuario.getMiembros().add(miembro);
                direccionesUsuario = em.merge(direccionesUsuario);
            }
            if (personal != null) {
                Miembro oldMiembroOfPersonal = personal.getMiembro();
                if (oldMiembroOfPersonal != null) {
                    oldMiembroOfPersonal.setPersonal(null);
                    oldMiembroOfPersonal = em.merge(oldMiembroOfPersonal);
                }
                personal.setMiembro(miembro);
                personal = em.merge(personal);
            }
            if (voluntario != null) {
                Miembro oldMiembroOfVoluntario = voluntario.getMiembros();
                if (oldMiembroOfVoluntario != null) {
                    oldMiembroOfVoluntario.setVoluntario(null);
                    oldMiembroOfVoluntario = em.merge(oldMiembroOfVoluntario);
                }
                voluntario.setMiembros(miembro);
                voluntario = em.merge(voluntario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Miembro miembro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em.getTransaction().begin();
            Miembro persistentMiembro = em.find(Miembro.class, miembro.getIdMiembro());
            Colaborador colaboradorOld = persistentMiembro.getColaborador();
            Colaborador colaboradorNew = miembro.getColaborador();
            DireccionesUsuario direccionesUsuarioOld = persistentMiembro.getDireccionesUsuario();
            DireccionesUsuario direccionesUsuarioNew = miembro.getDireccionesUsuario();
            Personal personalOld = persistentMiembro.getPersonal();
            Personal personalNew = miembro.getPersonal();
            Voluntario voluntarioOld = persistentMiembro.getVoluntario();
            Voluntario voluntarioNew = miembro.getVoluntario();
            if (colaboradorNew != null) {
                colaboradorNew = em.getReference(colaboradorNew.getClass(), colaboradorNew.getIdColaborador());
                miembro.setColaborador(colaboradorNew);
            }
            if (direccionesUsuarioNew != null) {
                direccionesUsuarioNew = em.getReference(direccionesUsuarioNew.getClass(), direccionesUsuarioNew.getIdDireccion());
                miembro.setDireccionesUsuario(direccionesUsuarioNew);
            }
            if (personalNew != null) {
                personalNew = em.getReference(personalNew.getClass(), personalNew.getIdPersonal());
                miembro.setPersonal(personalNew);
            }
            if (voluntarioNew != null) {
                voluntarioNew = em.getReference(voluntarioNew.getClass(), voluntarioNew.getIdVoluntario());
                miembro.setVoluntario(voluntarioNew);
            }
            miembro = em.merge(miembro);
            if (colaboradorOld != null && !colaboradorOld.equals(colaboradorNew)) {
                colaboradorOld.setMiembro(null);
                colaboradorOld = em.merge(colaboradorOld);
            }
            if (colaboradorNew != null && !colaboradorNew.equals(colaboradorOld)) {
                Miembro oldMiembroOfColaborador = colaboradorNew.getMiembro();
                if (oldMiembroOfColaborador != null) {
                    oldMiembroOfColaborador.setColaborador(null);
                    oldMiembroOfColaborador = em.merge(oldMiembroOfColaborador);
                }
                colaboradorNew.setMiembro(miembro);
                colaboradorNew = em.merge(colaboradorNew);
            }
            if (direccionesUsuarioOld != null && !direccionesUsuarioOld.equals(direccionesUsuarioNew)) {
                direccionesUsuarioOld.getMiembros().remove(miembro);
                direccionesUsuarioOld = em.merge(direccionesUsuarioOld);
            }
            if (direccionesUsuarioNew != null && !direccionesUsuarioNew.equals(direccionesUsuarioOld)) {
                direccionesUsuarioNew.getMiembros().add(miembro);
                direccionesUsuarioNew = em.merge(direccionesUsuarioNew);
            }
            if (personalOld != null && !personalOld.equals(personalNew)) {
                personalOld.setMiembro(null);
                personalOld = em.merge(personalOld);
            }
            if (personalNew != null && !personalNew.equals(personalOld)) {
                Miembro oldMiembroOfPersonal = personalNew.getMiembro();
                if (oldMiembroOfPersonal != null) {
                    oldMiembroOfPersonal.setPersonal(null);
                    oldMiembroOfPersonal = em.merge(oldMiembroOfPersonal);
                }
                personalNew.setMiembro(miembro);
                personalNew = em.merge(personalNew);
            }
            if (voluntarioOld != null && !voluntarioOld.equals(voluntarioNew)) {
                voluntarioOld.setMiembros(null);
                voluntarioOld = em.merge(voluntarioOld);
            }
            if (voluntarioNew != null && !voluntarioNew.equals(voluntarioOld)) {
                Miembro oldMiembroOfVoluntario = voluntarioNew.getMiembros();
                if (oldMiembroOfVoluntario != null) {
                    oldMiembroOfVoluntario.setVoluntario(null);
                    oldMiembroOfVoluntario = em.merge(oldMiembroOfVoluntario);
                }
                voluntarioNew.setMiembros(miembro);
                voluntarioNew = em.merge(voluntarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = miembro.getIdMiembro();
                if (findMiembro(id) == null) {
                    throw new NonexistentEntityException("The miembro with id " + id + " no longer exists.");
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
            Miembro miembro;
            try {
                miembro = em.getReference(Miembro.class, id);
                miembro.getIdMiembro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The miembro with id " + id + " no longer exists.", enfe);
            }
            Colaborador colaborador = miembro.getColaborador();
            if (colaborador != null) {
                colaborador.setMiembro(null);
                colaborador = em.merge(colaborador);
            }
            DireccionesUsuario direccionesUsuario = miembro.getDireccionesUsuario();
            if (direccionesUsuario != null) {
                direccionesUsuario.getMiembros().remove(miembro);
                direccionesUsuario = em.merge(direccionesUsuario);
            }
            Personal personal = miembro.getPersonal();
            if (personal != null) {
                personal.setMiembro(null);
                personal = em.merge(personal);
            }
            Voluntario voluntario = miembro.getVoluntario();
            if (voluntario != null) {
                voluntario.setMiembros(null);
                voluntario = em.merge(voluntario);
            }
            em.remove(miembro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Miembro> findMiembroEntities() {
        return findMiembroEntities(true, -1, -1);
    }

    public List<Miembro> findMiembroEntities(int maxResults, int firstResult) {
        return findMiembroEntities(false, maxResults, firstResult);
    }

    private List<Miembro> findMiembroEntities(boolean all, int maxResults, int firstResult) {
    	EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Miembro.class));
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

    public Miembro findMiembro(int id) {
    	EntityManager em = getEntityManager();
        try {
            return em.find(Miembro.class, id);
        } finally {
            em.close();
        }
    }

    public int getMiembroCount() {
    	EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Miembro> rt = cq.from(Miembro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }    
}
