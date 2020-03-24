package DAO;

import javax.xml.bind.JAXBException;

public abstract class DAOFactory {

	// constante para acceso de datos
	//public static final int MYSQL = 1;
	public static final int XML = 1;
	
	// indica los DAO a implementar
	public abstract ActualLineasAccionDAO 
	getActualLineasAccionDAO();
	
	public abstract ColaboradorDAO
	getColaboradorDAO();
	
	public abstract CuotaSocioDAO
	getCuotaSocioDAO();
	
	public abstract DelegacionesDAO
	getDelegacionesDAO();
	
	public abstract DireccionDAO
	getDireccionDAO();
	
	
	public abstract ILogginDAO
	getILogginDAO();
	
	public abstract IngresoDAO
	getIngresoDAO();

	public abstract IngresoPrivadoDAO
	getIngresoPrivadoDAO();
	
	public abstract IngresoPublicoDAO
	getIngresoPublicoDAO();
	
	public abstract InternacionalDAO
	getInternacionalDAO();

	
	public abstract LineaAccionDAO
	getLineaAccionDAO();
	
	public abstract MiembrosDAO
	getMiembrosDAO();
	
	public abstract NacionalDAO
	getNacionalDAO();
	
	public abstract OngDAO
	getOngDAO();
	
	public abstract PersonalDAO
	getPersonalDAO();
	
	public abstract ProyectoDAO
	getProyectoDAO() throws JAXBException;
	
	public abstract SedeDAO
	getSedeDAO();
	
	public abstract SocioDAO
	getSocioDAO();
	
	public abstract SubLineaAccionDAO
	getSublineaAccionDAO();
	
	
	public abstract VoluntarioDAO
	getVoluntarioDAO();
	
	
	public static DAOFactory getDAOFactory(int qFactory) {
		
	switch (qFactory) {
	
    case XML:
        return new XmlDAOFactory();
        
	// case MYSQL:
		// return new MySQLDAOFactory();
		
	default:
		return null;
	}
	}
}
