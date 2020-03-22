package ongEC;

import java.sql.Date;

import javax.xml.bind.JAXBException;

public class IngresoPrivado extends Ingreso {
	
	int idIngreso;
	Date fechaIngreso;
	
	Legado legado;
	IngresoInstitut ingresoInstituciones;
	IngresoExtra ingresoExtraordinario;
	Herencia herencia;
	AportPuntualEmp aportacionPuntualEmpresas;
	AportPuntualPartic aportacionPuntualParticular;
	
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
	
	public Legado getLegado() {
		return legado;
	}

	public void setLegado(Legado legados) {
		this.legado = legados;
	}

	public IngresoInstitut getIngresoInstituciones() {
		return ingresoInstituciones;
	}

	public void setIngresoInstituciones(IngresoInstitut ingresoInstituciones) {
		this.ingresoInstituciones = ingresoInstituciones;
	}

	public IngresoExtra getIngresoExtraordinario() {
		return ingresoExtraordinario;
	}

	public void setIngresoExtraordinario(IngresoExtra ingresoExtraordinario) {
		this.ingresoExtraordinario = ingresoExtraordinario;
	}

	public Herencia getHerencia() {
		return herencia;
	}

	public void setHerencias(Herencia herencias) {
		this.herencia = herencias;
	}

	public AportPuntualEmp getAportacionPuntualEmpresas() {
		return aportacionPuntualEmpresas;
	}

	public void setAportacionPuntualEmpresas(AportPuntualEmp aportacionPuntualEmpresas) {
		this.aportacionPuntualEmpresas = aportacionPuntualEmpresas;
	}

	public AportPuntualPartic getAportacionPuntualParticular() {
		return aportacionPuntualParticular;
	}

	public void setAportacionPuntualParticular(AportPuntualPartic aportacionPuntualParticular) {
		this.aportacionPuntualParticular = aportacionPuntualParticular;
	}

	public IngresoPrivado(int idIngreso, Date fechaIngreso, Legado legado, IngresoInstitut ingresoInstituciones,
			IngresoExtra ingresoExtraordinario, Herencia herencia, AportPuntualEmp aportacionPuntualEmpresas,
			AportPuntualPartic aportacionPuntualParticular )throws JAXBException {
		super();
		this.idIngreso = idIngreso;
		this.fechaIngreso = fechaIngreso;
		this.legado = legado;
		this.ingresoInstituciones = ingresoInstituciones;
		this.ingresoExtraordinario = ingresoExtraordinario;
		this.herencia = herencia;
		this.aportacionPuntualEmpresas = aportacionPuntualEmpresas;
		this.aportacionPuntualParticular = aportacionPuntualParticular;
	}

	public IngresoPrivado() throws JAXBException {
		super();
	}		
}
