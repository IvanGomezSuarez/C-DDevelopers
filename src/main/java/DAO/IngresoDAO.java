package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.Ingreso;


public interface IngresoDAO {
	

	public int registrarIngreso(Ingreso ingreso, String descripcion, Direccion direccion,
			float importe, String nombreOrganizacion);

	public Ingreso obtenerIngreso(String nombreOrganizacion, float importe);
	
	public int eliminarIngreso(String nombreOrganizacion, float importe);
	
	public ArrayList<Ingreso>listadoIngreso();
}
