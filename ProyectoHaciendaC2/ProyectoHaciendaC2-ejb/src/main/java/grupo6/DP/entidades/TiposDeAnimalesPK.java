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
public class TiposDeAnimalesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_CIENTIFICO")
    private String nombreCientifico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_COMUN")
    private String nombreComun;

    public TiposDeAnimalesPK() {
    }

    public TiposDeAnimalesPK(String nombreCientifico, String nombreComun) {
        this.nombreCientifico = nombreCientifico;
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreCientifico != null ? nombreCientifico.hashCode() : 0);
        hash += (nombreComun != null ? nombreComun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeAnimalesPK)) {
            return false;
        }
        TiposDeAnimalesPK other = (TiposDeAnimalesPK) object;
        if ((this.nombreCientifico == null && other.nombreCientifico != null) || (this.nombreCientifico != null && !this.nombreCientifico.equals(other.nombreCientifico))) {
            return false;
        }
        if ((this.nombreComun == null && other.nombreComun != null) || (this.nombreComun != null && !this.nombreComun.equals(other.nombreComun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.TiposDeAnimalesPK[ nombreCientifico=" + nombreCientifico + ", nombreComun=" + nombreComun + " ]";
    }
    
}
