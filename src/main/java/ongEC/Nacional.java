package ongEC;

import java.sql.Date;

/*
 * esta clase contiene la informaci�n del origen nacional del voluntario
 * 
 * 
 * */
public class Nacional extends Voluntario {

	//Definiendo atributos
	
	private String Origen;
	
	
	//Definiendo Constructores
	
	public Nacional(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, Direccion direccion, String telefono, Date fechaAlta,
			Date fechaBaja, String origen) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono, fechaAlta, fechaBaja);
		Origen = origen;
	}
	
	public Nacional(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, Direccion direccion, String telefono, Date fechaAlta,
			Date fechaBaja) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono, fechaAlta, fechaBaja);
	}

	//Definiendo los Gets y los Sets

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}
	

	
}
