/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Animal;
import grupo6.DP.entidades.Area;
import grupo6.DP.entidades.Distribucionanimal;
import grupo6.DP.entidades.DistribucionanimalPK;
import grupo6.DP.entidades.Distribucionplanta;
import grupo6.DP.entidades.Planta;
import grupo6.MD.sesiones.AnimalFacadeLocal;
import grupo6.MD.sesiones.AreaFacadeLocal;
import grupo6.MD.sesiones.DistribucionanimalFacadeLocal;
import grupo6.MD.sesiones.DistribucionplantaFacadeLocal;
import grupo6.MD.sesiones.PlantaFacadeLocal;
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
    private List<Animal> animalesList;
    private List<Distribucionanimal> distribucionesAnimalesList;
    private List<Planta> plantasList;
    private List<Distribucionplanta> distribucionesPlantasList;
    private List<Area> areasList;
    private DistribucionanimalPK animalPK; 

    
    @EJB
    private AnimalFacadeLocal animalesFacadeLocal;
    private Animal animal;
    @EJB
    private DistribucionanimalFacadeLocal distribucionesAnimalesFacadeLocal;
    private Distribucionanimal distribucionAnimal;
    @EJB
    private PlantaFacadeLocal plantasFacadeLocal;
    private Planta planta;
    @EJB
    private DistribucionplantaFacadeLocal distribucionesPlantasFacadeLocal;
    private Distribucionplanta distribucionPlanta;
    private Area area;
    @EJB
    private AreaFacadeLocal areasFacadeLocal;
    private boolean esNuevo;
    private boolean Seleccion;
    

    public List<Animal> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animal> animalesList) {
        this.animalesList = animalesList;
    }

    public List<Distribucionanimal> getDistribucionesAnimalesList() {
        return distribucionesAnimalesList;
    }

    public void setDistribucionesAnimalesList(List<Distribucionanimal> distribucionesAnimalesList) {
        this.distribucionesAnimalesList = distribucionesAnimalesList;
    }

    public List<Planta> getPlantasList() {
        return plantasList;
    }

    public void setPlantasList(List<Planta> plantasList) {
        this.plantasList = plantasList;
    }

    public List<Distribucionplanta> getDistribucionesPlantasList() {
        return distribucionesPlantasList;
    }

    public void setDistribucionesPlantasList(List<Distribucionplanta> distribucionesPlantasList) {
        this.distribucionesPlantasList = distribucionesPlantasList;
    }

    public List<Area> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Area> areasList) {
        this.areasList = areasList;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Distribucionanimal getDistribucionAnimal() {
        return distribucionAnimal;
    }

    public void setDistribucionAnimal(Distribucionanimal distribucionAnimal) {
        this.distribucionAnimal = distribucionAnimal;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Distribucionplanta getDistribucionPlanta() {
        return distribucionPlanta;
    }

    public void setDistribucionPlanta(Distribucionplanta distribucionPlanta) {
        this.distribucionPlanta = distribucionPlanta;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public DistribucionanimalPK getAnimalPK() {
        return animalPK;
    }

    public void setAnimalPK(DistribucionanimalPK animalPK) {
        this.animalPK = animalPK;
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
        if(Seleccion){
             distribucionAnimal=new Distribucionanimal();
             animalPK=new DistribucionanimalPK();
        }   
        else
            distribucionPlanta=new Distribucionplanta();
        esNuevo=true;
    }
    
    public void grabar(){
        try{
            if(esNuevo){
                if(Seleccion){
                    animalPK.setIdanimal(distribucionAnimal.getAnimal().getAnimalPK().getIdanimal());
                    animalPK.setNombrecientifico(distribucionAnimal.getAnimal().getAnimalPK().getNombrecientifico());
                    animalPK.setNumeroarea(distribucionAnimal.getArea().getAreaPK().getNumeroarea());
                    animalPK.setIdtipoarea(distribucionAnimal.getArea().getAreaPK().getIdtipoarea());
                    distribucionAnimal.setDistribucionanimalPK(animalPK);
                    distribucionesAnimalesFacadeLocal.create(distribucionAnimal);
                }else
                    distribucionesPlantasFacadeLocal.create(distribucionPlanta);
            }else{
                if(Seleccion)
                    distribucionesAnimalesFacadeLocal.edit(distribucionAnimal);
                else
                    distribucionesPlantasFacadeLocal.edit(distribucionPlanta);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(Seleccion){
                distribucionAnimal=null;
                animalPK=null;
            }           
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
            distribucionAnimal.setArea((Area) e.getObject());
        else
            distribucionPlanta.setArea((Area) e.getObject());
    } 
    
    
    
     public void abrirBusquedaAnimal(){
            
        Map<String, Object> opciones =new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);
        
        PrimeFaces.current().dialog().openDynamic("seleccion_animal", opciones, null);
        }
    
    
    public void recibirAnimal(SelectEvent e){
            distribucionAnimal.setAnimal((Animal) e.getObject());
    }        
}
