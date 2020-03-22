package ongEC;

import java.sql.Date;
import java.util.List;
/*
 * esta clase contiene la informaci�n de los Proyectos
 * 
 * 
 * */

public class Proyecto {
	
	//Definicion de Atributos
	
	int idProyecto;
	Double financiacionAportada;
	
	String nombreProyecto;
	String pais;
	String localizacion;
	String financiador;
	
	String codigoProyecto;
	String AccionesRealizar;
	
	Date fechaInicio;
	Date fechaFin;
	
	LineaAccion lineaAccion;
	
	List<SubLineaAccion> subLineaAccion;
	List<Socio> socioLocal;
	List<Miembros> miembrosAsignados;
	
	//Definicion de Constructores
	
	public Proyecto(int idProyecto, String nombreProyecto, String pais, String localizacion, LineaAccion lineaAccion,
			List<SubLineaAccion> subLineaAccion, Date fechaInicio, Date fechaFin, List<Socio> socioLocal,
			String financiador, Double financiacionAportada, String codigoProyecto, String accionesRealizar,
			List<Miembros> miembrosAsignados) {
		super();
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.pais = pais;
		this.localizacion = localizacion;
		this.lineaAccion = lineaAccion;
		this.subLineaAccion = subLineaAccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.socioLocal = socioLocal;
		this.financiador = financiador;
		this.financiacionAportada = financiacionAportada;
		this.codigoProyecto = codigoProyecto;
		AccionesRealizar = accionesRealizar;
		this.miembrosAsignados = miembrosAsignados;
	}

	public Proyecto() {
		super();
	}
	
	//Definicion de los Getters and Settes
	
	public int getIdProyecto() {
		return idProyecto;
	}
	
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getLocalizacion() {
		return localizacion;
	}
	
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	public LineaAccion getLineaAccion() {
		return lineaAccion;
	}
	
	public void setLineaAccion(LineaAccion lineaAccion) {
		this.lineaAccion = lineaAccion;
	}
	
	public List<SubLineaAccion> getSubLineaAccion() {
		return subLineaAccion;
	}
	
	public void setSubLineaAccion(List<SubLineaAccion> subLineaAccion) {
		this.subLineaAccion = subLineaAccion;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public List<Socio> getSocioLocal() {
		return socioLocal;
	}
	
	public void setSocioLocal(List<Socio> socioLocal) {
		this.socioLocal = socioLocal;
	}
	
	public String getFinanciador() {
		return financiador;
	}
	
	public void setFinanciador(String financiador) {
		this.financiador = financiador;
	}
	
	public Double getFinanciacionAportada() {
		return financiacionAportada;
	}
	
	public void setFinanciacionAportada(Double financiacionAportada) {
		this.financiacionAportada = financiacionAportada;
	}
	
	public String getCodigoProyecto() {
		return codigoProyecto;
	}
	
	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}
	
	public String getAccionesRealizar() {
		return AccionesRealizar;
	}
	
	public void setAccionesRealizar(String accionesRealizar) {
		AccionesRealizar = accionesRealizar;
	}
	
	public List<Miembros> getMiembrosAsignados() {
		return miembrosAsignados;
	}
	
	public void setMiembrosAsignados(List<Miembros> miembrosAsignados) {
		this.miembrosAsignados = miembrosAsignados;
	}
}
