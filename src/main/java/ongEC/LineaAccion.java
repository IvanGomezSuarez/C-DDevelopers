package ongEC;

import java.util.List;

public class LineaAccion {

	ActualLineasAccion lineaAccion;
	List<SubLineaAccion>subLineaAccion;
	String descripcionAccion;
	
	public ActualLineasAccion getLineaAccion() {
		return lineaAccion;
	}
	
	public void setLineaAccion(ActualLineasAccion lineaAccion) {
		this.lineaAccion = lineaAccion;
	}
	
	public List<SubLineaAccion> getSubLineaAccion() {
		return subLineaAccion;
	}
	
	public void setSubLineaAccion(List<SubLineaAccion> subLineaAccion) {
		this.subLineaAccion = subLineaAccion;
	}
	
	public String getDescripcionAccion() {
		return descripcionAccion;
	}
	
	public void setDescripcionAccion(String descripcionAccion) {
		this.descripcionAccion = descripcionAccion;
	}

	public LineaAccion(ActualLineasAccion lineaAccion, List<ongEC.SubLineaAccion> subLineaAccion,
			String descripcionAccion) {
		super();
		this.lineaAccion = lineaAccion;
		this.subLineaAccion = subLineaAccion;
		this.descripcionAccion = descripcionAccion;
	}

	public LineaAccion() {
		super();
	}	
}
