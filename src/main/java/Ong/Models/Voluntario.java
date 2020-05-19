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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voluntario.findAll", query = "SELECT v FROM Voluntario v")
    , @NamedQuery(name = "Voluntario.findByIdVoluntario", query = "SELECT v FROM Voluntario v WHERE v.idVoluntario = :idVoluntario")
    , @NamedQuery(name = "Voluntario.findByFechaAlta", query = "SELECT v FROM Voluntario v WHERE v.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Voluntario.findByFechaBaja", query = "SELECT v FROM Voluntario v WHERE v.fechaBaja = :fechaBaja")
    , @NamedQuery(name = "Voluntario.findByOrigen", query = "SELECT v FROM Voluntario v WHERE v.origen = :origen")
    , @NamedQuery(name = "Voluntario.findByPaisOrigen", query = "SELECT v FROM Voluntario v WHERE v.paisOrigen = :paisOrigen")})
public class Voluntario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVoluntario")
    private Integer idVoluntario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaBaja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    @Size(max = 45)
    @Column(name = "origen")
    private String origen;
    @Size(max = 45)
    @Column(name = "paisOrigen")
    private String paisOrigen;
    @JoinColumn(name = "idVoluntario", referencedColumnName = "idMiembro", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Miembro miembros;

    public Voluntario() {
    }

    public Voluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Voluntario(Integer idVoluntario, Date fechaAlta, Date fechaBaja) {
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

    public Miembro getMiembros() {
        return miembros;
    }

    public void setMiembros(Miembro miembros) {
        this.miembros = miembros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoluntario != null ? idVoluntario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voluntario)) {
            return false;
        }
        Voluntario other = (Voluntario) object;
        if ((this.idVoluntario == null && other.idVoluntario != null) || (this.idVoluntario != null && !this.idVoluntario.equals(other.idVoluntario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ong.Models.Voluntario[ idVoluntario=" + idVoluntario + " ]";
    }

    
}
