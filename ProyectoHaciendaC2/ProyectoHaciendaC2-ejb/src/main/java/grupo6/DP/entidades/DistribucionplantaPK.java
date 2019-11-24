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
 * @author vjose
 */
@Embeddable
public class DistribucionplantaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROAREA")
    private BigInteger numeroarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "IDTIPOAREA")
    private String idtipoarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPLANTA")
    private String idplanta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRECIENTIFICO")
    private String nombrecientifico;

    public DistribucionplantaPK() {
    }

    public DistribucionplantaPK(BigInteger numeroarea, String idtipoarea, String idplanta, String nombrecientifico) {
        this.numeroarea = numeroarea;
        this.idtipoarea = idtipoarea;
        this.idplanta = idplanta;
        this.nombrecientifico = nombrecientifico;
    }

    public BigInteger getNumeroarea() {
        return numeroarea;
    }

    public void setNumeroarea(BigInteger numeroarea) {
        this.numeroarea = numeroarea;
    }

    public String getIdtipoarea() {
        return idtipoarea;
    }

    public void setIdtipoarea(String idtipoarea) {
        this.idtipoarea = idtipoarea;
    }

    public String getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(String idplanta) {
        this.idplanta = idplanta;
    }

    public String getNombrecientifico() {
        return nombrecientifico;
    }

    public void setNombrecientifico(String nombrecientifico) {
        this.nombrecientifico = nombrecientifico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroarea != null ? numeroarea.hashCode() : 0);
        hash += (idtipoarea != null ? idtipoarea.hashCode() : 0);
        hash += (idplanta != null ? idplanta.hashCode() : 0);
        hash += (nombrecientifico != null ? nombrecientifico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistribucionplantaPK)) {
            return false;
        }
        DistribucionplantaPK other = (DistribucionplantaPK) object;
        if ((this.numeroarea == null && other.numeroarea != null) || (this.numeroarea != null && !this.numeroarea.equals(other.numeroarea))) {
            return false;
        }
        if ((this.idtipoarea == null && other.idtipoarea != null) || (this.idtipoarea != null && !this.idtipoarea.equals(other.idtipoarea))) {
            return false;
        }
        if ((this.idplanta == null && other.idplanta != null) || (this.idplanta != null && !this.idplanta.equals(other.idplanta))) {
            return false;
        }
        if ((this.nombrecientifico == null && other.nombrecientifico != null) || (this.nombrecientifico != null && !this.nombrecientifico.equals(other.nombrecientifico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.DistribucionplantaPK[ numeroarea=" + numeroarea + ", idtipoarea=" + idtipoarea + ", idplanta=" + idplanta + ", nombrecientifico=" + nombrecientifico + " ]";
    }
    
}
