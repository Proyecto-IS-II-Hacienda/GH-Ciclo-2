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
 * @author marce
 */
@Entity
@Table(name = "PLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p")
    , @NamedQuery(name = "Planta.findByIdplanta", query = "SELECT p FROM Planta p WHERE p.plantaPK.idplanta = :idplanta")
    , @NamedQuery(name = "Planta.findByNombrecientifico", query = "SELECT p FROM Planta p WHERE p.plantaPK.nombrecientifico = :nombrecientifico")
    , @NamedQuery(name = "Planta.findByFechaplantacion", query = "SELECT p FROM Planta p WHERE p.fechaplantacion = :fechaplantacion")})
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlantaPK plantaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAPLANTACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaplantacion;
    @Lob
    @Column(name = "OBSERVACION")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planta")
    private List<DistribucionPlanta> distribucionPlantaList;
    @JoinColumns({
        @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO", insertable = false, updatable = false)
        , @JoinColumn(name = "NOMBRECOMUN", referencedColumnName = "NOMBRECOMUN")})
    @ManyToOne(optional = false)
    private TipoPlanta tipoPlanta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planta")
    private List<CuidadoPlanta> cuidadoPlantaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planta")
    private List<ProcesamientoPlanta> procesamientoPlantaList;

    public Planta() {
    }

    public Planta(PlantaPK plantaPK) {
        this.plantaPK = plantaPK;
    }

    public Planta(PlantaPK plantaPK, Date fechaplantacion) {
        this.plantaPK = plantaPK;
        this.fechaplantacion = fechaplantacion;
    }

    public Planta(String idplanta, String nombrecientifico) {
        this.plantaPK = new PlantaPK(idplanta, nombrecientifico);
    }

    public PlantaPK getPlantaPK() {
        return plantaPK;
    }

    public void setPlantaPK(PlantaPK plantaPK) {
        this.plantaPK = plantaPK;
    }

    public Date getFechaplantacion() {
        return fechaplantacion;
    }

    public void setFechaplantacion(Date fechaplantacion) {
        this.fechaplantacion = fechaplantacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<DistribucionPlanta> getDistribucionPlantaList() {
        return distribucionPlantaList;
    }

    public void setDistribucionPlantaList(List<DistribucionPlanta> distribucionPlantaList) {
        this.distribucionPlantaList = distribucionPlantaList;
    }

    public TipoPlanta getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(TipoPlanta tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    @XmlTransient
    public List<CuidadoPlanta> getCuidadoPlantaList() {
        return cuidadoPlantaList;
    }

    public void setCuidadoPlantaList(List<CuidadoPlanta> cuidadoPlantaList) {
        this.cuidadoPlantaList = cuidadoPlantaList;
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
        hash += (plantaPK != null ? plantaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.plantaPK == null && other.plantaPK != null) || (this.plantaPK != null && !this.plantaPK.equals(other.plantaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Planta[ plantaPK=" + plantaPK + " ]";
    }
    
}
