/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
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
public class AnimalesPK implements Serializable {

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

    public AnimalesPK() {
    }

    public AnimalesPK(String idAnimal, String nombreCientifico) {
        this.idAnimal = idAnimal;
        this.nombreCientifico = nombreCientifico;
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
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        hash += (nombreCientifico != null ? nombreCientifico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimalesPK)) {
            return false;
        }
        AnimalesPK other = (AnimalesPK) object;
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
        return "grupo6.DP.AnimalesPK[ idAnimal=" + idAnimal + ", nombreCientifico=" + nombreCientifico + " ]";
    }
    
}
