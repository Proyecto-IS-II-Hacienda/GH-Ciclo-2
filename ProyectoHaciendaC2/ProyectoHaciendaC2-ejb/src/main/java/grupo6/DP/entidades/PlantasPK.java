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
public class PlantasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_PLANTA")
    private String idPlanta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_CIENTIFICO")
    private String nombreCientifico;

    public PlantasPK() {
    }

    public PlantasPK(String idPlanta, String nombreCientifico) {
        this.idPlanta = idPlanta;
        this.nombreCientifico = nombreCientifico;
    }

    public String getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(String idPlanta) {
        this.idPlanta = idPlanta;
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
        hash += (idPlanta != null ? idPlanta.hashCode() : 0);
        hash += (nombreCientifico != null ? nombreCientifico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantasPK)) {
            return false;
        }
        PlantasPK other = (PlantasPK) object;
        if ((this.idPlanta == null && other.idPlanta != null) || (this.idPlanta != null && !this.idPlanta.equals(other.idPlanta))) {
            return false;
        }
        if ((this.nombreCientifico == null && other.nombreCientifico != null) || (this.nombreCientifico != null && !this.nombreCientifico.equals(other.nombreCientifico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.PlantasPK[ idPlanta=" + idPlanta + ", nombreCientifico=" + nombreCientifico + " ]";
    }
    
}
