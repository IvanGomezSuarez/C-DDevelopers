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
	
	String descripcion;

	//Constructores
	
	public SubLineaAccion(int idProyecto, String nombreProyecto, String pais, String localizacion,
			LineaAccion lineaAccion, List<SubLineaAccion> subLineaAccion, Date fechaInicio, Date fechaFin,
			List<Socio> socioLocal, String financiador, Double financiacionAportada, String codigoProyecto,
			String accionesRealizar, List<Miembros> miembrosAsignados, String descripcionAccion,
			SubLineaAccion defSubLineaAccion, ActualLineasAccion actualLineasAccion, String descripcion) {
		super(idProyecto, nombreProyecto, pais, localizacion, lineaAccion, subLineaAccion, fechaInicio, fechaFin,
				socioLocal, financiador, financiacionAportada, codigoProyecto, accionesRealizar, miembrosAsignados,
				descripcionAccion, defSubLineaAccion, actualLineasAccion);
		this.descripcion = descripcion;
	}
	
	public SubLineaAccion(int idProyecto, String nombreProyecto, String pais, String localizacion,
			LineaAccion lineaAccion, List<SubLineaAccion> subLineaAccion, Date fechaInicio, Date fechaFin,
			List<Socio> socioLocal, String financiador, Double financiacionAportada, String codigoProyecto,
			String accionesRealizar, List<Miembros> miembrosAsignados, String descripcionAccion,
			SubLineaAccion defSubLineaAccion, ActualLineasAccion actualLineasAccion) {
		super(idProyecto, nombreProyecto, pais, localizacion, lineaAccion, subLineaAccion, fechaInicio, fechaFin,
				socioLocal, financiador, financiacionAportada, codigoProyecto, accionesRealizar, miembrosAsignados,
				descripcionAccion, defSubLineaAccion, actualLineasAccion);
	}
	
	//Defincion de Gets and Sets
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}
