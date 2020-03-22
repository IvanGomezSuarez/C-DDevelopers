package ongEC;

/*
 * esta clase contiene la informaci�n de los datos de fechas del personal
 * 
 * 
 * */

import java.sql.Date;

public class Personal extends Miembros {
	
	//Definicion de los Atributos
	
	private Date fechaAlta;
	private Date fechaBaja;		
	
	//Definiendo los Constructores
	
	public Personal(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, String direccion, String telefono, Date fechaAlta,
			Date fechaBaja) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono);
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	
	public Personal(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, String direccion, String telefono) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono);
	}

	//Defincion de los Gets y Sets
	
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
