/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Animales;
import grupo6.DP.entidades.ProcesamientoAnimal;
import grupo6.DP.entidades.Productos;
import grupo6.MD.sesiones.AnimalesFacadeLocal;
import grupo6.MD.sesiones.ProcesamientoAnimalFacadeLocal;
import grupo6.MD.sesiones.ProductosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author XavierJC
 */
@Named(value = "transAnimalManagedBean")
@ViewScoped
public class TransAnimalesManagedBean implements Serializable {
    
    private ProcesamientoAnimal procesamientoAnimal;
    private List<ProcesamientoAnimal> procesamientoAnimalList;
    private List<Animales> animalesList;
    private List<Productos> productosList;
    private boolean edicion;
    
    @EJB
    private ProductosFacadeLocal productosFacadeLocal;
    
    @EJB
    private AnimalesFacadeLocal animalesFacadeLocal;
    
    @EJB
    private ProcesamientoAnimalFacadeLocal procesamientoAnimalFacadeLocal;
    
    public TransAnimalesManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        procesamientoAnimalList = procesamientoAnimalFacadeLocal.findAll();
        animalesList = animalesFacadeLocal.findAll();
        productosList = productosFacadeLocal.findAll();
    }
    
    public void grabar() {
        
        try {
            procesamientoAnimal.getProcesamientoAnimalPK().setCodProducto(procesamientoAnimal.getProductos().getCodProducto());
            if (edicion) {  //
                procesamientoAnimalFacadeLocal.edit(procesamientoAnimal);                             
            } else {
                 procesamientoAnimalFacadeLocal.create(procesamientoAnimal);
            }
            init();
            procesamientoAnimal = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "el producto Animal sea gravado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "error", "ocurrio un error al gravar el producto animal"));
        }
        
    }
    
    public List<ProcesamientoAnimal> getProcesamientoAnimalList() {
        return procesamientoAnimalList;
    }
    
    public void setProcesamientoAnimalList(List<ProcesamientoAnimal> procesamientoAnimalList) {
        this.procesamientoAnimalList = procesamientoAnimalList;
    }
    
    public List<Animales> getAnimalesList() {
        return animalesList;
    }
    
    public void setAnimalesList(List<Animales> animalesList) {
        this.animalesList = animalesList;
    }
    
    public List<Productos> getProductosList() {
        return productosList;
    }
    
    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }
    
    public boolean isEdicion() {
        return edicion;
    }
    
    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }
    
    public ProcesamientoAnimal getProcesamientoAnimal() {
        return procesamientoAnimal;
    }
    
    public void setProcesamientoAnimal(ProcesamientoAnimal procesamientoAnimal) {
        this.procesamientoAnimal = procesamientoAnimal;
    }
    
    public void nuevo() {
        edicion = false;
        procesamientoAnimal = new ProcesamientoAnimal();
        
    }

    public void cancelar() {
        procesamientoAnimal = null;
    }
    
    public void selecionar(ProcesamientoAnimal procesamientoAnimal) {
        edicion = true;
        this.procesamientoAnimal = procesamientoAnimal;
    }

    public void eliminar(ProcesamientoAnimal procesamientoAnimal) {
        procesamientoAnimalFacadeLocal.remove(procesamientoAnimal);
        init();        
    }
    
}
