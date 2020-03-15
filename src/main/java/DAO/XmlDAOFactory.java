package DAO;

public class XmlDAOFactory extends DAOFactory {

	@Override
	public ActualLineasAccionDAO getActualLineasAccionDAO() {
		// TODO Auto-generated method stub
		 return new XmlActualLineasAccionDAO();
	}

	@Override
	public AdminAutonomDAO getAdminAutonomDAO() {
		// TODO Auto-generated method stub
		 return new XmlAdminAutonomDAO();
	}

	@Override
	public AdminEstadoDAO getAdminEstadoDAO() {
		// TODO Auto-generated method stub
		 return new XmlgetAdminEstadoDAO();
	}

	@Override
	public AdminLocalDAO getAdminLocalDAO() {
		// TODO Auto-generated method stub
		 return new XmlAdminLocalDAO();
	}

	@Override
	public AportPuntualEmpDAO getAportPuntualEmpDAO() {
		// TODO Auto-generated method stub
		 return new XmlAportPuntualEmpDAO();
	}

	@Override
	public ColaboradorDAO getColaboradorDAO() {
		// TODO Auto-generated method stub
		 return new XmlColaboradorDAO();
	}

	@Override
	public CuotaSocioDAO getCuotaSocioDAO() {
		// TODO Auto-generated method stub
		 return new XmlCuotaSocioDAO();
	}

	@Override
	public DelegacionesDAO getDelegacionesDAO() {
		// TODO Auto-generated method stub
		 return new XmlDelegacionesDAO();
	}

	@Override
	public DireccionDAO getDireccionDAO() {
		// TODO Auto-generated method stub
		 return new XmlDireccionDAO();
	}

	@Override
	public HerenciaDAO getHerenciaDAO() {
		// TODO Auto-generated method stub
		 return new XmlHerenciaDAO();
	}

	@Override
	public ILogginDAO getILogginDAO() {
		// TODO Auto-generated method stub
		 return new XmlILogginDAO();
	}

	@Override
	public IngresoDAO getIngresoDAO() {
		// TODO Auto-generated method stub
		 return new XmlIngresoDAO();
	}

	@Override
	public IngresoExtraDAO getIngresoExtraDAO() {
		// TODO Auto-generated method stub
		 return new XmlIngresoExtraDAO();
	}

	@Override
	public IngresoInstitutDAO getIngresoInstitutDAO() {
		// TODO Auto-generated method stub
		 return new XmlIngresoInstitutDAO();
	}

	@Override
	public IngresoPrivadoDAO getIngresoPrivadoDAO() {
		// TODO Auto-generated method stub
		 return new XmlIngresoPrivadoDAO();
	}

	@Override
	public IngresoPublicoDAO getIngresoPublicoDAO() {
		// TODO Auto-generated method stub
		 return new XmlIngresoPublicoDAO();
	}

	@Override
	public InternacionalDAO getInternacionalDAO() {
		// TODO Auto-generated method stub
		 return new XmlInternacionalDAO();
	}

	@Override
	public LegadoDAO getLegadoDAO() {
		// TODO Auto-generated method stub
		 return new XmlLegadoDAO();
	}

	@Override
	public LineaAccionDAO getLineaAccionDAO() {
		// TODO Auto-generated method stub
		 return new XmlLineaAccionDAO();
	}

	@Override
	public MiembrosDAO getMiembrosDAO() {
		// TODO Auto-generated method stub
		 return new XmlMiembrosDAO();
	}

	@Override
	public NacionalDAO getNacionalDAO() {
		// TODO Auto-generated method stub
		 return new XmlNacionalDAO();
	}

	@Override
	public OngDAO getOngDAO() {
		// TODO Auto-generated method stub
		 return new XmlOngDAO();
	}

	@Override
	public PersonalDAO getPersonalDAO() {
		// TODO Auto-generated method stub
		 return new XmlPersonalDAO();
	}

	@Override
	public ProyectoDAO getProyectoDAO() {
		// TODO Auto-generated method stub
		 return new XmlProyectoDAO();
	}

	@Override
	public SedeDAO getSedeDAO() {
		// TODO Auto-generated method stub
		 return new XmlSedeDAO();
	}

	@Override
	public SocioDAO getSocioDAO() {
		// TODO Auto-generated method stub
		 return new XmlSocioDAO();
	}

	@Override
	public SubLineaAccionDAO getSublineaAccionDAO() {
		// TODO Auto-generated method stub
		 return new XmlSubLineaAccionDAO();
	}

	@Override
	public UEDAO getUEDAO() {
		// TODO Auto-generated method stub
		return new XmlUEDAO();
	}

	@Override
	public VoluntarioDAO getVoluntarioDAO() {
		// TODO Auto-generated method stub
		 return new XmlVoluntarioDAO();
	}

}
