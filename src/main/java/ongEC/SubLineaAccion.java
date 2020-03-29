package ongEC;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * esta clase contiene la informaci�n de las Sub Lineas de Accion
 * 
 * 
 * */
public class SubLineaAccion {

	//Incializacion de atributos
	private String descripcion;

	//Constructores
	
	public SubLineaAccion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public SubLineaAccion() {
	}

	//Defincion de Gets and Sets
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}
