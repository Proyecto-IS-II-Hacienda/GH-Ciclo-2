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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "ANIMALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animales.findAll", query = "SELECT a FROM Animales a")
    , @NamedQuery(name = "Animales.findByIdAnimal", query = "SELECT a FROM Animales a WHERE a.animalesPK.idAnimal = :idAnimal")
    , @NamedQuery(name = "Animales.findByNombreCientifico", query = "SELECT a FROM Animales a WHERE a.animalesPK.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "Animales.findByPeso", query = "SELECT a FROM Animales a WHERE a.peso = :peso")
    , @NamedQuery(name = "Animales.findByLongitudVetical", query = "SELECT a FROM Animales a WHERE a.longitudVetical = :longitudVetical")
    , @NamedQuery(name = "Animales.findByLongitudHorizontal", query = "SELECT a FROM Animales a WHERE a.longitudHorizontal = :longitudHorizontal")
    , @NamedQuery(name = "Animales.findByFechaNacimiento", query = "SELECT a FROM Animales a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Animales.findBySexo", query = "SELECT a FROM Animales a WHERE a.sexo = :sexo")})
public class Animales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnimalesPK animalesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO")
    private BigInteger peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUD_VETICAL")
    private double longitudVetical;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUD_HORIZONTAL")
    private double longitudHorizontal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO")
    private Character sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animales")
    private List<ProcesamientoAnimal> procesamientoAnimalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animales")
    private List<CuidadosAnimales> cuidadosAnimalesList;
    @JoinColumns({
        @JoinColumn(name = "NOMBRE_COMUN", referencedColumnName = "NOMBRE_COMUN")
        , @JoinColumn(name = "NOMBRE_CIENTIFICO", referencedColumnName = "NOMBRE_CIENTIFICO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TiposDeAnimales tiposDeAnimales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animales")
    private List<DistribucionesAnimales> distribucionesAnimalesList;

    public Animales() {
    }

    public Animales(AnimalesPK animalesPK) {
        this.animalesPK = animalesPK;
    }

    public Animales(AnimalesPK animalesPK, BigInteger peso, double longitudVetical, double longitudHorizontal, Date fechaNacimiento, Character sexo) {
        this.animalesPK = animalesPK;
        this.peso = peso;
        this.longitudVetical = longitudVetical;
        this.longitudHorizontal = longitudHorizontal;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Animales(String idAnimal, String nombreCientifico) {
        this.animalesPK = new AnimalesPK(idAnimal, nombreCientifico);
    }

    public AnimalesPK getAnimalesPK() {
        return animalesPK;
    }

    public void setAnimalesPK(AnimalesPK animalesPK) {
        this.animalesPK = animalesPK;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public double getLongitudVetical() {
        return longitudVetical;
    }

    public void setLongitudVetical(double longitudVetical) {
        this.longitudVetical = longitudVetical;
    }

    public double getLongitudHorizontal() {
        return longitudHorizontal;
    }

    public void setLongitudHorizontal(double longitudHorizontal) {
        this.longitudHorizontal = longitudHorizontal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public List<ProcesamientoAnimal> getProcesamientoAnimalList() {
        return procesamientoAnimalList;
    }

    public void setProcesamientoAnimalList(List<ProcesamientoAnimal> procesamientoAnimalList) {
        this.procesamientoAnimalList = procesamientoAnimalList;
    }

    @XmlTransient
    public List<CuidadosAnimales> getCuidadosAnimalesList() {
        return cuidadosAnimalesList;
    }

    public void setCuidadosAnimalesList(List<CuidadosAnimales> cuidadosAnimalesList) {
        this.cuidadosAnimalesList = cuidadosAnimalesList;
    }

    public TiposDeAnimales getTiposDeAnimales() {
        return tiposDeAnimales;
    }

    public void setTiposDeAnimales(TiposDeAnimales tiposDeAnimales) {
        this.tiposDeAnimales = tiposDeAnimales;
    }

    @XmlTransient
    public List<DistribucionesAnimales> getDistribucionesAnimalesList() {
        return distribucionesAnimalesList;
    }

    public void setDistribucionesAnimalesList(List<DistribucionesAnimales> distribucionesAnimalesList) {
        this.distribucionesAnimalesList = distribucionesAnimalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animalesPK != null ? animalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animales)) {
            return false;
        }
        Animales other = (Animales) object;
        if ((this.animalesPK == null && other.animalesPK != null) || (this.animalesPK != null && !this.animalesPK.equals(other.animalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.Animales[ animalesPK=" + animalesPK + " ]";
    }
    
}
