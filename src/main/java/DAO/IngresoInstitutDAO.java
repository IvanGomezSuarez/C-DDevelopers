package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.IngresoInstitut;


public interface IngresoInstitutDAO {
	

	public int registrarIngresoInstitut(IngresoInstitut ingresoInstitut, String descripcion, Direccion direccion,
			float importe, String nombreOrganizacion);

	public IngresoInstitut obtenerIngresoInstitut(String nombreOrganizacion, float importe);
	
	public int eliminarIngresoInstitut(String nombreOrganizacion, float importe);
	
	public ArrayList<IngresoInstitut>listadoIngresoInstitut();
}
