package ongEC;

import java.sql.Date;
/*
 * esta clase contiene la informaci�n del origen internacional del voluntario
 * 
 * 
 * */
public class Internacional{

	
	//ATRIBUTOS
	
	private String paisOrigen;

	//CONSTRUCTORES
	
	public Internacional(String paisOrigen) {
		super();
		this.paisOrigen = paisOrigen;
	}

	public Internacional() {
		super();
	}
	
	//M�TODOS 
	
	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
}
