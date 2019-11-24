package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Planta;
import grupo6.DP.entidades.Procesamientoplanta;
import grupo6.DP.entidades.Producto;
import grupo6.MD.sesiones.PlantaFacadeLocal;
import grupo6.MD.sesiones.ProcesamientoplantaFacadeLocal;
import grupo6.MD.sesiones.ProductoFacadeLocal;
import grupo6.utilitarios.Crud;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "transPlantaManagedBean")
@ViewScoped
public class TransPlantaManagedBean implements Serializable, Crud<Procesamientoplanta> {

    private Procesamientoplanta procesamientoPlanta;
    private List<Procesamientoplanta> listaProcesamientoPlanta;
    private List<Planta> listaPlanta;
    private List<Producto> listaProducto;
    private boolean esNuevo;
    @EJB
    private ProcesamientoplantaFacadeLocal procesamientoPlantaFacadeLocal;
    @EJB
    private PlantaFacadeLocal plantaFacadeLocal;
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;

    public TransPlantaManagedBean() {
    }

    @Override
    public void nuevo() {
        esNuevo = true;
        procesamientoPlanta = new Procesamientoplanta();
    }

    @Override
    public void seleccionar(Procesamientoplanta clase) {
        esNuevo = false;
        this.procesamientoPlanta = clase;
    }

    @Override
    public void grabar() {
        try {
            if (esNuevo) {
                procesamientoPlantaFacadeLocal.create(procesamientoPlanta);
            } else {
                procesamientoPlantaFacadeLocal.edit(procesamientoPlanta);
            }
            procesamientoPlanta = null;
            init();
            notificarExito("Se han guardado los datos con éxito");
        } catch (Exception e) {
            notificarError("Ha ocurrido un error al guardar los datos");
        }
    }

    @Override
    public void eliminar(Procesamientoplanta clase) {
        procesamientoPlantaFacadeLocal.remove(clase);
        init();
        notificarExito("Se han eliminado los datos con éxito");
    }

    @Override
    public void cancelar() {
        procesamientoPlanta = null;
    }

    @Override
    @PostConstruct
    public void init() {
        listaProcesamientoPlanta = procesamientoPlantaFacadeLocal.findAll();
        listaPlanta = plantaFacadeLocal.findAll();
        listaProducto = productoFacadeLocal.findAll();
    }

    public Procesamientoplanta getProcesamientoPlanta() {
        return procesamientoPlanta;
    }

    public void setProcesamientoPlanta(Procesamientoplanta procesamientoPlanta) {
        this.procesamientoPlanta = procesamientoPlanta;
    }

    public List<Procesamientoplanta> getListaProcesamientoPlanta() {
        return listaProcesamientoPlanta;
    }

    public void setListaProcesamientoPlanta(List<Procesamientoplanta> listaProcesamientoPlanta) {
        this.listaProcesamientoPlanta = listaProcesamientoPlanta;
    }

    public List<Planta> getListaPlanta() {
        return listaPlanta;
    }

    public void setListaPlanta(List<Planta> listaPlanta) {
        this.listaPlanta = listaPlanta;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }
    
}
