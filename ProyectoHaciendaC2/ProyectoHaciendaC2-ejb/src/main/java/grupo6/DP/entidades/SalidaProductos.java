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
import javax.persistence.JoinColumns;
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
@Table(name = "SALIDA_PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaProductos.findAll", query = "SELECT s FROM SalidaProductos s")
    , @NamedQuery(name = "SalidaProductos.findByIdSalidaProd", query = "SELECT s FROM SalidaProductos s WHERE s.idSalidaProd = :idSalidaProd")
    , @NamedQuery(name = "SalidaProductos.findByCantidad", query = "SELECT s FROM SalidaProductos s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SalidaProductos.findByFechaSalida", query = "SELECT s FROM SalidaProductos s WHERE s.fechaSalida = :fechaSalida")})
public class SalidaProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SALIDA_PROD")
    private Integer idSalidaProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @JoinColumns({
        @JoinColumn(name = "NUMERO_PROCESAMIENTO", referencedColumnName = "NUMERO_PROCESAMIENTO")
        , @JoinColumn(name = "FECHA", referencedColumnName = "FECHA")
        , @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")})
    @ManyToOne(optional = false)
    private ProcesamientoAnimal procesamientoAnimal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salidaProductos")
    private List<Ventas> ventasList;

    public SalidaProductos() {
    }

    public SalidaProductos(Integer idSalidaProd) {
        this.idSalidaProd = idSalidaProd;
    }

    public SalidaProductos(Integer idSalidaProd, BigInteger cantidad, Date fechaSalida) {
        this.idSalidaProd = idSalidaProd;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdSalidaProd() {
        return idSalidaProd;
    }

    public void setIdSalidaProd(Integer idSalidaProd) {
        this.idSalidaProd = idSalidaProd;
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

    public ProcesamientoAnimal getProcesamientoAnimal() {
        return procesamientoAnimal;
    }

    public void setProcesamientoAnimal(ProcesamientoAnimal procesamientoAnimal) {
        this.procesamientoAnimal = procesamientoAnimal;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalidaProd != null ? idSalidaProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaProductos)) {
            return false;
        }
        SalidaProductos other = (SalidaProductos) object;
        if ((this.idSalidaProd == null && other.idSalidaProd != null) || (this.idSalidaProd != null && !this.idSalidaProd.equals(other.idSalidaProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.SalidaProductos[ idSalidaProd=" + idSalidaProd + " ]";
    }
    
}
