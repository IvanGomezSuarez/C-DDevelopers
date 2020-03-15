package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.IngresoPublico;


public interface IngresoPublicoDAO {
	

	public int registrarIngresoPublico(IngresoPublico ingresoPublico, String descripcion, Direccion direccion,
			float importe, String nombreOrganizacion);

	public IngresoPublico obtenerIngresoPublico(String nombreOrganizacion, float importe);
	
	public int eliminarIngresoPublico(String nombreOrganizacion, float importe);
	
	public ArrayList<IngresoPublico>listadoIngresoPublico();
}
