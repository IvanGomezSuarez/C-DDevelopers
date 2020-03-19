package DAO;

import java.util.ArrayList;
import ongEC.Nacional;


public interface NacionalDAO {
	

	public int registrarNacional(Nacional nacional, String origen);

	public Nacional obtenerNacional(String origen);
	
	public int eliminarNacional(String origen);
	
	public ArrayList<Nacional>listadoNacional();
}
