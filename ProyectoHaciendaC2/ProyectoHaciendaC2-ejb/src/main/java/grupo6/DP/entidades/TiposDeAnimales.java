/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "TIPOS_DE_ANIMALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeAnimales.findAll", query = "SELECT t FROM TiposDeAnimales t")
    , @NamedQuery(name = "TiposDeAnimales.findByNombreCientifico", query = "SELECT t FROM TiposDeAnimales t WHERE t.tiposDeAnimalesPK.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "TiposDeAnimales.findByNombreComun", query = "SELECT t FROM TiposDeAnimales t WHERE t.tiposDeAnimalesPK.nombreComun = :nombreComun")
    , @NamedQuery(name = "TiposDeAnimales.findByRaza", query = "SELECT t FROM TiposDeAnimales t WHERE t.raza = :raza")})
public class TiposDeAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiposDeAnimalesPK tiposDeAnimalesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RAZA")
    private String raza;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposDeAnimales")
    private List<Animales> animalesList;

    public TiposDeAnimales() {
    }

    public TiposDeAnimales(TiposDeAnimalesPK tiposDeAnimalesPK) {
        this.tiposDeAnimalesPK = tiposDeAnimalesPK;
    }

    public TiposDeAnimales(TiposDeAnimalesPK tiposDeAnimalesPK, String raza, String descripcion) {
        this.tiposDeAnimalesPK = tiposDeAnimalesPK;
        this.raza = raza;
        this.descripcion = descripcion;
    }

    public TiposDeAnimales(String nombreCientifico, String nombreComun) {
        this.tiposDeAnimalesPK = new TiposDeAnimalesPK(nombreCientifico, nombreComun);
    }

    public TiposDeAnimalesPK getTiposDeAnimalesPK() {
        return tiposDeAnimalesPK;
    }

    public void setTiposDeAnimalesPK(TiposDeAnimalesPK tiposDeAnimalesPK) {
        this.tiposDeAnimalesPK = tiposDeAnimalesPK;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Animales> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animales> animalesList) {
        this.animalesList = animalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiposDeAnimalesPK != null ? tiposDeAnimalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeAnimales)) {
            return false;
        }
        TiposDeAnimales other = (TiposDeAnimales) object;
        if ((this.tiposDeAnimalesPK == null && other.tiposDeAnimalesPK != null) || (this.tiposDeAnimalesPK != null && !this.tiposDeAnimalesPK.equals(other.tiposDeAnimalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.TiposDeAnimales[ tiposDeAnimalesPK=" + tiposDeAnimalesPK + " ]";
    }
    
}
