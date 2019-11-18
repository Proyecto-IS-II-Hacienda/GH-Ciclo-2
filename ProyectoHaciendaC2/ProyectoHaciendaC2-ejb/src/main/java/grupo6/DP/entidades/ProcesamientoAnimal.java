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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "PROCESAMIENTO_ANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesamientoAnimal.findAll", query = "SELECT p FROM ProcesamientoAnimal p")
    , @NamedQuery(name = "ProcesamientoAnimal.findByNumeroProcesamiento", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.procesamientoAnimalPK.numeroProcesamiento = :numeroProcesamiento")
    , @NamedQuery(name = "ProcesamientoAnimal.findByFecha", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.procesamientoAnimalPK.fecha = :fecha")
    , @NamedQuery(name = "ProcesamientoAnimal.findByCodProducto", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.procesamientoAnimalPK.codProducto = :codProducto")
    , @NamedQuery(name = "ProcesamientoAnimal.findByMortal", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.mortal = :mortal")
    , @NamedQuery(name = "ProcesamientoAnimal.findByFechaCaducidad", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.fechaCaducidad = :fechaCaducidad")})
public class ProcesamientoAnimal implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private double cantidad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ATTRIBUTE_8")
    private double attribute8;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "UNIDADES")
    private String unidades;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesamientoAnimalPK procesamientoAnimalPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MORTAL")
    private BigInteger mortal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesamientoAnimal")
    private List<SalidaProductos> salidaProductosList;
    @JoinColumns({
        @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID_ANIMAL")
        , @JoinColumn(name = "NOMBRE_CIENTIFICO", referencedColumnName = "NOMBRE_CIENTIFICO")})
    @ManyToOne(optional = false)
    private Animales animales;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public ProcesamientoAnimal() {
    }

    public ProcesamientoAnimal(ProcesamientoAnimalPK procesamientoAnimalPK) {
        this.procesamientoAnimalPK = procesamientoAnimalPK;
    }

    public ProcesamientoAnimal(ProcesamientoAnimalPK procesamientoAnimalPK, BigInteger mortal, Date fechaCaducidad) {
        this.procesamientoAnimalPK = procesamientoAnimalPK;
        this.mortal = mortal;
        this.fechaCaducidad = fechaCaducidad;
    }

    public ProcesamientoAnimal(BigInteger numeroProcesamiento, Date fecha, String codProducto) {
        this.procesamientoAnimalPK = new ProcesamientoAnimalPK(numeroProcesamiento, fecha, codProducto);
    }

    public ProcesamientoAnimalPK getProcesamientoAnimalPK() {
        return procesamientoAnimalPK;
    }

    public void setProcesamientoAnimalPK(ProcesamientoAnimalPK procesamientoAnimalPK) {
        this.procesamientoAnimalPK = procesamientoAnimalPK;
    }

    public BigInteger getMortal() {
        return mortal;
    }

    public void setMortal(BigInteger mortal) {
        this.mortal = mortal;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @XmlTransient
    public List<SalidaProductos> getSalidaProductosList() {
        return salidaProductosList;
    }

    public void setSalidaProductosList(List<SalidaProductos> salidaProductosList) {
        this.salidaProductosList = salidaProductosList;
    }

    public Animales getAnimales() {
        return animales;
    }

    public void setAnimales(Animales animales) {
        this.animales = animales;
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
        hash += (procesamientoAnimalPK != null ? procesamientoAnimalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesamientoAnimal)) {
            return false;
        }
        ProcesamientoAnimal other = (ProcesamientoAnimal) object;
        if ((this.procesamientoAnimalPK == null && other.procesamientoAnimalPK != null) || (this.procesamientoAnimalPK != null && !this.procesamientoAnimalPK.equals(other.procesamientoAnimalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.ProcesamientoAnimal[ procesamientoAnimalPK=" + procesamientoAnimalPK + " ]";
    }

    public double getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(double attribute8) {
        this.attribute8 = attribute8;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
}
