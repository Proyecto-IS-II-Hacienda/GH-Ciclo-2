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
public class AreasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_AREA")
    private BigInteger numeroArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ID_TIPO_AREA")
    private String idTipoArea;

    public AreasPK() {
    }

    public AreasPK(BigInteger numeroArea, String idTipoArea) {
        this.numeroArea = numeroArea;
        this.idTipoArea = idTipoArea;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroArea != null ? numeroArea.hashCode() : 0);
        hash += (idTipoArea != null ? idTipoArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasPK)) {
            return false;
        }
        AreasPK other = (AreasPK) object;
        if ((this.numeroArea == null && other.numeroArea != null) || (this.numeroArea != null && !this.numeroArea.equals(other.numeroArea))) {
            return false;
        }
        if ((this.idTipoArea == null && other.idTipoArea != null) || (this.idTipoArea != null && !this.idTipoArea.equals(other.idTipoArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.AreasPK[ numeroArea=" + numeroArea + ", idTipoArea=" + idTipoArea + " ]";
    }
    
}
