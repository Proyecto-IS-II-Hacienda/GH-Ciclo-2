/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcelo_Echeverria
 */
@Embeddable
public class DistribucionesAnimalesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_AREA")
    private BigInteger numeroArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ID_TIPO_AREA")
    private String idTipoArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_ANIMAL")
    private String idAnimal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_CIENTIFICO")
    private String nombreCientifico;

    public DistribucionesAnimalesPK() {
    }

    public DistribucionesAnimalesPK(BigInteger numeroArea, String idTipoArea, String idAnimal, String nombreCientifico) {
        this.numeroArea = numeroArea;
        this.idTipoArea = idTipoArea;
        this.idAnimal = idAnimal;
        this.nombreCientifico = nombreCientifico;
    }

    public BigInteger getNumeroArea() {
        return numeroArea;
    }

    public void setNumeroArea(BigInteger numeroArea) {
        this.numeroArea = numeroArea;
    }

    public String getIdTipoArea() {
        return idTipoArea;
    }

    public void setIdTipoArea(String idTipoArea) {
        this.idTipoArea = idTipoArea;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroArea != null ? numeroArea.hashCode() : 0);
        hash += (idTipoArea != null ? idTipoArea.hashCode() : 0);
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        hash += (nombreCientifico != null ? nombreCientifico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistribucionesAnimalesPK)) {
            return false;
        }
        DistribucionesAnimalesPK other = (DistribucionesAnimalesPK) object;
        if ((this.numeroArea == null && other.numeroArea != null) || (this.numeroArea != null && !this.numeroArea.equals(other.numeroArea))) {
            return false;
        }
        if ((this.idTipoArea == null && other.idTipoArea != null) || (this.idTipoArea != null && !this.idTipoArea.equals(other.idTipoArea))) {
            return false;
        }
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        if ((this.nombreCientifico == null && other.nombreCientifico != null) || (this.nombreCientifico != null && !this.nombreCientifico.equals(other.nombreCientifico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.DistribucionesAnimalesPK[ numeroArea=" + numeroArea + ", idTipoArea=" + idTipoArea + ", idAnimal=" + idAnimal + ", nombreCientifico=" + nombreCientifico + " ]";
    }
    
}
