package DAO.impl;

import javax.xml.bind.JAXBException;

import DAO.impl.*;

/**
 * Esta clase factoria se usa para crear DAOs que usan
 * SQL para el almacenaje de los modelos.

 */
public abstract class SQLDAOFactory extends DAOFactory {
	
	

	@Override
	public DelegacionDAO getDelegacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MiembroDAO getMiembrosDAO() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ProyectoDAO getProyectoDAO() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

}
