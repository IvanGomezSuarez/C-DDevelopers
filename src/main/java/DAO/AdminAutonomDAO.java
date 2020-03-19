package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.AdminAutonom;
// estos import nos permiten utilizar esos tipos "Direccion", "AdminAutonom"...

public interface AdminAutonomDAO {
	
	// dentro de cada interface, mencionamos los métodos que manipulan a esa clase como public
	// si se registra algo devuelve un valor entero de control, por lo que registrar es un int
	// si se registra nos devuelve un valor mayor que 0, y si no se registra nos devuelve 0

	public int registrarAdminAutonom(AdminAutonom adminAutonom, String descripcion, Direccion direccion, float Importe, 
			String nombreOrganizacion);

	public AdminAutonom obtenerAdminAutonom(String nombreOrganizacion);
	
	public int eliminarAdminAutonom(String nombreOrganizacion);
	
	public ArrayList<AdminAutonom>listadoAdminAutonom();
}
