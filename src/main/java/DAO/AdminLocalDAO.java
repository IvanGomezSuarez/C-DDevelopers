package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.AdminLocal;


public interface AdminLocalDAO {
	

	public int registrarAdminLocal(AdminLocal adminLocal, String descripcion, Direccion direccion, float Importe, 
			String nombreOrganizacion);

	public AdminLocal obtenerAdminLocal(String nombreOrganizacion);
	
	public int eliminarAdminLocal(String nombreOrganizacion);
	
	public ArrayList<AdminLocal>listadoAdminLocal();
}
