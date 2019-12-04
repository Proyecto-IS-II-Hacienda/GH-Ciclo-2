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
 * @author marce
 */
@Entity
@Table(name = "PROCESAMIENTOANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesamientoAnimal.findAll", query = "SELECT p FROM ProcesamientoAnimal p")
    , @NamedQuery(name = "ProcesamientoAnimal.findByNumeroprocesamiento", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.procesamientoAnimalPK.numeroprocesamiento = :numeroprocesamiento")
    , @NamedQuery(name = "ProcesamientoAnimal.findByFecha", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.procesamientoAnimalPK.fecha = :fecha")
    , @NamedQuery(name = "ProcesamientoAnimal.findByCodProducto", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.procesamientoAnimalPK.codProducto = :codProducto")
    , @NamedQuery(name = "ProcesamientoAnimal.findByMortal", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.mortal = :mortal")
    , @NamedQuery(name = "ProcesamientoAnimal.findByFechacaducidad", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.fechacaducidad = :fechacaducidad")
    , @NamedQuery(name = "ProcesamientoAnimal.findByCantidad", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProcesamientoAnimal.findByUnidades", query = "SELECT p FROM ProcesamientoAnimal p WHERE p.unidades = :unidades")})
public class ProcesamientoAnimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesamientoAnimalPK procesamientoAnimalPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MORTAL")
    private BigInteger mortal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacaducidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "UNIDADES")
    private String unidades;
    @JoinColumns({
        @JoinColumn(name = "IDANIMAL", referencedColumnName = "IDANIMAL")
        , @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO")})
    @ManyToOne(optional = false)
    private Animal animal;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesamientoAnimal")
    private List<SalidaProducto> salidaProductoList;

    public ProcesamientoAnimal() {
        procesamientoAnimalPK = new ProcesamientoAnimalPK();
    }

    public ProcesamientoAnimal(ProcesamientoAnimalPK procesamientoAnimalPK) {
        this.procesamientoAnimalPK = procesamientoAnimalPK;
    }

    public ProcesamientoAnimal(ProcesamientoAnimalPK procesamientoAnimalPK, BigInteger mortal, Date fechacaducidad, double cantidad, String unidades) {
        this.procesamientoAnimalPK = procesamientoAnimalPK;
        this.mortal = mortal;
        this.fechacaducidad = fechacaducidad;
        this.cantidad = cantidad;
        this.unidades = unidades;
    }

    public ProcesamientoAnimal(BigInteger numeroprocesamiento, Date fecha, String codProducto) {
        this.procesamientoAnimalPK = new ProcesamientoAnimalPK(numeroprocesamiento, fecha, codProducto);
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

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public List<SalidaProducto> getSalidaProductoList() {
        return salidaProductoList;
    }

    public void setSalidaProductoList(List<SalidaProducto> salidaProductoList) {
        this.salidaProductoList = salidaProductoList;
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
        return "grupo6.DP.entidades.ProcesamientoAnimal[ procesamientoAnimalPK=" + procesamientoAnimalPK + " ]";
    }
    
}
