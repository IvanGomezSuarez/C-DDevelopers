package DAO;

import java.util.ArrayList;
import ongEC.LineaAccion;
import ongEC.ActualLineasAccion;



public interface LineaAccionDAO {
	

	public int registrarLineaAccion(LineaAccion lineaAccion, String descripcion, ActualLineasAccion LineaAccion);

	public LineaAccion obtenerLineaAccion(LineaAccion lineaAccion);
	
	public int eliminarLineaAccion(LineaAccion lineaAccion);
	
	public ArrayList<LineaAccion>listadoLineaAccion();
	
	public ArrayList<LineaAccion>listadoSubLineaAccion();
}
