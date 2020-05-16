package DAO.hibernate.interfaces;

import Ong.Models.Miembro;

public interface IMiembrosDao extends IBaseDao<Miembro> {
	public Miembro findById(Integer id);
	public Miembro findByDni(String dni);
}
