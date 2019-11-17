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
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "VENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdFactura", query = "SELECT v FROM Ventas v WHERE v.ventasPK.idFactura = :idFactura")
    , @NamedQuery(name = "Ventas.findByIdSalidaProd", query = "SELECT v FROM Ventas v WHERE v.ventasPK.idSalidaProd = :idSalidaProd")
    , @NamedQuery(name = "Ventas.findByCedula", query = "SELECT v FROM Ventas v WHERE v.ventasPK.cedula = :cedula")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasPK ventasPK;
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JoinColumn(name = "ID_SALIDA_PROD", referencedColumnName = "ID_SALIDA_PROD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalidaProductos salidaProductos;

    public Ventas() {
    }

    public Ventas(VentasPK ventasPK) {
        this.ventasPK = ventasPK;
    }

    public Ventas(String idFactura, BigInteger idSalidaProd, String cedula) {
        this.ventasPK = new VentasPK(idFactura, idSalidaProd, cedula);
    }

    public VentasPK getVentasPK() {
        return ventasPK;
    }

    public void setVentasPK(VentasPK ventasPK) {
        this.ventasPK = ventasPK;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public SalidaProductos getSalidaProductos() {
        return salidaProductos;
    }

    public void setSalidaProductos(SalidaProductos salidaProductos) {
        this.salidaProductos = salidaProductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasPK != null ? ventasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.ventasPK == null && other.ventasPK != null) || (this.ventasPK != null && !this.ventasPK.equals(other.ventasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.Ventas[ ventasPK=" + ventasPK + " ]";
    }
    
}
