package ongEC;

import java.sql.Date;
/*
 * esta clase contiene la informaci�n de los datos de fechas de los voluntarios
 * 
 * 
 * */
public class Voluntario extends Miembros  {
	
	//Definendo los Atributos
	
	private Date fechaAlta;
	private Date fechaBaja;
	
	
	// Definendo los constructores
	
	public Voluntario(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, String direccion, String telefono, Date fechaAlta,
			Date fechaBaja) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono);
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	public Voluntario(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, String direccion, String telefono) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono);
	}
	
	//Definiendo los gets y los sets
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}				
}
