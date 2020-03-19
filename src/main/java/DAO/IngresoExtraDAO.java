package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.IngresoExtra;


public interface IngresoExtraDAO {
	

	public int registrarIngresoExtra(IngresoExtra ingresoExtra, String descripcion, Direccion direccion,
			float importe, String nombreOrganizacion);

	public IngresoExtra obtenerIngresoExtra(String nombreOrganizacion, float importe);
	
	public int eliminarIngresoExtra(String nombreOrganizacion, float importe);
	
	public ArrayList<IngresoExtra>listadoIngresoExtra();
}
