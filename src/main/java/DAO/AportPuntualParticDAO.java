package DAO;

import java.util.ArrayList;
import ongEC.AportPuntualPartic;
import ongEC.Direccion;



public interface AportPuntualParticDAO {
	


	public int registrarAportPuntualPartic(AportPuntualPartic aportPuntualEmp, String descripcion, 
			Direccion direccion, float importe, String nombreOrganizacion);

	
	public ArrayList<AportPuntualPartic>listadoAportPuntualPartic();
}
