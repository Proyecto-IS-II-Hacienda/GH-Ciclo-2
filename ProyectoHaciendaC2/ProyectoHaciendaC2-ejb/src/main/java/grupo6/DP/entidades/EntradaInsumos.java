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
@Table(name = "ENTRADA_INSUMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaInsumos.findAll", query = "SELECT e FROM EntradaInsumos e")
    , @NamedQuery(name = "EntradaInsumos.findByIdCompraInsumo", query = "SELECT e FROM EntradaInsumos e WHERE e.idCompraInsumo = :idCompraInsumo")
    , @NamedQuery(name = "EntradaInsumos.findByFechaCompra", query = "SELECT e FROM EntradaInsumos e WHERE e.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "EntradaInsumos.findByCantidad", query = "SELECT e FROM EntradaInsumos e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "EntradaInsumos.findByFechaCaducidad", query = "SELECT e FROM EntradaInsumos e WHERE e.fechaCaducidad = :fechaCaducidad")})
public class EntradaInsumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPRA_INSUMO")
    private Integer idCompraInsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @JoinColumn(name = "COD_INSUMO", referencedColumnName = "COD_INSUMO")
    @ManyToOne(optional = false)
    private Insumos codInsumo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompraInsumo")
    private List<SalidaInsumos> salidaInsumosList;

    public EntradaInsumos() {
    }

    public EntradaInsumos(Integer idCompraInsumo) {
        this.idCompraInsumo = idCompraInsumo;
    }

    public EntradaInsumos(Integer idCompraInsumo, Date fechaCompra, Date cantidad, Date fechaCaducidad) {
        this.idCompraInsumo = idCompraInsumo;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public Integer getIdCompraInsumo() {
        return idCompraInsumo;
    }

    public void setIdCompraInsumo(Integer idCompraInsumo) {
        this.idCompraInsumo = idCompraInsumo;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getCantidad() {
        return cantidad;
    }

    public void setCantidad(Date cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Insumos getCodInsumo() {
        return codInsumo;
    }

    public void setCodInsumo(Insumos codInsumo) {
        this.codInsumo = codInsumo;
    }

    @XmlTransient
    public List<SalidaInsumos> getSalidaInsumosList() {
        return salidaInsumosList;
    }

    public void setSalidaInsumosList(List<SalidaInsumos> salidaInsumosList) {
        this.salidaInsumosList = salidaInsumosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraInsumo != null ? idCompraInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaInsumos)) {
            return false;
        }
        EntradaInsumos other = (EntradaInsumos) object;
        if ((this.idCompraInsumo == null && other.idCompraInsumo != null) || (this.idCompraInsumo != null && !this.idCompraInsumo.equals(other.idCompraInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.EntradaInsumos[ idCompraInsumo=" + idCompraInsumo + " ]";
    }
    
}
