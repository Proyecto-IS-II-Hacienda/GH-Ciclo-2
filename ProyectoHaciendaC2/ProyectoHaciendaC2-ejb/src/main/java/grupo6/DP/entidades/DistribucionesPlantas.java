/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "DISTRIBUCIONES_PLANTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DistribucionesPlantas.findAll", query = "SELECT d FROM DistribucionesPlantas d")
    , @NamedQuery(name = "DistribucionesPlantas.findByNumeroArea", query = "SELECT d FROM DistribucionesPlantas d WHERE d.distribucionesPlantasPK.numeroArea = :numeroArea")
    , @NamedQuery(name = "DistribucionesPlantas.findByIdTipoArea", query = "SELECT d FROM DistribucionesPlantas d WHERE d.distribucionesPlantasPK.idTipoArea = :idTipoArea")
    , @NamedQuery(name = "DistribucionesPlantas.findByIdPlanta", query = "SELECT d FROM DistribucionesPlantas d WHERE d.distribucionesPlantasPK.idPlanta = :idPlanta")
    , @NamedQuery(name = "DistribucionesPlantas.findByNombreCientifico", query = "SELECT d FROM DistribucionesPlantas d WHERE d.distribucionesPlantasPK.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "DistribucionesPlantas.findByFechaAsignacion", query = "SELECT d FROM DistribucionesPlantas d WHERE d.fechaAsignacion = :fechaAsignacion")
    , @NamedQuery(name = "DistribucionesPlantas.findByFechaSalida", query = "SELECT d FROM DistribucionesPlantas d WHERE d.fechaSalida = :fechaSalida")})
public class DistribucionesPlantas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DistribucionesPlantasPK distribucionesPlantasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Lob
    @Column(name = "DESCRIPCION_USO")
    private String descripcionUso;
    @JoinColumns({
        @JoinColumn(name = "NUMERO_AREA", referencedColumnName = "NUMERO_AREA", insertable = false, updatable = false)
        , @JoinColumn(name = "ID_TIPO_AREA", referencedColumnName = "ID_TIPO_AREA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Areas areas;
    @JoinColumns({
        @JoinColumn(name = "ID_PLANTA", referencedColumnName = "ID_PLANTA", insertable = false, updatable = false)
        , @JoinColumn(name = "NOMBRE_CIENTIFICO", referencedColumnName = "NOMBRE_CIENTIFICO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Plantas plantas;

    public DistribucionesPlantas() {
    }

    public DistribucionesPlantas(DistribucionesPlantasPK distribucionesPlantasPK) {
        this.distribucionesPlantasPK = distribucionesPlantasPK;
    }

    public DistribucionesPlantas(DistribucionesPlantasPK distribucionesPlantasPK, Date fechaAsignacion, Date fechaSalida) {
        this.distribucionesPlantasPK = distribucionesPlantasPK;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaSalida = fechaSalida;
    }

    public DistribucionesPlantas(BigInteger numeroArea, String idTipoArea, String idPlanta, String nombreCientifico) {
        this.distribucionesPlantasPK = new DistribucionesPlantasPK(numeroArea, idTipoArea, idPlanta, nombreCientifico);
    }

    public DistribucionesPlantasPK getDistribucionesPlantasPK() {
        return distribucionesPlantasPK;
    }

    public void setDistribucionesPlantasPK(DistribucionesPlantasPK distribucionesPlantasPK) {
        this.distribucionesPlantasPK = distribucionesPlantasPK;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcionUso() {
        return descripcionUso;
    }

    public void setDescripcionUso(String descripcionUso) {
        this.descripcionUso = descripcionUso;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    public Plantas getPlantas() {
        return plantas;
    }

    public void setPlantas(Plantas plantas) {
        this.plantas = plantas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distribucionesPlantasPK != null ? distribucionesPlantasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistribucionesPlantas)) {
            return false;
        }
        DistribucionesPlantas other = (DistribucionesPlantas) object;
        if ((this.distribucionesPlantasPK == null && other.distribucionesPlantasPK != null) || (this.distribucionesPlantasPK != null && !this.distribucionesPlantasPK.equals(other.distribucionesPlantasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.DistribucionesPlantas[ distribucionesPlantasPK=" + distribucionesPlantasPK + " ]";
    }
    
}
