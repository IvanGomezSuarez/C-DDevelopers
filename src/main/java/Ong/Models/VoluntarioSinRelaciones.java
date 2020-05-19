/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan
 */

@Entity
@Table(name = "voluntario")
public class VoluntarioSinRelaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVoluntario")
    private Integer idVoluntario;
    
    @Column(name = "fechaAlta")
    private Date fechaAlta;
    
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    
    @Column(name = "origen")
    private String origen;

    @Column(name = "paisOrigen")
    private String paisOrigen;

    
	public VoluntarioSinRelaciones() {
		super();
	}

	public VoluntarioSinRelaciones(Integer idVoluntario, Date fechaAlta, Date fechaBaja, String origen,
			String paisOrigen) {
		super();
		this.idVoluntario = idVoluntario;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.origen = origen;
		this.paisOrigen = paisOrigen;
	}

	public VoluntarioSinRelaciones(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public VoluntarioSinRelaciones(Integer idVoluntario, Date fechaAlta, Date fechaBaja) {
        this.idVoluntario = idVoluntario;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Integer getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    } 
    
}
