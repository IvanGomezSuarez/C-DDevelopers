package ongEC;

import java.util.List;

public class lineaAcccion {

	actualLineasAccion lineaAccion;
	List<subLineaAccion>subLineaAccion;
	String descripcionAccion;
	
	public actualLineasAccion getLineaAccion() {
		return lineaAccion;
	}
	
	public void setLineaAccion(actualLineasAccion lineaAccion) {
		this.lineaAccion = lineaAccion;
	}
	
	public List<subLineaAccion> getSubLineaAccion() {
		return subLineaAccion;
	}
	
	public void setSubLineaAccion(List<subLineaAccion> subLineaAccion) {
		this.subLineaAccion = subLineaAccion;
	}
	
	public String getDescripcionAccion() {
		return descripcionAccion;
	}
	
	public void setDescripcionAccion(String descripcionAccion) {
		this.descripcionAccion = descripcionAccion;
	}

	public lineaAcccion(actualLineasAccion lineaAccion, List<ongEC.subLineaAccion> subLineaAccion,
			String descripcionAccion) {
		super();
		this.lineaAccion = lineaAccion;
		this.subLineaAccion = subLineaAccion;
		this.descripcionAccion = descripcionAccion;
	}

	public lineaAcccion() {
		super();
	}	
}
