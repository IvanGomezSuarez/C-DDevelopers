package DAO;

import ongEC.Direccion;
import ongEC.Sede;


public interface SedeDAO {
	

	public int registrarSede(Sede sede, String cip, Direccion direccion, String nombre);

	public int modificarSede(Sede sede, String cip, Direccion direccion, String nombre);
	

}
