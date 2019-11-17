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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "DISTRIBUCIONES_ANIMALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DistribucionesAnimales.findAll", query = "SELECT d FROM DistribucionesAnimales d")
    , @NamedQuery(name = "DistribucionesAnimales.findByNumeroArea", query = "SELECT d FROM DistribucionesAnimales d WHERE d.distribucionesAnimalesPK.numeroArea = :numeroArea")
    , @NamedQuery(name = "DistribucionesAnimales.findByIdTipoArea", query = "SELECT d FROM DistribucionesAnimales d WHERE d.distribucionesAnimalesPK.idTipoArea = :idTipoArea")
    , @NamedQuery(name = "DistribucionesAnimales.findByIdAnimal", query = "SELECT d FROM DistribucionesAnimales d WHERE d.distribucionesAnimalesPK.idAnimal = :idAnimal")
    , @NamedQuery(name = "DistribucionesAnimales.findByNombreCientifico", query = "SELECT d FROM DistribucionesAnimales d WHERE d.distribucionesAnimalesPK.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "DistribucionesAnimales.findByFechaAsignacion", query = "SELECT d FROM DistribucionesAnimales d WHERE d.fechaAsignacion = :fechaAsignacion")
    , @NamedQuery(name = "DistribucionesAnimales.findByFechaSalida", query = "SELECT d FROM DistribucionesAnimales d WHERE d.fechaSalida = :fechaSalida")})
public class DistribucionesAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DistribucionesAnimalesPK distribucionesAnimalesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Lob
    @Column(name = "DESCRIPCION_USO")
    private String descripcionUso;
    @JoinColumns({
        @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID_ANIMAL", insertable = false, updatable = false)
        , @JoinColumn(name = "NOMBRE_CIENTIFICO", referencedColumnName = "NOMBRE_CIENTIFICO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Animales animales;
    @JoinColumns({
        @JoinColumn(name = "NUMERO_AREA", referencedColumnName = "NUMERO_AREA", insertable = false, updatable = false)
        , @JoinColumn(name = "ID_TIPO_AREA", referencedColumnName = "ID_TIPO_AREA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Areas areas;

    public DistribucionesAnimales() {
    }

    public DistribucionesAnimales(DistribucionesAnimalesPK distribucionesAnimalesPK) {
        this.distribucionesAnimalesPK = distribucionesAnimalesPK;
    }

    public DistribucionesAnimales(DistribucionesAnimalesPK distribucionesAnimalesPK, Date fechaAsignacion, Date fechaSalida) {
        this.distribucionesAnimalesPK = distribucionesAnimalesPK;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaSalida = fechaSalida;
    }

    public DistribucionesAnimales(BigInteger numeroArea, String idTipoArea, String idAnimal, String nombreCientifico) {
        this.distribucionesAnimalesPK = new DistribucionesAnimalesPK(numeroArea, idTipoArea, idAnimal, nombreCientifico);
    }

    public DistribucionesAnimalesPK getDistribucionesAnimalesPK() {
        return distribucionesAnimalesPK;
    }

    public void setDistribucionesAnimalesPK(DistribucionesAnimalesPK distribucionesAnimalesPK) {
        this.distribucionesAnimalesPK = distribucionesAnimalesPK;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcionUso() {
        return descripcionUso;
    }

    public void setDescripcionUso(String descripcionUso) {
        this.descripcionUso = descripcionUso;
    }

    public Animales getAnimales() {
        return animales;
    }

    public void setAnimales(Animales animales) {
        this.animales = animales;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distribucionesAnimalesPK != null ? distribucionesAnimalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistribucionesAnimales)) {
            return false;
        }
        DistribucionesAnimales other = (DistribucionesAnimales) object;
        if ((this.distribucionesAnimalesPK == null && other.distribucionesAnimalesPK != null) || (this.distribucionesAnimalesPK != null && !this.distribucionesAnimalesPK.equals(other.distribucionesAnimalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.DistribucionesAnimales[ distribucionesAnimalesPK=" + distribucionesAnimalesPK + " ]";
    }
    
}
