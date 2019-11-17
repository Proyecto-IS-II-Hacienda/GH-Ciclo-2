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
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "PROCESAMIENTO_PLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesamientoPlanta.findAll", query = "SELECT p FROM ProcesamientoPlanta p")
    , @NamedQuery(name = "ProcesamientoPlanta.findByNumeroProcesamiento", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.procesamientoPlantaPK.numeroProcesamiento = :numeroProcesamiento")
    , @NamedQuery(name = "ProcesamientoPlanta.findByFecha", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.procesamientoPlantaPK.fecha = :fecha")
    , @NamedQuery(name = "ProcesamientoPlanta.findByCodProducto", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.procesamientoPlantaPK.codProducto = :codProducto")
    , @NamedQuery(name = "ProcesamientoPlanta.findByMortal", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.mortal = :mortal")
    , @NamedQuery(name = "ProcesamientoPlanta.findByCantidad", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProcesamientoPlanta.findByUnidad", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.unidad = :unidad")
    , @NamedQuery(name = "ProcesamientoPlanta.findByFechaCaducidad", query = "SELECT p FROM ProcesamientoPlanta p WHERE p.fechaCaducidad = :fechaCaducidad")})
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
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @JoinColumns({
        @JoinColumn(name = "ID_PLANTA", referencedColumnName = "ID_PLANTA")
        , @JoinColumn(name = "NOMBRE_CIENTIFICO", referencedColumnName = "NOMBRE_CIENTIFICO")})
    @ManyToOne(optional = false)
    private Plantas plantas;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public ProcesamientoPlanta() {
    }

    public ProcesamientoPlanta(ProcesamientoPlantaPK procesamientoPlantaPK) {
        this.procesamientoPlantaPK = procesamientoPlantaPK;
    }

    public ProcesamientoPlanta(ProcesamientoPlantaPK procesamientoPlantaPK, BigInteger mortal, double cantidad, String unidad, Date fechaCaducidad) {
        this.procesamientoPlantaPK = procesamientoPlantaPK;
        this.mortal = mortal;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public ProcesamientoPlanta(BigInteger numeroProcesamiento, Date fecha, String codProducto) {
        this.procesamientoPlantaPK = new ProcesamientoPlantaPK(numeroProcesamiento, fecha, codProducto);
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

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Plantas getPlantas() {
        return plantas;
    }

    public void setPlantas(Plantas plantas) {
        this.plantas = plantas;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
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
        return "grupo6.DP.ProcesamientoPlanta[ procesamientoPlantaPK=" + procesamientoPlantaPK + " ]";
    }
    
}
