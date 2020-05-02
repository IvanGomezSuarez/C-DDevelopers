package DAO.JPA;
import java.util.List;

import Ong.Controllers.exceptions.IllegalOrphanException;
import Ong.Controllers.exceptions.NonexistentEntityException;
import Ong.Models.Miembros;

public interface DAOJpa {

	public void create(Miembros miembros);
	public void edit(Miembros miembros) throws IllegalOrphanException, NonexistentEntityException, Exception;
	public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;
	public List<Miembros> findMiembrosEntities();
	public List<Miembros> findMiembrosEntities(int maxResults, int firstResult);
	List<Miembros> findMiembrosEntities(boolean all, int maxResults, int firstResult);
	public Miembros findMiembros(Integer id);
	public int getMiembrosCount();
}






