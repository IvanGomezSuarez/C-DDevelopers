package DAO;

import java.util.ArrayList;
import ongEC.Colaborador;



public interface ColaboradorDAO {
	

	public int registrarColaborador(Colaborador colaborador, String apellidos, String direccion,
			String dni, String nombre);

	public Colaborador obtenerColaborador(String nombre, String apellidos, String dni);
	
	public int eliminarColaborador(String dni);
	
	public ArrayList<Colaborador>listadoColaborador();
}
