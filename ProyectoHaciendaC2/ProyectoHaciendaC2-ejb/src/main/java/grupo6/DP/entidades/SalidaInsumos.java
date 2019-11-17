/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "SALIDA_INSUMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaInsumos.findAll", query = "SELECT s FROM SalidaInsumos s")
    , @NamedQuery(name = "SalidaInsumos.findByIdSalidaInsumo", query = "SELECT s FROM SalidaInsumos s WHERE s.idSalidaInsumo = :idSalidaInsumo")
    , @NamedQuery(name = "SalidaInsumos.findByCantidad", query = "SELECT s FROM SalidaInsumos s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SalidaInsumos.findByFechaSalida", query = "SELECT s FROM SalidaInsumos s WHERE s.fechaSalida = :fechaSalida")})
public class SalidaInsumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SALIDA_INSUMO")
    private Integer idSalidaInsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalidaInsumo")
    private List<CuidadosPlantas> cuidadosPlantasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalidaInsumo")
    private List<CuidadosAnimales> cuidadosAnimalesList;
    @JoinColumn(name = "ID_COMPRA_INSUMO", referencedColumnName = "ID_COMPRA_INSUMO")
    @ManyToOne(optional = false)
    private EntradaInsumos idCompraInsumo;

    public SalidaInsumos() {
    }

    public SalidaInsumos(Integer idSalidaInsumo) {
        this.idSalidaInsumo = idSalidaInsumo;
    }

    public SalidaInsumos(Integer idSalidaInsumo, BigInteger cantidad, Date fechaSalida) {
        this.idSalidaInsumo = idSalidaInsumo;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdSalidaInsumo() {
        return idSalidaInsumo;
    }

    public void setIdSalidaInsumo(Integer idSalidaInsumo) {
        this.idSalidaInsumo = idSalidaInsumo;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @XmlTransient
    public List<CuidadosPlantas> getCuidadosPlantasList() {
        return cuidadosPlantasList;
    }

    public void setCuidadosPlantasList(List<CuidadosPlantas> cuidadosPlantasList) {
        this.cuidadosPlantasList = cuidadosPlantasList;
    }

    @XmlTransient
    public List<CuidadosAnimales> getCuidadosAnimalesList() {
        return cuidadosAnimalesList;
    }

    public void setCuidadosAnimalesList(List<CuidadosAnimales> cuidadosAnimalesList) {
        this.cuidadosAnimalesList = cuidadosAnimalesList;
    }

    public EntradaInsumos getIdCompraInsumo() {
        return idCompraInsumo;
    }

    public void setIdCompraInsumo(EntradaInsumos idCompraInsumo) {
        this.idCompraInsumo = idCompraInsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalidaInsumo != null ? idSalidaInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaInsumos)) {
            return false;
        }
        SalidaInsumos other = (SalidaInsumos) object;
        if ((this.idSalidaInsumo == null && other.idSalidaInsumo != null) || (this.idSalidaInsumo != null && !this.idSalidaInsumo.equals(other.idSalidaInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.SalidaInsumos[ idSalidaInsumo=" + idSalidaInsumo + " ]";
    }
    
}
