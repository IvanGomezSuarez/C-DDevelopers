package ongEC;

import java.sql.Date;
/*
 * esta clase contiene la informaci�n del origen internacional del voluntario
 * 
 * 
 * */
public class Internacional{

	
	//Definiendo los Atributos
	
	private String paisOrigen;

	//Definiendo los constructores
	
	public Internacional(String paisOrigen) {
		super();
		this.paisOrigen = paisOrigen;
	}

	public Internacional() {
		super();
	}
	
	//Definiendo los get y set
	
	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
}
