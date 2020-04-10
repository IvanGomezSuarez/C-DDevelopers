package DAO;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;


import ongEC.Direccion;
import ongEC.Delegacion;


public interface DelegacionesDAO {

	public int Delegacion(Delegacion delegacion, String cip, Direccion direccion,
			String nombre);

	public void obtenerDelegaciones(String nombre, String cip) throws JAXBException;
	
	public void crearNuevo(String nomDelegacion, String idDelegacion, String cip, String telefono) throws JAXBException;
	
	public int eliminarDelegaciones(String cip);
	
	public ongEC.Delegacion listadoDelegaciones();
}