package ongEC;

import java.sql.Date;
/*
 * esta clase contiene la informaci�n del origen internacional del voluntario
 * 
 * 
 * */
public class Internacional extends Voluntario {

	
	//Definiendo los Atributos
	
	private String paisOrigen;

	//Definiendo los constructores
	
	public Internacional(String idMiembro, String nombreMiembro, String nombreUsuario, String password,
			String apellido1, String apellido2, String dni, String pais, String ciudad, Direccion direccion,
			String telefono, Date fechaAlta, Date fechaBaja, String paisOrigen) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono, fechaAlta, fechaBaja);
		this.paisOrigen = paisOrigen;
	}
	
	public Internacional(String idMiembro, String nombreMiembro, String nombreUsuario, String password,
			String apellido1, String apellido2, String dni, String pais, String ciudad, Direccion direccion,
			String telefono, Date fechaAlta, Date fechaBaja) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono, fechaAlta, fechaBaja);
	}
	
	//Definiendo los get y set
	
	public String getPaisOrigen() {
		return paisOrigen;
	}



	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

}
