package ongEC;

import java.util.List;

public class LineaAccion {

	ActualLineasAccion lineaAccion;
	List<SubLineaAccion>listasubLineaAccion;
	String descripcionAccion;
	
	SubLineaAccion subLineaAccion;
	ActualLineasAccion actualLineasAccion;
	
	public ActualLineasAccion getLineaAccion() {
		return lineaAccion;
	}
	
	public void setLineaAccion(ActualLineasAccion lineaAccion) {
		this.lineaAccion = lineaAccion;
	}
	
	public List<SubLineaAccion> getListasubLineaAccion() {
		return listasubLineaAccion;
	}
	
	public void setListasubLineaAccion(List<SubLineaAccion> listasubLineaAccion) {
		this.listasubLineaAccion = listasubLineaAccion;
	}
	
	public String getDescripcionAccion() {
		return descripcionAccion;
	}
	
	public void setDescripcionAccion(String descripcionAccion) {
		this.descripcionAccion = descripcionAccion;
	}
	
	public SubLineaAccion getSubLineaAccion() {
		return subLineaAccion;
	}
	
	public void setSubLineaAccion(SubLineaAccion subLineaAccion) {
		this.subLineaAccion = subLineaAccion;
	}
	
	public ActualLineasAccion getActualLineasAccion() {
		return actualLineasAccion;
	}
	
	public void setActualLineasAccion(ActualLineasAccion actualLineasAccion) {
		this.actualLineasAccion = actualLineasAccion;
	}

	public LineaAccion(ActualLineasAccion lineaAccion, List<SubLineaAccion> listasubLineaAccion,
			String descripcionAccion, SubLineaAccion subLineaAccion, ActualLineasAccion actualLineasAccion) {
		super();
		this.lineaAccion = lineaAccion;
		this.listasubLineaAccion = listasubLineaAccion;
		this.descripcionAccion = descripcionAccion;
		this.subLineaAccion = subLineaAccion;
		this.actualLineasAccion = actualLineasAccion;
	}

	public LineaAccion() {
		super();
	}
}
