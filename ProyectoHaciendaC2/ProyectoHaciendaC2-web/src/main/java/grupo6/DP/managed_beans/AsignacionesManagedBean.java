/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Animales;
import grupo6.DP.entidades.Areas;
import grupo6.DP.entidades.DistribucionesAnimales;
import grupo6.DP.entidades.DistribucionesPlantas;
import grupo6.DP.entidades.Plantas;
import grupo6.MD.sesiones.AnimalesFacadeLocal;
import grupo6.MD.sesiones.AreasFacadeLocal;
import grupo6.MD.sesiones.DistribucionesAnimalesFacadeLocal;
import grupo6.MD.sesiones.DistribucionesPlantasFacadeLocal;
import grupo6.MD.sesiones.PlantasFacadeLocal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Albert
 */
@Named(value = "asignacionesManagedBean")
@ViewScoped
public class AsignacionesManagedBean implements Serializable{
    private List<Animales> animalesList;
    private List<DistribucionesAnimales> distribucionesAnimalesList;
    private List<Plantas> plantasList;
    private List<DistribucionesPlantas> distribucionesPlantasList;
    private List<Areas> areasList;

 

   
       
    @EJB
    private AnimalesFacadeLocal animalesFacadeLocal;
    private Animales animal;
    @EJB
    private DistribucionesAnimalesFacadeLocal distribucionesAnimalesFacadeLocal;
    private DistribucionesAnimales distribucionAnimal;
    @EJB
    private PlantasFacadeLocal plantasFacadeLocal;
    private Plantas planta;
    @EJB
    private DistribucionesPlantasFacadeLocal distribucionesPlantasFacadeLocal;
    private DistribucionesPlantas distribucionPlanta;
    private Areas area;
    @EJB
    private AreasFacadeLocal areasFacadeLocal;
    private boolean esNuevo;
    private boolean Seleccion;

    public List<Animales> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animales> animalesList) {
        this.animalesList = animalesList;
    }

    public List<DistribucionesAnimales> getDistribucionesAnimalesList() {
        return distribucionesAnimalesList;
    }

    public void setDistribucionesAnimalesList(List<DistribucionesAnimales> distribucionesAnimalesList) {
        this.distribucionesAnimalesList = distribucionesAnimalesList;
    }

    public List<Plantas> getPlantasList() {
        return plantasList;
    }

    public void setPlantasList(List<Plantas> plantasList) {
        this.plantasList = plantasList;
    }

    public List<DistribucionesPlantas> getDistribucionesPlantasList() {
        return distribucionesPlantasList;
    }

    public void setDistribucionesPlantasList(List<DistribucionesPlantas> distribucionesPlantasList) {
        this.distribucionesPlantasList = distribucionesPlantasList;
    }

    public Animales getAnimal() {
        return animal;
    }

    public void setAnimal(Animales animal) {
        this.animal = animal;
    }

    public DistribucionesAnimales getDistribucionAnimal() {
        return distribucionAnimal;
    }

    public void setDistribucionAnimal(DistribucionesAnimales distribucionAnimal) {
        this.distribucionAnimal = distribucionAnimal;
    }

    public Plantas getPlanta() {
        return planta;
    }

    public void setPlanta(Plantas planta) {
        this.planta = planta;
    }

    public DistribucionesPlantas getDistribucionPlanta() {
        return distribucionPlanta;
    }

    public void setDistribucionPlanta(DistribucionesPlantas distribucionPlanta) {
        this.distribucionPlanta = distribucionPlanta;
    }
    
       public List<Areas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Areas> areasList) {
        this.areasList = areasList;
    }

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }
    

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isSeleccion() {
        return Seleccion;
    }

    public void setSeleccion(boolean Seleccion) {
        this.Seleccion = Seleccion;
    }
    

    /**
     * Creates a new instance of AsignacionesManagedBean
     */
    public AsignacionesManagedBean() {
        
    }
    
    @PostConstruct
    public void init(){
        animalesList=null;
        animalesList=animalesFacadeLocal.findAll();
        plantasList=null;
        plantasList=plantasFacadeLocal.findAll();
        distribucionesAnimalesList=null;
        distribucionesAnimalesList=distribucionesAnimalesFacadeLocal.findAll();
        distribucionesPlantasList=null;
        distribucionesPlantasList=distribucionesPlantasFacadeLocal.findAll();   
        areasList=null;
        areasList=areasFacadeLocal.findAll();
        esNuevo=false;
    }
    
    
    public void nuevo(){
        if(Seleccion)
            distribucionAnimal=new DistribucionesAnimales();
        else
            distribucionPlanta=new DistribucionesPlantas();
        esNuevo=true;
    }
    
    public void grabar(){
        try{
            if(esNuevo){
                if(Seleccion)
                    distribucionesAnimalesFacadeLocal.create(distribucionAnimal);
                else
                    distribucionesPlantasFacadeLocal.create(distribucionPlanta);
            }else{
                if(Seleccion)
                    distribucionesAnimalesFacadeLocal.edit(distribucionAnimal);
                else
                    distribucionesPlantasFacadeLocal.edit(distribucionPlanta);
            }
        }catch (Exception e){
            
        }finally{
            if(Seleccion)
                distribucionAnimal=null;
            else
                distribucionPlanta=null;
            esNuevo=false;
            init();
        }   
    }
    
    
    public void cancelar(){
        if(Seleccion)
            distribucionAnimal=null;
        else
            distribucionPlanta=null;
    }
        
        public void abrirBusquedaArea(){
            
        Map<String, Object> opciones =new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);
        
        PrimeFaces.current().dialog().openDynamic("seleccion_area", opciones, null);
        }
    
    
    public void recibirArea(SelectEvent e){
        if(Seleccion)
            distribucionAnimal.setAreas((Areas) e.getObject());
        else
            distribucionPlanta.setAreas((Areas) e.getObject());
    } 
    
    
    
     public void abrirBusquedaAnimal(){
            
        Map<String, Object> opciones =new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);
        
        PrimeFaces.current().dialog().openDynamic("seleccion_animal", opciones, null);
        }
    
    
    public void recibirAnimal(SelectEvent e){
            distribucionAnimal.setAnimales((Animales) e.getObject());
    }        
}
