/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "PLANTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantas.findAll", query = "SELECT p FROM Plantas p")
    , @NamedQuery(name = "Plantas.findByIdPlanta", query = "SELECT p FROM Plantas p WHERE p.plantasPK.idPlanta = :idPlanta")
    , @NamedQuery(name = "Plantas.findByNombreCientifico", query = "SELECT p FROM Plantas p WHERE p.plantasPK.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "Plantas.findByFechaPlantacion", query = "SELECT p FROM Plantas p WHERE p.fechaPlantacion = :fechaPlantacion")})
public class Plantas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlantasPK plantasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_PLANTACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPlantacion;
    @Lob
    @Column(name = "OBSERVACION")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantas")
    private List<CuidadosPlantas> cuidadosPlantasList;
    @JoinColumns({
        @JoinColumn(name = "NOMBRE_CIENTIFICO", referencedColumnName = "NOMBRE_CIENTIFICO", insertable = false, updatable = false)
        , @JoinColumn(name = "NOMBRE_COMUN", referencedColumnName = "NOMBRE_COMUN")})
    @ManyToOne(optional = false)
    private TiposPlantas tiposPlantas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantas")
    private List<DistribucionesPlantas> distribucionesPlantasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantas")
    private List<ProcesamientoPlanta> procesamientoPlantaList;

    public Plantas() {
    }

    public Plantas(PlantasPK plantasPK) {
        this.plantasPK = plantasPK;
    }

    public Plantas(PlantasPK plantasPK, Date fechaPlantacion) {
        this.plantasPK = plantasPK;
        this.fechaPlantacion = fechaPlantacion;
    }

    public Plantas(String idPlanta, String nombreCientifico) {
        this.plantasPK = new PlantasPK(idPlanta, nombreCientifico);
    }

    public PlantasPK getPlantasPK() {
        return plantasPK;
    }

    public void setPlantasPK(PlantasPK plantasPK) {
        this.plantasPK = plantasPK;
    }

    public Date getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(Date fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<CuidadosPlantas> getCuidadosPlantasList() {
        return cuidadosPlantasList;
    }

    public void setCuidadosPlantasList(List<CuidadosPlantas> cuidadosPlantasList) {
        this.cuidadosPlantasList = cuidadosPlantasList;
    }

    public TiposPlantas getTiposPlantas() {
        return tiposPlantas;
    }

    public void setTiposPlantas(TiposPlantas tiposPlantas) {
        this.tiposPlantas = tiposPlantas;
    }

    @XmlTransient
    public List<DistribucionesPlantas> getDistribucionesPlantasList() {
        return distribucionesPlantasList;
    }

    public void setDistribucionesPlantasList(List<DistribucionesPlantas> distribucionesPlantasList) {
        this.distribucionesPlantasList = distribucionesPlantasList;
    }

    @XmlTransient
    public List<ProcesamientoPlanta> getProcesamientoPlantaList() {
        return procesamientoPlantaList;
    }

    public void setProcesamientoPlantaList(List<ProcesamientoPlanta> procesamientoPlantaList) {
        this.procesamientoPlantaList = procesamientoPlantaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plantasPK != null ? plantasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantas)) {
            return false;
        }
        Plantas other = (Plantas) object;
        if ((this.plantasPK == null && other.plantasPK != null) || (this.plantasPK != null && !this.plantasPK.equals(other.plantasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.Plantas[ plantasPK=" + plantasPK + " ]";
    }
    
}
