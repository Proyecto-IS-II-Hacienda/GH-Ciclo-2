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
public class VentasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ID_FACTURA")
    private String idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SALIDA_PROD")
    private BigInteger idSalidaProd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CEDULA")
    private String cedula;

    public VentasPK() {
    }

    public VentasPK(String idFactura, BigInteger idSalidaProd, String cedula) {
        this.idFactura = idFactura;
        this.idSalidaProd = idSalidaProd;
        this.cedula = cedula;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public BigInteger getIdSalidaProd() {
        return idSalidaProd;
    }

    public void setIdSalidaProd(BigInteger idSalidaProd) {
        this.idSalidaProd = idSalidaProd;
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
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        hash += (idSalidaProd != null ? idSalidaProd.hashCode() : 0);
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasPK)) {
            return false;
        }
        VentasPK other = (VentasPK) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        if ((this.idSalidaProd == null && other.idSalidaProd != null) || (this.idSalidaProd != null && !this.idSalidaProd.equals(other.idSalidaProd))) {
            return false;
        }
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.VentasPK[ idFactura=" + idFactura + ", idSalidaProd=" + idSalidaProd + ", cedula=" + cedula + " ]";
    }
    
}
