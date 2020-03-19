package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.IngresoPrivado;


public interface IngresoPrivadoDAO {
	

	public int registrarIngresoPrivado(IngresoPrivado ingresoPrivado, String descripcion, Direccion direccion,
			float importe, String nombreOrganizacion);

	public IngresoPrivado obtenerIngresoPrivado(String nombreOrganizacion, float importe);
	
	public int eliminarIngresoPrivado(String nombreOrganizacion, float importe);
	
	public ArrayList<IngresoPrivado>listadoIngresoPrivado();
}
