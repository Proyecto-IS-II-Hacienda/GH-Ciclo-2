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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TIPO_AREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoArea.findAll", query = "SELECT t FROM TipoArea t")
    , @NamedQuery(name = "TipoArea.findByIdTipoArea", query = "SELECT t FROM TipoArea t WHERE t.idTipoArea = :idTipoArea")
    , @NamedQuery(name = "TipoArea.findByNombreArea", query = "SELECT t FROM TipoArea t WHERE t.nombreArea = :nombreArea")})
public class TipoArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ID_TIPO_AREA")
    private String idTipoArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_AREA")
    private String nombreArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoArea")
    private List<Areas> areasList;

    public TipoArea() {
    }

    public TipoArea(String idTipoArea) {
        this.idTipoArea = idTipoArea;
    }

    public TipoArea(String idTipoArea, String nombreArea) {
        this.idTipoArea = idTipoArea;
        this.nombreArea = nombreArea;
    }

    public String getIdTipoArea() {
        return idTipoArea;
    }

    public void setIdTipoArea(String idTipoArea) {
        this.idTipoArea = idTipoArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    @XmlTransient
    public List<Areas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Areas> areasList) {
        this.areasList = areasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoArea != null ? idTipoArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoArea)) {
            return false;
        }
        TipoArea other = (TipoArea) object;
        if ((this.idTipoArea == null && other.idTipoArea != null) || (this.idTipoArea != null && !this.idTipoArea.equals(other.idTipoArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.TipoArea[ idTipoArea=" + idTipoArea + " ]";
    }
    
}
