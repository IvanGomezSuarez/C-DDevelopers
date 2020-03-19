package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.Delegaciones;


public interface DelegacionesDAO {

	public int Delegaciones(Delegaciones delegaciones, String cip, Direccion direccion,
			String nombre);

	public Delegaciones obtenerDelegaciones(String nombre, String cip);
	
	public int eliminarDelegaciones(String cip);
	
	public ArrayList<Delegaciones>listadoDelegaciones();
}