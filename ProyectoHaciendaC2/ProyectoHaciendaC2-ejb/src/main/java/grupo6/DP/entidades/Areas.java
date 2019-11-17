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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "AREAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")
    , @NamedQuery(name = "Areas.findByNumeroArea", query = "SELECT a FROM Areas a WHERE a.areasPK.numeroArea = :numeroArea")
    , @NamedQuery(name = "Areas.findByIdTipoArea", query = "SELECT a FROM Areas a WHERE a.areasPK.idTipoArea = :idTipoArea")
    , @NamedQuery(name = "Areas.findByArea", query = "SELECT a FROM Areas a WHERE a.area = :area")
    , @NamedQuery(name = "Areas.findByCercado", query = "SELECT a FROM Areas a WHERE a.cercado = :cercado")
    , @NamedQuery(name = "Areas.findByTipoSuelo", query = "SELECT a FROM Areas a WHERE a.tipoSuelo = :tipoSuelo")
    , @NamedQuery(name = "Areas.findByAgua", query = "SELECT a FROM Areas a WHERE a.agua = :agua")
    , @NamedQuery(name = "Areas.findByDisponible", query = "SELECT a FROM Areas a WHERE a.disponible = :disponible")})
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreasPK areasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AREA")
    private double area;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CERCADO")
    private BigInteger cercado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_SUELO")
    private String tipoSuelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGUA")
    private BigInteger agua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISPONIBLE")
    private BigInteger disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areas")
    private List<DistribucionesPlantas> distribucionesPlantasList;
    @JoinColumn(name = "ID_TIPO_AREA", referencedColumnName = "ID_TIPO_AREA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoArea tipoArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areas")
    private List<DistribucionesAnimales> distribucionesAnimalesList;

    public Areas() {
    }

    public Areas(AreasPK areasPK) {
        this.areasPK = areasPK;
    }

    public Areas(AreasPK areasPK, double area, BigInteger cercado, String tipoSuelo, BigInteger agua, BigInteger disponible) {
        this.areasPK = areasPK;
        this.area = area;
        this.cercado = cercado;
        this.tipoSuelo = tipoSuelo;
        this.agua = agua;
        this.disponible = disponible;
    }

    public Areas(BigInteger numeroArea, String idTipoArea) {
        this.areasPK = new AreasPK(numeroArea, idTipoArea);
    }

    public AreasPK getAreasPK() {
        return areasPK;
    }

    public void setAreasPK(AreasPK areasPK) {
        this.areasPK = areasPK;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public BigInteger getCercado() {
        return cercado;
    }

    public void setCercado(BigInteger cercado) {
        this.cercado = cercado;
    }

    public String getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    public BigInteger getAgua() {
        return agua;
    }

    public void setAgua(BigInteger agua) {
        this.agua = agua;
    }

    public BigInteger getDisponible() {
        return disponible;
    }

    public void setDisponible(BigInteger disponible) {
        this.disponible = disponible;
    }

    @XmlTransient
    public List<DistribucionesPlantas> getDistribucionesPlantasList() {
        return distribucionesPlantasList;
    }

    public void setDistribucionesPlantasList(List<DistribucionesPlantas> distribucionesPlantasList) {
        this.distribucionesPlantasList = distribucionesPlantasList;
    }

    public TipoArea getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(TipoArea tipoArea) {
        this.tipoArea = tipoArea;
    }

    @XmlTransient
    public List<DistribucionesAnimales> getDistribucionesAnimalesList() {
        return distribucionesAnimalesList;
    }

    public void setDistribucionesAnimalesList(List<DistribucionesAnimales> distribucionesAnimalesList) {
        this.distribucionesAnimalesList = distribucionesAnimalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areasPK != null ? areasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.areasPK == null && other.areasPK != null) || (this.areasPK != null && !this.areasPK.equals(other.areasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.Areas[ areasPK=" + areasPK + " ]";
    }
    
}
