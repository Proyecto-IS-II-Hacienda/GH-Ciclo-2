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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "INSUMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i")
    , @NamedQuery(name = "Insumos.findByCodInsumo", query = "SELECT i FROM Insumos i WHERE i.codInsumo = :codInsumo")
    , @NamedQuery(name = "Insumos.findByNombre", query = "SELECT i FROM Insumos i WHERE i.nombre = :nombre")})
public class Insumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_INSUMO")
    private String codInsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_ADM_PROD", referencedColumnName = "ID_ADM_PROD")
    @ManyToOne(optional = false)
    private TipoAdministracionInsumo idAdmProd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInsumo")
    private List<EntradaInsumos> entradaInsumosList;

    public Insumos() {
    }

    public Insumos(String codInsumo) {
        this.codInsumo = codInsumo;
    }

    public Insumos(String codInsumo, String nombre) {
        this.codInsumo = codInsumo;
        this.nombre = nombre;
    }

    public String getCodInsumo() {
        return codInsumo;
    }

    public void setCodInsumo(String codInsumo) {
        this.codInsumo = codInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoAdministracionInsumo getIdAdmProd() {
        return idAdmProd;
    }

    public void setIdAdmProd(TipoAdministracionInsumo idAdmProd) {
        this.idAdmProd = idAdmProd;
    }

    @XmlTransient
    public List<EntradaInsumos> getEntradaInsumosList() {
        return entradaInsumosList;
    }

    public void setEntradaInsumosList(List<EntradaInsumos> entradaInsumosList) {
        this.entradaInsumosList = entradaInsumosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInsumo != null ? codInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.codInsumo == null && other.codInsumo != null) || (this.codInsumo != null && !this.codInsumo.equals(other.codInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.Insumos[ codInsumo=" + codInsumo + " ]";
    }
    
}
