package DAO;

import java.util.ArrayList;
import ongEC.AportPuntualEmp;
import ongEC.Direccion;



public interface AportPuntualEmpDAO {
	


	public int registrarAportPuntualEmp(AportPuntualEmp aportPuntualEmp, String descripcion, 
			Direccion direccion, float importe, String nombreOrganizacion);

	
	public ArrayList<AportPuntualEmp>listadoAportPuntualEmp();
}
