package ongEC;

import java.util.Date;
/*
 * esta clase contiene la informaci�n de los datos de fechas de los voluntarios
 * 
 * 
 * */
public class Voluntario extends Miembro  {
	
	//Definendo los Atributos
	
	private Date fechaAlta;
	private Date fechaBaja;
	Nacional nacional;
	Internacional internacional;
	
	
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


	public Nacional getNacional() {
		return nacional;
	}


	public void setNacional(Nacional nacional) {
		this.nacional = nacional;
	}


	public Internacional getInternacional() {
		return internacional;
	}


	public void setInternacional(Internacional internacional) {
		this.internacional = internacional;
	}
}
