package ongEC;

public class SubLineaAccion {

	String subLineaAccion;
	String descripcion;
	
	public String getSubLineaAccion() {
		return subLineaAccion;
	}
	
	public void setSubLineaAccion(String subLineaAccion) {
		this.subLineaAccion = subLineaAccion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SubLineaAccion(String subLineaAccion, String descripcion) {
		super();
		this.subLineaAccion = subLineaAccion;
		this.descripcion = descripcion;
	}

	public SubLineaAccion() {
		super();
	}
}
