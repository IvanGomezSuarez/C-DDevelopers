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
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import DAO.hibernate.interfaces.IMiembrosDao;
import Ong.Controller.exceptions.NonexistentEntityException;
import Ong.Models.Colaborador;
import Ong.Models.DireccionesUsuario;
import Ong.Models.Miembro;
import Ong.Models.MiembroSinRelaciones;
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
            DireccionesUsuario direccionesUsuario = miembro.getDireccionesUsuario();
            if (direccionesUsuario != null) {
                //direccionesUsuario = em.getReference(direccionesUsuario.getClass(), direccionesUsuario.getIdDireccion());            	
            	//direccionesUsuario = em.getReference(direccionesUsuario.getClass(), direccionesUsuario.getIdDireccion()); 
            	//miembro.setDireccionesUsuario(direccionesUsuario);
                //direccionesUsuario = em.getReference(direccionesUsuario.getClass(), miembro.getIdMiembro());
            	//miembro.setDireccionesUsuario(miembro.getDireccionesUsuario());            
            	}            
            em.merge(miembro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public int createMiembroSinRelacioens(MiembroSinRelaciones miembro) {
        EntityManager em = null;
        MiembroSinRelaciones miembros;
        int i=0;
        try {
            em = getEntityManager();
            em.getTransaction().begin();        
            miembros=em.merge(miembro);
            i=miembros.getIdMiembro();
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
                return(i);
            }
        }
		return i;
    }
    
    public void edit(Miembro miembro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em.getTransaction().begin();
            Miembro persistentMiembro = em.find(Miembro.class, miembro.getIdMiembro());
            DireccionesUsuario direccionesUsuarioOld = persistentMiembro.getDireccionesUsuario();
            DireccionesUsuario direccionesUsuarioNew = miembro.getDireccionesUsuario();
            if (direccionesUsuarioNew != null) {
                direccionesUsuarioNew = em.getReference(direccionesUsuarioNew.getClass(), direccionesUsuarioNew.getIdDireccion());
                miembro.setDireccionesUsuario(direccionesUsuarioNew);
            }
            miembro = em.merge(miembro);
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

    public void editSin(MiembroSinRelaciones miembro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        emf = Persistence.createEntityManagerFactory("persistencia2");
        em=emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MiembroSinRelaciones persistentMiembro = em.find(MiembroSinRelaciones.class, miembro.getIdMiembro());
            miembro = em.merge(miembro);
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
            DireccionesUsuario direccionesUsuario = miembro.getDireccionesUsuario();
            em.remove(miembro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void destroySin(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
        	em = getEntityManager();
            em.getTransaction().begin();
            MiembroSinRelaciones miembro;
            try {
                miembro = em.getReference(MiembroSinRelaciones.class, id);
                miembro.getIdMiembro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The miembro with id " + id + " no longer exists.", enfe);
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
    
    public List<Ong.Models.MiembroSinRelaciones> findMiembroEntitiesSin() {
        return findMiembroEntitiesSin(true, -1, -1);
    }
    
    private List<Ong.Models.MiembroSinRelaciones> findMiembroEntitiesSin(boolean all, int maxResults, int firstResult) {
    	EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MiembroSinRelaciones.class));
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
