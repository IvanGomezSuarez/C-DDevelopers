package ongEC;

import java.sql.Date;
import java.util.List;

/*
 * esta clase contiene las Lineas de Accion
 * 
 * 
 * */

public class LineaAccion extends Proyecto {

	//Defincion de los Atributos
	
	private String descripcionAccion;
	
	private SubLineaAccion defSubLineaAccion;
	
	private ActualLineasAccion actualLineasAccion;
	
	//Definicion de los constructores
	
	
	
	public LineaAccion() {
		super();
	}

	public LineaAccion(int idProyecto, String nombreProyecto, String pais, String localizacion, LineaAccion lineaAccion,
			List<SubLineaAccion> subLineaAccion, java.util.Date fechaInicio, java.util.Date fechaFin,
			List<String> socioLocal, String financiador, Double financiacionAportada, String codigoProyecto,
			String accionesRealizar, List<Miembros> miembrosAsignados, String descripcionAccion,
			SubLineaAccion defSubLineaAccion, ActualLineasAccion actualLineasAccion) {
		super(idProyecto, nombreProyecto, pais, localizacion, lineaAccion, subLineaAccion, fechaInicio, fechaFin,
				socioLocal, financiador, financiacionAportada, codigoProyecto, accionesRealizar, miembrosAsignados);
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
