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
	
	public Nacional(Date fechaAlta, Date fechaBaja, String origen) {
		super(fechaAlta, fechaBaja);
		Origen = origen;
	}
	
	public Nacional(Date fechaAlta, Date fechaBaja) {
		super(fechaAlta, fechaBaja);
	}


	//Definiendo los Gets y los Sets






	public String getOrigen() {
		return Origen;
	}



	public void setOrigen(String origen) {
		Origen = origen;
	}
	

	
}
