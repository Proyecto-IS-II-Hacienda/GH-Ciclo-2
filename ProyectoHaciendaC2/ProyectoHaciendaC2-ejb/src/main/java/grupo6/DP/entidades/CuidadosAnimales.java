/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "CUIDADOS_ANIMALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuidadosAnimales.findAll", query = "SELECT c FROM CuidadosAnimales c")
    , @NamedQuery(name = "CuidadosAnimales.findByIdCuidado", query = "SELECT c FROM CuidadosAnimales c WHERE c.idCuidado = :idCuidado")})
public class CuidadosAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUIDADO")
    private Integer idCuidado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DOCIFICACION")
    private String docificacion;
    @JoinColumns({
        @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID_ANIMAL")
        , @JoinColumn(name = "NOMBRE_CIENTIFICO", referencedColumnName = "NOMBRE_CIENTIFICO")})
    @ManyToOne(optional = false)
    private Animales animales;
    @JoinColumn(name = "ID_SALIDA_INSUMO", referencedColumnName = "ID_SALIDA_INSUMO")
    @ManyToOne(optional = false)
    private SalidaInsumos idSalidaInsumo;

    public CuidadosAnimales() {
    }

    public CuidadosAnimales(Integer idCuidado) {
        this.idCuidado = idCuidado;
    }

    public CuidadosAnimales(Integer idCuidado, String docificacion) {
        this.idCuidado = idCuidado;
        this.docificacion = docificacion;
    }

    public Integer getIdCuidado() {
        return idCuidado;
    }

    public void setIdCuidado(Integer idCuidado) {
        this.idCuidado = idCuidado;
    }

    public String getDocificacion() {
        return docificacion;
    }

    public void setDocificacion(String docificacion) {
        this.docificacion = docificacion;
    }

    public Animales getAnimales() {
        return animales;
    }

    public void setAnimales(Animales animales) {
        this.animales = animales;
    }

    public SalidaInsumos getIdSalidaInsumo() {
        return idSalidaInsumo;
    }

    public void setIdSalidaInsumo(SalidaInsumos idSalidaInsumo) {
        this.idSalidaInsumo = idSalidaInsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuidado != null ? idCuidado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuidadosAnimales)) {
            return false;
        }
        CuidadosAnimales other = (CuidadosAnimales) object;
        if ((this.idCuidado == null && other.idCuidado != null) || (this.idCuidado != null && !this.idCuidado.equals(other.idCuidado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.CuidadosAnimales[ idCuidado=" + idCuidado + " ]";
    }
    
}
