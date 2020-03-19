package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.Herencia;


public interface HerenciaDAO {
	

	public int registrarAdminEstado(Herencia herencia, String descripcion, Direccion direccion, 
			float importe, String nombreOrganizacion);

	public Herencia obtenerHerencia(String nombreOrganizacion, float importe);
	
	public int eliminarAdminEstado(String nombreOrganizacion);
	
	public ArrayList<Herencia>listadoHerencia();
}
