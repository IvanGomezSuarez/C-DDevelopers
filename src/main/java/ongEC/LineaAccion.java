package ongEC;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/*
 * esta clase contiene las Lineas de Accion
 * 
 * 
 * */

public class LineaAccion extends Proyecto {

	//Defincion de los Atributos
	
	private String descripcionAccion;
	//@XmlElement(name = "ActualLineasAccion")
	private SubLineaAccion defSubLineaAccion;
	@XmlElement(name = "ActualLineasAccion")
	private ActualLineasAccion actualLineasAccion;
	
	//Definicion de los constructores
	
	
	
	public LineaAccion() {
	}

	public LineaAccion(String descripcionAccion, SubLineaAccion defSubLineaAccion,
			ActualLineasAccion actualLineasAccion) {
		this.descripcionAccion = descripcionAccion;
		this.defSubLineaAccion = defSubLineaAccion;
		this.actualLineasAccion = actualLineasAccion;
	}

	//Definicion de los Gets y sets
	

	public String getDescripcionAccion() {
		return descripcionAccion;
	}

	public void setDescripcionAccion(String descripcionAccion) {
		this.descripcionAccion = descripcionAccion;
	}

	public SubLineaAccion getDefSubLineaAccion() {
		return defSubLineaAccion;
	}

	public void setDefSubLineaAccion(SubLineaAccion defSubLineaAccion) {
		this.defSubLineaAccion = defSubLineaAccion;
	}

	public ActualLineasAccion getActualLineasAccion() {
		return actualLineasAccion;
	}

	public void setActualLineasAccion(ActualLineasAccion actualLineasAccion) {
		this.actualLineasAccion = actualLineasAccion;
	}
	
}
