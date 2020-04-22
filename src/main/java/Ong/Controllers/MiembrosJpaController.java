/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controllers;

import Ong.Controllers.exceptions.IllegalOrphanException;
import Ong.Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Ong.Models.Colaborador;
import Ong.Models.Personal;
import Ong.Models.Voluntario;
import Ong.Models.Direccionesusuarios;
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
public class MiembrosJpaController implements Serializable {

    public MiembrosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MiembrosJpaController() {
    }
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Miembros miembros) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Colaborador colaborador = miembros.getColaborador();
            if (colaborador != null) {
                colaborador = em.getReference(colaborador.getClass(), colaborador.getIdColaborador());
                miembros.setColaborador(colaborador);
            }
            Personal personal = miembros.getPersonal();
            if (personal != null) {
                personal = em.getReference(personal.getClass(), personal.getIdPersonal());
                miembros.setPersonal(personal);
            }
            Voluntario voluntario = miembros.getVoluntario();
            if (voluntario != null) {
                voluntario = em.getReference(voluntario.getClass(), voluntario.getIdVoluntario());
                miembros.setVoluntario(voluntario);
            }
            Direccionesusuarios direccion = miembros.getDireccion();
            if (direccion != null) {
                direccion = em.getReference(direccion.getClass(), direccion.getIdDireccion());
                miembros.setDireccion(direccion);
            }
            em.persist(miembros);
            if (colaborador != null) {
                Miembros oldMiembrosOfColaborador = colaborador.getMiembros();
                if (oldMiembrosOfColaborador != null) {
                    oldMiembrosOfColaborador.setColaborador(null);
                    oldMiembrosOfColaborador = em.merge(oldMiembrosOfColaborador);
                }
                colaborador.setMiembros(miembros);
                colaborador = em.merge(colaborador);
            }
            if (personal != null) {
                Miembros oldMiembrosOfPersonal = personal.getMiembros();
                if (oldMiembrosOfPersonal != null) {
                    oldMiembrosOfPersonal.setPersonal(null);
                    oldMiembrosOfPersonal = em.merge(oldMiembrosOfPersonal);
                }
                personal.setMiembros(miembros);
                personal = em.merge(personal);
            }
            if (voluntario != null) {
                Miembros oldMiembrosOfVoluntario = voluntario.getMiembros();
                if (oldMiembrosOfVoluntario != null) {
                    oldMiembrosOfVoluntario.setVoluntario(null);
                    oldMiembrosOfVoluntario = em.merge(oldMiembrosOfVoluntario);
                }
                voluntario.setMiembros(miembros);
                voluntario = em.merge(voluntario);
            }
            if (direccion != null) {
                direccion.getMiembrosCollection().add(miembros);
                direccion = em.merge(direccion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Miembros miembros) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Miembros persistentMiembros = em.find(Miembros.class, miembros.getIdMiembro());
            Colaborador colaboradorOld = persistentMiembros.getColaborador();
            Colaborador colaboradorNew = miembros.getColaborador();
            Personal personalOld = persistentMiembros.getPersonal();
            Personal personalNew = miembros.getPersonal();
            Voluntario voluntarioOld = persistentMiembros.getVoluntario();
            Voluntario voluntarioNew = miembros.getVoluntario();
            Direccionesusuarios direccionOld = persistentMiembros.getDireccion();
            Direccionesusuarios direccionNew = miembros.getDireccion();
            List<String> illegalOrphanMessages = null;
            if (colaboradorOld != null && !colaboradorOld.equals(colaboradorNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Colaborador " + colaboradorOld + " since its miembros field is not nullable.");
            }
            if (personalOld != null && !personalOld.equals(personalNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Personal " + personalOld + " since its miembros field is not nullable.");
            }
            if (voluntarioOld != null && !voluntarioOld.equals(voluntarioNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Voluntario " + voluntarioOld + " since its miembros field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (colaboradorNew != null) {
                colaboradorNew = em.getReference(colaboradorNew.getClass(), colaboradorNew.getIdColaborador());
                miembros.setColaborador(colaboradorNew);
            }
            if (personalNew != null) {
                personalNew = em.getReference(personalNew.getClass(), personalNew.getIdPersonal());
                miembros.setPersonal(personalNew);
            }
            if (voluntarioNew != null) {
                voluntarioNew = em.getReference(voluntarioNew.getClass(), voluntarioNew.getIdVoluntario());
                miembros.setVoluntario(voluntarioNew);
            }
            if (direccionNew != null) {
                direccionNew = em.getReference(direccionNew.getClass(), direccionNew.getIdDireccion());
                miembros.setDireccion(direccionNew);
            }
            miembros = em.merge(miembros);
            if (colaboradorNew != null && !colaboradorNew.equals(colaboradorOld)) {
                Miembros oldMiembrosOfColaborador = colaboradorNew.getMiembros();
                if (oldMiembrosOfColaborador != null) {
                    oldMiembrosOfColaborador.setColaborador(null);
                    oldMiembrosOfColaborador = em.merge(oldMiembrosOfColaborador);
                }
                colaboradorNew.setMiembros(miembros);
                colaboradorNew = em.merge(colaboradorNew);
            }
            if (personalNew != null && !personalNew.equals(personalOld)) {
                Miembros oldMiembrosOfPersonal = personalNew.getMiembros();
                if (oldMiembrosOfPersonal != null) {
                    oldMiembrosOfPersonal.setPersonal(null);
                    oldMiembrosOfPersonal = em.merge(oldMiembrosOfPersonal);
                }
                personalNew.setMiembros(miembros);
                personalNew = em.merge(personalNew);
            }
            if (voluntarioNew != null && !voluntarioNew.equals(voluntarioOld)) {
                Miembros oldMiembrosOfVoluntario = voluntarioNew.getMiembros();
                if (oldMiembrosOfVoluntario != null) {
                    oldMiembrosOfVoluntario.setVoluntario(null);
                    oldMiembrosOfVoluntario = em.merge(oldMiembrosOfVoluntario);
                }
                voluntarioNew.setMiembros(miembros);
                voluntarioNew = em.merge(voluntarioNew);
            }
            if (direccionOld != null && !direccionOld.equals(direccionNew)) {
                direccionOld.getMiembrosCollection().remove(miembros);
                direccionOld = em.merge(direccionOld);
            }
            if (direccionNew != null && !direccionNew.equals(direccionOld)) {
                direccionNew.getMiembrosCollection().add(miembros);
                direccionNew = em.merge(direccionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = miembros.getIdMiembro();
                if (findMiembros(id) == null) {
                    throw new NonexistentEntityException("The miembros with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Miembros miembros;
            try {
                miembros = em.getReference(Miembros.class, id);
                miembros.getIdMiembro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The miembros with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Colaborador colaboradorOrphanCheck = miembros.getColaborador();
            if (colaboradorOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Miembros (" + miembros + ") cannot be destroyed since the Colaborador " + colaboradorOrphanCheck + " in its colaborador field has a non-nullable miembros field.");
            }
            Personal personalOrphanCheck = miembros.getPersonal();
            if (personalOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Miembros (" + miembros + ") cannot be destroyed since the Personal " + personalOrphanCheck + " in its personal field has a non-nullable miembros field.");
            }
            Voluntario voluntarioOrphanCheck = miembros.getVoluntario();
            if (voluntarioOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Miembros (" + miembros + ") cannot be destroyed since the Voluntario " + voluntarioOrphanCheck + " in its voluntario field has a non-nullable miembros field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Direccionesusuarios direccion = miembros.getDireccion();
            if (direccion != null) {
                direccion.getMiembrosCollection().remove(miembros);
                direccion = em.merge(direccion);
            }
            em.remove(miembros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Miembros> findMiembrosEntities() {
        return findMiembrosEntities(true, -1, -1);
    }

    public List<Miembros> findMiembrosEntities(int maxResults, int firstResult) {
        return findMiembrosEntities(false, maxResults, firstResult);
    }

    private List<Miembros> findMiembrosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Miembros.class));
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

    public Miembros findMiembros(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Miembros.class, id);
        } finally {
            em.close();
        }
    }

    public int getMiembrosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Miembros> rt = cq.from(Miembros.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
