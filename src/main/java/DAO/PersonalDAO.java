package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.Personal;


public interface PersonalDAO {
	

	public int registrarPersonal(Personal personal, String apellidos, Direccion direccion, 
			String dni, String nombre);

	public Personal obtenerPersonal(String dni, String nombre, String apellidos);
	
	public int eliminarPersonal(String dni);
	
	public ArrayList<Personal>listadoPersonal();
}
