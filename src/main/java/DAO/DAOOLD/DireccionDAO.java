package DAO;

import java.util.ArrayList;
import ongEC.Direccion;


public interface DireccionDAO {
	

	public int registrarDireccion(Direccion direccion, String cp, int escalera,
			String localidad, int numero, String provincia, int puerta,
			String tipoVia);

	public Direccion obtenerDireccion(String cp, int escalera,
			String localidad, int numero, String provincia, int puerta,
			String tipoVia);
	
	public int eliminarDireccion(String cp);
	
	public ArrayList<Direccion>listadoDireccion();
}
