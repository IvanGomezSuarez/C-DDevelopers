package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.Voluntario;


public interface VoluntarioDAO {
	

	public int registrarVoluntario(Voluntario voluntario, String apellidos, Direccion direccion,
			String dni, String nombre);

	public Voluntario obtenerVoluntario(String dni, String nombre, String apellidos);
	
	public int eliminarVoluntario(String dni);
	
	public ArrayList<Voluntario>listadoVoluntario();
}
