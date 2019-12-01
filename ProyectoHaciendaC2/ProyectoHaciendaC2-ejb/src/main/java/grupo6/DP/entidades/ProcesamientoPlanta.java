/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "PROCESAMIENTOPLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesamientoPlanta.findAll", query = "SELECT p FROM ProcesamientoPlanta p")
    , @NamedQuery(name = "ProcesamientoPlanta.findByNumeroprocesamiento", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.procesamientoPlantaPK.numeroprocesamiento = :numeroprocesamiento")
    , @NamedQuery(name = "ProcesamientoPlanta.findByFecha", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.procesamientoPlantaPK.fecha = :fecha")
    , @NamedQuery(name = "ProcesamientoPlanta.findByCodProducto", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.procesamientoPlantaPK.codProducto = :codProducto")
    , @NamedQuery(name = "ProcesamientoPlanta.findByMortal", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.mortal = :mortal")
    , @NamedQuery(name = "ProcesamientoPlanta.findByCantidad", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProcesamientoPlanta.findByUnidad", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.unidad = :unidad")
    , @NamedQuery(name = "ProcesamientoPlanta.findByFechacaducidad", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.fechacaducidad = :fechacaducidad")})
public class ProcesamientoPlanta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesamientoPlantaPK procesamientoPlantaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MORTAL")
    private BigInteger mortal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "UNIDAD")
    private String unidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacaducidad;
    @JoinColumns({
        @JoinColumn(name = "IDPLANTA", referencedColumnName = "IDPLANTA")
        , @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO")})
    @ManyToOne(optional = false)
    private Planta planta;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public ProcesamientoPlanta() {
    }

    public ProcesamientoPlanta(ProcesamientoPlantaPK procesamientoPlantaPK) {
        this.procesamientoPlantaPK = procesamientoPlantaPK;
    }

    public ProcesamientoPlanta(ProcesamientoPlantaPK procesamientoPlantaPK, BigInteger mortal, double cantidad, String unidad, Date fechacaducidad) {
        this.procesamientoPlantaPK = procesamientoPlantaPK;
        this.mortal = mortal;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.fechacaducidad = fechacaducidad;
    }

    public ProcesamientoPlanta(BigInteger numeroprocesamiento, Date fecha, String codProducto) {
        this.procesamientoPlantaPK = new ProcesamientoPlantaPK(numeroprocesamiento, fecha, codProducto);
    }

    public ProcesamientoPlantaPK getProcesamientoPlantaPK() {
        return procesamientoPlantaPK;
    }

    public void setProcesamientoPlantaPK(ProcesamientoPlantaPK procesamientoPlantaPK) {
        this.procesamientoPlantaPK = procesamientoPlantaPK;
    }

    public BigInteger getMortal() {
        return mortal;
    }

    public void setMortal(BigInteger mortal) {
        this.mortal = mortal;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesamientoPlantaPK != null ? procesamientoPlantaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesamientoPlanta)) {
            return false;
        }
        ProcesamientoPlanta other = (ProcesamientoPlanta) object;
        if ((this.procesamientoPlantaPK == null && other.procesamientoPlantaPK != null) || (this.procesamientoPlantaPK != null && !this.procesamientoPlantaPK.equals(other.procesamientoPlantaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.ProcesamientoPlanta[ procesamientoPlantaPK=" + procesamientoPlantaPK + " ]";
    }
    
}
