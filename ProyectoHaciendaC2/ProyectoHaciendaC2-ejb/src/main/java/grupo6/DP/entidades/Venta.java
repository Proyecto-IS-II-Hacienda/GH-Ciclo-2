/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vjose
 */
@Entity
@Table(name = "VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdfactura", query = "SELECT v FROM Venta v WHERE v.ventaPK.idfactura = :idfactura")
    , @NamedQuery(name = "Venta.findByIdsalidaproducto", query = "SELECT v FROM Venta v WHERE v.ventaPK.idsalidaproducto = :idsalidaproducto")
    , @NamedQuery(name = "Venta.findByCedula", query = "SELECT v FROM Venta v WHERE v.ventaPK.cedula = :cedula")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaPK ventaPK;
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "IDSALIDAPRODUCTO", referencedColumnName = "IDSALIDAPRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Salidaproducto salidaproducto;

    public Venta() {
    }

    public Venta(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public Venta(String idfactura, BigInteger idsalidaproducto, String cedula) {
        this.ventaPK = new VentaPK(idfactura, idsalidaproducto, cedula);
    }

    public VentaPK getVentaPK() {
        return ventaPK;
    }

    public void setVentaPK(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Salidaproducto getSalidaproducto() {
        return salidaproducto;
    }

    public void setSalidaproducto(Salidaproducto salidaproducto) {
        this.salidaproducto = salidaproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaPK != null ? ventaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.ventaPK == null && other.ventaPK != null) || (this.ventaPK != null && !this.ventaPK.equals(other.ventaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Venta[ ventaPK=" + ventaPK + " ]";
    }
    
}
