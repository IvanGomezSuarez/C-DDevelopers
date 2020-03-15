package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.Legado;


public interface LegadoDAO {
	

	public int registrarLegado(Legado legado, String descripcion, Direccion direccion,
			float importe, String nombreOrganizacion);

	public Legado obtenerLegado(String nombreOrganizacion, float importe);
	
	public int eliminarLegado(String nombreOrganizacion, float importe);
	
	public ArrayList<Legado>listadoLegado();
}
