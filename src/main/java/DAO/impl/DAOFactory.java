package DAO.impl;

import javax.xml.bind.JAXBException;

import DAO.impl.ProyectoDAO;

public abstract class DAOFactory {

	// constante para acceso de datos
	public static final int MYSQL = 2;
	public static final int XML = 1;
	
	// indica los DAO a implementar
	public abstract DelegacionDAO 
	getDelegacionDao();
	
	public abstract MiembroDAO 
	getMiembroDao();
	
	public abstract ProyectoDAO 
	getProyecto();
	
	
	public static DAOFactory getDAOFactory(int qFactory) {
		
	switch (qFactory) {
	
    case XML:
        return new XmlDAOFactory();
        
	case MYSQL:
		return new MySQLDAOFactory();
		
	default:
		return null;
	}
	}
}
