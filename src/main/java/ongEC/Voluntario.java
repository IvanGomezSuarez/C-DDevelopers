package ongEC;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
/*
 * esta clase contiene la informaci�n de los datos de fechas de los voluntarios
 * 
 * 
 * */
public class Voluntario{
	
	//Definendo los Atributos

	int idVoluntario;
	public static Date fechaAlta;
	public static Date fechaBaja;

	Nacional nacional;
	Internacional internacional;
	
	
	// Definendo los constructores
	
	public Voluntario(int idVoluntario, Date fechaAlta, Date fechaBaja, Nacional nacional,
			Internacional internacional) {
		this.idVoluntario = idVoluntario;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.nacional = nacional;
		this.internacional = internacional;
	}

	
	public Voluntario() {
	}
	
	//Definiendo los gets y los sets

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public static Date getFechaAlta() {
		return fechaAlta;
	}


	public static Date getFechaBaja() {
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


	public int getIdVoluntario() {
		return idVoluntario;
	}


	public void setIdVoluntario(int idVoluntario) {
		this.idVoluntario = idVoluntario;
	}
	
}
