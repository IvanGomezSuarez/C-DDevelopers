package ongEC;

import java.sql.Date;

public class IngresoPublico {

	int idIngreso;
	Date fechaIngreso;
	
	AdminEstado administracionesEstatales;
	AdminAutonom administracionesAutonomicas;
	AdminLocal administracionesLocales;
	UE unionEuropea;
		
	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	
	public AdminEstado getAdministracionesEstatales() {
		return administracionesEstatales;
	}

	public void setAdministracionesEstatales(AdminEstado administracionesEstatales) {
		this.administracionesEstatales = administracionesEstatales;
	}

	public AdminAutonom getAdministracionesAutonomicas() {
		return administracionesAutonomicas;
	}

	public void setAdministracionesAutonomicas(AdminAutonom administracionesAutonomicas) {
		this.administracionesAutonomicas = administracionesAutonomicas;
	}

	public AdminLocal getAdministracionesLocales() {
		return administracionesLocales;
	}

	public void setAdministracionesLocales(AdminLocal administracionesLocales) {
		this.administracionesLocales = administracionesLocales;
	}

	public UE getUnionEuropea() {
		return unionEuropea;
	}

	public void setUnionEuropea(UE unionEuropea) {
		this.unionEuropea = unionEuropea;
	}
	
	public IngresoPublico(int idIngreso, Date fechaIngreso, AdminEstado administracionesEstatales,
			AdminAutonom administracionesAutonomicas, AdminLocal administracionesLocales, UE unionEuropea) {
		super();
		this.idIngreso = idIngreso;
		this.fechaIngreso = fechaIngreso;
		this.administracionesEstatales = administracionesEstatales;
		this.administracionesAutonomicas = administracionesAutonomicas;
		this.administracionesLocales = administracionesLocales;
		this.unionEuropea = unionEuropea;
	}

	public IngresoPublico() {
		super();
	}		
}
