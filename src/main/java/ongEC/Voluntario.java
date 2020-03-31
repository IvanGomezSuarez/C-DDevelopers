package ongEC;

import java.sql.Date;
/*
 * esta clase contiene la informaci�n de los datos de fechas de los voluntarios
 * 
 * 
 * */
public class Voluntario extends Miembro  {
	
	//Definendo los Atributos
	
	private Date fechaAlta;
	private Date fechaBaja;
	
	
	// Definendo los constructores
	
	public Voluntario(Date fechaAlta, Date fechaBaja) {
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	
	public Voluntario() {
		super();
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
