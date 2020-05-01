package DAO.JPA;
import java.util.List;

import Ong.Models.Miembros;

public interface DAOJpa {

	public void create(Miembros miembros);
	public void edit(Miembros miembros);
	public void destroy(Integer id);
	public List<Miembros> findMiembrosEntities();
	public List<Miembros> findMiembrosEntities(int maxResults, int firstResult);
	List<Miembros> findMiembrosEntities(boolean all, int maxResults, int firstResult);
	public Miembros findMiembros(Integer id);
	public int getMiembrosCount();
}






