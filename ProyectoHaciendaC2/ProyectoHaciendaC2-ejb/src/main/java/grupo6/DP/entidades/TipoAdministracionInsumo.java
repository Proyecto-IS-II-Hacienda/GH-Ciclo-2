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
@Table(name = "TIPO_ADMINISTRACION_INSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAdministracionInsumo.findAll", query = "SELECT t FROM TipoAdministracionInsumo t")
    , @NamedQuery(name = "TipoAdministracionInsumo.findByIdAdmProd", query = "SELECT t FROM TipoAdministracionInsumo t WHERE t.idAdmProd = :idAdmProd")
    , @NamedQuery(name = "TipoAdministracionInsumo.findByNombre", query = "SELECT t FROM TipoAdministracionInsumo t WHERE t.nombre = :nombre")})
public class TipoAdministracionInsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ADM_PROD")
    private Integer idAdmProd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdmProd")
    private List<Insumos> insumosList;

    public TipoAdministracionInsumo() {
    }

    public TipoAdministracionInsumo(Integer idAdmProd) {
        this.idAdmProd = idAdmProd;
    }

    public TipoAdministracionInsumo(Integer idAdmProd, String nombre) {
        this.idAdmProd = idAdmProd;
        this.nombre = nombre;
    }

    public Integer getIdAdmProd() {
        return idAdmProd;
    }

    public void setIdAdmProd(Integer idAdmProd) {
        this.idAdmProd = idAdmProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Insumos> getInsumosList() {
        return insumosList;
    }

    public void setInsumosList(List<Insumos> insumosList) {
        this.insumosList = insumosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdmProd != null ? idAdmProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAdministracionInsumo)) {
            return false;
        }
        TipoAdministracionInsumo other = (TipoAdministracionInsumo) object;
        if ((this.idAdmProd == null && other.idAdmProd != null) || (this.idAdmProd != null && !this.idAdmProd.equals(other.idAdmProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.TipoAdministracionInsumo[ idAdmProd=" + idAdmProd + " ]";
    }
    
}
