package ongEC;

import java.sql.Date;
/*
 * esta clase contiene la informaciï¿½n del origen internacional del voluntario
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
	
	//MÉTODOS 
	
	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
}
