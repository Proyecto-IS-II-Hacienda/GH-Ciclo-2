/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "TIPOS_PLANTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposPlantas.findAll", query = "SELECT t FROM TiposPlantas t")
    , @NamedQuery(name = "TiposPlantas.findByNombreCientifico", query = "SELECT t FROM TiposPlantas t WHERE t.tiposPlantasPK.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "TiposPlantas.findByNombreComun", query = "SELECT t FROM TiposPlantas t WHERE t.tiposPlantasPK.nombreComun = :nombreComun")
    , @NamedQuery(name = "TiposPlantas.findByDiasParaCosecha", query = "SELECT t FROM TiposPlantas t WHERE t.diasParaCosecha = :diasParaCosecha")})
public class TiposPlantas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiposPlantasPK tiposPlantasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIAS_PARA_COSECHA")
    private BigInteger diasParaCosecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlantas")
    private List<Plantas> plantasList;

    public TiposPlantas() {
    }

    public TiposPlantas(TiposPlantasPK tiposPlantasPK) {
        this.tiposPlantasPK = tiposPlantasPK;
    }

    public TiposPlantas(TiposPlantasPK tiposPlantasPK, BigInteger diasParaCosecha, String descripcion) {
        this.tiposPlantasPK = tiposPlantasPK;
        this.diasParaCosecha = diasParaCosecha;
        this.descripcion = descripcion;
    }

    public TiposPlantas(String nombreCientifico, String nombreComun) {
        this.tiposPlantasPK = new TiposPlantasPK(nombreCientifico, nombreComun);
    }

    public TiposPlantasPK getTiposPlantasPK() {
        return tiposPlantasPK;
    }

    public void setTiposPlantasPK(TiposPlantasPK tiposPlantasPK) {
        this.tiposPlantasPK = tiposPlantasPK;
    }

    public BigInteger getDiasParaCosecha() {
        return diasParaCosecha;
    }

    public void setDiasParaCosecha(BigInteger diasParaCosecha) {
        this.diasParaCosecha = diasParaCosecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Plantas> getPlantasList() {
        return plantasList;
    }

    public void setPlantasList(List<Plantas> plantasList) {
        this.plantasList = plantasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiposPlantasPK != null ? tiposPlantasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposPlantas)) {
            return false;
        }
        TiposPlantas other = (TiposPlantas) object;
        if ((this.tiposPlantasPK == null && other.tiposPlantasPK != null) || (this.tiposPlantasPK != null && !this.tiposPlantasPK.equals(other.tiposPlantasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.TiposPlantas[ tiposPlantasPK=" + tiposPlantasPK + " ]";
    }
    
}
