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
 * @author vjose
 */
@Entity
@Table(name = "DISTRIBUCIONPLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribucionplanta.findAll", query = "SELECT d FROM Distribucionplanta d")
    , @NamedQuery(name = "Distribucionplanta.findByNumeroarea", query = "SELECT d FROM Distribucionplanta d WHERE d.distribucionplantaPK.numeroarea = :numeroarea")
    , @NamedQuery(name = "Distribucionplanta.findByIdtipoarea", query = "SELECT d FROM Distribucionplanta d WHERE d.distribucionplantaPK.idtipoarea = :idtipoarea")
    , @NamedQuery(name = "Distribucionplanta.findByIdplanta", query = "SELECT d FROM Distribucionplanta d WHERE d.distribucionplantaPK.idplanta = :idplanta")
    , @NamedQuery(name = "Distribucionplanta.findByNombrecientifico", query = "SELECT d FROM Distribucionplanta d WHERE d.distribucionplantaPK.nombrecientifico = :nombrecientifico")
    , @NamedQuery(name = "Distribucionplanta.findByFechaasigncion", query = "SELECT d FROM Distribucionplanta d WHERE d.fechaasigncion = :fechaasigncion")
    , @NamedQuery(name = "Distribucionplanta.findByFechasalida", query = "SELECT d FROM Distribucionplanta d WHERE d.fechasalida = :fechasalida")})
public class Distribucionplanta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DistribucionplantaPK distribucionplantaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAASIGNCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaasigncion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalida;
    @Lob
    @Column(name = "DESCRIPCIONUSO")
    private String descripcionuso;
    @JoinColumns({
        @JoinColumn(name = "NUMEROAREA", referencedColumnName = "NUMEROAREA", insertable = false, updatable = false)
        , @JoinColumn(name = "IDTIPOAREA", referencedColumnName = "IDTIPOAREA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumns({
        @JoinColumn(name = "IDPLANTA", referencedColumnName = "IDPLANTA", insertable = false, updatable = false)
        , @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Planta planta;

    public Distribucionplanta() {
    }

    public Distribucionplanta(DistribucionplantaPK distribucionplantaPK) {
        this.distribucionplantaPK = distribucionplantaPK;
    }

    public Distribucionplanta(DistribucionplantaPK distribucionplantaPK, Date fechaasigncion, Date fechasalida) {
        this.distribucionplantaPK = distribucionplantaPK;
        this.fechaasigncion = fechaasigncion;
        this.fechasalida = fechasalida;
    }

    public Distribucionplanta(BigInteger numeroarea, String idtipoarea, String idplanta, String nombrecientifico) {
        this.distribucionplantaPK = new DistribucionplantaPK(numeroarea, idtipoarea, idplanta, nombrecientifico);
    }

    public DistribucionplantaPK getDistribucionplantaPK() {
        return distribucionplantaPK;
    }

    public void setDistribucionplantaPK(DistribucionplantaPK distribucionplantaPK) {
        this.distribucionplantaPK = distribucionplantaPK;
    }

    public Date getFechaasigncion() {
        return fechaasigncion;
    }

    public void setFechaasigncion(Date fechaasigncion) {
        this.fechaasigncion = fechaasigncion;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getDescripcionuso() {
        return descripcionuso;
    }

    public void setDescripcionuso(String descripcionuso) {
        this.descripcionuso = descripcionuso;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distribucionplantaPK != null ? distribucionplantaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribucionplanta)) {
            return false;
        }
        Distribucionplanta other = (Distribucionplanta) object;
        if ((this.distribucionplantaPK == null && other.distribucionplantaPK != null) || (this.distribucionplantaPK != null && !this.distribucionplantaPK.equals(other.distribucionplantaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Distribucionplanta[ distribucionplantaPK=" + distribucionplantaPK + " ]";
    }
    
}
