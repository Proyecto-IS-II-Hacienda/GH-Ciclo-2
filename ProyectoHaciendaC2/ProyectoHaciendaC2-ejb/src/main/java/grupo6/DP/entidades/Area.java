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
 * @author marce
 */
@Entity
@Table(name = "AREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findByNumeroarea", query = "SELECT a FROM Area a WHERE a.areaPK.numeroarea = :numeroarea")
    , @NamedQuery(name = "Area.findByIdtipoarea", query = "SELECT a FROM Area a WHERE a.areaPK.idtipoarea = :idtipoarea")
    , @NamedQuery(name = "Area.findByArea", query = "SELECT a FROM Area a WHERE a.area = :area")
    , @NamedQuery(name = "Area.findByCercado", query = "SELECT a FROM Area a WHERE a.cercado = :cercado")
    , @NamedQuery(name = "Area.findByTiposuelo", query = "SELECT a FROM Area a WHERE a.tiposuelo = :tiposuelo")
    , @NamedQuery(name = "Area.findByAgua", query = "SELECT a FROM Area a WHERE a.agua = :agua")
    , @NamedQuery(name = "Area.findByDisponible", query = "SELECT a FROM Area a WHERE a.disponible = :disponible")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreaPK areaPK;
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
    @Column(name = "TIPOSUELO")
    private String tiposuelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGUA")
    private BigInteger agua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISPONIBLE")
    private BigInteger disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<DistribucionAnimal> distribucionAnimalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<DistribucionPlanta> distribucionPlantaList;
    @JoinColumn(name = "IDTIPOAREA", referencedColumnName = "IDTIPOAREA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoArea tipoArea;

    public Area() {
    }

    public Area(AreaPK areaPK) {
        this.areaPK = areaPK;
    }

    public Area(AreaPK areaPK, double area, BigInteger cercado, String tiposuelo, BigInteger agua, BigInteger disponible) {
        this.areaPK = areaPK;
        this.area = area;
        this.cercado = cercado;
        this.tiposuelo = tiposuelo;
        this.agua = agua;
        this.disponible = disponible;
    }

    public Area(BigInteger numeroarea, String idtipoarea) {
        this.areaPK = new AreaPK(numeroarea, idtipoarea);
    }

    public AreaPK getAreaPK() {
        return areaPK;
    }

    public void setAreaPK(AreaPK areaPK) {
        this.areaPK = areaPK;
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

    public String getTiposuelo() {
        return tiposuelo;
    }

    public void setTiposuelo(String tiposuelo) {
        this.tiposuelo = tiposuelo;
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
    public List<DistribucionAnimal> getDistribucionAnimalList() {
        return distribucionAnimalList;
    }

    public void setDistribucionAnimalList(List<DistribucionAnimal> distribucionAnimalList) {
        this.distribucionAnimalList = distribucionAnimalList;
    }

    @XmlTransient
    public List<DistribucionPlanta> getDistribucionPlantaList() {
        return distribucionPlantaList;
    }

    public void setDistribucionPlantaList(List<DistribucionPlanta> distribucionPlantaList) {
        this.distribucionPlantaList = distribucionPlantaList;
    }

    public TipoArea getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(TipoArea tipoArea) {
        this.tipoArea = tipoArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaPK != null ? areaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaPK == null && other.areaPK != null) || (this.areaPK != null && !this.areaPK.equals(other.areaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Area[ areaPK=" + areaPK + " ]";
    }
    
}
