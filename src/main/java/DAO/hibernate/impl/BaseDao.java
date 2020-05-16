package DAO.hibernate.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import DAO.hibernate.interfaces.IBaseDao;

public abstract class BaseDao<T> implements IBaseDao<T> {

	@PersistenceContext(unitName = "persistencia2")
	protected EntityManager em;
	
	protected abstract Class<T> getModelClass();
	
	public T merge(T t) {
		return em.merge(t);
	}
	
	public void persist(T t) {
		em.persist(t);
	}
	
	public void remove(T t) {
		em.remove(t);
	}
	
	public List<T> getAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getModelClass());
		Root<T> from = criteriaQuery.from(getModelClass());
		CriteriaQuery<T> select = criteriaQuery.select(from);
		TypedQuery<T> typedQuery = em.createQuery(select);
		List<T> resultList = typedQuery.getResultList();
		return resultList;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
