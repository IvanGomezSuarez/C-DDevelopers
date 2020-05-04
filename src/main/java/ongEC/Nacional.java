package ongEC;

import java.sql.Date;
import javax.persistence.Entity;

/*
 * esta clase contiene la informaci�n del origen nacional del voluntario
 * 
 * 
 * */
@Entity
public class Nacional{

	//Definiendo atributos
	
	private String origen;
	
	
	//Definiendo Constructores
	
	public Nacional(String origen) {
		super();
		this.origen = origen;
	}

	public Nacional() {
		super();
	}

	//Definiendo los Gets y los Sets
	
	
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	
}
