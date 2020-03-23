package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.AdminEstado;


public interface AdminEstadoDAO {
	

	public int registrarAdminEstado(AdminEstado adminEstado, String descripcion, Direccion direccion, float Importe, 
			String nombreOrganizacion);

	public AdminEstado obtenerAdminEstado(String nombreOrganizacion);
	
	public int eliminarAdminEstado(String nombreOrganizacion);
	
	public ArrayList<AdminEstado>listadoAdminEstado();
}
