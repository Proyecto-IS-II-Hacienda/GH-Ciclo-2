package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Clientes;
import grupo6.DP.entidades.ProcesamientoAnimal;
import grupo6.DP.entidades.Productos;
import grupo6.DP.entidades.SalidaProductos;
import grupo6.DP.entidades.Ventas;
import grupo6.MD.sesiones.ClientesFacadeLocal;
import grupo6.MD.sesiones.ProcesamientoAnimalFacadeLocal;
import grupo6.MD.sesiones.SalidaProductosFacadeLocal;
import grupo6.MD.sesiones.VentasFacadeLocal;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author Marcelo_Echeverria
 */
@Named(value = "ventaMB")
@ViewScoped
public class VentaManagedBean implements Serializable {

    private Clientes cliente;
    private SalidaProductos salidaProducto;
    private ProcesamientoAnimal productoUsable;
    private Ventas venta;
    private List<Clientes> clientes;
    private List<ProcesamientoAnimal> productos;
    private List<ProcesamientoAnimal> productosComprados;

    @EJB
    private ClientesFacadeLocal clienteFacadeLocal;
    @EJB
    private SalidaProductosFacadeLocal salidaProductoFacadeLocal;
    @EJB
    private ProcesamientoAnimalFacadeLocal productoUsableFacadeLocal;
    @EJB
    private VentasFacadeLocal ventaFacadeLocal;

    public VentaManagedBean() {
    }

    @PostConstruct
    public void onInit() {
        cliente = new Clientes();
        salidaProducto = new SalidaProductos();
        productoUsable = new ProcesamientoAnimal();
        venta = new Ventas();
        clientes = clienteFacadeLocal.findAll();
        productos = productoUsableFacadeLocal.findAll();
        productosComprados = new ArrayList<>();
    }

    public void nuevaVenta() {
        ProcesamientoAnimal PAN = productos.get(0) == null ? new ProcesamientoAnimal() : productos.get(0);
        productosComprados.add(PAN);
    }

    private void equilibrarInventario() {
    }
    
    private void vender(){
        for (ProcesamientoAnimal pa : productosComprados) {
            SalidaProductos sa = new SalidaProductos();
            sa.setProcesamientoAnimal(pa);
            sa.setCantidad(pa.getCantidad());
            sa.setFechaSalida(Date.from(Instant.MIN));
            salidaProductoFacadeLocal.create(sa
                    );
        }
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public SalidaProductos getSalidaProducto() {
        return salidaProducto;
    }

    public void setSalidaProducto(SalidaProductos salidaProducto) {
        this.salidaProducto = salidaProducto;
    }

    public ProcesamientoAnimal getProductoUsable() {
        return productoUsable;
    }

    public void setProductoUsable(ProcesamientoAnimal productoUsable) {
        this.productoUsable = productoUsable;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public List<ProcesamientoAnimal> getProductos() {
        return productos;
    }

    public void setProductos(List<ProcesamientoAnimal> productos) {
        this.productos = productos;
    }

    public List<ProcesamientoAnimal> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(List<ProcesamientoAnimal> productosComprados) {
        this.productosComprados = productosComprados;
    }

}
