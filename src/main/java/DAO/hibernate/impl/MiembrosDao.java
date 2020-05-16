package DAO.hibernate.impl;

import DAO.hibernate.interfaces.IMiembrosDao;
import Ong.Models.Miembro;

public abstract class MiembrosDao extends BaseDao<Miembro> implements IMiembrosDao {

	@Override
	public Miembro findById(Integer id) {
		Miembro result = null;
		try {
			result = (Miembro) em.createNamedQuery(Miembro.FIND_BY_ID).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			
		}
		return result;
	}
	
	@Override
	protected Class<Miembro> getModelClass() {
		return Miembro.class;
	}
}
