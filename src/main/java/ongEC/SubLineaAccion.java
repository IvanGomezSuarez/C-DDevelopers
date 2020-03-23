package ongEC;

import java.sql.Date;
import java.util.List;

/*
 * esta clase contiene la informaci�n de las Sub Lineas de Accion
 * 
 * 
 * */

public class SubLineaAccion extends LineaAccion {

	//Incializacion de atributos
	
	private String descripcion;

	//Constructores
	
	public SubLineaAccion(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	
	public SubLineaAccion() {
		super();
	}

	//Defincion de Gets and Sets
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}
