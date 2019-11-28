package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Procesamientoanimal;
import grupo6.DP.entidades.Salidaproducto;
import grupo6.MD.sesiones.ClienteFacadeLocal;
import grupo6.MD.sesiones.ProcesamientoanimalFacadeLocal;
import grupo6.MD.sesiones.SalidaproductoFacadeLocal;
import grupo6.MD.sesiones.VentaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Marcelo_Echeverria
 */
@Named(value = "ventaMB")
@ViewScoped
public class VentaManagedBean implements Serializable {

    @EJB
    private ProcesamientoanimalFacadeLocal procesamientoanimalFacadeLocal;
    @EJB
    private SalidaproductoFacadeLocal salidaproductoFacadeLocal;
    @EJB
    private VentaFacadeLocal ventaFacadeLocal;
    @EJB
    private ClienteFacadeLocal clienteFacadeLocal;

    private Procesamientoanimal producto;
    private List<Procesamientoanimal> productos;
    private List<Salidaproducto> productosPreVenta;

    public Procesamientoanimal getProducto() {
        return producto;
    }

    public void setProducto(Procesamientoanimal producto) {
        this.producto = producto;
    }

    public List<Procesamientoanimal> getProductos() {
        return productos;
    }

    public void setProductos(List<Procesamientoanimal> productos) {
        this.productos = productos;
    }


    public List<Salidaproducto> getProductosPreVenta() {
        return productosPreVenta;
    }

    public void setProductosPreVenta(List<Salidaproducto> productosPreVenta) {
        this.productosPreVenta = productosPreVenta;
    }

    public VentaManagedBean() {
    }

    @PostConstruct
    public void onInit() {
        productos = procesamientoanimalFacadeLocal.findAll();
        productosPreVenta = new ArrayList<>();
        productos.stream().map((p) -> {
            Salidaproducto sp = new Salidaproducto();
            sp.setProcesamientoanimal(p);
            return sp;
        }).forEachOrdered((sp) -> {
            productosPreVenta.add(sp);
        });
    }

    private void equilibrarInventario() {
    }

    
    public void productoListener(ValueChangeEvent e){
        producto = (Procesamientoanimal)e.getNewValue();
        
    }   
    
   /* 
    public void onRowEdit(RowEditEvent<Car> event) {
        FacesMessage msg = new FacesMessage("Car Edited", event.getObject().getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent<Car> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
*/

    public void nuevoProducto() {
        Salidaproducto salidaProducto = new Salidaproducto();
        try {
            salidaProducto.setProcesamientoanimal(productos.get(0));
            productosPreVenta.add(salidaProducto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
