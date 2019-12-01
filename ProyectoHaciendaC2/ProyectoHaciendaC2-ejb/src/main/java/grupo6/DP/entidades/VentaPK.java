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
 * @author marce
 */
@Embeddable
public class VentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "IDFACTURA")
    private String idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSALIDAPRODUCTO")
    private BigInteger idsalidaproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CEDULA")
    private String cedula;

    public VentaPK() {
    }

    public VentaPK(String idfactura, BigInteger idsalidaproducto, String cedula) {
        this.idfactura = idfactura;
        this.idsalidaproducto = idsalidaproducto;
        this.cedula = cedula;
    }

    public String getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(String idfactura) {
        this.idfactura = idfactura;
    }

    public BigInteger getIdsalidaproducto() {
        return idsalidaproducto;
    }

    public void setIdsalidaproducto(BigInteger idsalidaproducto) {
        this.idsalidaproducto = idsalidaproducto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        hash += (idsalidaproducto != null ? idsalidaproducto.hashCode() : 0);
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaPK)) {
            return false;
        }
        VentaPK other = (VentaPK) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        if ((this.idsalidaproducto == null && other.idsalidaproducto != null) || (this.idsalidaproducto != null && !this.idsalidaproducto.equals(other.idsalidaproducto))) {
            return false;
        }
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.VentaPK[ idfactura=" + idfactura + ", idsalidaproducto=" + idsalidaproducto + ", cedula=" + cedula + " ]";
    }
    
}
