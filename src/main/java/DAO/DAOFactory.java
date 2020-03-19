package DAO;

public abstract class DAOFactory {

	// constante para acceso de datos
	//public static final int MYSQL = 1;
	public static final int XML = 1;
	
	// indica los DAO a implementar
	public abstract ActualLineasAccionDAO 
	getActualLineasAccionDAO();
	
	public abstract AdminAutonomDAO
	getAdminAutonomDAO();
	
	public abstract AdminEstadoDAO
	getAdminEstadoDAO();
	
	public abstract AdminLocalDAO
	getAdminLocalDAO();
	
	public abstract AportPuntualEmpDAO
	getAportPuntualEmpDAO();
	
	public abstract ColaboradorDAO
	getColaboradorDAO();
	
	public abstract CuotaSocioDAO
	getCuotaSocioDAO();
	
	public abstract DelegacionesDAO
	getDelegacionesDAO();
	
	public abstract DireccionDAO
	getDireccionDAO();
	
	public abstract HerenciaDAO
	getHerenciaDAO();
	
	public abstract ILogginDAO
	getILogginDAO();
	
	public abstract IngresoDAO
	getIngresoDAO();
	
	public abstract IngresoExtraDAO
	getIngresoExtraDAO();
	
	public abstract IngresoInstitutDAO
	getIngresoInstitutDAO();
	
	public abstract IngresoPrivadoDAO
	getIngresoPrivadoDAO();
	
	public abstract IngresoPublicoDAO
	getIngresoPublicoDAO();
	
	public abstract InternacionalDAO
	getInternacionalDAO();
	
	public abstract LegadoDAO
	getLegadoDAO();
	
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
	getProyectoDAO();
	
	public abstract SedeDAO
	getSedeDAO();
	
	public abstract SocioDAO
	getSocioDAO();
	
	public abstract SubLineaAccionDAO
	getSublineaAccionDAO();
	
	public abstract UEDAO
	getUEDAO();
	
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
