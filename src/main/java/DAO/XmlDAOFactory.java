package DAO;

import javax.xml.bind.JAXBException;

import DAO.impl.ProyectoDAO;

public class XmlDAOFactory extends DAOFactory {

	@Override
	public ActualLineasAccionDAO getActualLineasAccionDAO() {
		// TODO Auto-generated method stub
		 return new XmlActualLineasAccionDAO();
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
	public DireccionDAO getDireccionDAO() {
		// TODO Auto-generated method stub
		 return new XmlDireccionDAO();
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
	public PersonalDAO getPersonalDAO() {
		// TODO Auto-generated method stub
		 return new XmlPersonalDAO();
	}

	@Override
	public ProyectoDAO getProyectoDAO() throws JAXBException {
		// TODO Auto-generated method stub
		 return new XmlProyectoDAO();
	}

	@Override
	public SedeDAO getSedeDAO() {
		// TODO Auto-generated method stub
		 return new XmlSedeDAO();
	}

	@Override
	public SocioDAO getSocioDAO() throws JAXBException {
		// TODO Auto-generated method stub
		 return new XmlSocioDAO();
	}

	@Override
	public SubLineaAccionDAO getSublineaAccionDAO() {
		// TODO Auto-generated method stub
		 return new XmlSubLineaAccionDAO();
	}

	@Override
	public VoluntarioDAO getVoluntarioDAO() {
		// TODO Auto-generated method stub
		 return new XmlVoluntarioDAO();
	}


	@Override
	public DelegacionesDAO getDelegacionesDAO() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OngDAO getOngDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
