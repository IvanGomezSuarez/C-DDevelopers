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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c")
    , @NamedQuery(name = "Colaborador.findByIdColaborador", query = "SELECT c FROM Colaborador c WHERE c.idColaborador = :idColaborador")
    , @NamedQuery(name = "Colaborador.findByFechaAlta", query = "SELECT c FROM Colaborador c WHERE c.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Colaborador.findByFechaBaja", query = "SELECT c FROM Colaborador c WHERE c.fechaBaja = :fechaBaja")})
public class Colaborador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idColaborador")
    private Integer idColaborador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaBaja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @JoinColumn(name = "idColaborador", referencedColumnName = "idMiembro", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Miembros miembros;

    public Colaborador() {
    }

    public Colaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Colaborador(Integer idColaborador, Date fechaAlta, Date fechaBaja) {
        this.idColaborador = idColaborador;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
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

    public Miembros getMiembros() {
        return miembros;
    }

    public void setMiembros(Miembros miembros) {
        this.miembros = miembros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaborador != null ? idColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.idColaborador == null && other.idColaborador != null) || (this.idColaborador != null && !this.idColaborador.equals(other.idColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ong.Models.Colaborador[ idColaborador=" + idColaborador + " ]";
    }
    
}
