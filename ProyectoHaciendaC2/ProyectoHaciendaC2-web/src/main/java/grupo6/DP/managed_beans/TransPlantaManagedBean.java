package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Plantas;
import grupo6.DP.entidades.ProcesamientoPlanta;
import grupo6.DP.entidades.Productos;
import grupo6.MD.sesiones.PlantasFacadeLocal;
import grupo6.MD.sesiones.ProcesamientoPlantaFacadeLocal;
import grupo6.MD.sesiones.ProductosFacadeLocal;
import grupo6.utilitarios.Crud;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "transPlantaManagedBean")
@ViewScoped
public class TransPlantaManagedBean implements Serializable, Crud<ProcesamientoPlanta> {

    private ProcesamientoPlanta procesamientoPlanta;
    private List<ProcesamientoPlanta> listaProcesamientoPlantas;
    private List<Plantas> listaPlantas;
    private List<Productos> listaProductos;
    private boolean esNuevo;
    @EJB
    private ProcesamientoPlantaFacadeLocal procesamientoPlantaFacadeLocal;
    @EJB
    private PlantasFacadeLocal plantasFacadeLocal;
    @EJB
    private ProductosFacadeLocal productosFacadeLocal;

    public TransPlantaManagedBean() {
    }

    @Override
    public void nuevo() {
        esNuevo = true;
        procesamientoPlanta = new ProcesamientoPlanta();
    }

    @Override
    public void seleccionar(ProcesamientoPlanta clase) {
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
    public void eliminar(ProcesamientoPlanta clase) {
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
        listaProcesamientoPlantas = procesamientoPlantaFacadeLocal.findAll();
        listaPlantas = plantasFacadeLocal.findAll();
        listaProductos = productosFacadeLocal.findAll();
    }

    public ProcesamientoPlanta getProcesamientoPlanta() {
        return procesamientoPlanta;
    }

    public void setProcesamientoPlanta(ProcesamientoPlanta procesamientoPlanta) {
        this.procesamientoPlanta = procesamientoPlanta;
    }

    public List<ProcesamientoPlanta> getListaProcesamientoPlantas() {
        return listaProcesamientoPlantas;
    }

    public void setListaProcesamientoPlantas(List<ProcesamientoPlanta> listaProcesamientoPlantas) {
        this.listaProcesamientoPlantas = listaProcesamientoPlantas;
    }

    public List<Plantas> getListaPlantas() {
        return listaPlantas;
    }

    public void setListaPlantas(List<Plantas> listaPlantas) {
        this.listaPlantas = listaPlantas;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

}
