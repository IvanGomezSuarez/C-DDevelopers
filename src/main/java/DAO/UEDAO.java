package DAO;

import java.util.ArrayList;
import ongEC.Direccion;
import ongEC.UE;


public interface UEDAO {
	

	public int registrarUE(UE uE, String descripcion, Direccion direccion, float importe,
			String nombreOrganizacion);

	public UE obtenerUE(String nombreOrganizacion, float importe);
	
	public int eliminarUE(String nombreOrganizacion);
	
	public ArrayList<UE>listadoUE();
}
