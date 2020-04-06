package DAO;

import java.util.ArrayList;
import ongEC.SubLineaAccion;


public interface SubLineaAccionDAO {
	

	public int registrarSubLineaAccion(SubLineaAccion subLineaAccion, String descripcion,
			String SubLineaAccion);

	public SubLineaAccion obtenerSubLineaAccion(String SubLineaAccion);
	
	public int eliminarSubLineaAccion(String SubLineaAccion);
	
	public ArrayList<SubLineaAccion>listadoSubLineaAccion();
}
