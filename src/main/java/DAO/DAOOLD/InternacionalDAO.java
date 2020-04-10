package DAO;

import java.util.ArrayList;
import ongEC.Internacional;


public interface InternacionalDAO {
	

	public int registrarAdminEstado(Internacional internacional, String paisDeOrigen);

	public Internacional obtenerInternacional(String paisDeOrigen);
	
	public int eliminarInternacional(String paisDeOrigen);
	
	public ArrayList<Internacional>listadoInternacional();
}
